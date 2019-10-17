package com.xuzw.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 Broker:它提供一种传输服务,它的角色就是维护一条从生产者到消费者的路线，保证数据能按照指定的方式进行传输,
 Exchange：消息交换机,它指定消息按什么规则,路由到哪个队列。
 Queue:消息的载体,每个消息都会被投到一个或多个队列。
 Binding:绑定，它的作用就是把exchange和queue按照路由规则绑定起来.
 Routing Key:路由关键字,exchange根据这个关键字进行消息投递。
 vhost:虚拟主机,一个broker里可以有多个vhost，用作不同用户的权限分离。
 Producer:消息生产者,就是投递消息的程序.
 Consumer:消息消费者,就是接受消息的程序.
 Channel:消息通道,在客户端的每个连接里,可建立多个channel.
*/
@Configuration
public class RabbitConfig {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    public static final String EXCHANGE_A = "my-mq-exchange_A";
    public static final String CORE_EXCHANGE = "coreExchange";
    public static final String PAYMENT_EXCHANGE = "paymentExchange";
    public static final String REPORT_EXCHANGE = "reportExchange";

    public static final String QUEUE_A = "QUEUE_A";
    public static final String NOTIFY_PAYMENT = "notify.payment";
    public static final String API_CORE = "api.core";
    public static final String API_PAYMENT = "api.payment";
    public static final String API_REPORT_PAYMENT = "api.report.payment";
    public static final String API_REPORT_REFUND = "api.report.refund";

    public static final String ROUTINGKEY_A = "spring-boot-routingKey_A";

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host,port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        //消息的确认机制（confirm）；
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        //setCacheMode：设置缓存模式，共有两种，CHANNEL和CONNECTION模式。
        //1、CONNECTION模式，这个模式下允许创建多个Connection，会缓存一定数量的Connection，每个Connection中同样会缓存一些Channel，
        // 除了可以有多个Connection，其它都跟CHANNEL模式一样。
        //2、CHANNEL模式，程序运行期间ConnectionFactory会维护着一个Connection，
        // 所有的操作都会使用这个Connection，但一个Connection中可以有多个Channel，
        // 操作rabbitmq之前都必须先获取到一个Channel，
        // 否则就会阻塞（可以通过setChannelCheckoutTimeout()设置等待时间），
        // 这些Channel会被缓存（缓存的数量可以通过setChannelCacheSize()设置）；
        connectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);   //设置CONNECTION模式，可创建多个Connection连接
        //设置每个Connection中缓存Channel的数量，不是最大的。操作rabbitmq之前（send/receive message等）
        // 要先获取到一个Channel.获取Channel时会先从缓存中找闲置的Channel，如果没有则创建新的Channel，
        // 当Channel数量大于缓存数量时，多出来没法放进缓存的会被关闭。
        connectionFactory.setChannelCacheSize(10);
        //单位：毫秒；配合channelCacheSize不仅是缓存数量，而且是最大的数量。
        // 从缓存获取不到可用的Channel时，不会创建新的Channel，会等待这个值设置的毫秒数
        //同时，在CONNECTION模式，这个值也会影响获取Connection的等待时间，
        // 超时获取不到Connection也会抛出AmqpTimeoutException异常。
        connectionFactory.setChannelCheckoutTimeout(600);

        //仅在CONNECTION模式使用，设置Connection的缓存数量。
        connectionFactory.setConnectionCacheSize(3);
        //setConnectionLimit：仅在CONNECTION模式使用，设置Connection的数量上限。
        connectionFactory.setConnectionLimit(10);
        return connectionFactory;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    //必须是prototype类型
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> logger.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause));
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> logger.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange, routingKey, replyCode, replyText, message));
        return rabbitTemplate;
    }

    /**
     * 针对消费者配置
     * 1. 设置交换机类型
     * 2. 将队列绑定到交换机
     FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
     HeadersExchange ：通过添加属性key-value匹配
     DirectExchange:按照routingkey分发到指定队列
     TopicExchange:多关键字匹配
     */
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(EXCHANGE_A);
    }

    /**
     * 获取队列A
     * @return
     */
    @Bean
    public Queue queueA() {
        return new Queue(QUEUE_A, false); //队列持久
    }
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queueA()).to(defaultExchange()).with(RabbitConfig.ROUTINGKEY_A);
    }
}

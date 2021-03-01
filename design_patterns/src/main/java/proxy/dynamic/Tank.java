package proxy.dynamic;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author xuziwen
 * @date 2021/2/28 10:10 下午
 * 动态代理 借助了ASM这个非常强大的Java字节码生成框架
 */
public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("tank move momomomo.....");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        System.out.println("tank move stop.....");
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cglibDynamicProxy();
    }

    /**
     * jdk动态代理 必须实现接口
     */
    public static void jdkDynamicProxy(){
        Tank tank = new Tank();
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        //reflection 反射 通过分析类的属性和方法
        /*Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(), new Class[]{Movable.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method" + method.getName() + " start....");
                Object invoke = method.invoke(tank, args);
                System.out.println("method" + method.getName() + " end....");
                return invoke;
            }
        });*/
        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class}, new LogHandler(tank));
        movable.move();
    }

    public static void cglibDynamicProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new LogInterceptor());
        Tank tank = (Tank)enhancer.create();
        tank.stop();
    }
}

class LogHandler implements InvocationHandler{

    Movable movable;

    public LogHandler(Movable movable) {
        this.movable = movable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method" + method.getName() +" start....");
        Object invoke = method.invoke(movable, args);
        System.out.println("method" + method.getName() +" end....");
        return invoke;
    }
}

class LogInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用："+method.getName()+"------before");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("调用："+method.getName()+"------after");
        return invoke;
    }
}


interface Movable {
    /**
     * 移动
     */
    void move();
}

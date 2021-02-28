package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author xuziwen
 * @date 2021/2/28 10:10 下午
 * 静态代理
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

    public static void main(String[] args) {
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


interface Movable {
    /**
     * 移动
     */
    void move();
}

package proxy;

import java.util.Random;

/**
 * @author xuziwen
 * @date 2021/2/28 10:10 下午
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
        new TankTimeProxy(new TankLogProxy(tank)).move();

    }
}
class TankTimeProxy implements Movable {

    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long l = System.currentTimeMillis();
        m.move();
        System.out.println("move take time :"+(System.currentTimeMillis()-l));
    }
}

class TankLogProxy implements Movable {

    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("start move......");
        m.move();
        System.out.println("end move......");
    }
}

interface Movable {
    /**
     * 移动
     */
    void move();
}

package factory;

/**
 * @author xuziwen
 * @date 2021/2/28 2:31 下午
 * 任何可以产生对象的方法和类，都可以称之为工厂
 * 单例也是一种工厂
 * 不可咬文嚼字，死扣概念
 * 为什么有了new之后，还要有工厂？
 * 灵活控制生产过程（权限，日志，修饰....）
 */
public class Main {
    public static void main(String[] args) {
//        Movable movable = new Car();
//        movable.go();
//        Movable movable = SimpleVehicleFactory.createBroom();
//        movable.go();
        Movable car = CarFactory.create();
        car.go();
    }
}

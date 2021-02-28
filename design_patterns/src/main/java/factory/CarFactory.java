package factory;

/**
 * @author xuziwen
 * @date 2021/2/28 2:50 下午
 * 生产一种产品的工厂
 */
public class CarFactory {
    public static Moveable create(){
        System.out.println("a car creating");
        return new Car();
    }
}

package factory;

/**
 * @author xuziwen
 * @date 2021/2/28 2:50 下午
 * 简单工厂 生产一种产品的工厂，扩展性不好
 */
public class CarFactory {
    public static Movable create(){
        System.out.println("a car creating");
        return new Car();
    }
}

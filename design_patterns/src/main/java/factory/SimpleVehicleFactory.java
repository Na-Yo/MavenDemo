package factory;

/**
 * @author xuziwen
 * @date 2021/2/28 2:46 下午
 * 工厂方法 产品维度扩展
 */
public class SimpleVehicleFactory {
    public static Moveable createCar(){
        return new Car();
    }

    public static Moveable createPlane(){
        return new Plane();
    }

    public static Moveable createBroom(){
        return new Broom();
    }
}

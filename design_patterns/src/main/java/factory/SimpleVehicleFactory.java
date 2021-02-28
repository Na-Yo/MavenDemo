package factory;

/**
 * @author xuziwen
 * @date 2021/2/28 2:46 下午
 * 工厂方法 产品维度扩展
 */
public class SimpleVehicleFactory {
    public static Movable createCar(){
        return new Car();
    }

    public static Movable createPlane(){
        return new Plane();
    }

    public static Movable createBroom(){
        return new Broom();
    }
}

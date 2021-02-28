package factory.abstractFactory;

/**
 * @author xuziwen
 * @date 2021/2/28 3:13 下午
 */
public class Main {
    public static void main(String[] args) {
//        Car car = new Car();
//        car.go();
//        Ak47 ak47 = new Ak47();
//        ak47.shoot();
//        Bread bread = new Bread();
//        bread.eat();
        ModernFactory modernFactory = new ModernFactory();

        Vehicle vehicle = modernFactory.createVehicle();
        vehicle.go();
        Weapon weapon = modernFactory.createWeapon();
        weapon.shoot();
        Food food = modernFactory.createFood();
        food.eat();
    }
}

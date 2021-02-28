package factory.abstractFactory;

/**
 * @author xuziwen
 * @date 2021/2/28 3:32 下午
 * 现代化工厂
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new Ak47();
    }
}

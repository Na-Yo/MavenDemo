package factory.abstractFactory;

/**
 * @author xuziwen
 * @date 2021/2/28 3:23 下午
 * 抽象工厂，适合扩展产品族，生产一系列产品，不适合扩展产品
 */
public abstract class AbstractFactory {

    /**
     * 创建食物
     * @return
     */
    abstract Food createFood();

    /**
     * 创建交通工具
     * @return
     */
    abstract Vehicle createVehicle();

    /**
     * 创建武器
     * @return
     */
    abstract Weapon createWeapon();
}

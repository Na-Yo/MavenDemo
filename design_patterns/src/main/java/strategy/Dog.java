package strategy;

import java.math.BigDecimal;


/**
 * @author xuziwen
 * @date 2021/2/27 12:43 上午
 */
public class Dog {
    private String name;
    private BigDecimal height;

    public Dog(String name, BigDecimal height) {
        this.name = name;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", height=" + height +
                '}';
    }
}

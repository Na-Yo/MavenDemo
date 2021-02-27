package strategy;

import java.math.BigDecimal;

/**
 * @author xuziwen
 * @date 2021/2/27 12:43 上午
 */
public class Pig {
    private String name;
    private BigDecimal weight;

    public Pig(String name, BigDecimal weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

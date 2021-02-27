package strategy;

import java.math.BigDecimal;

/**
 * @author xuziwen
 * @date 2021/2/27 12:43 上午
 */
public class Main {
    public static void main(String[] args) {
        Comparable[] cats=new Cat[]{new Cat("A",2),new Cat("B",5),new Cat("C",1),new Cat("D",3),new Cat("E",6)};
        Dog[] dogs=new Dog[]{new Dog("A", BigDecimal.valueOf(2)),new Dog("B",BigDecimal.valueOf(5)),new Dog("C",BigDecimal.valueOf(1)),new Dog("D",BigDecimal.valueOf(3)),new Dog("E",BigDecimal.valueOf(6))};
        Sorter.quickSort(cats);
        Sorter.bubbleSort(dogs,new DefaultDogComparator());
    }
}

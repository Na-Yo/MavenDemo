package strategy;

/**
 * @author xuziwen
 * @date 2021/2/27 12:43 上午
 */
public class Main {
    public static void main(String[] args) {
        Cat[] cats=new Cat[]{new Cat("A",2),new Cat("B",5),new Cat("C",1),new Cat("D",3),new Cat("E",6)};
        new Sorter().quickSort(cats);
//        new Sorter().bubbleSort(cats);
    }
}

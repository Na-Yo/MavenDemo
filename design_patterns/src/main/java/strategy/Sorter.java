package strategy;

import java.util.Arrays;

/**
 * @author xuziwen
 * @date 2021/2/27 12:48 上午
 */
public class Sorter {

    /**
     * 快速排序/选择排序
     */
    public void quickSort(Cat[] cats){
        System.out.println("origin:"+Arrays.asList(cats));
        for (int i = 0; i < cats.length-1; i++) {
            for (int j = i+1; j < cats.length; j++) {
                if(cats[i].getAge()>cats[j].getAge()){
                    swap(cats,i,j);
                }
            }
            System.out.println("procedure："+Arrays.asList(cats));
        }
        System.out.println("result:"+Arrays.asList(cats));
    }

    public  void swap(Cat[] cats,int i,int j){
        Cat tempCat= cats[i];
        cats[i]=cats[j];
        cats[j]=tempCat;
    }

    //冒泡排序
    public void bubbleSort(Cat[] cats){
        System.out.println("origin:"+Arrays.asList(cats));
        for (int i = 0; i < cats.length-1; i++) {
            for (int j = 0; j < cats.length-1-i; j++) {
                if(cats[j].getAge()>cats[j+1].getAge()){
                    swap(cats,j);
                }
            }
            System.out.println("procedure："+Arrays.asList(cats));
        }
        System.out.println("result:"+Arrays.asList(cats));
    }

    public  void swap(Cat[] cats,int j){
        Cat tempCat= cats[j];
        cats[j]=cats[j+1];
        cats[j+1]=tempCat;
    }
}

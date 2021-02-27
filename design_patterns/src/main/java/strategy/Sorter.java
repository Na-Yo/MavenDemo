package strategy;

import java.util.Arrays;

/**
 * @author xuziwen
 * @date 2021/2/27 12:48 上午
 */
public class Sorter {

    /**
     * 选择排序
     */
    public static void quickSort(Comparable[] comparables){
        System.out.println("origin:"+Arrays.asList(comparables));
        for (int i = 0; i < comparables.length-1; i++) {
            for (int j = i+1; j < comparables.length; j++) {
                if(comparables[i].compareTo(comparables[j])==1){
                    swap(comparables,i,j);
                }
            }
            System.out.println("procedure："+Arrays.asList(comparables));
        }
        System.out.println("result:"+Arrays.asList(comparables));
    }

    public static void swap(Comparable[] comparables,int i,int j){
        Comparable comparable= comparables[i];
        comparables[i]=comparables[j];
        comparables[j]=comparable;
    }

    /**
     * 选择排序
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

    //冒泡排序
    public static <T> void bubbleSort(T[] ts,Comparator<T> comparator){
        System.out.println("origin:"+Arrays.asList(ts));
        for (int i = 0; i < ts.length-1; i++) {
            for (int j = 0; j < ts.length-1-i; j++) {
                if(comparator.compare(ts[j],ts[j+1]) == 1){
                    swap(ts,j);
                }
            }
            System.out.println("procedure："+Arrays.asList(ts));
        }
        System.out.println("result:"+Arrays.asList(ts));
    }

    public static <T> void swap(T[] ts,int j){
        T tempT= ts[j];
        ts[j]=ts[j+1];
        ts[j+1]=tempT;
    }

}

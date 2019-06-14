package day0601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lambdaSort {
    public static void main(String[] args) {
//        listSorted();
        arraySorted();
    }

    private static void listSorted() {
        //数组排序 1.8 以前
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        names.forEach(System.out::println);
        //1.8以后
        Collections.sort(names,(a,b)->a.compareTo(b));
        names.forEach(System.out::println);
    }

    private static void arraySorted(){

        String [] s=new String[]{"1","2","3","0"};

        Stream<String> sorted = Arrays.stream(s).sorted(Comparator.comparing(String::valueOf));
        List<String> collect = sorted.collect(Collectors.toList());
    }
}

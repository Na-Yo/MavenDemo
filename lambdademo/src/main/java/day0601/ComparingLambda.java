package day0601;

import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

public class ComparingLambda {

    public static void main(String[] args) {
        List<User> userList = asList(new User("张三" , 10,"30") ,new User(), new User("李四" , 10,"10") , new User("王五" , 13,"20"),new User());

//        userList.sort((o1,o2) -> o1.getUsername().compareTo(o2.getUsername()));

        /*userList.sort(Comparator.nullsLast(Comparator.comparing(User::getDevStatus,(o1,o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return 1;
            } else if (o2 == null) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        })));*/

        userList.sort(Comparator.comparing(User::getDevStatus, Comparator.nullsLast(Comparator.naturalOrder())));
//        userList.sort(Comparator.comparing(User::getDevStatus, Comparator.nullsLast(Comparator.naturalOrder())).thenComparing(User::getAge));

//        userList.sort(Comparator.comparing(User::getDevStatus));


        userList.forEach(System.out::println);



    }


}

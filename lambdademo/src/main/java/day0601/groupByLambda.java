package day0601;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class groupByLambda {

    public static void main(String[] args) {
        List<User> userList = asList(new User("张三" , 10) , new User("李四" , 10) , new User("王五" , 13));
        String result = userList.stream().map(User::getUsername).collect(Collectors.joining("," , "[" , "]"));
        System.out.println(result);
        toMap();
    }

   static void toMap() {
        List<User> userList = asList(new User("张三", 10), new User("李四", 10), new User("王五", 13));
        Stream<User> userStream = userList.stream();
//        Map<Integer, List<String>> integerStringMap = userStream.collect(groupingBy(User::getAge, mapping(User::getUsername, toList())));
//        Map<Integer, List<User>> integerStringMap = userStream.collect(groupingBy(User::getAge));
//        System.out.println(integerStringMap.toString());

//       Map<String, User> map = userStream.collect(Collectors.toMap(User::getUsername,e -> e));
       Map<String, User> map = userStream.collect(Collectors.toMap(User::getUsername, Function.identity(), (key1, key2) -> key2));
       map.forEach((k,v) -> System.out.println("k:v=="+k+":"+v));

   }


}

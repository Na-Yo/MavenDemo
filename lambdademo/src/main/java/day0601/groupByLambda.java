package day0601;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class GroupByLambda {

    public static void main(String[] args) {
        List<User> userList = asList(new User("张三", 10), new User("李四", 10), new User("王五", 13));
        Stream<User> userStream = userList.stream();
        Map<Integer, List<String>> integerStringMap = userStream.collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getUsername, Collectors.toList())));
//        Map<Integer, List<User>> integerStringMap = userStream.collect(groupingBy(User::getAge));
        System.out.println(integerStringMap.toString());
    }

}

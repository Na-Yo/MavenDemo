package day0601;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class JoinLambda {
    public static void main(String[] args) {
        List<User> userList = asList(new User("张三" , 10) , new User("李四" , 10) , new User("王五" , 13));
        String result = userList.stream().map(User::getUsername).collect(Collectors.joining("," , "[" , "]"));
        System.out.println(result);
    }
}

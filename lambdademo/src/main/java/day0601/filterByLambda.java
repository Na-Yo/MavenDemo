package day0601;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FilterByLambda {

    public static void main(String[] args) {
        List<User> userList = asList(new User("张三", 10, "20"), new User("李四", 10, "10"), new User("王五", 13));

        List<Integer> devStatus = userList.stream().filter(e -> "10".equals(e.getDevStatus())
                || "30".equals(e.getDevStatus())
                || "50".equals(e.getDevStatus())
                || "60".equals(e.getDevStatus())).map(User::getAge)
                .collect(Collectors.toList());
    }

}

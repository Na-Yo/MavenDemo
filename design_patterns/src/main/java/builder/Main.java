package builder;

/**
 * @author xuziwen
 * @date 2021/3/6 2:11 下午
 * 分离复杂对象的构建和表示
 * 同样的构建过程可以创建不同的表示
 * 无需记忆，自然使用
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .basicInfo(1, "张三", 10)
                .weight(110.3)
//                .score(90)
                .bulider();
        System.out.println(person.toString());
    }
}

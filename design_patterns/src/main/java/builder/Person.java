package builder;

/**
 * @author xuziwen
 * @date 2021/3/6 2:14 下午
 */
public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;

    private Person(){
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", score=" + score +
                '}';
    }

    public static class PersonBuilder{
        private Person p = new Person();

        public PersonBuilder basicInfo(int id,String name,int age){
            p.id=id;
            p.name=name;
            p.age=age;
            return this;
        }

        public PersonBuilder weight(double weight){
            p.weight=weight;
            return this;
        }

        public PersonBuilder score(int score){
            p.score=score;
            return this;
        }

        public Person bulider(){
            return p;
        }
    }

}

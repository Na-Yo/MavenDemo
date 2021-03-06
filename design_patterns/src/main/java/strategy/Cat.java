package strategy;


/**
 * @author xuziwen
 * @date 2021/2/27 12:43 上午
 */
public class Cat implements Comparable<Cat>{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Cat cat) {
        if (this.age > cat.getAge()) {return 1;}
        else if(this.age < cat.getAge()){return -1;};
        return 0;
    }
}

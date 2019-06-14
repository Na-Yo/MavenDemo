package day0601;

public class User {

    private String username;
    private int age;
    private String devStatus;

    public User(){}

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public User(String username, int age, String devStatus) {
        this.username = username;
        this.age = age;
        this.devStatus = devStatus;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDevStatus() {
        return devStatus;
    }

    public void setDevStatus(String devStatus) {
        this.devStatus = devStatus;
    }
}

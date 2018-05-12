package sample.kingja.volleysir;

/**
 * Description：TODO
 * Create Time：2018/5/12 10:08
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class User {
    private String name;
    private int age;

    public User(String name, int age) {
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
}

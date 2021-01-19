package arraylist.test;

/**
 * @Author: yanghao
 * @Date: 2021/1/19 18:59
 */
public class Person {
    private int id;

    private String name;

    private int age;

    public Person(){
        this.id = (int) (Math.random()*100);
        this.name = Math.random() + "someone";
        this.age = (int) (Math.random()*200);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

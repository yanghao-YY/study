package alitest;

import java.util.Objects;

/**
 * @Author hao.yang
 * @Date 2021/6/7
 **/
public class Student implements Comparable<Student>{
    private Long id;
    private String name;
    private Integer age;

    public Student(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id.equals(student.id) && name.equals(student.name) && age.equals(student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.id - o.id);
    }
}

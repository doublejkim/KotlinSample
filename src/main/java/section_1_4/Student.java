package section_1_4;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class Student implements Comparable<Student> {

    private String name;

    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        System.out.println("test....");
        return name.equals(student.name);
    }
}

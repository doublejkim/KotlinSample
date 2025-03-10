package section_1_4;

import java.util.Arrays;
import java.util.List;

public class Section_1_4_Main {

    public static void main(String[] args) {

        Student student1 = new Student("Jack", 25);
        Student student2 = new Student("Tom", 30);

        if (student1.compareTo(student2) > 0) {
            System.out.println("1번학생이 2번학생보다 나이가 많다");
        } else {
            System.out.println("2번학생이 1번학생보다 나이가 같거나 많다");
        }

        List<Integer> numbers = Arrays.asList(10, 20, 30);
        for (int number : numbers) {
            System.out.println(number);
        }



    }
}

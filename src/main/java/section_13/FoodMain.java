package section_13;

import java.util.Arrays;
import java.util.List;

public class FoodMain {

    public static void main(String[] args) {

        List<JavaFood> foods = Arrays.asList(
                new JavaFood("돈까스", 1_000),
                new JavaFood("돈까스", 3_500),
                new JavaFood("국수", 2_000),
                new JavaFood("국수", 2_500),
                new JavaFood("국수", 3_500),
                new JavaFood("스테이크", 20_000)
        );

        List<JavaFood>  newFoods = foods.stream().filter(food -> food.getPrice() > 3_000).toList();




    }

}

package section_13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class FoodMain {

    public static void main(String[] args) {

        List<Food> foods = Arrays.asList(
                new Food("돈까스", 1_000),
                new Food("돈까스", 3_500),
                new Food("국수", 2_000),
                new Food("국수", 2_500),
                new Food("국수", 3_500),
                new Food("스테이크", 20_000)
        );

        List<Food>  newFoods = foods.stream().filter(food -> food.getPrice() > 3_000).toList();




    }

}

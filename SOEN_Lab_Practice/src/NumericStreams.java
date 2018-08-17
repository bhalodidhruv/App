import java.util.stream.*;
import java.util.*;

public class NumericStreams{
	
	public static Stream<int[]> pythagoreanTriples;

    public static void main(String...args){
    
        List<Integer> numbers = Arrays.asList(3,4,5,1,2);

        Arrays.stream(numbers.toArray()).forEach(System.out::println);
        int calories = Dish.menu.stream()
                           .mapToInt(Dish::getCalories)
                           .sum();
        System.out.println("Number of calories:" + calories);


        // max and OptionalInt
        OptionalInt maxCalories = Dish.menu.stream()                                                      
                                      .mapToInt(Dish::getCalories)
                                      .max();
        String ouput = "";
        int max = 0;
        int max1 = 0;
        int max2 = 0;
        if(maxCalories.isPresent()){
            max = maxCalories.getAsInt();
        }
        else {
            // we can choose a default value
             ouput = "No Max Value";
        }
        System.out.println(max + ouput);

        // numeric ranges
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                                 .filter(n -> n % 2 == 0);

        System.out.println(evenNumbers.count());

        pythagoreanTriples =
               IntStream.rangeClosed(1, 100).boxed()
                        .flatMap(a -> IntStream.rangeClosed(a, 100)
                                               .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0).boxed()
                                               .map(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}));       
        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2])); 

    }
   
    public static boolean isPerfectSquare(int n){
        return Math.sqrt(n) % 1 == 0;
    }

}
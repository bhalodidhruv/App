import java.util.*;

import java.util.stream.*;

import static java.util.Comparator.comparing;
import java.util.stream.*;
import java.util.function.*;
import static java.util.stream.Collectors.*;

public class StreamBasic {

    public static void main(String...args){
        // Java 7
        //getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
    	
    	 IntSummaryStatistics menuStatistics =
       		  Dish.menu.stream().collect(summarizingInt(d -> d.getCalories()));
         
         System.out.println("menuStatistics Sum " + menuStatistics);
         
        System.out.println("---");

        // Java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
        
        List<Dish> firstTwoMeatDishes = Dish.menu.stream()
                .filter(ds -> ds.getType().toString() == "MEAT").limit(2).collect(toList());
        System.out.println("Test " + firstTwoMeatDishes);
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream().map(x -> x*x).collect(toList());
                          System.out.println(squares);
                          
                          List<Integer> numbers1 = Arrays.asList(1, 2, 3);
                          List<Integer> numbers2 = Arrays.asList(3, 4);
          List<String> joinedList = numbers1.stream().flatMap(x -> {
        	  
        	  return numbers2.stream().filter(y -> (x+y) % 3 ==0).map(y -> {
        		  
        			  return x + "," + y; 
        		 
        		  
        	  });
          }).collect(toList());
          System.out.println(joinedList);
          
          String shortMenu = Dish.menu.stream()
                  .collect( reducing( "", Dish::getName, (s1, s2) -> s1 + s2 ) );
          System.out.println("Short Menu" + shortMenu);
          
          Map<Boolean, Map<Boolean, List<Dish>>> partionxy = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                  partitioningBy(d -> d.getCalories() > 500)));
          
          Map<Boolean, Long> count = Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian,
                  counting()));
          System.out.println(partionxy);
          
          Optional<Dish> longestDish = Dish.menu.stream()
                  			.reduce((s1, s2) -> {
                  				if (s1.getName().length() > s2.getName().length())
                  					return s1;
                  				else
                  					return s2;
                  				});
          
          System.out.println("longestDish" + longestDish);
          
          // Longest Name using 

          Dish longestDishNormal = Dish.menu.stream().collect(Collectors.maxBy(Comparator.comparing( y -> y.getName().length())))
                                     .orElseThrow(RuntimeException::new);
          
          
          System.out.println("longestDishNormal" + longestDish);
          
          
          // Word Count
          
          Stream<String> names = Stream.of("Pasta", "Fish", "Pasta", "Meat", "Pasta", "Meat");
          
          Map<String, Long> wordCount = names.collect(groupingBy(name -> name.toString(), Collectors.counting()));
          System.out.println("wordCount"  + wordCount);
          
         

    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes){
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for(Dish d: dishes){
            if(d.getCalories() <= 400){
                lowCaloricDishes.add(d);
            }
        }
        List<String> lowCaloricDishesName = new ArrayList<>();
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            public int compare(Dish d1, Dish d2){
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        for(Dish d: lowCaloricDishes){
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes){
        return dishes.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)               
                .collect(toList());
    }
    
    
}
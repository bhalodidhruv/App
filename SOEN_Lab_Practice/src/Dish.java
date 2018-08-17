import java.util.*;

public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum Type { MEAT, FISH, OTHER }

    @Override
    public String toString() {
        return name;
    }

    public static final List<Dish> menu =
            Arrays.asList( new Dish("pork", false, 10 , Dish.Type.MEAT),
                           new Dish("beef", false, 40, Dish.Type.MEAT),
                           new Dish("chicken", false, 30, Dish.Type.MEAT),
                           new Dish("french fries", true, 20, Dish.Type.OTHER),
                           new Dish("rice", true, 10, Dish.Type.OTHER),
                           new Dish("season fruit", true, 70, Dish.Type.OTHER),
                           new Dish("pizza", true, 100, Dish.Type.OTHER),
                           new Dish("prawns", false, 220, Dish.Type.FISH),
                           new Dish("salmon", false, 500, Dish.Type.FISH));
}
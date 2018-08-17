import java.util.*;

public class FilteringApples{

	public static void main(String ... args){

		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(129, "yellow"), new Apple(120, "red"), new Apple(160, "blue"));	

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples = filterApplesByColor(inventory, "green");
		System.out.println(greenApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples = filterApplesByColor(inventory, "red");
		System.out.println(redApples);

		// [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
		List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
		System.out.println(greenApples2);

		// [Apple{color='green', weight=155}]
		List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
		System.out.println("<<<<<" + heavyApples);

		// []
		List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);

		// [Apple{color='red', weight=120}]
		List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
			public boolean xyz(Apple a, Apple b){
				return a.getColor().equals("red"); 
			}
		});
		System.out.println(redApples2);
		
		prettyPrintApple(inventory, new prettyprintApple());
		System.out.println(redAndHeavyApples);
		
	}

	public static List<Apple> filterGreenApples(List<Apple> inventory){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if("green".equals(apple.getColor())){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByColor(List<Apple> inventory, String color){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getColor().equals(color)){
				result.add(apple);
			}
		}
		return result;
	}

	public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight){
		List<Apple> result = new ArrayList<>();
		for(Apple apple: inventory){
			if(apple.getWeight() > weight){
				result.add(apple);
			}
		}
		return result;
	}


	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.xyz(apple,apple)){
				
				result.add(apple);
			}
		}
		return result;
	}       
	
	public static void prettyPrintApple(List<Apple> inventory, applepretty p){
	    for(Apple apple: inventory) {
		String output = p.xyz(apple);
		System.out.println("output" + output);
	    }
	}

	public static class Apple {
		private Integer weight = 0;
		private String color = "";

		public Apple(Integer weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}

	interface ApplePredicate{
		public boolean xyz(Apple a, Apple b);
	}
	
	interface applepretty{
		public String xyz(Apple a);
	}

	static class AppleWeightPredicate implements ApplePredicate{
		public boolean xyz(Apple apple, Apple apple2){
			System.out.println("apple 1 " + apple.getWeight());
			System.out.println("apple 2 " + apple2.getWeight());
			return apple.getWeight() == apple2.getWeight(); 
		}
	}
	static class AppleColorPredicate implements ApplePredicate{
		public boolean xyz(Apple apple, Apple apple2){
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean xyz(Apple apple, Apple apple2){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
	
	static class prettyprintApple implements applepretty{
		public String xyz(Apple apple){
			return String.valueOf(apple.getWeight()); 
		}
	}
}
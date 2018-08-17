import java.util.*;

import static java.util.Optional.of;
import static org.junit.Assert.assertEquals;
import static java.util.Optional.empty;

public class OperationsWithOptional {

    public static void main(String... args) {
        System.out.println(max(of(3), of(5)));
        
        Optional<Integer> entry = max(empty(), of(5));
        if(entry.isPresent()) {
        	System.out.println(entry);
        }else {
        	System.out.println("Invalid Input");
        }
        
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
        
        System.out.println(stringToInt("5"));
        System.out.println(stringToInt("Test"));
        
        assertEquals(5, readDuration(props, "a"));
        assertEquals(0, readDuration(props, "b"));
        assertEquals(0, readDuration(props, "c"));
        assertEquals(0, readDuration(props, "d"));

    }

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
         return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }
    
    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
    
    public static int readDuration(Properties props, String name) {
    	String value = props.getProperty(name);
    	Optional<Integer> returnInt = stringToInt(value);
    	if(returnInt.isPresent() && returnInt.get() > 0) {
    		return returnInt.get();
    	}    	
    	return 0;
    }
    
}
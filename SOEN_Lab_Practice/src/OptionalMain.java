
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toSet;

public class OptionalMain {

    public String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                     .flatMap(Car::getInsurance)
                     .flatMap(Insurance::getName)
                     .orElse("Unknown");
    }

 
}

import java.util.HashSet;

public class Collection_HashSet {

    public static void main(String[] args) {

        HashSet<String> cars = new HashSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println("HashSet: " + cars);

        // To check if a specific element exists in the HashSet
        System.out.println("Contains Volvo: " + cars.contains("Volvo"));

        // To remove an element from the HashSet
        cars.remove("Volvo");
        System.out.println("After removing Volvo: " + cars);

        for (String car : cars) {
            System.out.println(car);
        }
    }
}

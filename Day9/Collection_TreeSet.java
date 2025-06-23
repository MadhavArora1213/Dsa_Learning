import java.util.TreeSet;   

public class Collection_TreeSet {
    public static void main(String[] args) {
        
        TreeSet<String> cars = new TreeSet<>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");

        System.out.println("TreeSet: " + cars);

        // To check if a specific element exists in the TreeSet
        System.out.println("Contains Volvo: " + cars.contains("Volvo"));

        // To remove an element from the TreeSet
        cars.remove("Volvo");
        System.out.println("After removing Volvo: " + cars);

        for (String car : cars) {
            System.out.println(car);
        }
    }
}

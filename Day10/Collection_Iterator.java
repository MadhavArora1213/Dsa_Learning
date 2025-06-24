import java.util.ArrayList;
import java.util.Iterator;
public class Collection_Iterator {
    public static void main(String[] args) {
      

        // Creating an ArrayList instance
        ArrayList<String> list = new ArrayList<>();
        
        // Adding elements to the ArrayList
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");

        // Creating an Iterator for the ArrayList
        Iterator<String> iterator = list.iterator();

        // Using the Iterator to traverse the ArrayList
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);
        }
    }
}
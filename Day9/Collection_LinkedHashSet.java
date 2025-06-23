import java.util.LinkedHashSet;
public class Collection_LinkedHashSet {
    public static void main(String[] args) {
        
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apple");     
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        linkedHashSet.add("Date");

        System.out.println("LinkedHashSet: " + linkedHashSet);

        // To check if a specific element exists in the LinkedHashSet
        System.out.println("Contains Banana: " + linkedHashSet.contains("Banana"));

        // To remove an element from the LinkedHashSet
        linkedHashSet.remove("Banana");
        System.out.println("After removing Banana: " + linkedHashSet);

        // Iterating through the LinkedHashSet
        for (String fruit : linkedHashSet) {
            System.out.println(fruit);
        }
        
    }
}

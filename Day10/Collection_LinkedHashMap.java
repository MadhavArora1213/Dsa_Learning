import java.util.LinkedHashMap;

public class Collection_LinkedHashMap {
    public static void main(String[] args) {

       LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Adding key-value pairs to the LinkedHashMap
        linkedHashMap.put("Apple", 1);
        linkedHashMap.put("Banana", 2);
        linkedHashMap.put("Cherry", 3);
        linkedHashMap.put("Date", 4);

        System.out.println("LinkedHashMap: " + linkedHashMap);

        // Retrieving a value for a specific key
        System.out.println("Value for key 'Banana': " + linkedHashMap.get("Banana"));

        // Removing an element with a specific key
        linkedHashMap.remove("Banana");
        System.out.println("After removing 'Banana': " + linkedHashMap);

        // Iterating through the LinkedHashMap
        for (String key : linkedHashMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + linkedHashMap.get(key));
        }
    }
}
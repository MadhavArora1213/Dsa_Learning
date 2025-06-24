import java.util.TreeMap;
public class Collection_TreeMap {
    public static void main(String[] args) {

        // Importing TreeMap from java.util package

        // Creating a TreeMap instance
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Adding key-value pairs to the TreeMap
        treeMap.put("Apple", 1);
        treeMap.put("Banana", 2);
        treeMap.put("Cherry", 3);
        treeMap.put("Date", 4);

        System.out.println("TreeMap: " + treeMap);

        // Retrieving a value for a specific key
        System.out.println("Value for key 'Banana': " + treeMap.get("Banana"));

        // Removing an element with a specific key
        treeMap.remove("Banana");
        System.out.println("After removing 'Banana': " + treeMap);

        // Iterating through the TreeMap
        for (String key : treeMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + treeMap.get(key));
        }
    }
}
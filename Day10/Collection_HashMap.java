import java.util.HashMap;
public class Collection_HashMap{
    public static void main(String[] args){

        HashMap<String, Integer> hashMap = new HashMap<>();

        // Adding key-value pairs to the HashMap
        hashMap.put("Apple", 1);
        hashMap.put("Banana", 2);   
        hashMap.put("Cherry", 3);
        hashMap.put("Date", 4);

        System.out.println("HashMap: " + hashMap);

        System.out.println("Value for key 'Banana': " + hashMap.get("Banana"));

        // Remove the element with key "Banana"
        hashMap.remove("Banana");
        System.out.println("After removing 'Banana': " + hashMap);

        // Iterating through the HashMap
        for (String key : hashMap.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hashMap.get(key));
        }

        
    }
}
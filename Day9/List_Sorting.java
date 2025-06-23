import java.util.ArrayList;
import java.util.Collections;

public class List_Sorting {
    public static void main(String[] args) {
        
        ArrayList<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Cherry");
        list.add("Date");

        Collections.sort(list);
        System.out.println("Sorted List: " + list);

        // Sorting in reverse order
        Collections.sort(list, Collections.reverseOrder());
    }
}

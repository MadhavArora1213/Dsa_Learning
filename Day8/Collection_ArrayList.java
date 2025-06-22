import java.util.ArrayList;
public class Collection_ArrayList {

    public static void main(String[] args) {

        // Creating an ArrayList of Strings

            ArrayList<String> cars = new ArrayList();

        // Adding elements to the ArrayList

            cars.add("BMW");
            cars.add("Volvo");
            cars.add("Ford");
            cars.add("Mazda");
            cars.add(0,"Toyota");

            System.out.println(cars);
            // System.out.println(cars.get(1));

            // cars.set(2, "Audi"); // Changing the element at index 2
            // System.out.println(cars);

            // cars.remove(3); // Removing the element at index 3
            // System.out.println(cars.size());

            // cars.clear(); // Clearing the ArrayList
            // System.out.println("After clearing: " + cars);

        // Looping through the ArrayList using a for loop

            // for(int i =0; i<cars.size(); i++) {
            //     System.out.println(cars.get(i));
            // }

        // Looping through the ArrayList using a for-each loop

            // for(String i: cars){
            //     System.out.println(i);    
            // }


        // Integer ArrayList


            // ArrayList<Integer> numbers = new ArrayList<>();
            // // Adding elements to the Integer ArrayList
            // numbers.add(10);
            // numbers.add(20);            
            // numbers.add(30);
            // numbers.add(40);
            // System.out.println(numbers);

            // Sort ArrayList

                // Collections.sort(cars);
                // System.out.println("Sorted ArrayList: " + cars);

            // You Can also use the following syntax to create an ArrayList

                    // List<String> cars = new ArrayList<>();   

    }
}

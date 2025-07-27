import java.util.Arrays;

public class Second_Largest_And_Second_Smallest {
    public static void main(String[] args) {
      int[] arr = {8, 10, 5, 7, 9};
      
      Arrays.sort(arr);

        // The second largest element will be the second last element in the sorted array
        int secondLargest = arr[arr.length - 2];
        // The second smallest element will be the second element in the sorted array
        int secondSmallest = arr[1];
        System.out.println("Second largest element in the array: " + secondLargest);
        System.out.println("Second smallest element in the array: " + secondSmallest);
    }
}

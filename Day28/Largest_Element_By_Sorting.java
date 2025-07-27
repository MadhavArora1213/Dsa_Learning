import java.util.Arrays;

public class Largest_Element_By_Sorting {
    public static void main(String[] args) {
        int[] arr = {8, 10, 5, 7, 9};
        // Sort the array
        Arrays.sort(arr);

        // The largest element will be the last element in the sorted array
        System.out.println("Largest element in the array: " + arr[arr.length - 1]);
    }
}
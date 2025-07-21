
import java.util.ArrayList;
import java.util.Scanner;

public class Merge_Sort {
 public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = 7;
        int arr[] = { 9, 4, 7, 6, 3, 1, 5 };
        System.out.println("Before sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        Merge_Sort.mergeSort(arr, 0, n - 1);
        System.out.println("After sorting array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void mergeSort(int[] arr, int low, int high) {

        if (low >= high) {
            return; // Base case: if the array has one or no elements, it's already sorted
        }
        int mid = (low + high) / 2; // Find the middle index

        mergeSort(arr, low, mid); // Recursively sort the left half
        mergeSort(arr, mid + 1, high); // Recursively sort the right half
        merge(arr, low, mid, high); // Merge the two halves
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]); // Add the smaller element to the temporary array
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]); // Add remaining elements from the left half
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]); // Add remaining elements from the right half
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

    }
}

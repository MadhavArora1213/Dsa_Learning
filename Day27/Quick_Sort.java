import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quick_Sort {
    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (i <= high - 1 && arr.get(i) <= pivot) {
                i++;
            }
            while (j >= low + 1 && arr.get(j) > pivot) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }

    public static List<Integer> quickSort(List<Integer> arr) {
        // Defensive copy to avoid modifying the original list
        List<Integer> copy = new ArrayList<>(arr);
        qs(copy, 0, copy.size() - 1);
        return copy;
    }

    public static void main(String args[]) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(4, 6, 2, 5, 7, 9, 1, 3));
        int n = arr.size();
        System.out.println("Before Using Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        List<Integer> sortedArr = Quick_Sort.quickSort(arr);
        System.out.println("After Quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(sortedArr.get(i) + " ");
        }
        System.out.println();
    }
}

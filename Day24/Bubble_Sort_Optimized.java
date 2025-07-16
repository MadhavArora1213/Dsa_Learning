// Here the Time complexity is O(n^2) and Space complexity is O(1) in the average case and worst case.
// In the best case, the time complexity is O(n) when the array is already sorted.

public class Bubble_Sort_Optimized {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before bubble sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        bubble_sort(arr, n);
    }

     static void bubble_sort(int arr[], int n) {
        int swap=0;
        for(int i=n-1;i>=0;i--){
            for(int j=0; j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    swap=1;
                }
            }
            if(swap==0){
                break;
            }
        }
        System.out.println("After bubble sort:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
     }
}

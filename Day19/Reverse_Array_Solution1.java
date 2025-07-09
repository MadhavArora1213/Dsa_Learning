// Solution to reverse an array using an auxiliary array
// This solution creates a new array to store the reversed elements of the original array.

public class Reverse_Array_Solution1 {
    //Function to print array
   static void printArray(int ans[], int n) {
      System.out.print("Reversed array is:- \n");
      for (int i = 0; i < n; i++) {
         System.out.print(ans[i] + " ");
      }
   }
   //Function to reverse array using an auxiliary array
   static void reverseArray(int arr[], int n) {
      int[] ans = new int[n];
      for (int i = n - 1; i >= 0; i--) {
         ans[n - i - 1] = arr[i];
      }
      printArray(ans, n);
   }
   public static void main(String[] args) {
      int n = 5;
      int arr[] = { 5, 4, 3, 2, 1};
      reverseArray(arr, n);
   }

}
// My Brute Force Approach to solve the problem of finding the largest element in an array
// This is also and optimized approach as well.
// Time Complexity: O(n)

public class Largest_Element_In_An_Array {
    public static void main(String[] args) {
        int[] arr ={8,10,5,7,9};
        int largest = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i]> largest) {
                largest = arr[i];
            }
        }
        System.out.println("Largest element in the array: " + largest);
    }
}


public class LoopOptimization {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;

        for (int i = 0; i < arr.length; i++) {
            if (i == target) {
                System.out.println("Found target: " + target + " at index: " + i);
                break; // Exit the loop once the target is found
            } else {
                System.out.println("Current index: " + i + ", value: " + arr[i]);
            }
        }
    }
}

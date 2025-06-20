
import java.util.Scanner;

public class Pattern13 {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();
        int num = 1;
        // Increasing Number Triangle Pattern
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num = num + 1; // Increment j by 2 to skip the next number
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class Pattern12 {

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        // Number Crown Pattern
        int spaces = 2 * (n - 1); // Calculate the number of spaces for alignment

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            for(int j = 1; j <= spaces; j++) {
                System.out.print(" "); // Print spaces for alignment
            }
           
            for (int j= i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();

            spaces -= 2; // Decrease spaces for the next row
        }
    }
}

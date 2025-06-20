import java.util.Scanner;
public class Pattern14 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        // Increasing Letter Triangle Pattern
        for (int i = 1; i <= n; i++) {
            for (char ch = 'A'; ch < 'A' + i; ch++) {
                System.out.print(ch + " ");
               
            }
            System.out.println();
        }
    }
}

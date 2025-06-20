import java.util.Scanner;
public class Pattern15 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        // Reverse Letter Triangle Pattern
        for (int i = 0; i <n ; i++) {
            for (char ch = 'A'; ch <= 'A' + (n-i-1); ch++) {
                System.out.print(ch + " ");
               
            }
            System.out.println();
        }
    }
}

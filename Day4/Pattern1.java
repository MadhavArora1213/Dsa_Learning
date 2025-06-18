import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args){

        // Rectangular Star Pattern
// This program prints a square pattern of stars with size n x n  (N-forest pattern)
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

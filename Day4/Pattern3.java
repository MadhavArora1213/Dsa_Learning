
import java.util.Scanner;

public class Pattern3 {

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        // Right-Angled Number Pyramid

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j + " "); 
            }
            System.out.println();
        }
    }
}


import java.util.Scanner;

public class Pattern2 {

    public static void main(String[] args) {


        //Right-Angled Triangle Pattern
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        for(int i=0;i<=n;i++){
            for(int j=0;j<i;j++){
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line after printing stars for the current row
        }
    }
}

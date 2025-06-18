import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        
          int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        // Inverted Right Pyramid

        for(int i=n;i>=1;i--){
            for(int j=i;j>=1;j--){
                System.out.print("* "); 
            }
            System.out.println();
        }
    }
}

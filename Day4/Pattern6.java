import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        // Inverted Numbered Right Pyramid

        for(int i=0;i<n;i++){
            for(int j=n;j>i;j--){
                System.out.print(n-j+1 + " "); 
            }
            System.out.println();
        }
    }
}

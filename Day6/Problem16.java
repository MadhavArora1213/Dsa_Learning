import java.util.Scanner;
public class Problem16 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        n = sc.nextInt();

        // 
        for (int i = 0; i < n; i++) {
            for (int j =0; j <i; j++) {
                 System.out.print((char)((int)('A'+i)) + " ");
            }
            System.out.println();
        }
    }
}

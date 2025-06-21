
public class Pattern17 {
    public static void main(String[] args) {
        int n = 5; // You can change this value for more rows

        // Reverse Letter Triangle Pattern
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + (n - i - 1); ch++) {
                System.out.print(ch + " ");
            }
            System.out.println(); // Move to the next line
        }
    }
}

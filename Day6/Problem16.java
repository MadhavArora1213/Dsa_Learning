public class Problem16 {
    public static void main(String[] args) {
     
        // 
      int rows = 5; // You can change this value for more rows

        for (int i = 1; i <= rows; i++) {
            char ch = (char) ('A' + i - 1); // Calculate the character
            for (int j = 1; j <= i; j++) {
                System.out.print(ch);
            }
            System.out.println(); // Move to the next line
        }
    }
}

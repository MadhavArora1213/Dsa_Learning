public class Palindrome {
    public static void main(String[] args) {
       
        int n = 12321;
        int originalN = n; // Store the original number
        int revN = 0;

        while(n > 0){
            int LastDigit = n % 10; // Get the last digit   
            revN = revN * 10 + LastDigit; // Build the reversed number
            n = n / 10; // Remove the last digit from n
        }

        if(revN == originalN) {
            System.out.println("The number is a palindrome.");
        } else {
            System.out.println("The number is not a palindrome.");
        }

    }
}
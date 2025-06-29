public class Armstrong {
    public static void main(String[] args) {
        
        int n =35;
        int originalN = n; // Store the original number
        int sum = 0;

        while(n>0){
            int lastDigit =n%10;
            sum += lastDigit * lastDigit * lastDigit; // Cube the last digit and add to sum
            n = n / 10; // Remove the last digit from n
        }
        if(sum == originalN) {
            System.out.println("The number is an Armstrong number.");
        } else {
            System.out.println("The number is not an Armstrong number.");
        }
    }
}

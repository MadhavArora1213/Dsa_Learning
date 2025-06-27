public class Count_Digit {
    public static void main(String[] args) {
       
        int n =77896789;
        int count = 0;
        while(n>0){
            int lastDigit = n % 10; // Get the last digit
            n = n/10;
            count++; // Increment the count for each digit

        }
        System.out.println("The number of digits is: " + count);
    }

}
public class Factorial_Recursive {
    public static void main(String[] args) {
        int n =5;

        int fact = factorial(n);
        System.out.println("Factorial of " + n + " is: " + fact);
    }

    public static int factorial(int n){
        if( n==0 || n==1){
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}

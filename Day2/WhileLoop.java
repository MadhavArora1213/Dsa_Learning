public class WhileLoop {
    public static void main(String[] args){

        // Factorial of a number 

        int n = 6;
        int fact = 1;

        for (int i=1;i<=n;i++){
            fact = fact*i;
        }
        System.out.println("Factorial of " + n + " is: " + fact);
    }
}

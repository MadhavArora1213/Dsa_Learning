// Optimized version as using List and checking up to the square root of n
import java.util.ArrayList;
import java.util.List;

public class Optimized_Way_Print_All_Divisors {
    public static void main(String[] args) {

        int n = 36;
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        // Sort the divisors list
        divisors.sort(null);

        // Print all divisors
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }
    }
}

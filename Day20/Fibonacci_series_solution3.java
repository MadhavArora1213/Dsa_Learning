public class Fibonacci_series_solution3 {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fib(n));

    }
    static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}

// Given a number n, find the sum of first n natural numbers using recursion functional way (without using parameters for sum).
public class SumOfNaturalNNumberFunctionalWay {
    public static void main(String[] args) {
        int n = 6;
        int result = sum(n);
        System.out.println(result);
    }

    public static int sum(int n) {
        if (n == 0) {
            return 0;
        }
        return n + sum(n - 1);
    }
}

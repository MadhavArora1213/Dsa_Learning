// Sum of first n natural numbers using recursion parameterized version

public class SumOfNaturalNumber {
    public static void main(String[] args) {
        int n= 6;
        func(n, 0);
    }   
    public static void func(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }
        func(i - 1, sum + i);
    }
}

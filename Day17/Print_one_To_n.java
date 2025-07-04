// Print numbers from 1 to n using recursion using forward recursion.

public class Print_one_To_n {
    public static void main(String[] args) {
        
        int n =6;
   
        func(1,n);
    }
    public static void func(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println(i);
        func(i + 1, n);
    }
}

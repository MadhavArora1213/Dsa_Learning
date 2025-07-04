// Print n to 1 using recursion

public class Print_n_To_1 {
    public static void main(String[] args) {
        
        int n =6;
   
        func(n,n);
    }
    public static void func(int i, int n) {
        if (i < 1) {
            return;
        }
        System.out.println(i);
        func(i - 1, n);
    }
}

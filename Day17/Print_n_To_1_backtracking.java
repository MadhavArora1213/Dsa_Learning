// print n to 1 using backtracking

public class Print_n_To_1_backtracking {
     public static void main(String[] args) {
        
        int n =6;

        func(1,n);
    }
    public static void func(int i, int n) {
        if (i > n) {
            return;
        }
        func(i + 1, n);
        System.out.println(i);

    }
}

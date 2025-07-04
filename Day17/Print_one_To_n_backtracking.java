// Print numbers from 1 to n using backtracking

public class Print_one_To_n_backtracking {
     public static void main(String[] args) {
        
        int n =6;
   
        func(n,n);
    }
    public static void func(int i, int n) {
        if (i < 1) {
            return;
        }
        func(i - 1, n);
        System.out.println(i);

    }
}

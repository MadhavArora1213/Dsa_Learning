

public class Print_Name {
    public static void main(String[] args) {
        
        int n =6;
   
        func(1,n);
    }
    public static void func(int i, int n) {
        if (i > n) {
            return;
        }
        System.out.println("Madhav");
        func(i + 1, n);
    }
}

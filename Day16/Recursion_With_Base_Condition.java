// 

public class Recursion_With_Base_Condition {
// global variable to keep track of the count
    static int count = 0;

    public static void main(String[] args) {
        func();
    }

    public static void func() {
        // This function demonstrates a proper base condition
        if (count == 5) {
            return; // Base condition to stop recursion
        }

        System.out.println(count);
        count++;
        func();

    }

}

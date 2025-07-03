// This code demonstrates a recursive function that does not have a base condition,
// which will lead to a stack overflow error if executed. It is important to always have a
// base condition in recursive functions to prevent infinite recursion.

public class RecursionWithoutBaseCondition {
    public static void main(String[] args) {
      func();
    }
    public static void func() {
        // This function calls itself indefinitely without a base condition
        System.out.println(1);
        func(); // Recursive call without a base condition
    }

    
}
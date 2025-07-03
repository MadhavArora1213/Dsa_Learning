# Recursion in Java

## Table of Contents
1. [What is Recursion?](#what-is-recursion)
2. [How Recursion Works](#how-recursion-works)
3. [Base Case and Recursive Case](#base-case-and-recursive-case)
4. [Call Stack and Memory](#call-stack-and-memory)
5. [Types of Recursion](#types-of-recursion)
6. [Basic Examples](#basic-examples)
7. [Advanced Examples](#advanced-examples)
8. [Recursion vs Iteration](#recursion-vs-iteration)
9. [Time and Space Complexity](#time-and-space-complexity)
10. [Common Mistakes](#common-mistakes)
11. [Best Practices](#best-practices)
12. [Practice Problems](#practice-problems)

## What is Recursion?

Recursion is a programming technique where a function calls itself directly or indirectly to solve a problem. It's a powerful concept that allows us to solve complex problems by breaking them down into smaller, similar subproblems.

### Key Characteristics:
- A function that calls itself
- Solves problems by reducing them to smaller versions of the same problem
- Must have a terminating condition (base case)
- Elegant solution for problems with repetitive structure

## How Recursion Works

When a function calls itself, the program creates a new instance of that function on the call stack. Each recursive call has its own set of local variables and parameters.

```java
public static int factorial(int n) {
    // Base case
    if (n <= 1) {
        return 1;
    }
    // Recursive case
    return n * factorial(n - 1);
}
```

### Execution Flow:
1. Function is called with initial parameter
2. Check base case - if true, return result
3. If false, make recursive call with modified parameter
4. Wait for recursive call to return
5. Process the returned value
6. Return final result

## Base Case and Recursive Case

### Base Case
- The condition that stops the recursion
- Must be simple and solvable without further recursion
- Prevents infinite recursion
- Every recursive function must have at least one base case

### Recursive Case
- The part where the function calls itself
- Must progress toward the base case
- Usually involves a smaller or simpler version of the original problem

```java
public static int fibonacci(int n) {
    // Base cases
    if (n <= 0) return 0;
    if (n == 1) return 1;
    
    // Recursive case
    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

## Call Stack and Memory

### Call Stack
- Each recursive call is pushed onto the call stack
- When a function returns, it's popped from the stack
- Stack stores local variables, parameters, and return addresses

### Memory Usage
- Each recursive call uses stack memory
- Deep recursion can lead to stack overflow
- Java default stack size is usually around 1MB

```java
// Stack visualization for factorial(3):
// factorial(3) -> 3 * factorial(2)
//                     factorial(2) -> 2 * factorial(1)
//                                         factorial(1) -> 1
//                                     returns 2 * 1 = 2
//                 returns 3 * 2 = 6
```

## Types of Recursion

### 1. Direct Recursion
Function calls itself directly.

```java
public static int sum(int n) {
    if (n <= 0) return 0;
    return n + sum(n - 1);
}
```

### 2. Indirect Recursion
Function calls another function, which eventually calls the first function.

```java
public static boolean isEven(int n) {
    if (n == 0) return true;
    return isOdd(n - 1);
}

public static boolean isOdd(int n) {
    if (n == 0) return false;
    return isEven(n - 1);
}
```

### 3. Tail Recursion
The recursive call is the last operation in the function.

```java
public static int factorialTail(int n, int acc) {
    if (n <= 1) return acc;
    return factorialTail(n - 1, n * acc);
}
```

### 4. Head Recursion
Operations are performed after the recursive call returns.

```java
public static void printNumbers(int n) {
    if (n <= 0) return;
    printNumbers(n - 1);  // Recursive call first
    System.out.println(n); // Operation after
}
```

### 5. Tree Recursion
Function makes multiple recursive calls.

```java
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2); // Two recursive calls
}
```

## Basic Examples

### 1. Factorial
```java
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

### 2. Sum of Natural Numbers
```java
public static int sum(int n) {
    if (n <= 0) return 0;
    return n + sum(n - 1);
}
```

### 3. Power Function
```java
public static int power(int base, int exp) {
    if (exp == 0) return 1;
    return base * power(base, exp - 1);
}
```

### 4. Count Digits
```java
public static int countDigits(int n) {
    if (n == 0) return 0;
    return 1 + countDigits(n / 10);
}
```

### 5. Reverse a Number
```java
public static int reverse(int n, int rev) {
    if (n == 0) return rev;
    return reverse(n / 10, rev * 10 + n % 10);
}
```

## Advanced Examples

### 1. Binary Search
```java
public static int binarySearch(int[] arr, int target, int left, int right) {
    if (left > right) return -1;
    
    int mid = left + (right - left) / 2;
    
    if (arr[mid] == target) return mid;
    else if (arr[mid] > target) return binarySearch(arr, target, left, mid - 1);
    else return binarySearch(arr, target, mid + 1, right);
}
```

### 2. Tower of Hanoi
```java
public static void towerOfHanoi(int n, char source, char destination, char auxiliary) {
    if (n == 1) {
        System.out.println("Move disk 1 from " + source + " to " + destination);
        return;
    }
    
    towerOfHanoi(n - 1, source, auxiliary, destination);
    System.out.println("Move disk " + n + " from " + source + " to " + destination);
    towerOfHanoi(n - 1, auxiliary, destination, source);
}
```

### 3. Generate Permutations
```java
public static void permute(String str, String result) {
    if (str.length() == 0) {
        System.out.println(result);
        return;
    }
    
    for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        String remaining = str.substring(0, i) + str.substring(i + 1);
        permute(remaining, result + ch);
    }
}
```

### 4. Tree Traversal
```java
class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int val) {
        this.val = val;
    }
}

public static void inorderTraversal(TreeNode root) {
    if (root == null) return;
    
    inorderTraversal(root.left);
    System.out.print(root.val + " ");
    inorderTraversal(root.right);
}
```

## Recursion vs Iteration

### Recursion Advantages:
- Clean and elegant code
- Natural for problems with recursive structure
- Easier to understand for complex problems
- Less code required

### Recursion Disadvantages:
- Higher memory usage (call stack)
- Slower execution due to function call overhead
- Risk of stack overflow
- Difficult to debug

### Iteration Advantages:
- More memory efficient
- Faster execution
- No risk of stack overflow
- Easier to debug

### Iteration Disadvantages:
- More complex code for recursive problems
- May require explicit stack or queue
- Less intuitive for certain problems

### Example Comparison:
```java
// Recursive Factorial
public static int factorialRecursive(int n) {
    if (n <= 1) return 1;
    return n * factorialRecursive(n - 1);
}

// Iterative Factorial
public static int factorialIterative(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

## Time and Space Complexity

### Time Complexity
- Depends on the number of recursive calls
- Often related to the depth of recursion
- Can be exponential for problems like naive Fibonacci

### Space Complexity
- O(depth) for the call stack
- Additional space for local variables in each call

### Examples:
```java
// Linear recursion: O(n) time, O(n) space
public static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}

// Exponential recursion: O(2^n) time, O(n) space
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// Optimized with memoization: O(n) time, O(n) space
public static int fibonacciMemo(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    
    memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
    return memo[n];
}
```

## Common Mistakes

### 1. Missing Base Case
```java
// Wrong - infinite recursion
public static int badFunction(int n) {
    return n + badFunction(n - 1); // No base case!
}

// Correct
public static int goodFunction(int n) {
    if (n <= 0) return 0; // Base case
    return n + goodFunction(n - 1);
}
```

### 2. Wrong Base Case
```java
// Wrong - never reaches base case
public static int badFactorial(int n) {
    if (n == 0) return 1;
    return n * badFactorial(n - 1); // What if n is negative?
}

// Correct
public static int goodFactorial(int n) {
    if (n <= 1) return 1; // Handles negative and zero
    return n * goodFactorial(n - 1);
}
```

### 3. Not Progressing Toward Base Case
```java
// Wrong - infinite recursion
public static int badSum(int n) {
    if (n == 0) return 0;
    return n + badSum(n); // Not progressing toward base case
}

// Correct
public static int goodSum(int n) {
    if (n <= 0) return 0;
    return n + goodSum(n - 1); // Progressing toward base case
}
```

### 4. Stack Overflow
```java
// Can cause stack overflow for large n
public static int fibonacci(int n) {
    if (n <= 1) return n;
    return fibonacci(n - 1) + fibonacci(n - 2);
}

// Better approach with memoization
public static int fibonacciMemo(int n) {
    int[] memo = new int[n + 1];
    return fibHelper(n, memo);
}

private static int fibHelper(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != 0) return memo[n];
    
    memo[n] = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
    return memo[n];
}
```

## Best Practices

### 1. Always Define Base Case First
```java
public static int example(int n) {
    // Base case first
    if (n <= 0) return 0;
    
    // Recursive case
    return n + example(n - 1);
}
```

### 2. Ensure Progress Toward Base Case
```java
public static int countdown(int n) {
    if (n <= 0) return 0;
    System.out.println(n);
    return countdown(n - 1); // Always decreasing n
}
```

### 3. Use Memoization for Overlapping Subproblems
```java
public static int fibonacci(int n) {
    Map<Integer, Integer> memo = new HashMap<>();
    return fibHelper(n, memo);
}

private static int fibHelper(int n, Map<Integer, Integer> memo) {
    if (n <= 1) return n;
    if (memo.containsKey(n)) return memo.get(n);
    
    int result = fibHelper(n - 1, memo) + fibHelper(n - 2, memo);
    memo.put(n, result);
    return result;
}
```

### 4. Consider Tail Recursion
```java
public static int factorialTail(int n) {
    return factorialHelper(n, 1);
}

private static int factorialHelper(int n, int acc) {
    if (n <= 1) return acc;
    return factorialHelper(n - 1, n * acc);
}
```

### 5. Validate Input Parameters
```java
public static int factorial(int n) {
    if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
    if (n <= 1) return 1;
    return n * factorial(n - 1);
}
```

## Practice Problems

### Beginner Level
1. **Print numbers from 1 to n**
2. **Calculate sum of digits**
3. **Check if number is palindrome**
4. **Find GCD of two numbers**
5. **Print array elements**

### Intermediate Level
1. **Generate all subsets of a set**
2. **Solve N-Queens problem**
3. **Find all paths in a maze**
4. **Implement quick sort**
5. **Calculate Catalan numbers**

### Advanced Level
1. **Solve Sudoku puzzle**
2. **Find longest common subsequence**
3. **Implement expression evaluation**
4. **Solve graph coloring problem**
5. **Find all Hamiltonian paths**

## Sample Solutions

### 1. Print Numbers 1 to N
```java
public static void printNumbers(int n) {
    if (n <= 0) return;
    printNumbers(n - 1);
    System.out.println(n);
}
```

### 2. Sum of Digits
```java
public static int sumOfDigits(int n) {
    if (n == 0) return 0;
    return (n % 10) + sumOfDigits(n / 10);
}
```

### 3. Check Palindrome
```java
public static boolean isPalindrome(String str, int start, int end) {
    if (start >= end) return true;
    if (str.charAt(start) != str.charAt(end)) return false;
    return isPalindrome(str, start + 1, end - 1);
}
```

### 4. GCD using Euclidean Algorithm
```java
public static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
}
```

### 5. Generate Subsets
```java
public static void generateSubsets(int[] arr, int index, List<Integer> current, List<List<Integer>> result) {
    if (index == arr.length) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    // Include current element
    current.add(arr[index]);
    generateSubsets(arr, index + 1, current, result);
    
    // Exclude current element
    current.remove(current.size() - 1);
    generateSubsets(arr, index + 1, current, result);
}
```

## Conclusion

Recursion is a powerful programming technique that can make complex problems more manageable. While it may seem challenging at first, understanding the fundamental concepts of base cases, recursive cases, and the call stack will help you master this important concept.

Remember:
- Always define a clear base case
- Ensure progress toward the base case
- Be mindful of stack overflow for deep recursion
- Consider iterative solutions for better performance when needed
- Practice with various problems to build intuition

With practice and understanding, recursion becomes an invaluable tool in your programming arsenal, especially for problems involving trees, graphs, and divide-and-conquer algorithms.

---

*Happy coding and keep practicing recursion!*
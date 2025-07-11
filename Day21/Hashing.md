# 🔑 Hashing in Data Structures

## Introduction to Hashing

Hashing is a technique that optimizes data retrieval operations by pre-storing information and fetching it efficiently. It's fundamentally based on two key steps: **pre-storing** and **fetching**.

### Why Hashing is Important

Consider this example:
- Given array: `[1, 2, 1, 3, 2]` 
- Queries: `[1, 3, 4, 2, 10]`
- We need to count occurrences of each queried number

#### Brute Force Approach
```java
public static int countOccurrence(int[] arr, int number) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == number) {
            count++;
        }
    }
    return count;
}
```

**Time Complexity**: 
- Each query takes O(N) time
- For Q queries: O(Q*N)
- When Q and N are large (e.g., 10^5), it becomes O(10^10) operations

## Number Hashing

### Basic Implementation

The optimized approach using hashing:

1. **Pre-storing**: Create a frequency array (hash array)
2. **Fetching**: Directly access the count from the hash array

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Precompute
        int[] hash = new int[13]; // Assuming max element is 12
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        int q = sc.nextInt();
        while (q-- != 0) {
            int number = sc.nextInt();
            // Fetching
            System.out.println(hash[number]);
        }
    }
}
```

### Limitations

- Cannot handle large numbers (e.g., 10^9)
- Maximum array size is limited (typically ~10^7)

## Character Hashing

### Mapping Characters to Integers

#### Case 1: Lowercase Letters Only
- Map 'a' → 0, 'b' → 1, ..., 'z' → 25
- Formula: `character - 'a'`
- Hash array size: 26

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();

        // Precompute
        int[] hash = new int[26];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            char c = sc.next().charAt(0);
            // Fetch
            System.out.println(hash[c - 'a']);
        }
    }
}
```

#### Case 2: Uppercase Letters Only
- Map 'A' → 0, 'B' → 1, ..., 'Z' → 25
- Formula: `character - 'A'`
- Hash array size: 26

#### Case 3: Mixed Case Letters
- Use ASCII values directly
- Hash array size: 256

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();

        // Precompute
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            char c = sc.next().charAt(0);
            // Fetch
            System.out.println(hash[c]);
        }
    }
}
```

## Hashing Large Numbers: Maps

For large numbers like 10^9, we use maps instead of arrays:

### HashMap in Java

```java
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Precompute
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int freq = 0;
            if (mp.containsKey(key)) freq = mp.get(key);
            freq++;
            mp.put(key, freq);
        }

        int q = sc.nextInt();
        while (q-- > 0) {
            int number = sc.nextInt();
            // Fetch
            if (mp.containsKey(number)) System.out.println(mp.get(number));
            else System.out.println(0);
        }
    }
}
```

### Map vs Array Hashing

Example array: `[1, 2, 3, 1, 3, 2, 12]`

- **Array hashing**: Requires array of size 13
- **Map hashing**: Only stores required elements (1→2, 2→2, 3→2, 12→1)

## Time Complexity

- **HashMap/TreeMap operations**:
  - HashMap (Java): O(1) average case, O(N) worst case
  - TreeMap (Java): O(log N) consistent

## Collision in Hashing

Collision occurs when multiple elements map to the same hash index.

### Division Method

A common technique to map large numbers to smaller indices:
- Hash function: `element % m` (where m is hash table size)
- Example with array `[2, 5, 16, 28, 139]` and modulo 10:
  - 2 % 10 = 2
  - 5 % 10 = 5
  - 16 % 10 = 6
  - 28 % 10 = 8
  - 139 % 10 = 9

### Handling Collisions

When multiple elements map to the same index (e.g., `[2, 5, 16, 28, 139, 38,
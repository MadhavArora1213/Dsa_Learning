# 🫧 Bubble Sort Algorithm

## Introduction

Bubble Sort is a simple comparison-based sorting algorithm. It repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted. The largest (or smallest) elements "bubble up" to their correct position in each pass.

---

## How Bubble Sort Works

1. Start from the first element.
2. Compare each pair of adjacent elements.
3. Swap them if they are in the wrong order.
4. Repeat the process for all elements.
5. After each pass, the largest unsorted element moves to its correct position.
6. Continue until no swaps are needed in a pass.

---

## Example

**Input:**  
`[5, 1, 4, 2, 8]`

**Steps:**
- Pass 1: `[1, 4, 2, 5, 8]`
- Pass 2: `[1, 2, 4, 5, 8]`
- Pass 3: `[1, 2, 4, 5, 8]` (No swaps, array is sorted)

**Output:**  
`[1, 2, 4, 5, 8]`

---

## Java Implementation

```java
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }
}
```

---

## Time and Space Complexity

| Case        | Time Complexity | Space Complexity |
|-------------|----------------|-----------------|
| Best Case   | O(n)           | O(1)            |
| Average     | O(n²)          | O(1)            |
| Worst Case  | O(n²)          | O(1)            |

- **Stable?** Yes
- **In-place?** Yes

---

## When to Use Bubble Sort

- For educational purposes
- When simplicity is preferred over efficiency
- For small datasets

---

## Summary

Bubble Sort is easy to implement and understand but inefficient for large datasets. It is mainly used for teaching sorting concepts and for small
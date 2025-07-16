# 📋 Selection Sort Algorithm

## Introduction

Selection Sort is a simple comparison-based sorting algorithm. It divides the input array into two parts: the sorted part at the beginning and the unsorted part at the end. The algorithm repeatedly selects the smallest (or largest, depending on sorting order) element from the unsorted part and swaps it with the first unsorted element, moving the boundary of the sorted part one step forward.

---

## How Selection Sort Works

1. Start from the first element.
2. Find the minimum element in the unsorted part of the array.
3. Swap it with the first unsorted element.
4. Move the boundary of the sorted part one step forward.
5. Repeat until the array is sorted.

---

## Example

**Input:**  
`[64, 25, 12, 22, 11]`

**Steps:**
- Find minimum (11), swap with 64 → `[11, 25, 12, 22, 64]`
- Find minimum (12), swap with 25 → `[11, 12, 25, 22, 64]`
- Find minimum (22), swap with 25 → `[11, 12, 22, 25, 64]`
- Find minimum (25), swap with 25 → `[11, 12, 22, 25, 64]`
- Array is sorted.

**Output:**  
`[11, 12, 22, 25, 64]`

---

## Java Implementation

```java
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // Swap minimum element with first unsorted element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }
}
```

---

## Time and Space Complexity

| Case        | Time Complexity | Space Complexity |
|-------------|----------------|-----------------|
| Best Case   | O(n²)          | O(1)            |
| Average     | O(n²)          | O(1)            |
| Worst Case  | O(n²)          | O(1)            |

- **Stable?** No (can be made stable with extra effort)
- **In-place?** Yes

---

## When to Use Selection Sort

- When memory is limited (in-place sorting)
- For small datasets
- When simplicity is preferred over efficiency

---

## Summary

Selection Sort is easy to implement and understand but inefficient for large datasets. It is mainly used for educational purposes and
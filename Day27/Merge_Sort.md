# 🧩 Merge Sort Algorithm

## Introduction

Merge Sort is a classic divide-and-conquer sorting algorithm. It divides the input array into two halves, recursively sorts each half, and then merges the sorted halves to produce the final sorted array. Merge Sort is known for its predictable O(n log n) time complexity and stability.

---

## How Merge Sort Works

1. **Divide:** Split the array into two halves.
2. **Conquer:** Recursively sort each half.
3. **Combine:** Merge the two sorted halves into a single sorted array.

---

## Example

**Input:**  
`[38, 27, 43, 3, 9, 82, 10]`

**Steps:**
- Divide: `[38, 27, 43]` and `[3, 9, 82, 10]`
- Recursively sort both halves
- Merge: `[27, 38, 43]` and `[3, 9, 10, 82]` → `[3, 9, 10, 27, 38, 43, 82]`

**Output:**  
`[3, 9, 10, 27, 38, 43, 82]`

---

## Java Implementation

```java
public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
```

---

## Time and Space Complexity

| Case        | Time Complexity | Space Complexity |
|-------------|----------------|-----------------|
| Best Case   | O(n log n)     | O(n)            |
| Average     | O(n log n)     | O(n)            |
| Worst Case  | O(n log n)     | O(n)            |

- **Stable?** Yes
- **In-place?** No (uses extra space for merging)

---

## When to Use Merge Sort

- When stability is required
- For sorting linked lists
- For large datasets where worst-case performance matters

---

## Summary

Merge Sort is a stable, efficient, and predictable sorting algorithm. Its O(n log n) time complexity makes it suitable for large datasets, though it requires
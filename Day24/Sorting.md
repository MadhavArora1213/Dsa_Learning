# 🔀 Sorting Algorithms Overview

## Introduction

Sorting is the process of arranging data in a particular order (ascending or descending). It is a fundamental operation in computer science, used in searching, data analysis, and many algorithms.

---

## Why Sorting is Important

- Makes searching faster (e.g., binary search)
- Helps in data organization and presentation
- Used in algorithms like merge intervals, finding duplicates, etc.

---

## Types of Sorting Algorithms

### 1. Bubble Sort
- Repeatedly compares and swaps adjacent elements.
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Stable:** Yes
- **In-place:** Yes

### 2. Selection Sort
- Selects the minimum (or maximum) element and places it at the correct position.
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Stable:** No
- **In-place:** Yes

### 3. Insertion Sort
- Builds the sorted array one element at a time by inserting elements into their correct position.
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Stable:** Yes
- **In-place:** Yes

### 4. Merge Sort
- Divides the array into halves, sorts them, and merges them.
- **Time Complexity:** O(n log n)
- **Space Complexity:** O(n)
- **Stable:** Yes
- **In-place:** No

### 5. Quick Sort
- Picks a pivot, partitions the array, and sorts recursively.
- **Time Complexity:** O(n log n) average, O(n²) worst
- **Space Complexity:** O(log n)
- **Stable:** No
- **In-place:** Yes

### 6. Heap Sort
- Builds a heap and repeatedly extracts the maximum/minimum.
- **Time Complexity:** O(n log n)
- **Space Complexity:** O(1)
- **Stable:** No
- **In-place:** Yes

---

## Comparison Table

| Algorithm      | Best Case | Average Case | Worst Case | Space | Stable | In-place |
|----------------|----------|--------------|------------|-------|--------|----------|
|
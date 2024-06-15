package com.gbm.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] arr = new int[]{3, 5, 4, 6, 8, 2, 1, 9, 0, 7};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, arr);
    }

    @Test
    public void testQuickSortSingleElement() {
        int[] arr = new int[]{5};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

}

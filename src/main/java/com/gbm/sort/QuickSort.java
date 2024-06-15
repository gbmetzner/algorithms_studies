package com.gbm.sort;

public class QuickSort {

    public void quickSort(int[] values) {

        if (values == null || values.length == 0) {
            return;
        }

        quicksort(values, 0, values.length - 1);
    }

    private void quicksort(int[] values, int first, int last) {
        int i = first, j = last;

        int pivot = values[(last + first) / 2];

        while (i <= j) {

            while (values[i] < pivot) {
                i++;
            }

            while (values[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(values, i, j);
                i++;
                j--;
            }
        }

        if (first < j) {
            quicksort(values, first, j);
        }
        if (i < last) {
            quicksort(values, i, last);
        }

    }
    private void swap(int[] values, int i, int j) {
        int temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

}

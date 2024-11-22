package com.gbm.sort;

public class SelectionSort {

	public void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			var minIndex = getMinIndex(arr, i);
			var tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
	}

	private int getMinIndex(int[] arr, int i) {
		var minIndex = i;
		for (var j = i + 1; j < arr.length; j++) {
			if (arr[j] < arr[minIndex]) {
				minIndex = j;
			}
		}
		return minIndex;
	}
}

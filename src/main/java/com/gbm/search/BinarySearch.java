package com.gbm.search;

public class BinarySearch {

	public int binarySearch(int[] arr, int target) {

		var low = 0;
		var high = arr.length - 1;

		while (low <= high) {
			var mid = (low + high) / 2;

			var midValue = arr[mid];
			if (midValue == target) {
				return mid;
			}

			if (midValue < target) {
				low = mid + 1;
			}

			if (midValue > target) {
				high = mid - 1;
			}
		}
		return -1;
	}
}

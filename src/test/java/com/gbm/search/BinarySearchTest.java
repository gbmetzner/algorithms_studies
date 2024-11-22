package com.gbm.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	@Test
	public void testBinarySearchFindNumber() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int item = 6;
		BinarySearch binarySearch = new BinarySearch();
		var result = binarySearch.binarySearch(arr, item);
		assertEquals(item, arr[result]);
	}

	@Test
	public void testBinarySearchDontFindNumber() {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		int item = 16;
		BinarySearch binarySearch = new BinarySearch();
		var result = binarySearch.binarySearch(arr, item);
		assertEquals(-1, result);
	}
}

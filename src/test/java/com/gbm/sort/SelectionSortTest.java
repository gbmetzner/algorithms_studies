package com.gbm.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SelectionSortTest {

	@Test
	public void testSelectionSortUnsortedSequence() {
		var selectionSort = new SelectionSort();
		var toBeSorted = new int[]{5, 4, 3, 2, 1};
		selectionSort.selectionSort(toBeSorted);
		assertArrayEquals(new int[]{1, 2, 3, 4, 5}, toBeSorted);
	}

	@Test
	public void testSelectionSortUnsortedNonSequence() {
		var selectionSort = new SelectionSort();
		var toBeSorted = new int[]{5, 4, 2, 1, 3, 8, 6, 12, 4};
		selectionSort.selectionSort(toBeSorted);
		assertArrayEquals(new int[]{1, 2, 3, 4, 4, 5, 6, 8, 12}, toBeSorted);
	}
}

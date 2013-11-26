package fr.utt.huffman.utils;

import java.util.Arrays;

/**
 * Class to make a QSort on an array
 * 
 * @author cyprien
 * 
 */
public class QSortArray {
	/**
	 * Main method of the class: launch the QSort
	 * 
	 * @param array
	 *            The array to sort
	 * @return A sorted array
	 */
	public static int[] sort(int[] array) {
		// Check for empty or null array
		if (array == null || array.length == 0) {
			return null;
		}

		// Launch QSort
		int[] sortedArray = new int[array.length];
		System.arraycopy(array, 0, sortedArray, 0, array.length);
		quicksort(sortedArray, 0, sortedArray.length - 1);

		return sortedArray;
	}

	/**
	 * The QSort algorithm
	 * 
	 * @param array
	 *            The array to sort
	 * @param low
	 *            Start of the sorting section
	 * @param high
	 *            End of the sorting section
	 */
	private static void quicksort(int[] array, int low, int high) {
		int i = low, j = high;
		// Pivot element is the middle of the array
		int pivot = array[low + (high - low) / 2];

		// Divide into two array
		while (i <= j) {
			// If the current value from the left array is smaller than the
			// pivot element
			// then get the next element from the left list
			while (array[i] < pivot) {
				i++;
			}

			// If the current value from the right array is larger than the
			// pivot element
			// then get the next element from the right list
			while (array[j] > pivot) {
				j--;
			}

			// If we have found a value in the left array larger than the pivot
			// Or a value from the right array smaller than the pivot
			// Then we exchange the two values
			// Then increase i and j
			if (i <= j) {
				exchange(array, i, j);
				i++;
				j--;
			}
		}

		// Recursion
		if (low < j)
			quicksort(array, low, j);
		if (i < high)
			quicksort(array, i, high);
	}

	/**
	 * Exchange two values of the array
	 * 
	 * @param array
	 *            The Array where are the two values
	 * @param i
	 *            Index of the first value
	 * @param j
	 *            Index of the second value
	 */
	private static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}

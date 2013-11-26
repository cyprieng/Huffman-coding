package fr.utt.huffman.utils;

/**
 * Class managing small handling on arrays
 * 
 * @author cyprien
 * 
 */
public class ArrayUtils {
	/**
	 * Delete the 0 values of a sorted array (without negative value)
	 * 
	 * @param array
	 *            The sorted array where we want to proceed
	 * @return An array without 0
	 */
	public static int[] deleteZero(int[] array) {
		// We scan the array
		for (int i = 0; i < array.length; i++) {
			if (array[i] != 0) {
				// The value is not 0, and the array is sorted. So we just keep
				// the end of the array
				int[] arrayWithoutZero = new int[array.length - i];
				System.arraycopy(array, i, arrayWithoutZero, 0,
						arrayWithoutZero.length);
				return arrayWithoutZero;
			}
		}

		return null;
	}
}

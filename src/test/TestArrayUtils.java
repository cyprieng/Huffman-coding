package test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import fr.utt.huffman.utils.ArrayUtils;

public class TestArrayUtils {

	@Test
	public void testDeleteZero() {
		// Test with null array
		assertTrue("Error with null table", ArrayUtils.deleteZero(null) == null);

		// Test array without zero
		int testArray[] = { 1, 5, 78, 89, 23, 33 };
		int expected[] = { 1, 5, 78, 89, 23, 33 };
		testArray = ArrayUtils.deleteZero(testArray);

		for (int i = 0; i < testArray.length; i++) {
			assertTrue("Error with array without zero",
					testArray[i] == expected[i]);
		}

		// Test array with negative number
		int testArray2[] = { -10, -5, 0, 0, 15, 33 };
		int expected2[] = { 15, 33 };
		testArray2 = ArrayUtils.deleteZero(testArray2);

		for (int i = 0; i < testArray2.length; i++) {
			assertTrue("Error with array with negative number",
					testArray2[i] == expected2[i]);
		}

		// Test standard array
		int testArray3[] = { 0, 0, 0, 5, 8, 96, 101, 56 };
		int expected3[] = { 5, 8, 96, 101, 56 };
		testArray3 = ArrayUtils.deleteZero(testArray3);

		for (int i = 0; i < testArray3.length; i++) {
			assertTrue("Error with standad array",
					testArray3[i] == expected3[i]);
		}
	}

}

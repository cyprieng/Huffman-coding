package fr.utt.huffman;

import java.util.Arrays;

import fr.utt.huffman.utils.ArrayUtils;
import fr.utt.huffman.utils.QSortArray;

/**
 * Class caculating an Huffman Tree
 * 
 * @author cyprien
 * 
 */
public class HuffmanCalc {
	/**
	 * 
	 * @param asciiFreq
	 *            The array[ascii] = freq
	 */
	public HuffmanCalc(int asciiFreq[]) {
		int[] sortedFreq = QSortArray.sort(asciiFreq);
		sortedFreq = ArrayUtils.deleteZero(sortedFreq);
		int[] ascii = getAsciiFromFreq(asciiFreq, sortedFreq);
		System.out.println(Arrays.toString(sortedFreq));
		System.out.println(Arrays.toString(ascii));
	}

	/**
	 * Retrieve ascii from freq
	 * 
	 * @param asciiFreq
	 *            The array[ascii] = freq
	 * @param freq
	 *            The sorted freq array
	 * @return The ascii array where return[i] => freq[i]
	 */
	public int[] getAsciiFromFreq(int[] asciiFreq, int[] freq) {
		int[] ascii = new int[freq.length];

		for (int i = 0; i < ascii.length; i++) {
			for (int j = 0; j < asciiFreq.length; j++) {
				if (asciiFreq[j] == freq[i]) {
					boolean change = true;
					for (int k = 0; k <= i; k++) {
						if (ascii[k] == j) {
							change = false;
						}
					}

					if (change) {
						ascii[i] = j;
						break;
					}
				}
			}
		}

		return ascii;
	}
}

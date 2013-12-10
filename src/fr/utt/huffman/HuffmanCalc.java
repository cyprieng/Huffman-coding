package fr.utt.huffman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	 * Store ascii char
	 */
	int ascii[];

	/**
	 * Store ascii char frequency
	 */
	int freq[];

	/**
	 * Constructor
	 * 
	 * @param asciiFreq
	 *            The array[ascii] = freq
	 */
	public HuffmanCalc(int asciiFreq[]) {
		freq = QSortArray.sort(asciiFreq);
		freq = ArrayUtils.deleteZero(freq);
		ascii = getAsciiFromFreq(asciiFreq, freq);
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
	private int[] getAsciiFromFreq(int[] asciiFreq, int[] freq) {
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

	/**
	 * Calc the Huffman Tree
	 * 
	 * @param freq
	 *            The sorted frequency array
	 * @param ascii
	 *            The ascii char array where ascii[i] correspond to freq[i]
	 * @return The huffman tree
	 */
	public HuffmanTree calcTree() {
		List<HuffmanTree> ht = new ArrayList<HuffmanTree>();
		HuffmanTree root = new HuffmanTree(-1, 0);

		while (freq.length > 1) { // For all freq
			int indexRight = 0;
			int indexLeft = 0;

			// Get index of HuffmanTree list
			if (ascii[0] < 0) { // Existing node
				indexRight = -ascii[0] - 1;
			} else {
				// We create a node
				ht.add(new HuffmanTree(ascii[0], freq[0]));
				indexRight = ht.size() - 1;
			}

			if (ascii[1] < 0) { // Existing node
				indexLeft = -ascii[1] - 1;
			} else {
				// We create a node
				ht.add(new HuffmanTree(ascii[1], freq[1]));
				indexLeft = ht.size() - 1;
			}

			int total = freq[1] + freq[0]; // Total frequency

			// Create a node linked to the two element of the index above
			if (freq[0] < freq[1]) {
				ht.add(new HuffmanTree(-1, total, ht.get(indexLeft), ht
						.get(indexRight)));
			} else {
				ht.add(new HuffmanTree(-1, total, ht.get(indexRight), ht
						.get(indexLeft)));
			}

			int newFreq[] = new int[freq.length - 1];
			int newAscii[] = new int[freq.length - 1];

			// We delete the two first cell of each table, and we insert the
			// total in the array
			int shift = 0;
			for (int i = 0; i < newFreq.length; i++) {
				if (i == newFreq.length - 1 && shift == 0) { // We are at the
																// end of the
																// array and we
																// have not
																// insert the
																// total yet =>
																// we insert it
					newFreq[i] = total;
					newAscii[i] = -ht.size(); // Store the node index
					break;
				} else if (total < freq[i + 2 - shift] && shift == 0) { // The
																		// next
																		// element
																		// is
																		// highter
																		// than
																		// the
																		// total
																		// => we
																		// insert
																		// it
					newFreq[i] = total;
					newAscii[i] = -ht.size(); // Store the node index
					shift++; // Indicate that the shift is changed
				} else {
					// We shift the arrays
					newFreq[i] = freq[i + 2 - shift];
					newAscii[i] = ascii[i + 2 - shift];
				}
			}

			freq = newFreq;
			ascii = newAscii;

		}

		// Return root of the HuffmanTree
		root = ht.get(ht.size() - 1);
		return root;
	}
}

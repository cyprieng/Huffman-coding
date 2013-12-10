package fr.utt.huffman.coding;

import java.util.BitSet;

import fr.utt.huffman.HuffmanTree;

/**
 * Class calculating the binary code for each char
 * 
 * @author cyprien
 * 
 */
public class CharCoding {
	/**
	 * Calc the binary code, and print it in the given array. Please note that
	 * this method return an extra 1 at the end of each code to fix the length
	 * of the code to the right one.
	 * 
	 * @param ht
	 *            The huffman tree
	 * @param level
	 *            The actual level of the tree (for external call, pass 0)
	 * @param code
	 *            The code of the first level (if you don't know, pass
	 *            "new BitSet()")
	 * @param ascii
	 *            The ascii array of BitSet to fill
	 */
	public static void getBinaryCharCode(HuffmanTree ht, int level,
			BitSet code, BitSet[] ascii) {
		if (ht != null) {
			// Add 1 to the code of the right part
			BitSet right = new BitSet();
			right = code.get(0, code.length());
			right.set(level, true);

			getBinaryCharCode(ht.getRight(), level + 1, right, ascii); // Fetch
																		// right
																		// part
																		// of
																		// the
																		// tree

			// It is a leaf
			if (ht.getAscii() >= 0) {
				// Add 1 at the end of the code to fix the length
				BitSet code2 = new BitSet();
				code2 = code.get(0, code.length());
				code2.set(level, true);

				ascii[ht.getAscii()] = code2; // Set code
			}

			// Add 0 to the code of the left part
			BitSet left = new BitSet();
			left = code.get(0, code.length());
			left.set(level, false);

			getBinaryCharCode(ht.getLeft(), level + 1, left, ascii); // Fetch
																		// left
																		// part
																		// of
																		// the
																		// tree
		}
	}
}

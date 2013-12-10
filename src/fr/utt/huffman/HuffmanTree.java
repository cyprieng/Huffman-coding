package fr.utt.huffman;

/**
 * Class to store the Hufmman tree
 * 
 * @author cyprien
 * 
 */
public class HuffmanTree {
	/**
	 * Right and left part of the tree
	 */
	private HuffmanTree left, right;

	/**
	 * Ascii code of the cell
	 */
	private int ascii;

	/**
	 * Frequency of the cell
	 */
	private int frequency;

	/**
	 * Constructor of a leaf
	 * 
	 * @param asciiCode
	 *            ascii code of the char (-1 if it is not a char)
	 * @param frequency
	 *            frequency of the char
	 */
	public HuffmanTree(int asciiCode, int frequency) {
		left = right = null;

		this.ascii = asciiCode;
		this.frequency = frequency;
	}

	/**
	 * Constructor of a cell
	 * 
	 * @param asciiCode
	 *            ascii code of the char (-1 if it is not a char)
	 * @param frequency
	 *            frequency of the char
	 * @param left
	 *            left child
	 * @param right
	 *            right child
	 */
	public HuffmanTree(int asciiCode, int frequency, HuffmanTree left,
			HuffmanTree right) {
		this.ascii = asciiCode;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	/**
	 * Print the HuffmanTree in the given StringBuilder
	 * 
	 * @param ht
	 *            The HuffmanTree to print
	 * @param level
	 *            The level of the tree (Give 0)
	 * @param str
	 *            The StringBuilder in which the function will print
	 */
	public static void print(HuffmanTree ht, int level, StringBuilder str) {
		if (ht != null) {
			HuffmanTree.print(ht.right, level + 1, str); // Print right part

			// Add tabulation for the level
			for (int i = 0; i < level; i++) {
				str.append("\t");
			}

			str.append(ht.ascii + "(" + ht.frequency + ")\n"); // Print the info
																// of the cell

			HuffmanTree.print(ht.left, level + 1, str); // Print the left part
		}
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("");
		print(this, 0, str);
		return str.toString();
	}

	/**
	 * Get the left part of the tree
	 * 
	 * @return The left part of the tree
	 */
	public HuffmanTree getLeft() {
		return left;
	}

	/**
	 * Get the right part of the tree
	 * 
	 * @return The right part of the tree
	 */
	public HuffmanTree getRight() {
		return right;
	}

	/**
	 * Get the ascii code of the node
	 * 
	 * @return The ascii code of the node
	 */
	public int getAscii() {
		return ascii;
	}

	/**
	 * Get the frequency of the node
	 * 
	 * @return The frequency of the node
	 */
	public int getFrequency() {
		return frequency;
	}
}

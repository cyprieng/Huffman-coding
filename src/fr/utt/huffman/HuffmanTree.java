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

	@Override
	public String toString() {
		return "HuffmanTree [left=" + left + ", right=" + right + ", ascii="
				+ ascii + ", frequency=" + frequency + "]";
	}
}

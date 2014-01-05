package fr.utt.huffman;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * File managing the decoding of an Huffman encoded file
 * 
 * @author cyprien
 * 
 */
public class HuffmanReverseCalc {
	/**
	 * The Huffman encoded file
	 */
	private FileInputStream fis;

	/**
	 * The huffman tree uses to decrypt
	 */
	private HuffmanTree ht;

	/**
	 * the byte which is read
	 */
	private byte actualByte;

	/**
	 * The position in the actual byte
	 */
	private int bytePos;

	/**
	 * The file decoded
	 */
	private StringBuilder decoded;

	/**
	 * The steps remaining before stop (-10 if no stop yet)
	 */
	private int stop;

	/**
	 * Constructor => init field
	 * 
	 * @param filename
	 *            The Huffman encoded file
	 * @param ht
	 *            The Huffman tree uses to decode
	 * @throws FileNotFoundException
	 */
	public HuffmanReverseCalc(String filename, HuffmanTree ht)
			throws FileNotFoundException {
		fis = new FileInputStream(filename);
		this.getNextByte();
		decoded = new StringBuilder();
		bytePos = -1;
		this.ht = ht;
		stop = -10;
	}

	/**
	 * Get the next byte of the file
	 */
	private void getNextByte() {
		try {
			if (fis.available() == 2) { // It remained 2 byte => Get next one
										// and the mask
				actualByte = (byte) fis.read();
				byte mask = (byte) fis.read();
				stop = 0;

				// Set the stop
				for (int i = 7; i >= 0; i--) {
					if ((mask & this.mask(i)) == (byte) Math.pow(2, 7 - i)) {
						stop++;
					}
				}
			} else { // Else, just get the next byte
				actualByte = (byte) fis.read();
			}
		} catch (IOException e) {
			actualByte = -1;
		}
	}

	/**
	 * Get the mask for the selected pos
	 * 
	 * @param bytePos
	 *            The position in the byte
	 * @return A mask uses for returning the right bit in a byte
	 */
	private byte mask(int bytePos) {
		return (byte) Math.pow(2, 7 - bytePos);
	}

	/**
	 * Get the next bit
	 * 
	 * @return A boolean corresponding to the next bit
	 */
	private boolean getNextBit() {
		bytePos++;

		// Get next byte
		if (bytePos > 7) {
			bytePos = 0;
			this.getNextByte();
		}

		// Decrease the stop counter
		if (stop != -10) {
			stop--;
		}

		// Returning the bit at the right pos of the byte
		return ((actualByte & this.mask(bytePos)) == (byte) Math.pow(2,
				7 - bytePos));
	}

	/**
	 * Check if we can continue to read
	 * 
	 * @return True if we can continue
	 */
	private boolean hasNext() {
		return !(stop < 0 && stop != -10);
	}

	/**
	 * Get the decoded huffman file
	 * 
	 * @return A string representing the decoded huffman file
	 */
	public String getDecryptedHuffmanFile() {
		this.decode(ht);
		try {
			fis.close();
		} catch (IOException e) {
		}
		return decoded.toString();
	}

	/**
	 * Decode the huffman encoded file
	 * 
	 * @param ht
	 *            The huffman tree uses to decode
	 */
	public void decode(HuffmanTree ht) {
		HuffmanTree ht2 = this.ht; // Get huffman tree

		while (this.hasNext()) {
			boolean bit = this.getNextBit();

			// Go on the right side of the tree
			if (bit) {
				ht2 = ht2.getRight();
			} else {
				ht2 = ht2.getLeft();
			}

			// The node of the tree is a char => write it in the StringBuilder
			if (ht2.getAscii() != -1) {
				if (ht2.getAscii() == 10) {
					decoded.append(System.lineSeparator());
				} else {
					decoded.append((char) ht2.getAscii());
				}
				ht2 = this.ht;
			}
		}
	}
}

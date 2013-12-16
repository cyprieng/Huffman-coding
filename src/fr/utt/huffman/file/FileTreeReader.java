package fr.utt.huffman.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import fr.utt.huffman.HuffmanTree;

/**
 * Class whiwh retrieve Huffman Tree from a file
 * 
 * @author cyprien
 * 
 */
public class FileTreeReader {
	/**
	 * Get the huffman tree stored in a file
	 * 
	 * @param filename
	 *            The name of the file where the huffman tree is stored
	 * @return The huffman tree
	 */
	public static HuffmanTree readTree(String filename) {
		HuffmanTree ht = new HuffmanTree(0, 0);

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					new File(filename)));

			try {
				ht = (HuffmanTree) ois.readObject();
			} catch (ClassNotFoundException e) {
			}

			ois.close();
		} catch (IOException e) {
		}

		return ht;
	}
}

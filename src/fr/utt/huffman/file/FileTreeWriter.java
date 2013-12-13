package fr.utt.huffman.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import fr.utt.huffman.HuffmanTree;

/**
 * Class which manage writing an huffman tree to a file
 * 
 * @author cyprien
 * 
 */
public class FileTreeWriter {
	/**
	 * Write an huffman tree to a file
	 * 
	 * @param ht
	 *            The huffman tree to write
	 * @param filename
	 *            The file to write
	 */
	public static void writeTree(HuffmanTree ht, String filename) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(new File(filename)));

			oos.writeObject(ht);

			oos.close();
		} catch (IOException e) {
		}
	}
}

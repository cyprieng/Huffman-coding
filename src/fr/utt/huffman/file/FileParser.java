package fr.utt.huffman.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * Class parsing a file to get the char's frequency
 * 
 * @author cyprien
 * 
 */
public class FileParser {
	/**
	 * Store the char's frequency
	 * 
	 * @see code ascii
	 */
	private int[] ascii;

	/**
	 * Constructor initializing the array, and launching the parsing
	 * 
	 * @param file
	 *            The file to parse
	 */
	public FileParser(String file) {
		ascii = new int[128];
		loadFile(file);
	}

	/**
	 * Read a file and calc the char's frequency
	 * 
	 * @param file
	 *            The file to parse
	 */
	public void loadFile(String file) {
		try (FileInputStream fis = new FileInputStream(file)) {
			byte[] buf = new byte[8];
			int n = 0;
			while ((n = fis.read(buf)) >= 0) {
				for (byte bit : buf) {
					ascii[bit]++;
				}
			}

		} catch (IOException e) {
		}
	}

	@Override
	public String toString() {
		return "FileParser [ascii=" + Arrays.toString(ascii) + "]";
	}
}

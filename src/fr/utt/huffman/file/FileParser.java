package fr.utt.huffman.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));

			String str;
			while ((str = br.readLine()) != null) {
				for (int i = 0; i < str.length(); i++) {
					ascii[(int) str.charAt(i)]++;
				}
			}

		} catch (IOException e) {
		}
	}

	/**
	 * Get the ascii array
	 * 
	 * @return the ascii array
	 */
	public int[] getAscii() {
		return ascii;
	}

	@Override
	public String toString() {
		return "FileParser [ascii=" + Arrays.toString(ascii) + "]";
	}
}

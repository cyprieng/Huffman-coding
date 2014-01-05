package fr.utt.huffman.file;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class uses to write string in file
 * 
 * @author cyprien
 * 
 */
public class FileStringWriter {
	/**
	 * Write the given string to the given file
	 * 
	 * @param txt
	 *            The string to write
	 * @param filename
	 *            Path of the file
	 */
	public static void writeStringToFile(String txt, String filename) {
		try {
			PrintWriter out = new PrintWriter(filename);

			out.print(txt);
			out.close();
		} catch (FileNotFoundException e) {
		}
	}
}

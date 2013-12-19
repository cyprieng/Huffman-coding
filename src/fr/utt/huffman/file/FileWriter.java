package fr.utt.huffman.file;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;

/**
 * Class writing huffman files
 * 
 * @author cyprien
 * 
 */
public class FileWriter {
	/**
	 * Write the coded original file in a new file
	 * 
	 * @param original
	 *            The path of the original file
	 * @param charCoding
	 *            The BitSet array of code for each char
	 * @return The byte length of the written file
	 */
	public static int writeFile(String original, BitSet[] charCoding) {
		int fileLength = 0; // Size of the written file

		try {
			// Get the content of the original file
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(original)));

			String originalContent = "";
			String str;
			boolean first = true;
			while ((str = br.readLine()) != null) {
				if (first) { // No \n if it is the first line
					originalContent += str;
					first = false;
				} else {
					originalContent += "\n" + str;
				}
			}

			// Create the new file
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(new File(original + ".huffman")));

			BitSet buffer = new BitSet(); // Buffer of 8 bits to write in the
											// file
			int size = 0; // Size of the buffer
			for (int i = 0; i < originalContent.length(); i++) { // Parse the
																	// original
																	// file

				// Check if the char is in ascii table
				if ((int) originalContent.charAt(i) > 128)
					continue;

				for (int j = 0; j < charCoding[(int) originalContent.charAt(i)]
						.length() - 1; j++) { // Parse the code of the char

					// Left shift of the buffer
					for (int k = size; k > 0; k--) {
						buffer.set(k, buffer.get(k - 1));
					}

					// We add one bit code of the char
					buffer.set(0,
							charCoding[(int) originalContent.charAt(i)].get(j));
					size++;

					// Size = 8 => the buffer fill a byte
					if (size == 8) {
						// Write buffer in the file
						byte toWrite[] = buffer.toByteArray();
						bos.write(toWrite);
						buffer = new BitSet();
						fileLength++;
						size = 0;
					}
				}
			}

			// We have finished to write, but it may remain some bits
			if (size != 0) {
				// We put the bits to write at the beginning of the byte
				for (int k = 0; k < size; k++) {
					buffer.set(7 - k, buffer.get(size - k - 1));
					buffer.set(size - k - 1, false);
				}

				// We write the buffer
				byte toWrite[] = buffer.toByteArray();
				bos.write(toWrite);
				buffer = new BitSet();
				fileLength++;
			}

			// Create a mask
			size = (size == 0) ? 8 : size;
			for (int i = 7; i >= 8 - size; i--) {
				buffer.set(i, true);
			}

			// Write the mask
			byte toWrite[] = buffer.toByteArray();
			bos.write(toWrite);

			bos.close();
			br.close();

		} catch (IOException e) {
		}

		return fileLength;
	}
}

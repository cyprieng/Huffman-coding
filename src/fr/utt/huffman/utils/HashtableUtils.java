package fr.utt.huffman.utils;

import java.util.Hashtable;

/**
 * Utils to manage hastable for the Huffman coding
 * 
 * @author cyprien
 * 
 */
public class HashtableUtils {
	/**
	 * Get an hashtable from an array. Hashtable: key=array index; value=array
	 * value at index
	 * 
	 * @param array
	 *            The array to turn into an Hashtable
	 * @return The Hashtable
	 */
	public static Hashtable arraytoHashtable(int array[]) {
		Hashtable ht = new Hashtable();

		for (int i = 0; i < array.length; i++) {
			ht.put(i, array[i]);
		}

		return ht;
	}
}

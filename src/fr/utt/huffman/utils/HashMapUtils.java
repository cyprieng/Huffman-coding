package fr.utt.huffman.utils;

import java.util.HashMap;

/**
 * Utils to manage hasmap for the Huffman coding
 * 
 * @author cyprien
 * 
 */
public class HashMapUtils {
	/**
	 * Get an hashmap from an array. Hashmap: key=array index; value=array
	 * value at index
	 * 
	 * @param array
	 *            The array to turn into an Hashmap
	 * @return The Hashmap
	 */
	public static HashMap arraytoHashMap(int array[]) {
		HashMap hm = new HashMap();

		for (int i = 0; i < array.length; i++) {
			hm.put(i, array[i]);
		}

		return hm;
	}
}

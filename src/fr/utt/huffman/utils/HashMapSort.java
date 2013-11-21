package fr.utt.huffman.utils;

import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Map;

/**
 * Class to sort a map
 * 
 * @author cyprien
 * 
 */
public class HashMapSort {
	/**
	 * Sort a map into a List
	 * 
	 * @param map
	 *            The map to sort
	 * @return The sorted list
	 */
	public static <K, V extends Comparable<V>> List<Map.Entry<K, V>> sortMapByValue(
			Map<K, V> map) {
		// Create list
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(
				map.entrySet());

		// Define the comparator
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o2.getValue().compareTo(o1.getValue()));
			}
		});

		return list;
	}
}

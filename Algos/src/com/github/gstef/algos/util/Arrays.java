package com.github.gstef.algos.util;

public class Arrays {
	
	/**
	 * Searches the specified array of ints for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, the algorithm returns the first 
	 * index.
	 * @param array
	 * @param key
	 * @return index of the search key, if it is contained in the array; otherwise, -1.
	 */
	public static int linearSearch(int[] array, int key) {
		assert array != null;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key)
				return i;
		}
		return -1;
	}
	
	public static <T> int linearSearch(T[] array, T key) {
		assert array != null && key != null;
		for (int i = 0; i < array.length; i++) {
			if (key.equals(array[i])) {
				return i;
			}
		}
		return -1;
	}
	

}

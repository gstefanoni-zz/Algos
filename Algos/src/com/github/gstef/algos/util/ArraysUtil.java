package com.github.gstef.algos.util;

import java.util.Random;

public class ArraysUtil {
	
	/**
	 * Searches the specified array of ints for the specified value using the linear search algorithm.
	 * If the array contains multiple elements with the specified value, the algorithm returns the first 
	 * such index.
	 * @param array
	 * @param key
	 * @return index of the search key, if it is contained in the array; otherwise, -1.
	 */
	public static int linearSearch(int[] array, int key) {
		assert array != null;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return i;
			}
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
	
	/**
	 * Sorts the specified the int array into ascending order using the insertion sort algorithm.
	 * @param a the array to be sorted
	 */
	public static void insertionSort(int[] a) {
		assert a != null;
		for (int i = 1; i < a.length; i++) {
			int key = a[i];
			int j = i -1;
			while (j >= 0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}
	
	public static int[] randomIntArray(int[] array) {
		return randomIntArray(array, new Random());

	}
	
	public static int[] randomIntArray(int[] array, long seed) {
		return randomIntArray(array, new Random(seed));
	}
	
	public static int[] randomIntArray(int[] array, Random generator) {
		for (int i = 0; i < array.length; i++) {
			array[i] = generator.nextInt();
		}
		return array;
	}
}

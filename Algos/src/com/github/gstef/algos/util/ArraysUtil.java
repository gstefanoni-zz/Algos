package com.github.gstef.algos.util;

import java.util.Arrays;
import java.util.Random;

public class ArraysUtil {
	
	/**
	 * Searches an array of sorted integers for a specific value using binary search.
	 * @param array of sorted integers
	 * @param key
	 * @return index of the search key, if it is contained in the array; otherwise, -1.
	 */
	public static int binarySearch(int[] array, int key) {
		assert array != null;
		int left = 0;
		int right = array.length -1;
		int middle;
		while (right >= left) {
			middle = (left + right) >>> 1;
			if (array[middle] == key)
				return middle;
			else if (array[middle] > key) {
				right = middle -1;
			} else {
				// array[middle] < key
				left = middle +1;
			}		
		}
		return -1;
	}
	
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
	
	
	/**
	 * Sorting an array of ints using section sort:
	 * for each 0 \leq i < a.length, we find the index
	 * of the smallest element occurring in a[i+1,n]
	 * and exchange it with i.
	 * @param a
	 */
	public static void selectionSort(int[] a) {
		assert a != null;
		int minIndex = -1;
		int j = -1;
		for (int i = 0; i < a.length -1; i++) {
			minIndex = i;
			for (j = i+1; j < a.length; j++) {
				if (a[j] < a[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex)
				swap(a, i, minIndex);
		}
	}

	/**
	 * Auxiliary method for swapping two array elements.
	 * @param a
	 * @param i
	 * @param j
	 */
	protected static void swap(int[] a, int i, int j) {
		assert a != null && i < a.length && j < a.length;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
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
	
	/**
	 * A recursive implementation of the insertion sort algorithm
	 * @param a
	 */
	public static void recursiveInsertionSort(int[] a) {
		recursiveInsertionSort(a, a.length -1);
	}
	
	protected static void recursiveInsertionSort(int[] a, int index) {
		if (index > 0) {
			int key = a[index];
			recursiveInsertionSort(a, index-1);
			// the subarray a[0..index -1] is sorted, we now have to find the
			// right position where to add key
			int j = index - 1;
			while (j >=0 && a[j] > key) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}
	
	
	/**
	 * Sorts the given integer array using the mergesort
	 * algorithm
	 * @param a not-null integer array
	 */
	public static void mergeSort(int[] a) {
		assert a != null;		
		int[] b = Arrays.copyOf(a, a.length);
		mergeSort(b, 0, a.length -1,a);
	}
	
	/**
	 * Auxiliary procedure for sorting an integer array b[start..end]. The resulting
	 * sorted array is stored in a[start..end].
	 * @param b
	 * @param start
	 * @param end
	 * @param a
	 */
	protected static void mergeSort(int[] b, int start, int end, int[] a) {
		if (end > start) {	
			// int midpoint = (start + end)/2 can cause overflows; 
			int midpoint = (start + end) >>> 1;
			mergeSort(a, start, midpoint,b);
			mergeSort(a, midpoint +1, end,b);
			merge(b, start, midpoint, end,a);
		}
	}
	
	/**
	 * Merging two adjacent sorted subsequences a[p..q] and a[q+1..r]
	 * into a unique sorted sequence b[p..r].
	 * @param a the source array
	 * @param p 
	 * @param q 
	 * @param r 
	 * @param b the target array
	 */
	protected static void merge(int[] a, int p, int q, int r, int[] b) {
		assert p <= q && q <= r && r < a.length;
		int i = p; // index on the left array a[p..q]
		int j = q+1; // index on the right array a[q+1..r]
		for (int k = p; k <= r; k++) {
			if (i <= q && (j > r || a[i] <= a[j])) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
		}
	}
	
	/**
	 * Overwrites the given array with random integers.
	 * @param a
	 */
	public static void randomIntArray(int[] a) {
		randomIntArray(a, new Random());

	}
	
	/**
	 * Overwrites the given array with random integers.
	 * @param a
	 * @param seed
	 */
	public static void randomIntArray(int[] a, long seed) {
		randomIntArray(a, new Random(seed));
	}
	
	/**
	 * Overwrites the given array with random integers.
	 * @param a
	 * @param generator
	 */
	public static void randomIntArray(int[] a, Random generator) {
		for (int i = 0; i < a.length; i++) {
			a[i] = generator.nextInt();
		}
	}
	
	/**
	 * Determines whether there exists two indexes
	 * i and j in the array such that a[i] + a[j] = x
	 * @param a an array of integers
	 * @param x
	 * @return
	 */
	public static boolean biSum(int[] a, int x) {
		assert a != null;
		mergeSort(a);
		for (int i = 0; i < a.length; i++) {
			if (binarySearch(a, x - a[i]) >= 0) {
				return true;
			}
		}
		return false;
	}
}

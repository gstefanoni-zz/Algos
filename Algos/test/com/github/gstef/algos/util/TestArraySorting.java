package com.github.gstef.algos.util;

import java.util.Arrays;
import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class TestArraySorting extends TestCase {
	
	final int ARRAY_SIZE = 1000;
	final int ITERATIONS = 1000;
	final long SEED = 3514514561L;

	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	@Test
	public void testNullArray() {
		try {
			ArraysUtil.insertionSort(null);
			thrown.expect(NullPointerException.class);
		} catch (NullPointerException e) {}
	}
	
	public void testBubbleSort() {
		int[] array = new int[ARRAY_SIZE];
		Random generator = new Random(SEED);
		for (int k = 0; k < ITERATIONS; k++) {
			ArraysUtil.randomIntArray(array, generator);
			ArraysUtil.bubbleSort(array);
			assertTrue(isSorted(array));
		}
	}
	
	public void testIntegerInsertionSort() {
		int[] array = new int[ARRAY_SIZE];
		Random generator = new Random(SEED);
		for (int k = 0; k < ITERATIONS; k++) {
			ArraysUtil.randomIntArray(array, generator);
			ArraysUtil.insertionSort(array);
			assertTrue(isSorted(array));
		}
	}
	
	public void testIntegerRecInsertionSort() {
		int[] array = new int[ARRAY_SIZE];
		Random generator = new Random(SEED);
		for (int k = 0; k < ITERATIONS; k++) {
			ArraysUtil.randomIntArray(array, generator);
			ArraysUtil.recursiveInsertionSort(array);
			assertTrue(isSorted(array));
		}
	}
	
	public void testIntegerSelectionSort() {
		int[] array = new int[ARRAY_SIZE];
		Random generator = new Random(SEED);
		for (int k = 0; k < ITERATIONS; k++) {
			ArraysUtil.randomIntArray(array, generator);
			ArraysUtil.selectionSort(array);
			assertTrue(isSorted(array));
		}
	}
	
	public void testmergeSort() {
		int[] array = new int[ARRAY_SIZE];
		Random generator = new Random(SEED);
		for (int k = 0; k < ITERATIONS; k++) {
			ArraysUtil.randomIntArray(array, generator);
			ArraysUtil.mergeSort(array);
			assertTrue(isSorted(array));
		}
	}
	
	public void testMerge() {
		int[] firstArray = new int[ARRAY_SIZE];
		int[] secondArray = new int[ARRAY_SIZE];
		int[] array;
		int[] temp = new int[ARRAY_SIZE*2];
		Random generator = new Random(SEED);
		for (int k = 0; k < ITERATIONS; k++) {
			ArraysUtil.randomIntArray(firstArray, generator);
			ArraysUtil.randomIntArray(secondArray, generator);
			ArraysUtil.insertionSort(firstArray);
			ArraysUtil.insertionSort(secondArray);
			array = Arrays.copyOf(firstArray, ARRAY_SIZE *2);
			System.arraycopy(secondArray, 0, array, ARRAY_SIZE, ARRAY_SIZE);
			ArraysUtil.merge(array, 0, ARRAY_SIZE-1,  ARRAY_SIZE*2-1,temp);
			assertTrue(isSorted(temp));
		}
	}
	
	protected boolean isSorted(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if(array[i-1] > array[i])
				return false;
		}
		return true;
	}
}

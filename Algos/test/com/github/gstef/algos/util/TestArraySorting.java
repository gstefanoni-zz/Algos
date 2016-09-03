package com.github.gstef.algos.util;

import java.util.Random;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.TestCase;

public class TestArraySorting extends TestCase {
	
	final int ARRAY_SIZE = 1000;
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
	
	public void testIntegerInsertionSort() {
		int[] array = new int[ARRAY_SIZE];
		Random generator = new Random(123135);
		for (int k = 0; k < 1000; k++) {
			ArraysUtil.randomIntArray(array, generator);
			ArraysUtil.insertionSort(array);
			for (int i = 1; i < array.length; i++) {
				assertTrue(array[i-1] <= array[i]);
			}
		}
	}
}

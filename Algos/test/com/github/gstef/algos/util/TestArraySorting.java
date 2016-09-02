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
	
	public void testBinaryAddition() {
		
		int term1 = (int) (Math.random() * 1000); 
		int term2 = (int) (Math.random() * 1000); 

		String binary1 = new StringBuilder(Integer.toBinaryString(term1)).reverse().toString();		
		String binary2 = new StringBuilder(Integer.toBinaryString(term2)).reverse().toString();

		
		int length = Math.max(binary1.length(), binary2.length());
		int[] a = new int[length];
		int[] b = new int[length];
		
		for (int i = 0; i < length; i++) {
			if (i < binary1.length())
				a[i] = Character.getNumericValue(binary1.charAt(i));
			if (i < binary2.length())
				b[i] = Character.getNumericValue(binary2.charAt(i));
		}
		
		int[] binaryResult = ArraysUtil.binaryAddition(a, b);
		int result = 0;
		for (int i = 0; i < binaryResult.length; i++) {
			result += (binaryResult[i] << i);
		}
		assertEquals(term1 + term2, result);
	}
	
	
	
	
	
}

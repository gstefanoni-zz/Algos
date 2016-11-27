package com.github.gstef.algos.util;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import org.junit.Test;

import junit.framework.TestCase;

public class TestArraySearch extends TestCase  {
	
	final int ARRAY_SIZE = 1000;
	final int ITERATIONS = 1000;
	final long SEED = 538957389475L;

	@Test
	public void testEmptyArray() {
		int[] a = new int[0];
		assertEquals(-1, ArraysUtil.linearSearch(a, 1));
		assertEquals(-1, ArraysUtil.binarySearch(a, 1));
	}
	
	
	@Test
	public void testAbsentKey() {
		int[] a = new int[] {34,90548,24,54,23};
		assertEquals(-1, ArraysUtil.linearSearch(a, 1));
		Arrays.sort(a);
		assertEquals(-1, ArraysUtil.binarySearch(a, 1));
		a = new int[] {0};
		assertEquals(-1, ArraysUtil.linearSearch(a, 1));
		assertEquals(-1, ArraysUtil.binarySearch(a, 1));
	}
	
	@Test
	public void testPresentKey() {
		int[] a = new int[] {34,90548,24,54,23};
		for (int i = 0; i < a.length; i++) {
			assertEquals(i, ArraysUtil.linearSearch(a, a[i]));
		}
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			assertEquals(i, ArraysUtil.binarySearch(a, a[i]));
		}
		a = new int[] {0};
		assertEquals(0, ArraysUtil.linearSearch(a, 0));
		assertEquals(0, ArraysUtil.binarySearch(a, 0));
	}
	
	@Test
	public void testRandomPresentKey() {
		int[] a = new int[ARRAY_SIZE];
		for (int it = 0; it < ITERATIONS; it++) {
			ArraysUtil.randomIntArray(a, SEED);
			for (int i = 0; i < a.length; i++) {
				assertEquals(i, ArraysUtil.linearSearch(a, a[i]));
			}
			Arrays.sort(a);
			for (int i = 0; i < a.length; i++) {
				assertEquals(i, ArraysUtil.binarySearch(a, a[i]));
			}
		}
	}
	
	@Test
	public void testRandomAbsentKey() {
		int[] a = new int[ARRAY_SIZE];
		int[] absent = new int[ARRAY_SIZE];
		Random r = new Random(SEED);
		for (int it = 0; it < ITERATIONS; it++) {
			ArraysUtil.randomIntArray(a, r);
			for (int i = 0; i < absent.length; i++) {
				int missing = r.nextInt();
				while (contains(a, missing)) {
					missing = r.nextInt();
				}
				a[i] = missing;
			}
			for (int i = 0; i < absent.length; i++) {
				assertEquals(-1, ArraysUtil.linearSearch(a, absent[i]));
			}
			Arrays.sort(a);
			for (int i = 0; i < a.length; i++) {
				assertEquals(-1, ArraysUtil.binarySearch(a, absent[i]));
			}
		}
	}
	
	protected boolean contains(int[] a, final int absent) { 
		return IntStream.of(a).anyMatch(x -> x == absent);
	}

}

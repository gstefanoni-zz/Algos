package com.github.gstef.algos.util;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

public class TestBinaryUtil extends TestCase {
	
	
	@Test
	public void testGetBit() {
		assertEquals(1, BinaryUtil.getBit(2, 1));
		assertEquals(0, BinaryUtil.getBit(2, 0));
		assertEquals(1, BinaryUtil.getBit(72, 6));
		assertEquals(0, BinaryUtil.getBit(72, 7));
	}
	
	@Test
	public void testDecimalBinary() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Arrays.toString(BinaryUtil.decimalToUnsignedBinary(i)));
		}
	}
	
	@Test
	public void testBinaryToDecimal() {
		int[] a = {0,0,1};
		assertEquals(4, BinaryUtil.unsignedBinaryToDecimal(a));
		a = new int[] {0,0,1,1,1,0,0,1};
		assertEquals(156, BinaryUtil.unsignedBinaryToDecimal(a));
	}
	
	@Test
	public void testBinaryAddition() {
		int term1 = (int) (Math.random() * 100000); 
		int term2 = (int) (Math.random() * 100000); 

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
		assertEquals(term1 + term2, BinaryUtil.unsignedBinaryToDecimal(BinaryUtil.add(a, b)));
		assertEquals(term1 + term2, BinaryUtil.unsignedBinaryToDecimal(BinaryUtil.addBM(a, b)));

	}
	
	@Test
	public void testTwoPowers() {
		for (int i = 0; i < 20; i++) {
			assertEquals((int) Math.pow(2, i), BinaryUtil.powerTwo(i));

		}
	}

}

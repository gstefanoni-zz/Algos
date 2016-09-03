package com.github.gstef.algos.util;

public class BinaryUtil {
	
	public static int getBit(int number, int index) {
		return (number >> index) & 1;
	}
	
	/**
	 * Represents the given binary number in decimal
	 * @param a the array encoding the binary number from LSB to MSB
	 * @return the decimal representation of a
	 */
	public static int unsignedBinaryToDecimal(int[] a) {
		assert a != null;
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			result += a[i] << i;
		}
		return result;
	}
	
	public static int[] decimalToUnsignedBinary(int number) {
		assert number >= 0;
		int[] binary = new int[32];
		int index = 0;
		while (number > 0) {
			binary[index] = number % 2;
			number = number >>> 1;
			index++;
		}
		return binary;
	}
	
	/**
	 * Returns the k-th power of two
	 * @param k
	 * @return
	 */
	public static int powerTwo(int k) {
		return 1 << k;
	}
	
	/**
	 * Adds the binary numbers encoded in the two arrays. The arrays
	 * encode binary numbers from the least to the most significant bits.
	 * @param a
	 * @param b
	 * @return An array c such that binary(c) = binary(a) + binary(b).
	 */
	public static int[] add(int[] a, int[] b) {
		assert a != null && b != null;
		// making sure that a is always the longest of the two arrays
		if (a.length < b.length) {
			int[] swap = a;
			a = b;
			b = swap;
		}
		int[] sum = new int[a.length+1];
		int partialSum;
		for (int i = 0; i < a.length; i++) {
			partialSum = a[i] + sum[i];
			if (i < b.length) {
				partialSum += b[i];
			}
			// computing the least significant bit of the sum
			sum[i] = partialSum % 2; 
			// computing the carry
			sum[i+1] = partialSum / 2; 
		}
		return sum;
	}
	
	/**
	 * Adds the two binary numbers encoded in the two arrays
	 * using the Brookhouse Method of Binary Addition.
	 * @see <a href="https://en.wikipedia.org/wiki/Binary_number#Addition">Brookhouse Method of Binary Addition</a>
	 * @param a
	 * @param b
	 * @return
	 */
	public static int[] addBM(int[] a, int[] b) {
		assert a != null && b != null;
		// making sure that a is always the longer array
		if (a.length < b.length) {
			int[] swap = a;
			a = b;
			b = swap;
		}
		int[] sum = new int[a.length + 1];
		int partialSum;
		int carry;
		int j;
		int i = 0;
		while (i < a.length) {
			partialSum = a[i] + sum[i];
			if (i < b.length) {
				partialSum += b[i];
			}
			// compute the sum and carry
			sum[i] = partialSum % 2;
			carry = partialSum / 2;
			
			// Apply the long carry method 
			j = i + 1;
			if (carry == 1) {
				while (j < a.length && a[j] == 1) {
					sum[j] = b[j];
					j++;
				}
			}
			//store the carry
			sum[j] = carry; 	
			i = j;
		}
		return sum;
	}
}

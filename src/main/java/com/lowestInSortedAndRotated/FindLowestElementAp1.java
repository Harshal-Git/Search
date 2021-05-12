/**
 * 
 */
package com.lowestInSortedAndRotated;

import java.util.Arrays;

/**
 * @author Harshal-Git
 * 
 *	Assumptions:
 *	An array of distinct numbers, sorted in increasing order. The array has been rotated (clockwise - right shifted) k number of times.
 *	This 'k' is unknown. Find lowest element from this array.
 *
 *	Approach 1: Linear search. Find lowest element from complete array. 
 *
 *	-> Time complexity: O(n) - linear search for lowest element in the given array  
 *
 *	-> Space complexity: O(1) - apart from 1 variable; no other data structures are used.
 *
 *	-> Instead of returning lowest element, we can return index of the lowest element; which will be a rotation count for given array.
 */
public class FindLowestElementAp1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// case 1
		runCase(new int[] {15, 18, 2, 3, 6, 12});

		// case 2
		runCase(new int[] {7, 9, 11, 12, 5});

		// case 3
		runCase(new int[] {7, 9, 11, 12, 15});
	}

	/**
	 * print results
	 * @param data - array data
	 */
	private static void runCase(int [] data) {
		// get rotation count
		System.out.println("Data: "+Arrays.toString(data)+" -> Lowest element : "+findLowestElement(data));
	}

	/**
	 * method to find lowest element from given sorted & rotated array
	 * @param data - array 
	 * @return - lowest element from given array
	 */
	private static int findLowestElement(int[] data) {
		// find lowest element index
		int lowestElement = -1;

		// if data is null
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array.");
		}

		// length validation
		int length = data.length;

		// if only one element exist OR array is not rotated at all
		if(length == 1 || (data[0] < data[length-1])) {
			lowestElement = data[0];
		}
		else {
			lowestElement = data[0];
			for(int index = 1; index < length; index++) {
				if(lowestElement > data[index]) {
					lowestElement  = data[index];
				}
			}
		}
		return lowestElement;
	}
}
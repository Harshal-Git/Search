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
 *	This approach might not give proper results with fully reverse sorted elements.
 *
 *	Approach 2: Binary search. 
 *
 * -> Time complexity: [NEED TO CALCULATE]  
 *
 * -> Space complexity: [NEED TO CALCULATE]
 *
 * -> Instead of returning lowest element, we can return index of the lowest element; which will be a rotation count for given array.
 */
public class FindLowestElementAp2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// case 1
		runCase(new int[] {5, 6, 1, 2, 3, 4});
		
		// case 2
		runCase(new int[] {1, 2, 3, 4});
		
		// case 3
		runCase(new int[] {1});
		
		// case 4
		runCase(new int[] {1, 2});
		
		// case 5
		runCase(new int[] {5, 6, 7, 1, 2, 3, 4});
		
		// case 6
		runCase(new int[] {1, 2, 3, 4, 5, 6, 7});
		
		// case 7
		runCase(new int[] {2, 3, 4, 5, 6, 7, 8, 1});
		
		// case 8
		runCase(new int[] {3, 4, 5, 1, 2});
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
		// if data is null
		if(data == null) {
			throw new IllegalArgumentException("Invalid input array.");
		}

		// length validation
		int length = data.length;

		// if only one element exist OR array is not rotated at all
		if(length == 1 || (data[0] < data[length-1])) {
			return data[0];
		} else {
			return findLowest(data, 0, (length-1));
		}
	}

	/**
	 * recursive method to find lowest element (based on recursive binary search)
	 * @param data - array elements
	 * @param start - start position
	 * @param end - end position
	 * @return return lowest element from given array
	 * 
	 * A method to find a pivot point for sorted + rotated array (inspired from binary search).
	 * Pivot point: An index 'n' in the array; such that a(n) > a(n+1). 
	 */
	private static int findLowest(int[] data, int start, int end) {
		// calculate mid position
		int mid = start + ((end - start)/2);

		// check if 'mid' is lowest element 
		if(data[mid] < data[mid-1]) {
			return data[mid];
		}
		// check if 'mid+1' is lowest element
		if(data[mid+1] < data[mid]) {
			return data[mid+1];
		}
		// decide whether to go for left OR right portion
		if(data[mid] < data[end]) {
			return findLowest(data, start, mid-1);
		} else {
			return findLowest(data, mid+1, end);
		}
	}
}
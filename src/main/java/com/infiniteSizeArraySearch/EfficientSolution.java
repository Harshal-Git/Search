/**
 * 
 */
package com.infiniteSizeArraySearch;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> a sorted array given with infinite elements (means array.length would be impossible to do) and find a given number 
 *		from that array.
 *
 *	-> optimized approach : this approach works in 2 phases:
 *
 *		P#1: iterate over the array from starting position and keep checking for the element. The moment array element 
 *			becomes greater than the given value; make that position as end point and previous position as start point.
 *
 *		Jumping indexes with double value; will give (log n) time complexity (same as dividing  in half gives in binary search)		
 *						
 *		P#2: Perform binary search from above start & end positions.
 *
 *	-> this algo is known as Unbounded binary search.
 *
 * -> Time complexity: O(log POSITION) + O(log POSITION) ~ O(log n)	
 * -> Space complexity:	[too large - infinite array]
 * -> Auxiliary space:	0(1)
 */
public class EfficientSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int searchElement;

		int [] data1 = {5, 10, 12, 15, 20, 26, 33, 45, 60, 80, 99};
		searchElement = 15;
		printMessage(data1, searchElement);

		int [] data2 = {5, 10, 12, 15, 20, 26, 33, 45, 60, 80, 99};
		searchElement = 20;
		printMessage(data2, searchElement);

		int [] data3 = {5, 10, 12, 15, 20, 26, 33, 45, 60, 80, 99};
		searchElement = 5;
		printMessage(data3, searchElement);

		int [] data4 = {20, 22, 26, 32, 40, 49, 62, 76, 92, 100};
		searchElement = 50;
		printMessage(data4, searchElement);
	}

	/**
	 * @param data1
	 * @param searchElement
	 */
	private static void printMessage(int[] data, int searchElement) {
		int searchIndex = searchElement(data, searchElement);
		if(searchIndex < 0) {
			System.out.println("\nArray "+Arrays.toString(data)+" does not contain element "+searchElement+".");
		} else {
			System.out.println("\nArray "+Arrays.toString(data)+" has element "+searchElement
					+" at position "+searchIndex+".");
		}
	}

	/**
	 * @param data
	 * @param searchElement
	 * @return
	 */
	private static int searchElement(int[] data, int searchElement) {

		// check first element
		if(data[0] == searchElement) {
			return 0;
		}

		// initializations
		int index = 1;

		// iterate over remaining elements to find possible index where element can be
		while(data[index] < searchElement) {

			// if element found at given index
			if(data[index] == searchElement) {
				return index;
			}
			// otherwise keep searching with doubled position
			index *= 2;
		} 
		/*
		 * after completion of above loop; we will have an end point at which search should end.
		 * to get start point, we can divide end point with 2 perform a binary search.
		 */
		return binarySearch(data, searchElement, (index/2), index);
	}

	/**
	 * @param data
	 * @param searchElement
	 * @param start
	 * @param end
	 * @return
	 */
	private static int binarySearch(int[] data, int searchElement, int start, int end) {
		int mid = -1;
		while(start <= end) {
			// find mid element
			mid = start + ((end-start)/2);
			// if mid element is the search element
			if(data[mid] == searchElement) {
				return mid;
			} else if(data[mid] > searchElement) {
				// if mid element is higher than the search element : search in left half
				end = (mid-1);
			} else {
				// if mid element is smaller than search element : search in right half
				start = (mid+1);
			}
		}
		// if no element found : return -1
		return -1;
	}
}

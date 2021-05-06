/**
 * 
 */
package com.binarySearch;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> perform search on given sorted array for given number.
 *
 *	-> Iterative solution: formula => start+((end-start)/2)
 *
 * -> Time complexity: O(log n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 */
public class IterativeAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int searchElement;

		int [] data1 = {2, 3, 6, 12, 15, 18};
		searchElement = 3;
		runCase(data1, searchElement);

		int [] data2 = {2, 3, 4, 10, 40}; 
		searchElement = 10;
		runCase(data2, searchElement);

		int [] data3 =  {1, 2, 3, 4, 5, 6, 7}; 
		searchElement = 9;
		runCase(data3, searchElement);
		
		int [] data4 =  {1, 2, 3, 4, 5, 6, 6, 7}; 
		searchElement = 6;
		runCase(data4, searchElement);
		
		int [] data6 =  {1, 2}; 
		searchElement = 1;
		runCase(data6, searchElement);
		
		int [] data7 =  {9}; 
		searchElement = 9;
		runCase(data7, searchElement);
		searchElement = 21;
		runCase(data7, searchElement);
	}

	/**
	 * @param data1
	 * @param searchElement1
	 */
	private static void runCase(int[] elements, int searchVal) {
		int searchIndex = binarySearchIT(elements, searchVal);
		if(searchIndex == -1) {
			System.out.println("\nSearch data: "+searchVal+" could not be found in array "
					+Arrays.toString(elements));
		} else {
			System.out.println("\nArray: "+Arrays.toString(elements)+" has search element = "
					+searchVal+" at position "+searchIndex+"."); 
		}
	}

	/**
	 * @param elements
	 * @param searchVal
	 * @return
	 */
	private static int binarySearchIT(int[] elements, int searchVal) {

		// initializations
		int size = elements.length;
		int start = 0;
		int end = (size-1);
		int mid = -1;

		while(start <= end) {

			// find mid element
			mid = start + ((end-start)/2);

			// if mid element is the search element
			if(elements[mid] == searchVal) {
				return mid;
			} else if(elements[mid] > searchVal) {
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

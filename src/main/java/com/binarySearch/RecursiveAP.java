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
 *	-> Recursive solution: formula => start+((end-start)/2)
 *
 * -> Time complexity: O(log n)	
 * -> Space complexity:	O(log n) - recursive call stack
 * -> Auxiliary space: O(log n) - recursive call stack
 */
public class RecursiveAP {

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
		int searchIndex = binarySearchREC(elements, searchVal, 0, (elements.length-1));
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
	 * @param start
	 * @param end
	 * @return
	 */
	private static int binarySearchREC(int[] elements, int searchVal, int start, int end) {

		// if no element found : return -1
		if(start > end) {
			return -1;
		}

		// find mid position
		int mid = (start+((end - start)/2));

		// if mid position element is search element
		if(elements[mid] == searchVal) {
			return mid;
		} else if(searchVal < elements[mid]) {
			// if search element is lower than mid element : search in left half
			return binarySearchREC(elements, searchVal, start, (mid-1));
		} else {
			// if search element is higher than mid element : search in right half
			return binarySearchREC(elements, searchVal, (mid+1), end);
		}
	}
}

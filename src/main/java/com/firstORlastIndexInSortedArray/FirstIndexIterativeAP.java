/**
 * 
 */
package com.firstORlastIndexInSortedArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find first index of given number from given sorted array. the array may contain duplicate elements.
 *
 *	ex:
 *		i/p : {1, 10, 10, 10, 20, 20, 40}	& x = 20 	=> o/p : 4
 *
 *		i/p : {10, 20, 30}	& x = 15 	=> o/p : -1
 *
 *		i/p : {15, 15, 15}	& x = 15 	=> o/p : 0
 *
 *	-> naive approach : linear search & find first ever occurrence with O(n) time complexity.
 *
 *  -> efficient approach iterative manner
 *  
 * -> Time complexity: O(log n)	
 * -> Space complexity:	0(n)
 * -> Auxiliary space: 0(1)
 */
public class FirstIndexIterativeAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int searchElement;

		int [] data1 = {1, 10, 10, 10, 20, 20, 40};
		searchElement = 20;
		printMessage(data1, searchElement);

		int [] data2 = {10, 20, 30};
		searchElement = 15;
		printMessage(data2, searchElement);

		int [] data3 = {15, 15, 15};
		searchElement = 15;
		printMessage(data3, searchElement);
		
		int [] data4 = {5, 8, 8, 10, 10};
		searchElement = 10;
		printMessage(data4, searchElement);
		
		int [] data5 = {8, 10, 10, 12};
		searchElement = 7;
		printMessage(data5, searchElement);
	}

	/**
	 * @param data
	 * @param searchElement
	 */
	private static void printMessage(int[] data, int searchElement) {
		int firstIndex = findFirstIndex(data, searchElement, 0, (data.length-1));
		if(firstIndex < 0) {
			System.out.println("\nNo element "+searchElement+" found in data: "+Arrays.toString(data));
		} else {
			System.out.println("\nData: "+Arrays.toString(data)+" has first occrrence of element "+searchElement
					+" at position = "+firstIndex);
		}
	}

	/**
	 * @param data
	 * @param searchElement
	 * @param start
	 * @param end
	 * @return
	 */
	private static int findFirstIndex(int[] data, int searchElement, int start, int end) {

		int mid = -1;

		while(start <= end) {

			// find mid
			mid = (start+((end-start)/2));

			// search right half
			if(data[mid] < searchElement) {
				start = (mid+1);
			} else if(data[mid] > searchElement) {
				// search left half
				end = (mid-1);
			} else {
				// check that current element is not it's first occurrence
				// and we have not encountered first element of the data yet.
				if(mid != 0 && (data[mid] == data[mid-1])) {
					// search left half
					end = (mid-1);  
				} else {
					// otherwise current element is first occurrence
					return mid;
				}
			}
		}
		// if no element found : return -1
		return -1;
	}
}
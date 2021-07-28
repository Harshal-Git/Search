/**
 * 
 */
package com.searchInSortedAndRotated;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> given a sorted array which is rotated by unknown times. a number 'k' is given and we need to find whether 'k' exist
 *		or not in  the given array. Rotation side is also unknown.
 *
 *  -> naive solution : linear search with O(n) complexity.
 *  
 *  -> efficient solution : using binary search
 *  
 * -> Time complexity: O(log n)	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(1)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int searchElement;

		int [] data1 = {10, 20, 30, 40, 50, 8, 9};
		searchElement = 30;
		printMessage(data1, searchElement);

		int [] data2 = {100, 200, 300, 10, 20};
		searchElement = 10;
		printMessage(data2, searchElement);

		int [] data3 = {100, 200, 500, 1000, 2000, 10, 20};
		searchElement = 100;
		printMessage(data3, searchElement);
		searchElement = 25;
		printMessage(data3, searchElement);

		int [] data4 = {10, 20, 40, 60, 5, 8};
		searchElement = 6;
		printMessage(data4, searchElement);

		int [] data5 = {100, 500, 10, 20, 30, 40, 50};
		searchElement = 40;
		printMessage(data5, searchElement);
		searchElement = 500;
		printMessage(data5, searchElement);
		searchElement = 50;
		printMessage(data5, searchElement);
	}

	/**
	 * @param data
	 * @param searchElement
	 * @return
	 */
	private static void printMessage(int[] data, int searchElement) {
		int position = binarySearch(data, searchElement);
		// print index accordingly
		if(position < 0) {
			System.out.println("\nArray: "+Arrays.toString(data)+" does not have element "+searchElement+".");
		} else {
			System.out.println("\nArray: "+Arrays.toString(data)+" has element "+searchElement
					+" at position: "+position);
		}
	}

	/**
	 * @param data
	 * @param searchElement
	 * @param start
	 * @param end
	 */
	private static int binarySearch(int[] data, int searchElement) {

		int size = data.length;
		int mid = -1;
		int start = 0;
		int end = (size-1);

		while(start <= end) {
			// find mid
			mid = (start+((end-start)/2));
			// if mid element is search element?
			if(data[mid] == searchElement) {
				return mid;
			} else if (data[start] < data[mid]) {					// when left half is sorted
				// check whether elements resides in the left half range? 
				if((searchElement >= data[start]) && (searchElement < data[mid])) {
					end = (mid-1);
				} else {
					// otherwise go to right half
					start = (mid+1);
				}
			} else {												// when right half is sorted 
				// check whether elements resides in the right half range?
				if((searchElement > data[mid]) && (searchElement <= data[end])) {
					start = (mid+1);
				} else {
					// otherwise go to left half
					end = (mid-1);
				}
			}
		}
		// no element exist
		return -1;
	}
}

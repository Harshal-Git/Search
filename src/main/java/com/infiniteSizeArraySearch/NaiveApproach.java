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
 * 	-> this is naive approach : linear search from start
 * 
 * -> Time complexity: O(POSITION)	
 * -> Space complexity:	[too large - infinite array]
 * -> Auxiliary space:	0(1)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int searchElement;

		int [] data1 = {5, 10, 12, 15, 20, 26, 33, 45, 60, 80, 99};
		searchElement = 15;
		printMessage(data1, searchElement);

		int [] data2 = {20, 40, 100, 150, 200, 300, 400, 500, 600, 800, 1000};
		searchElement = 50;
		printMessage(data2, searchElement);
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
		int index = 0;
		while(true) {
			// if current element is smaller than search element
			if(data[index] < searchElement) {
				index++;
			} else if(data[index] == searchElement) {
				// if current element is same as search element
				return index;
			} else {
				// if search element is not found and current element has exceeded the search value
				return -1;
			}
		}
	}
}

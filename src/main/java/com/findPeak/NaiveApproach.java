/**
 * 
 */
package com.findPeak;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Find a peak element from a given unsorted array. 
 *		Peak element : an element which is greater than both of it's neighbour elements.
 *
 *
 *	-> naive solution : linear search
 *
 *	ex:
 *		i/p = {5, 10, 20, 15, 7} => o/p = 20 (20 > 10 & 20 > 15)
 *
 *		i/p = {10, 20, 15, 5, 23, 90} => o/p = 20 or 90 (20 > 10 & 20 > 15 || 90 > 23)
 * 
 *		i/p = {80, 70, 60} => o/p = 80 (80 > 70)
 *
 *		i/p = {80, 70, 90} => o/p = 80 or 90 (80 > 70 & 90 > 70)
 *
 * -> Time complexity:	O(n)
 * -> Space complexity:	O(n)
 * -> Auxiliary space:  O(1)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {5, 10, 20, 15, 7};
		System.out.print("Array: "+Arrays.toString(data1)+" has peak element/s : ");
		printPeakElements(data1);

		int [] data2 = {10, 20, 15, 5, 23, 90};
		System.out.print("\nArray: "+Arrays.toString(data2)+" has peak element/s : ");
		printPeakElements(data2);

		int [] data3 = {80, 70, 90};
		System.out.print("\nArray: "+Arrays.toString(data3)+" has peak element/s : ");
		printPeakElements(data3);

		int [] data4 = {80, 70, 60};
		System.out.print("\nArray: "+Arrays.toString(data4)+" has peak element/s : ");
		printPeakElements(data4);
	}

	/**
	 * @param data
	 * @return
	 */
	private static void printPeakElements(int[] data) {

		int size = data.length;

		// single / border elements
		if(size == 1 || (data[0] > data[1])) {
			System.out.print(" "+data[0]);
		}

		// last element
		if(data[size-1] > data[size-2]) {
			System.out.print(" "+data[size-1]);
		}

		// iterate over all elements and find peak element
		for(int index = 1; index < (size-1); index++) {
			if((data[index] > data[index-1]) && (data[index] > data[index+1])) {
				System.out.print(" "+data[index]);
			}
		}
		System.out.println();
	}

}

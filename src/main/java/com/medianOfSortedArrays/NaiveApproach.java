/**
 * 
 */
package com.medianOfSortedArrays;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Given 2 sorted arrays. Find median of these sorted arrays.
 *	-> After combining both these arrays; based on the length of the array, we will have 2 possibilities:
 *
 *		1. If there is only one element as middle element, that will become median.
 *		2. If there are two elements as middle elements, then average of those will become median.
 *
 *	ex:
 *
 *	->  i/p: a1 = {10, 20, 30, 40, 50} & a2 = {5, 15, 25, 35, 45}
 *		=> resulting array: {5, 10, 15, 20, 25, 30, 35, 40, 45, 50}	=> middle elements = 25 & 30
 *		o/p: 27.5  ((25 + 30)/2)
 *
 *	-> 	i/p: a1 = {1, 2, 3, 4, 5, 6} & a2 = {10, 20, 30, 40, 50}	=> o/p : 6.0
 *
 *	-> 	i/p: a1 = {10, 20, 30, 40, 50, 60} & a2 = {1, 2, 3, 4, 5}	=> o/p : 10.0
 *  		
 *  -> naive approach:	combine both arrays & sort those. If length is even; then there will be 2 mid elements. If yes, then
 *  					find average of those numbers. Otherwise find the middle element and make it median.
 *  					
 * -> Time complexity: O(n1+n2 * log (n1+n2)) ~ O(n log n)	
 * -> Space complexity:	O(n1+n2) ~ O(n)
 * -> Auxiliary space: O(n1+n2) ~ O(n)
 * 
 * -> EFFICIENT SOLUTION FOR THIS IS PENDING.
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {10, 20, 30};
		int [] data2 = {5, 15, 25};
		printMessage(data1, data2);

		int [] data3 = {10, 20, 30};
		int [] data4 = {5, 15};
		printMessage(data3, data4);

		int [] data5 = {1, 2};
		int [] data6 = {10, 20};
		printMessage(data5, data6);

		int [] data7 = {10, 20, 30};
		int [] data8 = {1, 2, 3};
		printMessage(data7, data8);

	}

	/**
	 * @param data1
	 * @param data2
	 */
	private static void printMessage(int[] data1, int[] data2) {
		System.out.println("\nArrays: "+Arrays.toString(data1)+" & "+
				Arrays.toString(data2)+" has median = "+findMedian(data1, data2));
	}

	/**
	 * @param data1
	 * @param data2
	 * @return
	 */
	private static double findMedian(int[] data1, int[] data2) {

		int size1 = data1.length;
		int size2 = data2.length;

		int [] mergedArray = new int[size1+size2];

		// copy array1 into merged array 
		for(int index = 0; index < size1; index++) {
			mergedArray[index] = data1[index];
		}
		// copy array2 into merged array		
		for(int index = size1; index < mergedArray.length; index++) {
			mergedArray[index] = data2[index-size1];
		}

		// sort merged array
		Arrays.sort(mergedArray);

		// check mid position
		int newSize = mergedArray.length; 
		int mid = (newSize/2);
		double median;
		if((newSize % 2) == 0) {
			median = ((mergedArray[mid]+mergedArray[mid-1])/2.0);
		} else {
			median = mergedArray[mid];
		}
		return median;
	}

}

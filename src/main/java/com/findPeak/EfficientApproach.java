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
 *	-> efficient solution : binary search : it's based on the property that if from mid element, left element is greater than
 *		mid element, there will be a peak element on left can be found via binary search. And if right element is greater, 
 *		then peak can be found on right side with binary search.  
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
 * -> Time complexity:	O(log n)
 * -> Space complexity:	O(n)
 * -> Auxiliary space:  O(1)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {5, 10, 20, 15, 7};
		System.out.println("Array: "+Arrays.toString(data1)+" has peak element/s : "+getPeakElements(data1));

		int [] data2 = {10, 20, 15, 5, 23, 90};
		System.out.println("\nArray: "+Arrays.toString(data2)+" has peak element/s : "+getPeakElements(data2));

		int [] data3 = {80, 70, 90};
		System.out.println("\nArray: "+Arrays.toString(data3)+" has peak element/s : "+getPeakElements(data3));

		int [] data4 = {80, 70, 60};
		System.out.println("\nArray: "+Arrays.toString(data4)+" has peak element/s : "+getPeakElements(data4));

		int [] data5 = {5, 20, 40, 30, 20, 50, 60};
		System.out.println("\nArray: "+Arrays.toString(data5)+" has peak element/s : "+getPeakElements(data5));

		int [] data6 = {5, 10, 20, 40, 60, 80, 70};
		System.out.println("\nArray: "+Arrays.toString(data6)+" has peak element/s : "+getPeakElements(data6));

		int [] data7 = {5, 10, 20, 40, 60, 70, 80};
		System.out.println("\nArray: "+Arrays.toString(data7)+" has peak element/s : "+getPeakElements(data7));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int getPeakElements(int[] data) {

		int size = data.length;
		int start = 0;
		int end = size-1;
		int mid;

		while(start <= end) {

			// find mid
			mid = (start+((end-start)/2));

			// initial positions
			if(((mid == 0) || (data[mid-1] < data[mid])) && 
					((mid == (size-1)) || (data[mid+1] < data[mid]))) {
				return data[mid];
			} 
			else if ((mid > 0) && data[mid-1] >= data[mid]) {
				// perform left search
				end = (mid-1);
			} else {
				// perform right search
				start = (mid+1);
			}
		}
		// if no element found
		return -1;
	}
}

/**
 * 
 */
package com.mergeSortedArrays;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> merge 2 sorted arrays in sorted manner.
 *
 * -> Time complexity: O(n) + O(m) = O(n+m) ~ O(n)	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(n)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


		int [] data1 = {10, 20, 30, 40, 50};
		int [] data2 = {5, 15, 25, 35, 45};
		System.out.println("Array 1: "+Arrays.toString(data1));
		System.out.println("Array 2: "+Arrays.toString(data2));
		int [] merge1 = mergeArray(data1, data2);
		System.out.println("Merged array: "+Arrays.toString(merge1));
		
		int [] data3 = {1, 2, 3, 4, 5, 6};
		int [] data4 = {10, 20, 30, 40, 50};
		System.out.println("\nArray 1: "+Arrays.toString(data3));
		System.out.println("Array 2: "+Arrays.toString(data4));
		int [] merge2 = mergeArray(data3, data4);
		System.out.println("Merged array: "+Arrays.toString(merge2));
		
		int [] data5 = {10, 20, 30, 40, 50, 60};
		int [] data6 = {1, 2, 3, 4, 5};
		System.out.println("\nArray 1: "+Arrays.toString(data5));
		System.out.println("Array 2: "+Arrays.toString(data6));
		int [] merge3 = mergeArray(data5, data6);
		System.out.println("Merged array: "+Arrays.toString(merge3));
	}

	/**
	 * @param data1
	 * @param data2
	 * @return
	 */
	private static int[] mergeArray(int[] data1, int[] data2) {

		int size1 = data1.length;
		int size2 = data2.length;

		int [] mergedArray = new int[size1+size2];

		int index1 = 0;
		int index2 = 0; 
		int mergeIndex = 0;

		while(mergeIndex < (size1+size2)) {

			if((index1 < size1) && (index2 < size2)) {
				// check for lower elements from respective arrays
				// and send that into merged array
				if(data1[index1] < data2[index2]) {
					mergedArray[mergeIndex] = data1[index1];
					index1++;
				} else if(data1[index1] > data2[index2]) {
					mergedArray[mergeIndex] = data2[index2];
					index2++;
				} else {
					mergedArray[mergeIndex] = data1[index1];
					mergeIndex++;
					mergedArray[mergeIndex] = data2[index2];
					index1++;
					index2++;
				}
			} else if(index1 < size1) {
				mergedArray[mergeIndex] = data1[index1];
				index1++;
			} else {
				mergedArray[mergeIndex] = data2[index2];
				index2++;
			}
			mergeIndex++;
		}
		return mergedArray;
	}
}

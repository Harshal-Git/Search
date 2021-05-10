/**
 * 
 */
package com.findPairWithGivenSum;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *	
 *	-> find pair of 3 elements from an array whose sum is given number.
 *
 *	-> If the array is sorted; then we can use 2 pointers method to find a pair with 2 elements. This process can be iterated
 *		over the array once to find all 3 elements. 
 *
 *	-> If the array is not sorted, then we need to sort it once and then follow the same approach done above. 
 *
 *	-> Based on the given array sort status; we will have different time complexity; but it will be better than O(n^3)
 *
 * -> Time complexity:  when sorted array is given
 * 
 * 						 O(n) [for initial iteration] * O(n) [for 2 pointer method] = O(n^2) 
 * 
 * -> Time complexity: when array needs to be sorted
 * 						
 * 						O(n * log n) [for sorting] + (O(n) [for initial iteration] * O(n) [for 2 pointer method]) 
 * 					  = O(n * log n) * O(n^2)
 * 					  = O(n^2) 
 * 	
 * -> Space complexity:	O(n)
 * -> Auxiliary space:	0(1)	[changes to O(n) - if hashing DS is used]
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int sum;

		int [] data1 = {2, 3, 4, 8, 9, 20, 40};
		sum = 32;
		printMessage(data1, sum);

	}

	/**
	 * @param data
	 * @param sum
	 */
	private static void printMessage(int[] data, int sum) {

		int size = data.length;
		boolean pairFound = false;

		// iterate over array element once
		for(int i1 = 0; i1 < (size-1); i1++) {

			// as the array is sorted, apply 2 element pair function 
			if(isPair(data, (i1+1), (size-1), (sum-data[i1]))) {
				//System.out.print(data[i1]);
				pairFound = true;
				break;
			} 
		}
		if(pairFound) {
			System.out.println("\nArray: "+Arrays.toString(data)+" has pair with sum = "+sum+".");
			//System.out.println("Yes");
		} else {
			System.out.println("\nArray: "+Arrays.toString(data)+" has no pair with sum = "+sum+".");
			//System.out.println("No");
		}
	}

	/**
	 * as this function will check only for 2 pairs & the array is sorted;
	 * we can apply two pointer method. 
	 *  
	 * @param data
	 * @param startPoint
	 * @param endPoint
	 * @param sum
	 * @return
	 */
	private static boolean isPair(int[] data, int startPoint, int endPoint, int sum) {

		int start = startPoint;
		int end = endPoint;
		int tempSum = -1;

		while(start < end) {
			// find temp sum of 2 elements
			tempSum = (data[start]+data[end]);
			if(tempSum == sum) {
				//System.out.print(data[start]+", "+data[end]+", ");
				// if we find required sum
				return true;
			} else if(tempSum < sum) {
				// if required sum is smaller; move right
				start++;
			} else {
				// if required sum is greater; move left
				end--;
			}
		}
		// if no elements sum found: 
		return false;
	}
}

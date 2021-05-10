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
 *	-> for 2 number pair, refer readMe.txt
 *
 *	-> naive approach: run 3 internal loops to find such 3 elements which will result in given sum.
 *
 *  ex:
 *  	i/p : {2, 3, 4, 8, 9, 20, 40} & sum = 32	=> o/p : yes (4+8+20)
 * 
 *  
 * -> Time complexity: O(n^3)	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: 0(1)
 */
public class NaiveApproach {

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
		System.out.print("Array "+Arrays.toString(data)+" has ");
		boolean pairFound = findPairs(data, sum);
		if(!pairFound) {
			System.out.print("no triplet pair which makes sum = "+sum+".");
		} else {
			System.out.print("\ntriplet pairs which makes sum = "+sum+".");
		}
		System.out.println();
	}

	/**
	 * @param data
	 * @param sum
	 * @return
	 */
	private static boolean findPairs(int[] data, int sum) {
		int size = data.length;
		boolean pairFound = false;
		// iterate over all elements
		for(int i1 = 0; i1 < size; i1++) {
			for(int i2 = (i1+1); i2 < size; i2++) {
				for(int i3 = (i2+1); i3 < size; i3++) {
					if((data[i1]+data[i2]+data[i3]) == sum) {
						pairFound = true;
						System.out.print("\n"+data[i1]+", "+data[i2]+", "+data[i3]);
					}
				}
			}
		}
		return pairFound;
	}
}

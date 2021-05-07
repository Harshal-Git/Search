/**
 * 
 */
package com.count1s;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> given a sorted binary array & find total 1s in the array.
 *
 *	-> naive approach : linear search for first occurrence of 1. Once we encounter first position; we can subtract
 *						the position from total size to know the number of 1s. It will take O(n) times.
 *
 *	-> efficient solution : same process above can be done with binary search by finding first occurrence of 1. And then
 *							size of 1s can be identified by initial position.
 *
 *	ex: 
 *		i/p : {0, 0, 1, 1, 1, 1} => o/p : 4
 *
 *		i/p : {1, 1, 1, 1, 1} => o/p : 5
 *
 *		i/p : {0, 0, 0, 0} => o/p : 0
 *
 * -> Time complexity: O(log n)	
 * -> Space complexity:	O(log n)
 * -> Auxiliary space:	O(1)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {0, 0, 1, 1, 1, 1};
		printMessage(data1);

		int [] data2 = {0, 0, 0, 1, 1, 1};
		printMessage(data2);

		int [] data3 = {1, 1, 1, 1, 1};
		printMessage(data3);

		int [] data4 = {0, 0, 0};
		printMessage(data4);
	}

	/**
	 * @param data
	 */
	private static void printMessage(int[] data) {
		int countOf1 = findCountOf1(data);
		if(countOf1 < 0) {
			System.out.println("\nArray: "+Arrays.toString(data)+" does not contain 1s.");	
		} else {
			System.out.println("\nArray: "+Arrays.toString(data)+" has "+countOf1+" number of 1s.");
		}
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findCountOf1(int[] data) {
		int size = data.length;
		int start = 0;
		int end = (size-1);
		int mid = -1;

		while(start <= end) {
			// find mid
			mid = (start+((end-start)/2));
			// if mid element is 0 : right search
			if(data[mid] == 0) {
				start = (mid+1);
			} else {
				/*
				 * If mid element is '1'; then there are multiple possibilities
				 * 1. if mid element is first '1' (or (mid-1) is 0) 
				 * OR we might have reached to first position 
				 * then that's first occurrence
				 */
				//if((mid == 0) || (data[mid] != data[mid-1])) {
				if((mid == 0) || (data[mid-1] == 0)) {	
					return (size-mid);
				} else {
					// mid element is not first '1' : left search would be needed
					end = (mid-1);
				}
			}
		}
		// if no '1' found
		return -1;
	}
}

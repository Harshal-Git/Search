/**
 * 
 */
package com.frequencyInSortedArray;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> find frequency of elements from given sorted array
 *
 *	ex:
 *		i/p : {10, 20, 20, 20, 30, 30} & num = 20	=> o/p : 3
 *
 *		i/p : {10, 10, 10, 10, 10}  & num = 10	=> o/p : 5
 *
 *		i/p : {5, 8, 10} & num = 7	=> o/p : 0
 *
 *	-> standard approach : find first & last occurrence & return position difference between them.
 *
 * -> Time complexity:	O(log n) + O(log n) ~ O(log n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:	0(1)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int searchNum;

		int [] data1 = {10, 20, 20, 20, 30, 30};
		searchNum = 20;
		printMessage(data1, searchNum);

		int [] data2 = {10, 10, 10, 10, 10};
		searchNum = 10;
		printMessage(data2, searchNum);

		int [] data3 = {5, 8, 10};
		searchNum = 7;
		printMessage(data3, searchNum);

		int [] data4 = {10, 10, 10, 20, 30, 30};
		searchNum = 30;
		printMessage(data4, searchNum);

		int [] data5 = {10};
		searchNum = 30;
		printMessage(data5, searchNum);

		int [] data6 = {10, 10, 10, 10, 30, 30, 30, 40, 40, 50};
		searchNum = 50;
		printMessage(data6, searchNum);

		int [] data7 = {10};
		searchNum = 10;
		printMessage(data7, searchNum);

	}

	/**
	 * @param data 
	 * @param searchNum
	 */
	private static void printMessage(int[] data, int searchNum) {
		int frequency = getFrequency(data, searchNum);
		if(frequency == 0) {
			System.out.println("\nIn data "+Arrays.toString(data)+" element "+searchNum+" does not exist.");
		} else {
			System.out.println("\nIn data "+Arrays.toString(data)+" element "+searchNum+" exist "+frequency+" times.");
		}
	}

	/**
	 * @param data - array data
	 * @param searchNum 
	 */
	private static int getFrequency(int[] data, int searchNum) {

		// find first occurrence
		int firstOccurrence  = findFirstOccurrence(data, searchNum);
		//System.out.println("First occurrence: "+firstOccurrence);

		// if first element is not found
		if(firstOccurrence < 0) {
			// element does not exist : return count 0
			return 0;
		}
		// find last occurrence
		int lastOccurrence = findLastOccurrence(data, searchNum);
		//System.out.println("Last occurrence: "+lastOccurrence);

		// return position difference of first & last occurrence to find frequency
		return ((lastOccurrence - firstOccurrence)+1);
	}

	/**
	 * @param data
	 * @param searchNum
	 * @return
	 */
	private static int findLastOccurrence(int[] data, int searchNum) {

		int size=  data.length;
		int start = 0;
		int end = (size-1);
		int mid = -1;

		while(start <= end) {

			// find mid
			mid = (start+((end-start)/2));

			// if search element bigger than mid element : right search
			if(searchNum > data[mid]) {
				start = (mid+1);
			} else if(searchNum < data[mid]) {
				// if search element is lower than mid element : left search 
				end = (mid-1);
			} else {
				// if current element is not same as next element 
				// OR we have reached last position in the array: return current index
				if((mid == (size-1)) || (data[mid] != data[mid+1])) {
					return mid;
				} else {
					// otherwise to find last occurrence; perform right search
					start = (mid+1);
				}
			}
		}
		return -1;
	}

	/**
	 * @param data
	 * @param searchNum
	 * @return
	 */
	private static int findFirstOccurrence(int[] data, int searchNum) {

		int size=  data.length;
		int start = 0;
		int end = (size-1);
		int mid = -1;

		while(start <= end) {

			// find mid
			mid = (start+((end-start)/2));

			// if search element bigger than mid element : right search
			if(searchNum > data[mid]) {
				start = (mid+1);
			} else if(searchNum < data[mid]) {
				// if search element is lower than mid element : left search 
				end = (mid-1);
			} else {
				// if current element is not same as previous element 
				// OR we have reached first position in the array: return current index
				if(mid == 0 || (data[mid] != data[mid-1])) {
					return mid;
				} else {
					// otherwise to find first occurrence; perform left search
					end = (mid-1);
				}
			}
		}
		return -1;
	}

}

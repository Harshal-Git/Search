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
 *	-> standard approach : predefine last traversed element & initial count. Traverse through all elements and 
 *						if current elements matches last traversed elements: then
 *								increment count
 *						else if current element doesn't match last traversed element: then
 *								 print data of current count and last traversed
 *								 reset the counter
 *							     replace the last traversed elements   
 *
 *	ex:
 *		i/p : 10, 10, 10, 20, 30, 30	=> o/p : 10 3
 *												 20 1
 *												 30 2
 *
 * -> Time complexity:	0(n)
 * -> Space complexity:	0(n)
 * -> Auxiliary space:	0(1)
 */
public class StandardApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {10, 10, 10, 20, 30, 30};
		System.out.println("Array: "+Arrays.toString(data1));
		printFrequency(data1);
		
		int [] data2 = {10, 10, 10, 10};
		System.out.println("\nArray: "+Arrays.toString(data2));
		printFrequency(data2);
		
		int [] data3 = {10, 20, 30};
		System.out.println("\nArray: "+Arrays.toString(data3));
		printFrequency(data3);
		
		int [] data4 = {10};
		System.out.println("\nArray: "+Arrays.toString(data4));
		printFrequency(data4);
		
		int [] data5 = {10, 10, 10, 10, 30, 30, 30, 40, 40, 50};
		System.out.println("\nArray: "+Arrays.toString(data5));
		printFrequency(data5);
		
		int [] data6 = {10, 10, 40, 50, 50};
		System.out.println("\nArray: "+Arrays.toString(data6));
		printFrequency(data6);
	}

	/**
	 * @param data - array data
	 */
	private static void printFrequency(int[] data) {
		
		// validation
		if(data == null) {
			throw new IllegalArgumentException("Invalid input provided.");
		}
		
		// initialize frequency count
		int frequencyCount = 0;
		
		// predefine first element of the array as already traversed element
		int completedElement = data[0];
		
		// iterate through all elements
		for(int index = 0; index < data.length; index++) {
			// if current element matches already traversed element : increment count
			if(data[index] == completedElement) {
				frequencyCount++;
			} else {
				// print the existing frequency count & already traversed element
				printData(completedElement, frequencyCount);
				// reset counter for new element
				frequencyCount = 1;
				// set current element as already traversed element
				completedElement = data[index];
			}
		}
		// once the iteration ends, print data for the last element 
		printData(completedElement, frequencyCount);
	}

	/**
	 * @param completedElement
	 * @param frequencyCount
	 */
	private static void printData(int completedElement, int frequencyCount) {
		System.out.println(completedElement+" "+frequencyCount);
	}

}

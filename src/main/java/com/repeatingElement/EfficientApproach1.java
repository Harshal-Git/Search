/**
 * 
 */
package com.repeatingElement;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> Efficient approach to find repeating elements from a given array in O(n) time & O(1) complexity.
 *
 *	-> This is for the case when there is no '0' in the given array.
 *
 *	-> In this approach, a cycle will be identified by 2 pointers. One pointer will move single element at a time
 *		and other will move at double speed.
 *
 *		The point when they will meet for the first time, will indicate a start point of a cycle.
 *
 *		Then the slow pointer is reset and then both are moved by single position until they meet. The meeting
 *		point is the repeating element.
 *
 * -> Time complexity: O(n)	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(1)
 */
public class EfficientApproach1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {1, 2, 3, 3, 4, 5};
		System.out.println("\nArray: "+Arrays.toString(data1)+" has repeating element: "+findRepeatingElement(data1));

		int [] data2 = {1, 3, 2, 4, 3, 3};
		System.out.println("\nArray: "+Arrays.toString(data2)+" has repeating element: "+findRepeatingElement(data2));

		int [] data3 = {1, 1};
		System.out.println("\nArray: "+Arrays.toString(data3)+" has repeating element: "+findRepeatingElement(data3));

		int [] data4 = {3, 4, 5, 1, 2, 4, 4};
		System.out.println("\nArray: "+Arrays.toString(data4)+" has repeating element: "+findRepeatingElement(data4));

	}

	/**
	 * @param data
	 * @return - repeating element (not position of the repeating element)
	 */
	private static int findRepeatingElement(int[] data) {
		// initializations
		int slowIndex = data[0];
		int fastIndex = data[0];

		// at this phase; they will meet at the point where cycle is started 
		do {
			slowIndex = data[slowIndex];
			fastIndex = data[data[fastIndex]];
		}while(slowIndex != fastIndex);

		// now reset the slow pointer to first position
		slowIndex = data[0];

		// now move both by 1 position until they meet again
		while(slowIndex != fastIndex) {
			slowIndex = data[slowIndex];
			fastIndex = data[fastIndex];
		}
		// return the point where both pointers met
		return slowIndex;
		/*
		 * or (as both matches)
		 * 
		 * return fastIndex;
		 */
	}
}

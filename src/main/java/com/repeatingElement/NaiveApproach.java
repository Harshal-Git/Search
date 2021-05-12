/**
 * 
 */
package com.repeatingElement;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> naive solution as per approach#3 in readMe.txt
 *
 * -> Time complexity: O(n)	
 * -> Space complexity:	O(n)
 * -> Auxiliary space: O(n)
 */
public class NaiveApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int [] data1 = {0, 2, 1, 3, 2, 2};
		System.out.println("\nArray: "+Arrays.toString(data1)+" has repeating element: "+findRepeatingElement(data1));

		int [] data2 = {1, 2, 3, 0, 3, 4, 5};
		System.out.println("\nArray: "+Arrays.toString(data2)+" has repeating element: "+findRepeatingElement(data2));

		int [] data3 = {0, 0};
		System.out.println("\nArray: "+Arrays.toString(data3)+" has repeating element: "+findRepeatingElement(data3));

		int [] data4 = {1, 3, 2, 4, 3, 3};
		System.out.println("\nArray: "+Arrays.toString(data4)+" has repeating element: "+findRepeatingElement(data4));

		int [] data5 = {1, 1};
		System.out.println("\nArray: "+Arrays.toString(data5)+" has repeating element: "+findRepeatingElement(data5));

		int [] data6 = {3, 4, 5, 1, 2, 4, 4};
		System.out.println("\nArray: "+Arrays.toString(data6)+" has repeating element: "+findRepeatingElement(data6));
	}

	/**
	 * @param data
	 * @return
	 */
	private static int findRepeatingElement(int[] data) {
		int size = data.length;
		boolean [] visited = new boolean[size];
		// iterate over elements and set respective index in the boolean array as visited
		for(int index = 0; index < size; index++) {
			if(visited[data[index]] == true) {
				return data[index];
			}
			visited[data[index]] = true;
		}
		return -1;
	}
}

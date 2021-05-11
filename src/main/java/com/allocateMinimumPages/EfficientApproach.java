/**
 * 
 */
package com.allocateMinimumPages;

import java.util.Arrays;

/**
 * @author Harshal-Git
 *
 *	-> An array contains of the number of pages in some books. (Unsorted).  And number of students who will be given these 
 *		books to read as input. Find the minimum number of pages a student can finish; without any student staying free.
 *
 *	-> A student can be given only full pages / full book.  
 *
 * 	-> I could not understand naive solution for this issue. Hence directly efficient solution is written.
 * 	
 * 	-> efficient solution: 
 * 							Find the maximum number of pages and total number of pages.
 * 							We will use above range perform binary search to find an optimum number of pages a student 
 * 							can be given to complete the task such that all students are properly given pages.
 * 
 *  -> ex:
 *  	i/p : {10, 5, 20} & k = 2	==> o/p: 20
 *  
 *  	i/p : {10, 20, 30, 40} & k = 2	==> o/p: 60
 *  
 *  	i/p : {10, 20, 30} & k = 1	==> o/p: 60
 *  
 *  	i/p : {10, 5, 30, 1, 2, 5, 10, 10} & k = 3	==> o/p: 30
 *  
 * -> Time complexity: O(n) [for finding max] + O(log n * n) [binary search + feasibility check] 
 * 					 = O(n) + O(n * log n) ~ O(n * log n)
 * -> Space complexity: O(n)	
 * -> Auxiliary space: O(1)
 */
public class EfficientApproach {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// number of students
		int k;

		// pages from books
		int [] data1 = {10, 5, 20};
		k = 2;
		printMessage(data1, k);

		int [] data2 = {10, 20, 30, 40};
		k = 2;
		printMessage(data2, k);

		int [] data3 = {10, 20, 30};
		k = 1;
		printMessage(data3, k);

		int [] data4 = {10, 5, 30, 1, 2, 5, 10, 10};
		k = 3;
		printMessage(data4, k);

	}

	/**
	 * @param data
	 * @param k
	 */
	private static void printMessage(int[] data, int numberOfStudents) {
		System.out.println("For pages: "+Arrays.toString(data)+" to be given to "+numberOfStudents
				+" students; minimum number of pages can be alloted are "+findMinimumPages(data, numberOfStudents)+".");
	}

	/**
	 * @param data
	 * @param numberOfStudents
	 * @return
	 */
	private static int findMinimumPages(int[] data, int numberOfStudents) {

		// initializations
		int size = data.length;
		int minimumPages = -1;


		// find maximum number of pages from given data and find total pages
		int maxPages = 0;
		int totalPages = 0;
		for(int index = 0; index < size; index++) {
			totalPages += data[index];
			if(maxPages < data[index]) {
				maxPages = data[index];
			}
		}

		// perform binary search from above range and find optimum pages each student can be allotted
		int start = maxPages;
		int end = totalPages;
		int mid = -1;

		while(start <= end) {

			// find mid
			mid = (start+((end-start)/2));
			/*
			 * If current solution pages is a feasible solution?
			 * Yes then still find better solution by performing left search 
			 */
			if(isFeasibleSolution(mid, data, numberOfStudents)) {
				end = (mid-1);
				minimumPages = mid;
			} else {
				// if current solution is not feasible solution : perform right search
				start = (mid+1);
			}
		}
		return minimumPages;
	}

	/**
	 * check whether given number of current Pages can be distributed among given number of students?
	 * 
	 * @param currentPages
	 * @param data
	 * @param numberOfStudents
	 * @return
	 */
	private static boolean isFeasibleSolution(int currentPages, int[] data, int numberOfStudents) {
		// minimum 1 student is needed to start reading given pages
		int requiredStudents = 1;

		// initial pages for a single student
		int pagesAllotted = 0;
		int size = data.length;

		/*
		 * Iterate over all pages to see whether with given number of current pages, how many
		 * students are needed? That should be less than OR equal to given number of students.
		 * Then only it will be a feasible solution.
		 */
		for(int index = 0; index < size; index++) {
			// if current read pages has become more than given pages
			// extra student will be needed. 
			if((pagesAllotted+data[index]) > currentPages) {
				requiredStudents++;
				pagesAllotted = data[index];
			} else {
				// current student can still read more pages 
				pagesAllotted+= data[index];
			}
		}
		// if number of required students is actually as per given input?
		return (requiredStudents <= numberOfStudents);
	}
}

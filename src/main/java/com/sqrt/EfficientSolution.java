/**
 * 
 */
package com.sqrt;

/**
 * @author Harshal-Git
 *
 *	-> find square root of given number. If exact square root could not be found; return nearest value of it.
 *
 *	-> naive approach : already discussed in MathsAndNumbers with 0(Sqrt n) solution.
 *
 *	-> efficient solution : using binary search : 
 *					assume a sorted array from 1 -> X and find an element 'p' such that (p*p = X)
 *
 * -> Time complexity: O(log n)	
 * -> Space complexity:	0(1)
 * -> Auxiliary space: 0(1)
 * 
 */
public class EfficientSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int number;

		number = 4;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));

		number = 8;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));

		number = 9;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));

		number = 10;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));

		number = 20;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));

		number = 31;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));

		number = 45;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));

		number = 49;
		System.out.println("Sqrt("+number+") = "+findSqrt(number));
	}

	/**
	 * @param number
	 * @return
	 */
	private static int findSqrt(int number) {

		// initializations
		int start = 1;
		int end = number;
		int mid = -1;
		int midSqr = -1;
		int result = -1;

		while(start <= end) {

			// find mid
			mid = (start+((end-start)/2));
			midSqr = (mid*mid);

			// if midSqr element is same as given number
			if(midSqr == number) {
				result = mid;
				break;
			} else if(midSqr > number) {
				// if midSqr is larger than given number : perform left search
				end = (mid-1);
			} else {
				// otherwise perform right search & update result with 'mid'
				start = (mid+1);
				result = mid;
			}
		}
		return result;
	}
}

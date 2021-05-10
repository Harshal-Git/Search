For different cases; there are already few methods mentioned in "Arrays/com.findPairWithGivenSum" project.

Below algo are useful when we have a pair of 2 elements to be found from given array.

1. Naive solution : For each element, find respective right element by 2 loops. This will work in any case whether array is sorted
					or not.
					
					
2. Hashing solution : Prepare a hashing based storage in which all elements will be inserted IF there is no difference 
					(sum - current element) present of that element in the hash structure. It will also work for any type of sorted
					or unsorted array. It will take auxiliary space.
					
					
3. Two pointers solution : This is best solution when we are given a sorted array. Traversal will happen with 2 pointers : start & end
						and both are added to see whether they have sum as given element OR not. 
						If the sum is greater, then move decrement right side pointer and left side pointer otherwise.
	
						
###     

Further in this package, solution for sum with 3 elements are given.

Related practice questions of triplet problem:

1. Count pairs with given sum.
2. Count triplets with given sum.
3. Find if there is a triplet (a, b, c) such that (a^2 + b^2 = c^2) OR is there a pythagorian triplet in given array?
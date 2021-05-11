This problem has below base line conditions for it's efficient solutions.

1. The array will contain 0. And minimum array size will be 2.

2. If the maximum element from the array is 'p'; then all elements will be present from '0' -> 'p' in the array.

3. Except the repeating element; all other elements will be present exactly once.

4. If the array has length 'n' then the maximum element of the array will fall in range :
		
					0 <= Max(array) <= (n-2)
		
		This condition will help to eliminate possibility of array out of bound exception. 
		
5. Requirement is to find the solution with O(n) time complexity & O(1) auxiliary space.

######

This problem has below naive solutions:


1. Traverse the whole array with 2 loops to see whether same element is present again in the right side of current element?
	This will take O(n^2) time complexity & O(1) auxiliary space. 

2. Second solution is to sort the given array and see for same consecutive elements. If we find such elements, we can return it.
	This solution will take O(n * log n) time complexity & O(1) auxiliary space.
	
3. We can maintain a boolean array of the same size. During iteration of the array elements, for current element; we will set 
	respective position in the array as 'TRUE'. If ever we encounter a position which is already set; that is the required
	repeated element.
	
####

Required solution for O(n) time & O(1) space.

1. First solution is for the array where there is no '0' element. -- EfficientApproach1.java

2. Above solution will be extended further for the case when '0' is in the array. -- EfficientApproach2.java
	

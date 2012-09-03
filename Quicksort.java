package QuickSort;

import java.util.Arrays;

public class Quicksort {
	public static void main(String [] args){
		int [] array = {8, 3, 7, 5, 2, 1, 6, 10};
		System.out.println(Arrays.toString(quicksort(array, 0, array.length-1)));
	}
	/** In quicksort implementation, we have a start, a pivot, and an end.
	 *  Ex. an array of {3,2,1} a start would be 3, a pivot would be 2 and an end would be 1.
	 *  We first find an index of a value that is greater than the pivot value starting from the left side, then
	 *  we find an index of a value that is less than the pivot value starting from the right side.
	 *  Then as long as the start index is less than or equal to the end index, we are allow to swap the
	 *  start value and the end value. As soon as the start index crosses the end index, we partition the 
	 *  array using recursion and reset the start index and the end index. In another words, we use recursion
	 *  to partition the array into sub-array and use the same method to sort the sub array.
	 * 
	 */
	public static int [] quicksort(int [] array, int start, int end){
		//First save the original start index and the end index.
		//Also find the value of the pivot point.
		int i = start, j = end, pivot_value = array[(start+end)/2];
		int temp;
		
		//Check if the start index is still less than or equal to the end index. If not, then stop
		while(i <= j){
			
			//Check if the value on the left side of the pivot point is less than the pivot value,
			//if it is, then increment the index value.
			while(array[i] < pivot_value) i++;
			
			
			//Check if the value on the right side of the pivot point is greater than the pivot value,
			//if it is, then decrement the index value
			while(array[j] > pivot_value) j--;
			
			
			//if i is still less than j, then swap both values
			if(i <= j){
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++; j--;
			}
			
			//Check if i is less than the original end, if it is then we need to divide the array into sub-array
			//But this time, i becomes the new start and the original end remains the same.
			if(i < end) quicksort(array, i, end);
			
			//Also check if j is still greater than the original start, if it is, then we also have to divide the
			//array into sub-array.
			if(j > start) quicksort(array, start, j);
			
		}
		
		
		
		return array;
		
	}
}

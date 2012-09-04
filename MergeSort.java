package MergeSort;

import java.util.Arrays;

public class MergeSort {
	
	public static void main(String [] args){
		int [] array = {3, 9, 2, 5, 4, 1, 0, 8};
		mergeSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));
	}
	
	/**
	 * First divide the array into sub-array and merge
	 * @param array
	 * @param left
	 * @param right
	 */
	
	public static void mergeSort(int [] array, int left, int right){
		if(left < right){
			int middle = (right+left) / 2;
			mergeSort(array, left, middle);
			mergeSort(array, middle+1, right);
			merge(array, left, middle, right);
		}
	}
	
	/**
	 * Merge two unsorted array to sort them.
	 * @param array
	 * @param leftpos
	 * @param leftend
	 * @param rightend
	 */
	public static void merge(int [] array, int leftpos, int leftend, int rightend){
		int rightpos = leftend+1;
		int [] tempArray = new int[rightend - leftpos + 1];
		int tempvalue = 0;
		while(leftpos <= leftend && rightpos <= rightend){
			if(array[leftpos] < array[rightpos]){
				tempArray[tempvalue++] = array[leftpos++];
			}else{
				tempArray[tempvalue++] = array[rightpos++];
			}
		}
		
		while(leftpos <= leftend)
			tempArray[tempvalue++] = array[leftpos++];
		
		while(rightpos <= rightend)
			tempArray[tempvalue++] = array[rightpos++];
		
		for(int i = tempArray.length-1; i >= 0; i--, rightend--){
			array[rightend] = tempArray[i];
		}
		
	}
	
	
}

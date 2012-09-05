
import java.util.Arrays;

public class QuickSort{
	public static void main(String [] args){
		
		int [] array = {6, 10, 13, 5, 8, 3, 2, 11};
		quickSort(array, 0, array.length-1);
		System.out.println(Arrays.toString(array));

	}	

	public static void quickSort(int [] array, int start, int end){
		if(start < end){
			int r = partition(array, start, end);
			quickSort(array, start, r-1);
			quickSort(array, r+1, end);
		}
	}
	
	/**
	*	To make it a randomized quick sort, just swap any value in the array with
	*	the first value. Because This method uses the first value as a pivot point.
  *	The randomized quick sort makes the algorithm has a better chance of not going
	* in to the worst case such as the array is already sorted.
	*/
	public static int partition(int [] array, int start, int end){
		int pivot_value = array[start];
		int i = start;
		int temp;
		for(int j = i + 1; j <= end; j++){
			if(array[j] <= pivot_value){
				i++;
				temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}	
		}
		temp  = array[i];
		array[i] = array[start];
		array[start] = temp;
		return i;
	}

}

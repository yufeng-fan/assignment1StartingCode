package utilities;

import java.util.Comparator;


public class ShellSort {
	public  <T> void shellSort(T[] shapes, Comparator<T> comparator) {
		for(int gap =shapes.length/2 ; gap > 0 ; gap/=2) {  // start with a large gap, then reduce it
			// perform a 'gapped' insertion sort for this gap size
			for(int i= gap ; i< shapes.length; i++) {
				// current element to be placed corrctly
				T temp = shapes[i];
				int j =i;
				// Shift earlier elements that are greater than temp
				while(j >= gap && comparator.compare(shapes[j-gap], temp) < 0) {
					shapes[j] = shapes[j-gap];
					j-=gap;
				}
				//place temp in its correct position
				shapes[j] = temp;
			}
		}
	}
}
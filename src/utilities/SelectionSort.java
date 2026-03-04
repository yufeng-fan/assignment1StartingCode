package utilities;

import java.util.Comparator;

import shapes.Shape;

public class SelectionSort implements SortStrategy {

	// Sorting using Selection Sort with Comparable (natural order)
	@Override
	public void sort(Comparable<Shape>[] array) {
	    
		// move boundary of unsorted subarray
		for (int i = 0; i < array.length - 1; i++) {

	        int maxIndex = i;
	        
	        // find the largest element in the remaining unsorted array
	        for (int j = i + 1; j < array.length; j++) {
	            if (array[j].compareTo((Shape) array[maxIndex]) > 0) {
	                maxIndex = j;
	            }
	        }

	        Comparable<Shape> temp = array[i];
	        array[i] = array[maxIndex];
	        array[maxIndex] = temp;
	    }
	}
	
	
	// Sorting using Selection Sort with Comparator (Comparator for descending ordering)
	@Override
	public void sort(Comparable<Shape>[] array, Comparator<? super Shape> comp) {
		for (int i = 0; i < array.length - 1; i++) {
			
			// first unsorted element is the largest
	        int maxIndex = i;

	        for (int j = i + 1; j < array.length; j++) {
	            if (comp.compare((Shape) array[j],
	                             (Shape) array[maxIndex]) > 0) {
	                maxIndex = j;
	            }
	        }
	        
	        // Swap largest found element into correct position
	        Comparable<Shape> temp = array[i];
	        array[i] = array[maxIndex];
	        array[maxIndex] = temp;
	    }
	}
}

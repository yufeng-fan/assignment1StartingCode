package utilities;

import java.util.Comparator;

import shapes.Shape;

public class InsertionSort implements SortStrategy {

	// Insertion Sort using Comparable (largest to smallest)
	@Override
	public void sort(Comparable<Shape>[] array) {
		for (int i = 1; i < array.length; i++) {

	        // Store the current element to be positioned correctly
	        // Start comparing with the element before it
	        Comparable<Shape> key = array[i];
	        int j = i - 1;

	        // Descending: move smaller elements right
	        while (j >= 0 && array[j].compareTo((Shape) key) < 0) {
	            array[j + 1] = array[j];
	            j--;
	        }

	        array[j + 1] = key;
	    }

	}
	

	// Insertion Sort using Comparator
	@Override
	public void sort(Comparable<Shape>[] array, Comparator<? super Shape> comp) {
		for (int i = 1; i < array.length; i++) {

	        Comparable<Shape> key = array[i];
	        int j = i - 1;
	        
	        // If current element is smaller than key, shift it right
	        while (j >= 0 && 
	               comp.compare((Shape) array[j], (Shape) key) < 0) {
	            array[j + 1] = array[j];
	            j--;
	        }

	        array[j + 1] = key;
	    }
	}
}

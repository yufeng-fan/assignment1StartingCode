package utilities;

import java.util.Comparator;

import shapes.Shape;

public class InsertionSort implements SortStrategy {

	@Override
	public void sort(Comparable<Shape>[] array) {
		// TODO Auto-generated method stub
		for (int i = 1; i < array.length; i++) {

	        Comparable<Shape> key = array[i];
	        int j = i - 1;

	        // DESCENDING: move smaller elements right
	        while (j >= 0 && array[j].compareTo((Shape) key) < 0) {
	            array[j + 1] = array[j];
	            j--;
	        }

	        array[j + 1] = key;
	    }

	}

	@Override
	public void sort(Comparable<Shape>[] array, Comparator<? super Shape> comp) {
		// TODO Auto-generated method stub
		for (int i = 1; i < array.length; i++) {

	        Comparable<Shape> key = array[i];
	        int j = i - 1;

	        while (j >= 0 && 
	               comp.compare((Shape) array[j], (Shape) key) < 0) {
	            array[j + 1] = array[j];
	            j--;
	        }

	        array[j + 1] = key;
	    }
	}

}

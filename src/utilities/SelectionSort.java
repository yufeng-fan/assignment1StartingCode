package utilities;

import java.util.Comparator;

import shapes.Shape;

public class SelectionSort implements SortStrategy {

	@Override
	public void sort(Comparable<Shape>[] array) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.length - 1; i++) {

	        int maxIndex = i;

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

	@Override
	public void sort(Comparable<Shape>[] array, Comparator<? super Shape> comp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < array.length - 1; i++) {

	        int maxIndex = i;

	        for (int j = i + 1; j < array.length; j++) {
	            if (comp.compare((Shape) array[j],
	                             (Shape) array[maxIndex]) > 0) {
	                maxIndex = j;
	            }
	        }

	        Comparable<Shape> temp = array[i];
	        array[i] = array[maxIndex];
	        array[maxIndex] = temp;
	    }
	}

}

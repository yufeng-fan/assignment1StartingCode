package utilities;

import java.util.Comparator;

import shapes.Shape;

public interface SortStrategy {
	void sort( Comparable<Shape>[] array );
	
	void sort( Comparable<Shape>[] array, Comparator<? super Shape> comp );
}

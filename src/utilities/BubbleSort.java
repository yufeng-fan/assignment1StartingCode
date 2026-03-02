package utilities;

import java.util.Comparator;

import shapes.Shape;

public class BubbleSort implements SortStrategy {

	@Override
	public void sort(Comparable<Shape>[] array) {
		int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                // For descending: swap if current < next
                if (array[j].compareTo((Shape)array[j + 1]) < 0) {

                	Comparable<Shape> temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop early if already sorted
            if (!swapped) {
                break;
            }
        }

	}

	@Override
	public void sort(Comparable<Shape>[] array, Comparator<? super Shape> comp) {
		int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                // If left is smaller than right, swap (for descending order)
                if (comp.compare((Shape)array[j], (Shape)array[j + 1]) < 0) {

                	Comparable<Shape> temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // Optimization: stop if already sorted
            if (!swapped) {
                break;
            }
        }
	}

}

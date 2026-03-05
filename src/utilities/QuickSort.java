package utilities;
/*
Team ZELDA: PHAN CAO THANH VINH, Yufeng Fan, Jianning Li, Henry Leung
DATE: March 4, 2026
PROGRAM DESCRIPTION: AppDriver.java :is the main Class that load the data files (Shapes) , read the via from the command prompt of users and display the output sorting for users
 									EXCEPTION via - length input of users >= 3 and contain -f"fileName.txt" -t"compareType" -s"sortType". If it's not correct --> display Error and Exit();
 									Read data Files - Based on the name of each line of file , it will be stored to the shapeArray and divide into shapes or prisms that it belongs to
 									Sort and runTime - Based on the via , it will jump to the sortType that users want and calculate the runTime of it, 
 									Output - Based on the compareType and sortType, it will display the descending sort for users
 			shapes package : Shape.java : - abstract class that contain abstract methods(calculate the Volume and Area and Output for shapes)
 							 Prism.java : - abstract class for the shapes that belongs to Prism (SquarePrism,.. ) 
 							 ShapeComparator.java: the child class that inheritance the comparator interface, based on the compareType(h: height, v: Volume, a: area) this class helps to compare shapeValues 
 							The others : - Class that extends the abstract classes, get abstract methods to calculate the base and area, display Output
 			utilities package(contain all of sortTypes): BubbleSort: sort shapes using bubble sort
 														InsertionSort: sort shapes using insertionSort
 														MergeSort: sort shapes using mergeSort
 														QuickSort: sort shapes using quickSort
 														shellSort: sort shapes using shellSort						
*/
import java.util.Comparator;
// idea: sorted first, last and middle element first then choose pivot then compare pivot. If greater than pivot move before pivot otherwise move left
public class QuickSort {
	
	public <T> void quickSort(int start, int end,T[] shapes, Comparator<T> comparator) {
        if (end <= start) return; // to stop the recursion
        medianOfThree(start, end, shapes,  comparator); // compare mid, start 
		int pivot = partition(start, end, shapes, comparator); // swap pivot to the position after leftSize be sorted
		quickSort(start, pivot -1, shapes, comparator); // recursion the leftSize
		quickSort(pivot + 1, end, shapes, comparator); // recursion the right Size
	} 
	
	private <T> int partition(int start, int end,T[] shapes, Comparator<T> comparator) {
		T pivot = shapes[end]; // choose the pivot at the end of array
		int i = start-1; // initialize index i = -1
		for(int j = start; j <= end-1; j++) { // run j at index = 0 
			if(comparator.compare(shapes[j], pivot) > 0) { // if pivot > shapes [j] --> i++ AND swap(i , j)
				i++;
				swap(shapes, i, j);
			}
		}
		// at the end swap(pivot, i);
		i++;
	
		swap(shapes, i, end);
		return i;
	}

    private <T> void medianOfThree(int start, int end, T[] shapes, Comparator<T> comparator) {

        int mid = (start + end) / 2;

        // sort start, mid, end
        
        // mid > start ? --> mid > start
        if (comparator.compare(shapes[start], shapes[mid]) < 0) 
            swap(shapes, start, mid);
        // end > start ? --> mid, end > start
        if (comparator.compare(shapes[start], shapes[end]) < 0)
            swap(shapes, start, end);
        // end > mid ? --> end > mid > start
        if (comparator.compare(shapes[mid], shapes[end]) < 0)
            swap(shapes, mid, end);

        // give the median to last index for partition
        swap(shapes, mid, end);
    }

    private <T> void swap(T[] shapes, int i, int j) {
        T temp = shapes[i];
        shapes[i] = shapes[j];
        shapes[j] = temp;
    }
}

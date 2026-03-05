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

public class MergeSort {
	public <T> void mergeSort(T[] shapes, Comparator<T> comparator) {
			// idea split to other arrays then compare and merge arrays again --> using recursion
			int length = shapes.length;
			if(length <=1) return; // not need to sort and the condition to stop the recursion
			int middle = length /2; // divide arrayShape to 2 arrays
			T[] leftArray = (T[]) new Object[middle];
			T[] rightArray = (T[]) new Object[length - middle];
			
			int i=0;  //index of left  array
			int j=0; //index of right array
			// store shapesValue into both arrays(left and right) to compare
			for(; i< length; i++) { 
				if(i< middle ) {
					leftArray[i] = shapes[i];
				}
				else {
					rightArray[j] = shapes[i];
					j++;
				}
			}
			mergeSort(leftArray,comparator); // recursion the array until arr.length ==1
			mergeSort(rightArray, comparator); // recursion the array until arr.length ==1
			merge(leftArray, rightArray, shapes, comparator);// merge the arrayShapes
	}
	private <T> void merge(T[] leftArray, T[] rightArray, T[] shapes, Comparator<T> comparator ) {
		int leftSize = shapes.length / 2; // recalculate the size of arrays
		int rightSize = shapes.length -leftSize; 
		int i =0, l = 0, r =0; // indices
		// the conditions for merging
		while(l < leftSize && r < rightSize) { // if both arrays still have indexes --> loop
			// value in left array is greater than right array --> store in shapes at first element then continue 
			if(comparator.compare(leftArray[l], rightArray[r]) > 0) {
				shapes[i] = leftArray[l];
				i++;
				l++;
			}
			else {
				shapes[i] = rightArray[r];
				i++;
				r++;
			}
		}
		while(l< leftSize ) { // if rightSize don't have any index value to compare --> store to shapes
			shapes[i] = leftArray[l];
			i++;
			l++;
		}
		while(r< rightSize) { // if leftSize don't have any index value to compare --> store to shapes
			shapes[i] = rightArray[r];
			i++;
			r++;
		}
	}
}

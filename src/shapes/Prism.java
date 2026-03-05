package shapes;
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
//abstract class for type of prisms(SquarePrism,...)
public abstract class Prism extends Shape{
	double side;
	// constructor
	public Prism(double height, double side) {
		super(height);
		this.side = side;
	}
	// getters and setters
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}
	

	
}

package shapes;
//Assignment 1: Complexity and Sorting

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
public class Cone extends Shape
{
	private double  radius;
	private String type;
	// constructors
	public Cone( double height, double radius) {
		super(height);
		this.type = "Cone";
		this.radius = radius;
	}
	// getter and setters
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
// abstract methods that extended (calVolume, calBaseArea , output)
	
	// Compares the height of this shape and another shape.
	public int compareTo(Shape s) {
		if (this.getHeight() > s.getHeight() ) {
			return 1;
		}
		else if (this.getHeight() < s.getHeight() ) {
			return -1;
		}
		else {
			return 0;
		}
	}
		
	// calculate
	@Override
	//calculate the volume
	public double calVolume() {
		// TODO Auto-generated method stub
		return (PI * Math.pow(radius, 2) * this.getHeight()) / 3;
	}

	//calculate the area
	@Override
	public double calBaseArea() {
		// TODO Auto-generated method stub
		return PI * Math.pow(radius, 2);
	}
	// return string based on CompareType parameters
	public String output(char compareType) {
		if(compareType == 'v') {
			return "shapes.Cone\t\t" + "Volume: " +this.calVolume();
		}
		else if(compareType == 'h') {
			return "shapes.Cone\t\t" + "Height: "+ this.getHeight();
		}
		else if(compareType == 'a') {
			return "shapes.Cone\t\t" + "Area: "+ this.calBaseArea();
		}
		else {
			return "";
		}
	}
	@Override
	public String toString() {
		return "Cone [radius=" + radius + ", type=" + type + "height:" + this.getHeight() + "]";
	}

}

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
public class Pyramid extends Shape
{
	private double side;
	private String type;
	// constructor
	public Pyramid(double height, double side) {
		super(height);
		this.type = "Pyramid";
		this.side = side;
	}
	// getter and setter
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	// calculate the volume
	@Override
	public double calVolume() {
		// TODO Auto-generated method stub
		return (Math.pow(side, 2) * this.getHeight() ) /3;
	}
	// calculate the area
	@Override
	public double calBaseArea() {
		// TODO Auto-generated method stub
		return Math.pow(side, 2);
	}
	// return String based on compareType
	public String output(char compareType) {
		if(compareType == 'v') {
			return "shapes.Pyramid\t\t" + "Volume: " +this.calVolume();
		}
		else if(compareType == 'h') {
			return "shapes.Pyramid\t\t" + "Height: "+ this.getHeight();
		}
		else if(compareType == 'a') {
			return "shapes.Pyramid\t\t" + "Area: "+ this.calBaseArea();
		}
		else {
			return "";
		}
	}
	@Override
	public String toString() {
		return "Pyramid [side=" + side + ", type=" + type + "]";
	}
	
}

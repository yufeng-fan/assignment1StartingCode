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
import java.util.Comparator;
// compare shapeValues (h, v, a)
public class ShapeComparator implements Comparator<Shape>{
	private char type; // 'h : height', 'v: volume', 'a: base Area'
	// constructors
	public ShapeComparator(char type) {
		super();
		this.type = type;
	}
	// gettter , setter
	public char getType() {
		return type;
	}
	
	public void setType(char type) {
		this.type = type; 
	}
	
	@Override
	//compare ascending
	public int compare(Shape o1, Shape o2) {
		// TODO Auto-generated method stub
		 // based on the type(h,v,a) --> compare shapes
		switch(Character.toLowerCase(type)) {
			case 'h':
				o1.compareTo(o2);
			case 'v':
				if(o1.calVolume() > o2.calVolume()) {
					return 1;
				}
				else if(o1.calVolume() < o2.calVolume()) {
					return -1;
				}
				else {
					return 0;
				}
			case 'a':
				if(o1.calBaseArea() > o2.calBaseArea()) {
					return 1;
				}
				else if(o1.calBaseArea() < o2.calBaseArea()) {
					return -1;
				}
				else {
					return 0;
				}
			default:
	            throw new IllegalArgumentException("Invalid compare type");
		}
		
	}
	
}

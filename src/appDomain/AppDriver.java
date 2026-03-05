package appDomain;
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
// import libraries
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// from shapes packages
import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.ShapeComparator;
import shapes.SquarePrism;
import shapes.TriangularPrism;
// sorts
import utilities.BubbleSort;
import utilities.InsertionSort;
import utilities.MergeSort;
import utilities.QuickSort;
import utilities.SelectionSort;
import utilities.ShellSort;
/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * W2026 class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	static int numberShapes; // shapes length
	static Shape[] shapes; // the array to store shape values
	static String PATH ; // filename
	static char compareType; // v: volume, h: height ,a: area 
	static char sortType; // b: Bubble Sort, i: Insertion Sort, m: Merge Sort ,  q: Quick Sort, s: Selection Sort, z: Shell Sort
	
	// main methods
	public static void main( String[] args )
	{
		parseArgs(args); 
	}
	// read the file.txt then store all value to list of shapes
	private static void loadShapeList() {		
				try(BufferedReader reader = new BufferedReader(new FileReader(PATH))){
//					
					long start, end; // initialize the attributes for runTime
					ShapeComparator sc = new ShapeComparator(compareType); //based on compareType to sort the value of shapes by descending
					String firstLine = reader.readLine(); // access the first line to read number of shapes
					numberShapes = Integer.parseInt(firstLine.trim()); // store number of shapes
					int index =0; // index to store the value of shapes
					shapes = new Shape[numberShapes]; // create the number of shapesArray
					String line; // initialize the attribute to read each line of file
					// if the line read out of the file AND the index is equal or greater than number of shapes --> out loop
					while((line = reader.readLine()) != null && index < numberShapes) {
						String[] fields = line.split(" "); //create the array to store type of shapes, height and side/radius
						String type = fields[0].trim(); // store the type of shapes (Cone, Cylinder , ...)
						double height = Double.parseDouble(fields[1].trim()); // store the height of shapes
						//based on the type of shapes, it will store to radius or side value then store type of shapes into shapeArray
						switch(type.toLowerCase()) { // change to the lowerCase
						// Cone
							case "cone": {
								double radius = Double.parseDouble(fields[2].trim());  
								shapes[index++] = new Cone(height, radius);
								break;
							}
							// Cylinder
							case "cylinder":{
								double radius  = Double.parseDouble(fields[2].trim()); 
								shapes[index++] = new Cylinder(height, radius); 
							}
							//OctagonalPrism
							case "octagonalprism":{
								double side = Double.parseDouble(fields[2].trim());
								shapes[index++] =  new OctagonalPrism(height, side);
								break;
							}
							// PentagonalPrism
							case "pentagonalprism":{
							    double side = Double.parseDouble(fields[2].trim());
								shapes[index++] = new PentagonalPrism(height, side);
								break;
							}
							// Pyramid
							case "pyramid":{
								double side = Double.parseDouble(fields[2].trim());
								shapes[index++] = new Pyramid(height, side);
								break;
							}
							//SquarePrism
							case "squareprism":{
								double side = Double.parseDouble(fields[2].trim());
								shapes[index++] = new SquarePrism(height,side);
								break;
							}
							// TriangularPrism
							case "triangularprism":{
							double side = Double.parseDouble(fields[2].trim());
								shapes[index++] = new TriangularPrism(height, side);
								break;
							}
							// not found display on screen to fix bug file.txt
							default: 
								System.out.println("Invalid Shape! at line :" + index+1);
								continue;
						}	
					}	
					// sort	 need type sort and the array of shapes ==> return the array
					System.out.println("Start sorting...");
					// Based on sortType , the shapesArray will sort using these types: b is Bubble Sort, s is Selection Sort, i is Insertion Sort, m is mergeSort. q is Quick Sort, z: ShellSort
					// calculate the run time of each type of sorts then display on screen
					switch(sortType) {
					//bubble sort
						case 'b':
							BubbleSort bs = new BubbleSort();
							start = System.nanoTime();
							bs.bubbleSort(shapes, sc);
							end = System.nanoTime();
							consoleSort(numberShapes);
							System.out.println("Bubble Sort run time was: " + runTimeMS(start, end)+ " milliseconds");
							break;
					// selection sort
						case 's':
							SelectionSort ss =new SelectionSort();
							start = System.nanoTime();
							ss.selectionSort(shapes, sc);
							end = System.nanoTime();
							consoleSort(numberShapes);
							System.out.println("Selection Sort run time was: " + runTimeMS(start, end)+ " milliseconds");
							break;
				   // insertion sort
						case 'i':
							InsertionSort is = new InsertionSort();
							start = System.nanoTime();
							is.insertionSort(shapes, sc);
							end = System.nanoTime();
							consoleSort(numberShapes);
							System.out.println("Insertion Sort run time was: " + runTimeMS(start,end)+ " milliseconds");
							break;
					// merge sort
						case 'm':
							MergeSort ms = new MergeSort();
							start = System.nanoTime();
							ms.mergeSort(shapes, sc);
							end = System.nanoTime();
							consoleSort(numberShapes);
							System.out.println("Merge Sort run time was: "+ runTimeMS(start,end)+ " milliseconds");
							break;
					// quick sort
						case 'q':
							QuickSort qs = new QuickSort();
							start = System.nanoTime();
							qs.quickSort(0, numberShapes-1, shapes, sc);
							end = System.nanoTime();
							consoleSort(numberShapes);
							System.out.println("Quick Sort run time was: "+ runTimeMS(start,end)+ " milliseconds");
							break;
					// shell sort
						case 'z':
							ShellSort shell = new ShellSort();
							start = System.nanoTime();
							shell.shellSort(shapes, sc);
							end = System.nanoTime();
							consoleSort(numberShapes);
							System.out.println("Shell Sort run time was: "+ runTimeMS(start, end) + " milliseconds");
							break;
					// invalid type
						default :
							System.out.println("Invalid Sort Type!");
							
							break;
					}	
					reader.close(); // close reading the file
					
				}
				//EXCEPTION while reading the file
				catch (FileNotFoundException e) {
					e.printStackTrace();
				 }		
				 catch (IOException e) {
					e.printStackTrace();
				}

	}
	// refer to demo01 Test.java for an example on how to parse command
	// line arguments and benchmarking tests
	private static void parseArgs( String[] args ) {
		// length of args is less than 3 return the error  on screen
		if(args.length <3) {
			System.out.println("Not enough arguments");
			return;
		}
		// for loop
		for(String arg: args) {
			arg = arg.toLowerCase(); // change case of string
			if(arg.startsWith("-f")) { // start with -f read after to get the filePath
				PATH= arg.substring(2).replace("\"", "");
			}
			else if(arg.startsWith("-t")) { // start -t read after to get the compareType
				 compareType = arg.charAt(2);
				 compareType= Character.toLowerCase(compareType);
			}
			else if(arg.startsWith("-s")) { // start -s read after to get the sortType
				 sortType = arg.charAt(2);
				 sortType=Character.toLowerCase(sortType);
			}
			// return 
			else {
				System.out.println("SOmething wrong");
				
				return;
			}
		}
		//exception
		// fileName is empty or -f"" --> return Error
		if(PATH.trim().equals("-f")  || PATH.isEmpty() ) {
			System.out.println("Please Enter FileName!");
			return;
		}
		// compare is not in(v,h,a) --> return Error
		else if(compareType != 'v' && compareType != 'h' && compareType != 'a') {
			System.out.println("Please enter correct option to compare!");
			System.out.println("h: height, v: volume, a: area");
			return;
		}
		// sort is not in (b,s,i,m,q,z) --> return error
		else if(sortType!= 'b' && sortType != 's' && sortType != 'i' && sortType != 'm' && sortType != 'q' && sortType != 'z') {
			System.out.println("Please enter correct option to sort");
			System.out.println("b: Bubble Sort, s: Selection Sort, i: Insertion Sort, m: Merge Sort, q: Quick Sort, z: Shell Sort");
			return;
		}
	
		//System.out.println(PATH +  compareType + sortType);
		loadShapeList(); // running loadShapeLIst method
	}
	// console.log : using to display indexOfShapes		TypeShapes and	type of shapes the user want to compare (h, v or a)
	private static void consoleSort(int numberShapes) {
//		if(numberShapes>= 1000) {
		//for i in numberShapes, i+=1000 --> display the information of shapes 
			for(int i=0;i< numberShapes; i+=1000) {
				if(i==0) {
					System.out.println("First element is: \t\t"+ shapes[0].output(compareType));
				}
				else {
					System.out.println(i+"-th element: \t\t"+ shapes[i].output(compareType));
				}
			}
			System.out.println("Last element is: \t\t"+ shapes[numberShapes-1].output(compareType));
		
//		else if(numberShapes <= 1000) {
//			for(int i=0; i< numberShapes; i++) {
//				if( i == 0) {
//					System.out.println("First element is: \t\t"+ shapes[0].output(compareType));
//				}
//				else if(i== numberShapes -1) {
//					System.out.println("Last element is: \t\t"+ shapes[numberShapes-1].output(compareType));
//				}
//				else {
//					System.out.println(i+"-th element: \t\t"+ shapes[i].output(compareType));
//				}
//			}
//		}
	}
	// calculate runtime milliseconds
	private static int runTimeMS(long start, long end) {
		return (int) ((end - start) /1000000);
	}
	
}

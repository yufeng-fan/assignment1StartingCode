package appDomain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cone;
import shapes.Cylinder;
import shapes.OctagonalPrism;
import shapes.PentagonalPrism;
import shapes.Pyramid;
import shapes.Shape;
import shapes.SquarePrism;
import shapes.TriangularPrism;
import utilities.BubbleSort;
import utilities.CustomSort;
import utilities.InsertionSort;
import utilities.MergeSort;
import utilities.QuickSort;
import utilities.SelectionSort;
import utilities.SortStrategy;
import utilities.VolumnCompare;
import utilities.BaseAreaCompare;

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
	// file path
	private static String file;
	/**
	 * Comparison types:
		H/h: height 
		V/v: volume
		A/a: base area
	 */
	private static String type;
	
	/**
	 * Sorting Algorithms:
		I/i: Insertion
		S/s: Selection
		B/b: Bubble
		M/m: Merge
		Q/q: Quick
		Z/z: Algorithm of your choice
	 */
	private static String sort;
	
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{
		// TODO Auto-generated method stub

		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)
		
		AppDriver appDriver = new AppDriver();
		
		// parse args
		appDriver.parseArgs(args);
		
		// read all shapes
		Shape[] shapes = appDriver.readShapesFromFile(AppDriver.file);

		// get algorithm 
		SortStrategy sortStrategy;
		String sortName = "Bubble";
		if (AppDriver.sort.equals("i")) {
			sortStrategy = new InsertionSort();
			sortName = "Insertion";
		}else if (AppDriver.sort.equals("s")) {
			sortStrategy = new SelectionSort();
			sortName = "Selection";
		}else if (AppDriver.sort.equals("b")) {
			sortStrategy = new BubbleSort();
			sortName = "Bubble";
		}else if (AppDriver.sort.equals("m")) {
			sortStrategy = new MergeSort();
			sortName = "Merge";
		}else if (AppDriver.sort.equals("q")) {
			sortStrategy = new QuickSort();
			sortName = "Quick";
		}else if (AppDriver.sort.equals("z")) {
			sortStrategy = new CustomSort();
			sortName = "Custom";
		}else {
			sortStrategy = new BubbleSort();
		}
		
		// sort by compare type
		long startTime = shapes.length < 100 ? System.nanoTime(): System.currentTimeMillis();
		if(AppDriver.type.equals("h")) {
			sortStrategy.sort(shapes);
		} else if(AppDriver.type.equals("v")) {
			sortStrategy.sort(shapes, new VolumnCompare());
		}else if(AppDriver.type.equals("a")) {
			sortStrategy.sort(shapes, new BaseAreaCompare());
		}
		long endTime = shapes.length < 100 ? System.nanoTime(): System.currentTimeMillis();
        long duration = endTime - startTime;
        
        // print the sorted result
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<shapes.length; i++) {
			if (i == 0 || i == shapes.length - 1 || i % 1000 == 0) {

				if (i == 0) {
					sb.append(String.format("%-25s", "First element is:"));
				} else if (i == shapes.length - 1) {
					sb.append(String.format("%-25s", "Last element is:"));
				} else if (i % 1000 == 0) {
					sb.append(String.format("%-25s", i + "-th element:"));
				}

				sb.append(String.format("%25s", shapes[i].getClass().getName()));
				sb.append(String.format("%10s", ""));

				if (AppDriver.type.equals("h")) {
					sb.append(String.format("%-25s", "Height: " + shapes[i].getHeight()));
				} else if (AppDriver.type.equals("v")) {
					sb.append(String.format("%-25s", "Volumn: " + shapes[i].calcVolume()));
				} else if (AppDriver.type.equals("a")) {
					sb.append(String.format("%-25s", "Area: " + shapes[i].calcBaseArea()));
				}
				sb.append("\n");
			}
        }
        
        sb.append(sortName);
        sb.append(" Sort run time was: ");
        sb.append(duration);
        sb.append(shapes.length < 100 ? " nanoseconds." : " milliseconds.");
        System.out.println(sb.toString());
        
	}
	
	private void parseArgs( String[] args )
	{
		if( args.length < 3 )
		{
			System.out.println( "Not enough arguments." );
			System.out.println( "Usage: -ffile_name -ttype -ssort" );
			return;
		}

		System.out.println( "Testing args..." );
		for( int i = 0; i < args.length; i++ )
		{
			System.out.println( args[i] );
			if(args[i].toLowerCase().startsWith("-f")){
				AppDriver.file = args[i].substring(2);
			}else if(args[i].toLowerCase().startsWith("-t")) {
				AppDriver.type = args[i].substring(2).toLowerCase();
			}else if(args[i].toLowerCase().startsWith("-s")) {
				AppDriver.sort = args[i].substring(2).toLowerCase();
			}
		}
		System.out.println( "Done testing args!\n" );
	}

	private Shape[] readShapesFromFile(String file) {
		File inputFile = new File(file);
		Shape[] shapes = null;
		
		try (Scanner input = new Scanner( inputFile ))
		{
			
			//first line is the number of shapes 
			int numbers = Integer.parseInt(input.nextLine());
			shapes = new Shape[numbers];
			
			String[] shapeLine;
			String type;	
			int i = 0;
			while( input.hasNext() )
			{
				shapeLine= input.nextLine().split(" ");
				type = shapeLine[0];
				
				switch(type) {
				case "Cylinder":
					Cylinder cylinder = new Cylinder();
					cylinder.setHeight(Double.parseDouble(shapeLine[1]));
					cylinder.setRadius(Double.parseDouble(shapeLine[2]));
					shapes[i++] = cylinder;
					break;
				case "Cone":
					Cone cone = new Cone();
					cone.setHeight(Double.parseDouble(shapeLine[1]));
					cone.setRadius(Double.parseDouble(shapeLine[2]));
					shapes[i++] = cone;
					break;
				case "Pyramid":
					Pyramid pyramid = new Pyramid();
					pyramid.setHeight(Double.parseDouble(shapeLine[1]));
					pyramid.setSide(Double.parseDouble(shapeLine[2]));
					shapes[i++] = pyramid;
					break;
				case "SquarePrism":
					SquarePrism squarePrism = new SquarePrism();
					squarePrism.setHeight(Double.parseDouble(shapeLine[1]));
					squarePrism.setSide(Double.parseDouble(shapeLine[2]));
					shapes[i++] = squarePrism;
					break;
				case "TriangularPrism":
					TriangularPrism triangularPrism = new TriangularPrism();
					triangularPrism.setHeight(Double.parseDouble(shapeLine[1]));
					triangularPrism.setSide(Double.parseDouble(shapeLine[2]));
					shapes[i++] = triangularPrism;
					break;
				case "PentagonalPrism":
					PentagonalPrism pentagonalPrism = new PentagonalPrism();
					pentagonalPrism.setHeight(Double.parseDouble(shapeLine[1]));
					pentagonalPrism.setSide(Double.parseDouble(shapeLine[2]));
					shapes[i++] = pentagonalPrism;
					break;
				case "OctagonalPrism":
					OctagonalPrism octagonalPrism = new OctagonalPrism();
					octagonalPrism.setHeight(Double.parseDouble(shapeLine[1]));
					octagonalPrism.setSide(Double.parseDouble(shapeLine[2]));
					shapes[i++] = octagonalPrism;
					break;
				default:
					
				}
			}
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}
		
		/*
		 * for(int i=0; i<shapes.length; i++) {
		 * System.out.println(shapes[i].getClass().getName());
		 * System.out.println(shapes[i].getHeight());
		 * System.out.println(shapes[i].calcBaseArea());
		 * System.out.println(shapes[i].calcVolume()); }
		 */
		return shapes;
	}
}

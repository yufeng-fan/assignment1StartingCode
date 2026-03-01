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
	private static String file;
	private static String type;
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
			if(args[i].startsWith("-f")){
				AppDriver.file = args[i].substring(2);
			}else if(args[i].startsWith("-t")) {
				AppDriver.type = args[i].substring(2);
			}else if(args[i].startsWith("-s")) {
				AppDriver.sort = args[i].substring(2);
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

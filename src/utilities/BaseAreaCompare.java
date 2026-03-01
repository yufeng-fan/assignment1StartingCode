package utilities;

import java.util.Comparator;
import shapes.Shape;

public class BaseAreaCompare implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		if( o1.calcBaseArea() > o2.calcBaseArea() )
		{
			return 100;
		}
		else if( o1.calcBaseArea() < o2.calcBaseArea() )
		{
			return -100;
		}
		else 
		{
			return 0;
		}
	}

}

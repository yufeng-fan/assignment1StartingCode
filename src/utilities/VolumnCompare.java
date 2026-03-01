package utilities;

import java.util.Comparator;
import shapes.Shape;

public class VolumnCompare implements Comparator<Shape> {

	@Override
	public int compare(Shape o1, Shape o2) {
		if( o1.calcVolume() > o2.calcVolume() )
		{
			return 100;
		}
		else if( o1.calcVolume() < o2.calcVolume() )
		{
			return -100;
		}
		else 
		{
			return 0;
		}
	}

}

package shapes;

public class Cone extends Shape
{

	private double radius;	
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double calcVolume() {
		return this.calcBaseArea() * this.getHeight() / 3;
	}

	@Override
	public double calcBaseArea() {
		return Math.PI * this.getRadius() * this.getRadius();

	}

}

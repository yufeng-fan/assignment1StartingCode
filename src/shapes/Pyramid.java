package shapes;

public class Pyramid extends Shape
{

	private double side;

	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double calcVolume() {
		return this.calcBaseArea() * this.getHeight() / 3;
	}

	@Override
	public double calcBaseArea() {
		return this.getSide() * this.getSide();
	}

}

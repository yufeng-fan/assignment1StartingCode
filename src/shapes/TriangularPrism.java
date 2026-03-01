package shapes;

public class TriangularPrism extends Prism
{

	@Override
	public double calcVolume() {
		return this.calcBaseArea() * this.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return this.getSide() * this.getSide() * Math.sqrt(3) / 4;
	}

}

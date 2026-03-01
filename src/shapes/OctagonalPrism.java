package shapes;

public class OctagonalPrism extends Prism
{

	@Override
	public double calcVolume() {
		return this.calcBaseArea() * this.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return 2 * (1 + Math.sqrt(2)) * this.getSide() * this.getSide();
	}

}

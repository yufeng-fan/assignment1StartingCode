package shapes;

public class PentagonalPrism extends Prism
{

	@Override
	public double calcVolume() {
		return this.calcBaseArea() * this.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return 5 * this.getSide() * this.getSide() * Math.tan(Math.toRadians(54)) / 4;
	}

}

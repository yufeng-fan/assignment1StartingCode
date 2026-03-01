package shapes;

public class SquarePrism extends Prism
{

	@Override
	public double calcVolume() {
		return this.calcBaseArea() * this.getHeight();
	}

	@Override
	public double calcBaseArea() {
		return this.getSide() * this.getSide();
	}

}

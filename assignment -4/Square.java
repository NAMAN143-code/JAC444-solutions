import java.text.DecimalFormat;

public class Square extends Rectangle{

	private static DecimalFormat formatter = new DecimalFormat("##.#####");

	public Square(double side) throws ParallelogramException, SquareException {
		super(side, side);
	}
	
	@Override
	public double getPerimeter() {
		return 4 * getWidth();
	}

	@Override
	public String toString() {
		return "Square {s=" + (new Double(getWidth()).toString()) + "} perimeter = " + (new Double(formatter.format(getPerimeter())).toString());
	}
}
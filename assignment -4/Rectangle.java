import java.text.DecimalFormat;

public class Rectangle extends Parallelogram{

	private static DecimalFormat formatter = new DecimalFormat("##.#####");
	
	public Rectangle(double width, double height) throws ParallelogramException, SquareException {
		super(width, height);
	}
	
	@Override
	public double getPerimeter() {
		return 2 * (getWidth() + getHeight());
	}
	
	@Override
	public String toString() {
		return "Rectangle {w=" + (new Double(getWidth()).toString()) + ", h=" + (new Double(getHeight()).toString()) + "} perimeter = " + (new Double(formatter.format(getPerimeter())).toString());
	}
}
import java.text.DecimalFormat;

public class Circle implements Shape{
	
	private double radius;
	private static DecimalFormat formatter = new DecimalFormat("#.#####");
	private double radius2;
	private double perimeter;
	

	public Circle(double radius) throws CircleException {
		if(radius > 0.00) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}
	
// getters and setters - Intellisense 
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) throws CircleException {
		if(radius > 0) {
			this.radius = radius;
		} else {
			throw new CircleException("Invalid radius!");
		}
	}

	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}
	

	public String toString() {
		radius2 = getRadius();
		perimeter = getPerimeter();
		return "Circle {r=" + (new Double(radius2).toString()) + "} perimeter = " + (new Double(formatter.format(perimeter)).toString());
	}
}
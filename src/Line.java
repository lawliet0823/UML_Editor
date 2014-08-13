import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;

public class Line {

	protected String startLocation = "";
	protected String endLocation = "";
	protected Component startObject = null;
	protected Component endObject = null;
	protected int x = 0;
	protected int y = 0;

	public Line() {

	}

	public void setStartLocation(String args) {

	}

	public void setEndLocation(String args) {

	}

	public void setStartObject(Component args) {
		startObject = args;
	}

	public Component getStartObject() {
		return startObject;
	}

	public void setEndObject(Component args) {
		endObject = args;
	}

	public Component getEndObject() {
		return endObject;
	}

	public static Point setPoint(Component component, String Location) {
		Point point = new Point(0, 0);
		if (component instanceof ClassCreate) {
			if (Location.equals("up")) {
				point.x = component.getLocation().x + 100;
				point.y = component.getLocation().y;
			}

			if (Location.equals("down")) {
				point.x = component.getLocation().x + 100;
				point.y = component.getLocation().y + 200;
			}

			if (Location.equals("left")) {
				point.x = component.getLocation().x;
				point.y = component.getLocation().y + 100;
			}
			if (Location.equals("right")) {
				point.x = component.getLocation().x + 200;
				point.y = component.getLocation().y + 100;
			}
		}

		if (component instanceof UseCase) {
			if (Location.equals("up")) {
				point.x = component.getLocation().x + 150;
				point.y = component.getLocation().y;
			}

			if (Location.equals("down")) {
				point.x = component.getLocation().x + 150;
				point.y = component.getLocation().y + 200;
			}

			if (Location.equals("left")) {
				point.x = component.getLocation().x;
				point.y = component.getLocation().y + 100;
			}
			if (Location.equals("right")) {
				point.x = component.getLocation().x + 300;
				point.y = component.getLocation().y + 100;
			}
		}
		return point;
	}

	public void drawOnLine(Graphics g) {

	}

	public void setNormalX(int args) {
		this.x = args;
	}

	public void setNormalY(int args) {
		this.y = args;
	}
}

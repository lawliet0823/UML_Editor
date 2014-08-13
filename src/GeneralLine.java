import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class GeneralLine extends Line {

	public GeneralLine(String sLocatoin, String eLocation, Component sObject,
			Component eObject) {
		startLocation = sLocatoin;
		endLocation = eLocation;
		startObject = sObject;
		endObject = eObject;
	}

	public void setStartLocation(String args) {
		startLocation = args;
	}

	public void setEndLocation(String args) {
		endLocation = args;
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

	public Component getEndPoint() {
		return endObject;
	}

	public void setStartPoint(Point args) {
		startObject.setLocation(args);
	}

	public void setEndPoint(Point args) {
		endObject.setLocation(args);
	}

	public void drawOnLine(Graphics g) {

		Point startPoint = CompositionLine.setPoint(startObject, startLocation);
		startPoint.x += x;
		startPoint.y += y;
		Point endPoint = CompositionLine.setPoint(endObject, endLocation);
		endPoint.x += x;
		endPoint.y += y;
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3.0f));
		if (endLocation.equals("up")) {
			g2.drawLine(Line.setPoint(startObject, startLocation).x,
					Line.setPoint(startObject, startLocation).y,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y - 16);
			g2.drawLine(Line.setPoint(endObject, endLocation).x - 8,
					Line.setPoint(endObject, endLocation).y - 16,
					Line.setPoint(endObject, endLocation).x + 8,
					Line.setPoint(endObject, endLocation).y - 16);
			g2.drawLine(Line.setPoint(endObject, endLocation).x - 8,
					Line.setPoint(endObject, endLocation).y - 16,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y,
					Line.setPoint(endObject, endLocation).x + 8,
					Line.setPoint(endObject, endLocation).y - 16);
		}

		if (endLocation.equals("down")) {
			g2.drawLine(Line.setPoint(startObject, startLocation).x,
					Line.setPoint(startObject, startLocation).y,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y + 16);
			g2.drawLine(Line.setPoint(endObject, endLocation).x - 8,
					Line.setPoint(endObject, endLocation).y + 16,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x + 8,
					Line.setPoint(endObject, endLocation).y + 16,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x - 8,
					Line.setPoint(endObject, endLocation).y + 16,
					Line.setPoint(endObject, endLocation).x + 8,
					Line.setPoint(endObject, endLocation).y + 16);
		}

		if (endLocation.equals("left")) {
			g2.drawLine(Line.setPoint(startObject, startLocation).x,
					Line.setPoint(startObject, startLocation).y,
					Line.setPoint(endObject, endLocation).x - 16,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x - 16,
					Line.setPoint(endObject, endLocation).y - 8,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x - 16,
					Line.setPoint(endObject, endLocation).y + 8,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x - 16,
					Line.setPoint(endObject, endLocation).y - 8,
					Line.setPoint(endObject, endLocation).x - 16,
					Line.setPoint(endObject, endLocation).y + 8);
		}

		if (endLocation.equals("right")) {
			g2.drawLine(Line.setPoint(startObject, startLocation).x,
					Line.setPoint(startObject, startLocation).y,
					Line.setPoint(endObject, endLocation).x + 16,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x + 16,
					Line.setPoint(endObject, endLocation).y - 8,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x + 16,
					Line.setPoint(endObject, endLocation).y + 8,
					Line.setPoint(endObject, endLocation).x,
					Line.setPoint(endObject, endLocation).y);
			g2.drawLine(Line.setPoint(endObject, endLocation).x + 16,
					Line.setPoint(endObject, endLocation).y - 8,
					Line.setPoint(endObject, endLocation).x + 16,
					Line.setPoint(endObject, endLocation).y + 8);
		}
	}
}

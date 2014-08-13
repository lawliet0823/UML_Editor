import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class AssociationLine extends Line {

	public AssociationLine(String sLocatoin, String eLocation,
			Component sObject, Component eObject) {
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

	public void setEndObject(Component args) {
		endObject = args;
	}

	public Component getStartObject() {
		return startObject;
	}

	public Component getEndObject() {
		return endObject;
	}

	public void drawOnLine(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3.0f));
		g2.drawLine(GeneralLine.setPoint(startObject, startLocation).x + x,
				GeneralLine.setPoint(startObject, startLocation).y + y,
				GeneralLine.setPoint(endObject, endLocation).x + x,
				GeneralLine.setPoint(endObject, endLocation).y + y);
	}
}
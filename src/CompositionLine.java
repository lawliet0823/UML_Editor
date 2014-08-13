
import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.xml.ws.Endpoint;

public class CompositionLine extends Line {

	public CompositionLine(String sLocatoin, String eLocation,
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

	public Component getStartObject() {
		return startObject;
	}

	public void setEndObject(Component args) {
		endObject = args;
	}

	public Component getEndObject() {
		return endObject;
	}

	public void setStartPoint(Point args){
		startObject.setLocation(args);
	}
	
	public void setEndPoint(Point args){
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
			int x[] = { endPoint.x, endPoint.x + 6, endPoint.x, endPoint.x - 6 };
			int y[] = { endPoint.y - 30, endPoint.y - 15, endPoint.y,
					endPoint.y - 15 };
			g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y - 30);
			g2.drawPolygon(x, y, 4);
		}

		if (endLocation.equals("down")) {
			int x[] = { endPoint.x, endPoint.x + 6, endPoint.x, endPoint.x - 6 };
			int y[] = { endPoint.y, endPoint.y + 15, endPoint.y + 30,
					endPoint.y + 15 };
			g2.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y + 30);
			g2.drawPolygon(x, y, 4);
		}

		if (endLocation.equals("left")) {
			int x[] = { endPoint.x, endPoint.x - 15, endPoint.x - 30,
					endPoint.x - 15 };
			int y[] = { endPoint.y, endPoint.y + 6, endPoint.y, endPoint.y - 6 };
			g2.drawLine(startPoint.x, startPoint.y, endPoint.x - 30, endPoint.y);
			g2.drawPolygon(x, y, 4);
		}

		if (endLocation.equals("right")) {
			int x[] = { endPoint.x, endPoint.x + 15, endPoint.x + 30,
					endPoint.x + 15 };
			int y[] = { endPoint.y, endPoint.y - 6, endPoint.y, endPoint.y + 6 };
			g2.drawLine(startPoint.x, startPoint.y, endPoint.x + 30, endPoint.y);
			g2.drawPolygon(x, y, 4);
		}
	}
}

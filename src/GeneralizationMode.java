import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

public class GeneralizationMode extends Mode {

	private static GeneralizationMode generalInstance = null;
	private Canvas secondCanvas = null;
	private String startLocation;
	private String endLocation;
	private Component sObject;
	private Component eObject;

	private GeneralizationMode() {
		secondCanvas = secondCanvas.getInstance();
	}

	public static GeneralizationMode getInstance() {
		if (generalInstance == null) {
			generalInstance = new GeneralizationMode();
		}
		return generalInstance;
	}

	public void componentMousePressed(Shape shapeObject, Point args) {
		shapeObject.setPoint(shapeObject.getX(), shapeObject.getY());
		shapeObject.setReleasedPoint(args.x, args.y);
		startLocation = shapeObject.getPortLocation();
		sObject = shapeObject;
	}

	public void componentMouseReleased(Shape shapeObject, Point args) {
		shapeObject.setPoint(shapeObject.getX(), shapeObject.getY());
		shapeObject.setReleasedPoint(args.x, args.y);
		endLocation = shapeObject.getPortLocation();
		eObject = shapeObject;
		secondCanvas.addLine(new GeneralLine(startLocation, endLocation,
				sObject, eObject));
		secondCanvas.repaint();
	}
}

import java.awt.Component;
import java.awt.Point;

public class CompositionMode extends Mode {

	private static CompositionMode compositionInstance = null;
	private Canvas secondCanvas = null;
	private String startLocation;
	private String endLocation;
	private Component sObject;
	private Component eObject;

	private CompositionMode() {
		secondCanvas = Canvas.getInstance();
	}

	public static CompositionMode getInstance() {
		if (compositionInstance == null) {
			compositionInstance = new CompositionMode();
		}
		return compositionInstance;
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
		secondCanvas.addLine(new CompositionLine(startLocation, endLocation,
				sObject, eObject));
		secondCanvas.repaint();
	}
}

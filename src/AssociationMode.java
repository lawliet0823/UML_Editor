import java.awt.Component;
import java.awt.Point;

public class AssociationMode extends Mode {

	private static AssociationMode associationInstance = null;
	private Canvas secondCanvas = null;
	private String startLocation;
	private String endLocation;
	private Component sObject;
	private Component eObject;

	private AssociationMode() {
		secondCanvas = Canvas.getInstance();
	}

	public static AssociationMode getInstance() {
		if (associationInstance == null) {
			associationInstance = new AssociationMode();
		}
		return associationInstance;
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
		secondCanvas.addLine(new AssociationLine(startLocation, endLocation,
				sObject, eObject));
		secondCanvas.repaint();
	}
}

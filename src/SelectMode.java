import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

import javax.swing.SwingUtilities;

public class SelectMode extends Mode {

	private static SelectMode selectInstance = null;
	private Canvas secondCanvas = null;
	private Point startPoint = new Point(0, 0);
	private Point endPoint = new Point(0, 0);
	private Rectangle captureRectangle;
	private LinkedList<Shape> shapeLists = new LinkedList<>();

	private SelectMode() {
		secondCanvas = Canvas.getInstance();
	}

	public static SelectMode getInstance() {
		if (selectInstance == null) {
			selectInstance = new SelectMode();
		}
		return selectInstance;
	}

	public void createGroup() {
		Point maximumPoint = shapeLists.get(0).getLocation();
		Point minimumPoint = shapeLists.get(0).getLocation();
		for (int i = 0; i < shapeLists.size(); i++) {
			if (shapeLists.get(i).getLocation().x > maximumPoint.x) {
				maximumPoint.x = shapeLists.get(i).getLocation().x;
			}
			if (shapeLists.get(i).getLocation().y > maximumPoint.y) {
				maximumPoint.y = shapeLists.get(i).getLocation().y;
			}
			if (shapeLists.get(i).getLocation().x < minimumPoint.x) {
				minimumPoint.x = shapeLists.get(i).getLocation().x;
			}
			if (shapeLists.get(i).getLocation().y < minimumPoint.y) {
				minimumPoint.y = shapeLists.get(i).getLocation().y;
			}
		}
		minimumPoint.x -= 10;
		minimumPoint.y -= 10;
		Group group = new Group(minimumPoint, maximumPoint.x - minimumPoint.x
				+ 210, maximumPoint.y - minimumPoint.y + 210);
		group.addComponent(shapeLists);
		group.setLocation(minimumPoint);
		secondCanvas.add(group);
		secondCanvas.updateUI();
	}

	public void mousePressed(MouseEvent e) {
		secondCanvas.clearClassState();
		startPoint = e.getPoint();
	}

	public void mouseReleased(MouseEvent e) {
		// reselect object
		shapeLists = new LinkedList<>();
		endPoint = e.getPoint();
		captureRectangle = new Rectangle(startPoint.getLocation(),
				new Dimension(endPoint.x - startPoint.x, endPoint.y
						- startPoint.y));
		Component components[] = secondCanvas.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (captureRectangle.contains(components[i].getX(),
					components[i].getY(), 200, 200)) {
				shapeLists.add((Shape) components[i]);
				((Shape) components[i]).setObjectBorder();
			}
		}
	}

	public void componentMouseClicked(Shape shapeObject) {
		shapeObject.setSelectable(true);
		if (shapeObject instanceof ClassCreate) {
			((ClassCreate) shapeObject).setObjectBorder();
		}
		if (shapeObject instanceof UseCase) {
			((UseCase) shapeObject).setObjectBorder();
		}
		secondCanvas.setComponentZOrder(shapeObject, new Integer(0));
	}

	public void componentMouseDragged(Shape shapeObject, Point newP) {
		shapeObject.setLocation(newP.x, newP.y);
		shapeObject.setPoint(newP.x, newP.y);
		shapeObject.repaint();
		secondCanvas.repaint();
	}
}

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

public class ComponentListener implements MouseInputListener {

	private Component tempComponent;
	private Canvas secondCanvas = null;

	public ComponentListener() {
		secondCanvas = Canvas.getInstance();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Component component = (Component) e.getSource();
		secondCanvas.clearClassState();
		if (secondCanvas.getMode().getClass().getName().equals("SelectMode")) {
			secondCanvas.getMode().componentMouseClicked((Shape) component);
		}
		System.out.print(component.getBounds());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		Component component = (Component) e.getSource();
		Point newP = SwingUtilities.convertPoint(component, e.getPoint(),
				secondCanvas);
		System.out.println(newP);
		if (secondCanvas.getMode().getClass().getName()
				.equals("GeneralizationMode")) {
			secondCanvas.getMode().componentMousePressed((Shape) component,
					newP);
		}

		if (secondCanvas.getMode().getClass().getName()
				.equals("AssociationMode")) {
			secondCanvas.getMode().componentMousePressed((Shape) component,
					newP);
		}

		if (secondCanvas.getMode().getClass().getName()
				.equals("CompositionMode")) {
			secondCanvas.getMode().componentMousePressed((Shape) component,
					newP);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Component component = (Component) e.getSource();
		Point newP = SwingUtilities.convertPoint(component, e.getPoint(),
				secondCanvas);
		Component object = secondCanvas.getComponentAt(secondCanvas, newP);
		if (secondCanvas.getMode().getClass().getName()
				.equals("GeneralizationMode")) {
			secondCanvas.getMode().componentMouseReleased((Shape) object, newP);
		}

		if (secondCanvas.getMode().getClass().getName()
				.equals("AssociationMode")) {
			secondCanvas.getMode().componentMouseReleased((Shape) object, newP);
		}

		if (secondCanvas.getMode().getClass().getName()
				.equals("CompositionMode")) {
			secondCanvas.getMode().componentMouseReleased((Shape) object, newP);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		Component component = (Component) e.getSource();
		Point newP = SwingUtilities.convertPoint(component, e.getPoint(),
				secondCanvas);
		if (secondCanvas.getMode().getClass().getName().equals("SelectMode")) {
			secondCanvas.getMode().componentMouseDragged((Shape) component,
					newP);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}

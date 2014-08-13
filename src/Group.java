import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

public class Group extends Shape {

	private Canvas secondCanvas = null;
	private Point point = null;
	private LinkedList<Shape> shapes = null;

	public Group(Point pointArgs, int width, int height) {
		point = pointArgs;
		secondCanvas = Canvas.getInstance();
		this.setLayout(null);
		this.setLocation(point);
		this.setBackground(Color.black);
		this.setBorder(BorderFactory.createLineBorder(Color.yellow, 3));
		this.setBounds(new Rectangle(width, height));
		this.addMouseListener(new ComponentListener());
		this.addMouseMotionListener(new ComponentListener());
		this.setVisible(true);
	}

	public void addComponent(LinkedList<Shape> args) {
		shapes = args;
		for (int i = 0; i < args.size(); i++) {
			Shape shape = args.get(i);
			shape.setLocation(shape.getX() - point.x, shape.getY() - point.y);
			this.add(shape);
			secondCanvas.remove(shape);
		}
		checkLine(secondCanvas.getLine());
		this.repaint();
	}

	public void checkLine(LinkedList<Line> lines) {
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < shapes.size(); j++) {
				if ((lines.get(i).getStartObject().hashCode()) == shapes.get(j)
						.hashCode()) {
					lines.get(i).setStartObject(shapes.get(j));
					lines.get(i).setNormalX(point.x);
					lines.get(i).setNormalY(point.y);
				}
				if ((lines.get(i).getEndObject().hashCode()) == shapes.get(j)
						.hashCode()) {
					lines.get(i).setEndObject(shapes.get(j));
					lines.get(i).setNormalX(point.x);
					lines.get(i).setNormalY(point.y);
					lines.get(i).setEndObject(shapes.get(j));
				}

			}
		}
		this.repaint();
		secondCanvas.repaint();
	}
}

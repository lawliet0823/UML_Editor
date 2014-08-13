import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.LinkedList;

import javax.swing.JPanel;

public class Canvas extends JPanel {

	private static Canvas uniqueInstance = null;
	private Mode mode = null;
	private Point startPoint = new Point(0, 0);
	private Point endPoint = new Point(0, 0);
	private LinkedList<Line> lines = new LinkedList<>();

	private Canvas() {
		this.setBackground(Color.black);
		this.setLayout(null);
		this.setVisible(true);
	}

	public static Canvas getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Canvas();
		}
		return uniqueInstance;
	}

	public void clearClassState() {
		Component components[] = this.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof ClassCreate) {
				((ClassCreate) components[i]).setBorder(null);
				((ClassCreate) components[i]).setSelectable(false);
			}
			if (components[i] instanceof UseCase) {
				((UseCase) components[i]).setBorder(null);
				((UseCase) components[i]).setSelectable(false);
			}
		}
	}

	public void addLine(Line args) {
		lines.add(args);
	}

	public LinkedList<Line> getLine() {
		return lines;
	}

	public Component getComponentAt(Container parent, Point p) {
		Component component = null;
		for (Component child : this.getComponents()) {
			if (child.getBounds().contains(p)) {
				component = child;
			}
		}
		return component;
	}

	public void setMode(Mode args) {
		mode = args;
	}

	public Mode getMode() {
		return mode;
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		for (int i = 0; i < lines.size(); i++) {
			Line line;
			line = lines.pop();
			line.drawOnLine(g);
			lines.add(line);
		}
	}

}

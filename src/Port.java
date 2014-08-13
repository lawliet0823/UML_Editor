
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.border.AbstractBorder;

public class Port extends AbstractBorder {

	private int drawObject = 0;
	private Color borderColor;
	private int gap;
	private double rectWidth;
	private double rectHeight;

	public Port(Color color, int g, double w, double h,int state) {
		borderColor = color;
		gap = g;
		rectWidth = w;
		rectHeight = h;
		drawObject = state;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {

		super.paintBorder(c, g, x, y, width, height);
		Graphics2D g2d = null;
		if (g instanceof Graphics2D) {
			if (drawObject == 1) {
				g2d = (Graphics2D) g;
				g2d.setColor(borderColor);
				// Left Border
				g2d.fill(new Rectangle2D.Double((double) x + 95, (double) y,
						rectWidth, rectHeight));
				g2d.fill(new Rectangle2D.Double((double) x + 190,
						(double) y + 95, rectWidth, rectHeight));
				g2d.fill(new Rectangle2D.Double((double) x + 95,
						(double) y + 190, rectWidth, rectHeight));
				g2d.fill(new Rectangle2D.Double((double) x, (double) y + 95,
						rectWidth, rectHeight));
			}
			
			if (drawObject == 2) {
				g2d = (Graphics2D) g;
				g2d.setColor(borderColor);
				// Left Border
				g2d.fill(new Rectangle2D.Double((double) x + 140, (double) y,
						rectWidth, rectHeight));
				g2d.fill(new Rectangle2D.Double((double) x + 280,
						(double) y + 95, rectWidth, rectHeight));
				g2d.fill(new Rectangle2D.Double((double) x + 140,
						(double) y + 180, rectWidth, rectHeight));
				g2d.fill(new Rectangle2D.Double((double) x, (double) y + 95,
						rectWidth, rectHeight));
			}
		}
	}

	@Override
	public Insets getBorderInsets(Component c) {
		return (getBorderInsets(c, new Insets(gap, gap, gap, gap)));
	}

	@Override
	public Insets getBorderInsets(Component c, Insets insets) {
		insets.left = insets.top = insets.right = insets.bottom = gap;
		return insets;
	}

	@Override
	public boolean isBorderOpaque() {
		return true;
	}
}

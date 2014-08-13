
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.Rectangle2D;

import javax.swing.border.AbstractBorder;

public class UseCaseBorder extends AbstractBorder {
	private Color borderColor;
	private int gap;
	private double rectWidth;
	private double rectHeight;

	public UseCaseBorder(Color color, int g, double w, double h) {
		borderColor = color;
		gap = g;
		rectWidth = w;
		rectHeight = h;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {

		super.paintBorder(c, g, x, y, width, height);;
		Graphics2D g2d = null;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
			g2d.setColor(borderColor);
			// Left Border
			g2d.fill(new Rectangle2D.Double((double) x + 95, (double) y,
					rectWidth, rectHeight));
			g2d.fill(new Rectangle2D.Double((double) x + 190, (double) y + 95,
					rectWidth, rectHeight));
			g2d.fill(new Rectangle2D.Double((double) x + 95, (double) y + 190,
					rectWidth, rectHeight));
			g2d.fill(new Rectangle2D.Double((double) x, (double) y + 95,
					rectWidth, rectHeight));
		}
	}
}

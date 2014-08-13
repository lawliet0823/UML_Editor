

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UseCase extends BasicObject {

	private Canvas secondCanvas = null;
	private Point releasedPoint = new Point(0, 0);
	private Point portPoint = new Point(0, 0);
	private String portLocation = "";
	private Port portBorder = new Port(Color.blue, 10, 10, 10, 2);
	private Font labelFont = new Font(Font.SERIF, Font.ITALIC, 30);

	// initialization
	public UseCase() {
		secondCanvas = Canvas.getInstance();
		jLabel.setFont(labelFont);
		jLabel.setForeground(Color.yellow);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.black);
		this.add(jLabel, BorderLayout.CENTER);
		this.addMouseListener(new ComponentListener());
		this.addMouseMotionListener(new ComponentListener());
		this.setVisible(true);
	}

	// paint border
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.red);
		g.drawOval(0, 0, 295, 195);
	}
	
	public void setObjectBorder(){
		this.setBorder(new Port(Color.blue, 10, 10, 10, 2));
	}

}

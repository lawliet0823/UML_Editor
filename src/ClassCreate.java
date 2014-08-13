

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ClassCreate extends BasicObject {

	private Canvas secondCanvas;
	private Point releasedPoint = new Point(0, 0);
	private Point portPoint = new Point(0, 0);
	private String portLocation = "";
	private JTextField jTextName = new JTextField();
	private Port portOrder = new Port(Color.blue, 10, 10, 10, 1);
	private Font labelFont = new Font(Font.SERIF, Font.ITALIC, 30);

	public ClassCreate() {
		secondCanvas = Canvas.getInstance();
		jLabel.setFont(labelFont);
		jLabel.setForeground(Color.blue);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.orange);
		this.setBorder(BorderFactory.createLineBorder(Color.white, 3));
		this.add(jLabel, BorderLayout.NORTH);
		this.add(jTextName, BorderLayout.SOUTH);
		this.addMouseListener(new ComponentListener());
		this.addMouseMotionListener(new ComponentListener());
		this.setVisible(true);
	}

	public void setObjectBorder() {
		this.setBorder(new Port(Color.blue, 10, 10, 10, 1));
	}
}

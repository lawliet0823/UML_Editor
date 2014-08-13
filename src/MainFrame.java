import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MainFrame extends JPanel {

	public TaskBar taskBar = null;
	private Canvas canvas = null;

	public MainFrame() {

		this.setLayout(new BorderLayout());
		// °ò¥»³]¸m
		taskBar = taskBar.getInstance();
		canvas = Canvas.getInstance();
		canvas.setPreferredSize(new Dimension(1000, 600));

		this.add(taskBar, BorderLayout.WEST);
		this.add(canvas, BorderLayout.EAST);
	}

	public Canvas getCanvas() {
		return canvas;
	}

}

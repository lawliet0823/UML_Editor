import java.awt.Component;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class UML extends JFrame {

	private MainFrame mainFrame = new MainFrame();
	private MenuBar menuBar = new MenuBar();
	private Menu fileMenu = new Menu("File");
	private Menu editMenu = new Menu("Edit");
	private MenuItem changeNameMenuItem = new MenuItem("Change name");
	private MenuItem groupMenuItem = new MenuItem("Group");
	private MenuItem unGroupMenuItem = new MenuItem("Ungroup");
	private boolean stateGroup;
	private boolean stateUnGroup;

	public UML() {

		// Menubar
		editMenu.add(changeNameMenuItem);
		editMenu.add(groupMenuItem);
		editMenu.add(unGroupMenuItem);
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		this.setMenuBar(menuBar);

		this.setTitle("UML Editor");
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(mainFrame);
		this.setMenuBar(menuBar);
		this.setVisible(true);

		changeNameMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (mainFrame.getCanvas().getMode().getClass().getName()
						.equals("SelectMode")) {
					String className = JOptionPane.showInputDialog(null,
							"Change Name");
					if (!(className == "") && !(className.equals(""))) {
						Component components[] = mainFrame.getCanvas()
								.getComponents();
						for (int i = 0; i < components.length; i++) {
							Shape shape = (Shape) components[i];
							if (shape.getSelectable()) {
								shape.setClassName(className);
								shape.repaint();
							}
						}
					}
				}
			}
		});

		groupMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (mainFrame.getCanvas().getMode().getClass().getName()
						.equals("SelectMode")) {
					SelectMode.getInstance().createGroup();
					mainFrame.getCanvas().repaint();
				}
			}
		});
	}

	public static void main(String args[]) {
		new UML();
	}
}

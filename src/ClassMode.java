import java.awt.Component;
import java.awt.event.MouseEvent;

public class ClassMode extends Mode {

	private static ClassMode classInstance = null;
	private Canvas secondCanvas = null;

	private ClassMode() {
		secondCanvas = Canvas.getInstance();
	}

	public static ClassMode getInstance() {
		if (classInstance == null) {
			classInstance = new ClassMode();
		}
		return classInstance;
	}

	public void mouseClicked(MouseEvent e) {
		ClassCreate create = new ClassCreate();
		create.setBounds(e.getX(), e.getY(), 200, 200);
		create.setVisible(true);
		secondCanvas.add(create);
		secondCanvas.updateUI();
	}
}

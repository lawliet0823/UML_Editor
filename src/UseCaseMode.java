import java.awt.event.MouseEvent;

public class UseCaseMode extends Mode {

	private static UseCaseMode usecaseInstance = null;
	private Canvas secondCanvas = null;

	private UseCaseMode() {
		secondCanvas = Canvas.getInstance();
	}

	public static UseCaseMode getInstance() {
		if (usecaseInstance == null) {
			usecaseInstance = new UseCaseMode();
		}
		return usecaseInstance;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("Use");
		UseCase usecase = new UseCase();
		usecase.setBounds(e.getX(), e.getY(), 300, 200);
		usecase.setVisible(true);
		secondCanvas.add(usecase);
		secondCanvas.updateUI();
	}
}

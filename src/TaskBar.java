import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class TaskBar extends JPanel implements ActionListener {

	private static TaskBar taskBarInstance = null;
	private Canvas canvas = null;
	private Mode mode = new Mode();
	private JButton btnSelect = new JButton("Select");
	private JButton btnAssociation = new JButton("Association Line");
	private JButton btnGeneralization = new JButton("Generalization Line");
	private JButton btnComposition = new JButton("Composition Line");
	private JButton btnClass = new JButton("Class");
	private JButton btnUseCase = new JButton("Use Case");

	private TaskBar() {
		
		canvas = Canvas.getInstance();
		// «öÁä°»´ú
		btnSelect.addActionListener(this);
		btnAssociation.addActionListener(this);
		btnGeneralization.addActionListener(this);
		btnComposition.addActionListener(this);
		btnClass.addActionListener(this);
		btnUseCase.addActionListener(this);

		this.add(btnSelect);
		this.add(btnAssociation);
		this.add(btnGeneralization);
		this.add(btnComposition);
		this.add(btnClass);
		this.add(btnUseCase);
		this.setLayout(new GridLayout(6, 1));
	}

	public static TaskBar getInstance() {
		if (taskBarInstance == null) {
			taskBarInstance = new TaskBar();
		}
		return taskBarInstance;
	}

	public void actionPerformed(ActionEvent e) {

		canvas.removeMouseListener(mode);

		// TODO Auto-generated method stub
		if (e.getSource() == btnSelect) {
			btnSelect.setBackground(Color.black);
			mode = SelectMode.getInstance();
			// System.out.println(mode.getClass().getName());
		} else {
			btnSelect.setBackground(null);
		}

		if (e.getSource() == btnAssociation) {
			btnAssociation.setBackground(Color.black);
			mode = AssociationMode.getInstance();
		}

		else {
			btnAssociation.setBackground(null);
		}

		if (e.getSource() == btnGeneralization) {
			btnGeneralization.setBackground(Color.black);
			mode = GeneralizationMode.getInstance();
		} else {
			btnGeneralization.setBackground(null);
		}

		if (e.getSource() == btnComposition) {
			btnComposition.setBackground(Color.black);
			mode = CompositionMode.getInstance();

		} else {
			btnComposition.setBackground(null);
		}

		if (e.getSource() == btnClass) {
			btnClass.setBackground(Color.black);
			mode = ClassMode.getInstance();
		} else {
			btnClass.setBackground(null);
		}

		if (e.getSource() == btnUseCase) {
			btnUseCase.setBackground(Color.black);
			mode = UseCaseMode.getInstance();
		} else {
			btnUseCase.setBackground(null);
		}
		canvas.setMode(mode);
		canvas.addMouseListener(mode);
	}
}

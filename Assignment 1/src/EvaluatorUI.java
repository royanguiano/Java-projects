import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EvaluatorUI extends JFrame implements ActionListener {


	private TextField txField = new TextField();
	private Panel buttonPanel = new Panel();

	// total of 20 buttons on the calculator,
	// numbered from left to right, top to bottom
	// bText[] array contains the text for corresponding buttons
	private static final String[] bText = { "7", "8", "9", "+", "4", "5", "6",
			"- ", "1", "2", "3", "*", "0", ".", "=", "/", "(", ")", "C", "CE" };
	private Button[] buttons = new Button[bText.length];

	public static void main(String argv[]) {
		EvaluatorUI calc = new EvaluatorUI();
	}

	public EvaluatorUI() {

		setLayout(new BorderLayout());

		add(txField, BorderLayout.NORTH);
		txField.setEditable(false);

		add(buttonPanel, BorderLayout.CENTER);
		buttonPanel.setLayout(new GridLayout(5, 4));

		// create 20 buttons with corresponding text in bText[] array
		for (int i = 0; i < 20; i++) {
			buttons[i] = new Button(bText[i]);
		}

		// add buttons to button panel
		for (int i = 0; i < 20; i++) {
			buttonPanel.add(buttons[i]);
		}

		// set up buttons to listen for mouse input
		for (int i = 0; i < 20; i++) {
			buttons[i].addActionListener(this);
		}

		setTitle("Calculator");
		setSize(400, 400);
		setLocationByPlatform(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		for (int i = 0; i < 14; i++) {
			if (event.getSource() == buttons[i]) {
				txField.setText(txField.getText() + bText[i]);
				// buttons[ i ] = new Button( bText[ i ]);
			}
		}
		for (int j = 15; j <= 17; j++) {
			if (event.getSource() == buttons[j]) {
				txField.setText(txField.getText() + bText[j]);
				// buttons[ j ] = new Button( bText[ j ]);
			}
		}

		Evaluator calculator = new Evaluator();
		// String toDisplay = null;

		if (event.getActionCommand() == "C") {
			txField.setText("");

		} else if (event.getActionCommand() == "CE") {
			txField.setText(txField.getText().substring(0,
					txField.getText().length() - 1));
		}

		else if (event.getActionCommand().toString().trim().equals("=")) {
			String Display = ((txField.getText() + event.getActionCommand())
					.toString().trim());
			txField.setText(Display);
			String Process = Display.substring(0, Display.length() - 1);
			int result = calculator.eval(Process);
			String Displayedanswer = Integer.toString(result);
			txField.setText(Displayedanswer);
		}
	}
}

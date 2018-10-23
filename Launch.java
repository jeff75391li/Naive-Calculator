import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Load the GUI of the calculator
public class Launch {
	public JTextField[][] tf;
	public JDialog d;
	
	public Launch() {
		JFrame f = new JFrame("Naive Calculator"); // basic frame of the calculator
		f.setLayout(new GridLayout(5, 1));
		d = new JDialog(f, "Hey!", true); // Dialog that appears with warning
		d.setSize(150, 62);
		d.setLocation(700, 350);
		d.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel warning = new JLabel("Please enter number!"); // content of the warning
		d.add(warning);
		d.setResizable(false);
		tf = new JTextField[4][3]; // set up text fields for inputs and answers
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++)
			tf[i][j] = new JTextField(20);
		}
		JLabel remark = new JLabel("NOTES: All results will be rounded to thousandths"); // add notes about the results

		// set up the symbols of "+" "-" "*" "/"
		JLabel[] L = new JLabel[4];
		String[] sign = {"+", "£­", "¡Á", "¡Â"};
		for (int i = 0; i < 4; i++) {
			L[i] = new JLabel(sign[i]);
		}

		// set up buttons of "equals"
		JButton[] equal = new JButton[4];
		for (int i = 0; i < 4; i++) {
			equal[i] = new JButton("=");
		}

		// set up panels for 4 different operations and add corresponding textfields and buttons
		JPanel[] p = new JPanel[4];
		for (int i = 0; i < 4; i++) {
			p[i] = new JPanel();
			p[i].setLayout(new FlowLayout());
		}
		for (int i = 0; i < 4; i++) {
			p[i].add(tf[i][0]);
			p[i].add(L[i]);
			p[i].add(tf[i][1]);
			p[i].add(equal[i]);
			p[i].add(tf[i][2]);
		}
		f.add(remark);
		for (int i = 0; i < 4; i++) {
			f.add(p[i]);
		}
		
		// set up listeners for 4 operations
		AddListener AL = new AddListener(this);
		SubListener SL = new SubListener(this);
		MulListener ML = new MulListener(this);
		DivListener DL = new DivListener(this);
		equal[0].addActionListener(AL);
		equal[1].addActionListener(SL);
		equal[2].addActionListener(ML);
		equal[3].addActionListener(DL);

		f.pack();

		f.setLocation(400,300);
		f.setVisible(true);
		
		f.setResizable(false);
		f.addWindowListener(new CloseWindow());
	}
}

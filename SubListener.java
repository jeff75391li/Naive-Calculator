import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

// Listener for subtraction
public class SubListener implements ActionListener {
	private Launch L;
	
	public SubListener(Launch L) {
		this.L = L;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// perform subtraction after clicking the button
		try {
			DecimalFormat df = new DecimalFormat("0.000");
			double number1 = Double.parseDouble(L.tf[1][0].getText());
			double number2 = Double.parseDouble(L.tf[1][1].getText());
			L.tf[1][2].setText(df.format(number1 - number2));
		}
		catch (Exception ex) {
			L.d.setVisible(true);
		}
	}
}

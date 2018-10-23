import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

// Listener for addition
public class AddListener implements ActionListener {
	private Launch L;
	
	public AddListener(Launch L) {
		this.L = L;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// perform addition after clicking the button
		try {
			DecimalFormat df = new DecimalFormat("0.000"); // Round the result to thousandths
			double number1 = Double.parseDouble(L.tf[0][0].getText());
			double number2 = Double.parseDouble(L.tf[0][1].getText());
			L.tf[0][2].setText(df.format(number1 + number2));
		}
		catch (Exception ex) {
			L.d.setVisible(true);
		}
	}
}

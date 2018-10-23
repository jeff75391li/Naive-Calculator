import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// The class is to handle the event of closing the window
public class CloseWindow extends WindowAdapter {
	// close the window and end the progress when click the exit button
	public void windowClosing(WindowEvent e)
	{
		System.exit(0);
	}
}

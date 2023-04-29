package view;

import javax.swing.JPanel;
import java.awt.Color;

public class JPanelLoaiLinhKien extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelLoaiLinhKien() {
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1397, 53);
		add(panel);

	}

}

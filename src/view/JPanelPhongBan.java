package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class JPanelPhongBan extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelPhongBan() {
		setBackground(new Color(64, 224, 208));
		setForeground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1286, 53);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHÒNG BAN");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1286, 53);
		panel.add(lblNewLabel);

	}
}

package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class JPanelTrangChu extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelTrangChu() {
		setBackground(new Color(153, 204, 51));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1316, 53);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("TRANG CHỦ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		panel.add(lblNewLabel, BorderLayout.CENTER);

	}
}

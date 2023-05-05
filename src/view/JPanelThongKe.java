package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class JPanelThongKe extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelThongKe() {
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1285, 53);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ");
		lblNewLabel.setBounds(0, 0, 1285, 53);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel);
		
		

	}
}

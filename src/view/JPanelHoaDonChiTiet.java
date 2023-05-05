package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;

public class JPanelHoaDonChiTiet extends JPanel {
	private JTable tableLinhKien;
	private JTable tableHoaDonChiTiet;

	/**
	 * Create the panel.
	 */
	public JPanelHoaDonChiTiet() {
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1284, 53);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT ĐƠN HÀNG");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1284, 53);
		panel.add(lblNewLabel);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBackground(new Color(204, 255, 255));
		splitPane.setResizeWeight(0.45);
		splitPane.setBounds(10, 63, 821, 621);
		add(splitPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 153, 102));
		splitPane.setLeftComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1 = new JLabel("LINH KIỆN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tableLinhKien = new JTable();
		tableLinhKien.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3", "T\u00CAN", "LO\u1EA0I LINH KI\u1EC6N", "NH\u00C0 CUNG C\u1EA4P", "S\u1ED0 L\u01AF\u1EE2NG"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableLinhKien.getColumnModel().getColumn(0).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(0).setPreferredWidth(55);
		tableLinhKien.getColumnModel().getColumn(1).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(1).setPreferredWidth(114);
		tableLinhKien.getColumnModel().getColumn(2).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(2).setPreferredWidth(85);
		tableLinhKien.getColumnModel().getColumn(3).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(3).setPreferredWidth(82);
		tableLinhKien.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tableLinhKien);
		
		JLabel label = new JLabel("New label");
		scrollPane.setColumnHeaderView(label);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(51, 51, 51));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("THÊM");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnNewButton);
		
		JButton btnXa = new JButton("XÓA");
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnXa);
		
		JButton btnCpNht = new JButton("CẬP NHẬT");
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnCpNht);
		
		JButton btnXaTrng = new JButton("XÓA TRẮNG");
		btnXaTrng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnXaTrng);
		
		JButton btnInHan = new JButton("IN HÓA ĐƠN");
		btnInHan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnInHan);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 102));
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("HÓA ĐƠN CHI TIẾT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		tableHoaDonChiTiet = new JTable();
		tableHoaDonChiTiet.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 H\u00D3A \u0110\u01A0N", "M\u00C3 LINH KI\u1EC6N", "GI\u00C1 G\u1ED0C", "S\u1ED0 L\u01AF\u1EE2NG", "GI\u1EA2M GI\u00C1", "TH\u00C0NH TI\u1EC0N"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableHoaDonChiTiet.getColumnModel().getColumn(0).setResizable(false);
		tableHoaDonChiTiet.getColumnModel().getColumn(0).setPreferredWidth(74);
		tableHoaDonChiTiet.getColumnModel().getColumn(1).setResizable(false);
		tableHoaDonChiTiet.getColumnModel().getColumn(2).setResizable(false);
		tableHoaDonChiTiet.getColumnModel().getColumn(3).setResizable(false);
		tableHoaDonChiTiet.getColumnModel().getColumn(4).setResizable(false);
		tableHoaDonChiTiet.getColumnModel().getColumn(4).setPreferredWidth(60);
		tableHoaDonChiTiet.getColumnModel().getColumn(5).setResizable(false);
		scrollPane_1.setViewportView(tableHoaDonChiTiet);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 51));
		panel_4.setBounds(841, 63, 433, 621);
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		JTextPane txtpane = new JTextPane();
		txtpane.setText("ZZZZZZZZZ");
		scrollPane_2.setViewportView(txtpane);
		
		JLabel lblNewLabel_3 = new JLabel("PHIẾU HÓA ĐƠN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);

	}
}

package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class JPanelKhachHang extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 */
	public JPanelKhachHang() {
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1286, 53);
		add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("KHÁCH HÀNG");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		panelTitle.add(lblNewLabel);
		
		JPanel panel_table = new JPanel();
		panel_table.setBorder(null);
		panel_table.setBackground(new Color(153, 204, 204));
		panel_table.setBounds(284, 63, 992, 394);
		add(panel_table);
		panel_table.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 992, 364);
		panel_table.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 KH\u00C1CH H\u00C0NG", "H\u1ECC V\u00C0 T\u00CAN", "\u0110\u1ECAA CH\u1EC8", "S\u0110T", "EMAIL"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 992, 30);
		panel_3.setBackground(new Color(255, 0, 51));
		panel_table.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DANH SÁCH KHÁCH HÀNG");
		lblNewLabel_2.setBounds(10, 5, 972, 20);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_inforKH = new JPanel();
		panel_inforKH.setBorder(null);
		panel_inforKH.setBackground(new Color(204, 204, 204));
		panel_inforKH.setBounds(10, 467, 1266, 215);
		add(panel_inforKH);
		panel_inforKH.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 1266, 30);
		panel_6.setBackground(new Color(255, 51, 51));
		panel_inforKH.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_4.setBounds(5, 5, 1251, 20);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_6.add(lblNewLabel_4);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 30, 1266, 185);
		panel_inforKH.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Mã khách hàng");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 10, 91, 28);
		panel_7.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 38, 377, 28);
		panel_7.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblMessMaKH = new JLabel("");
		lblMessMaKH.setForeground(new Color(255, 0, 0));
		lblMessMaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessMaKH.setBounds(111, 10, 276, 28);
		panel_7.add(lblMessMaKH);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tên khách hàng");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(10, 76, 91, 28);
		panel_7.add(lblNewLabel_5_1);
		
		JLabel lblMessTenKH = new JLabel("");
		lblMessTenKH.setForeground(Color.RED);
		lblMessTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessTenKH.setBounds(111, 76, 276, 28);
		panel_7.add(lblMessTenKH);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 104, 377, 28);
		panel_7.add(textField_3);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Địa chỉ");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1_1.setBounds(444, 10, 91, 28);
		panel_7.add(lblNewLabel_5_1_1);
		
		JLabel lblMessDiaChi = new JLabel("");
		lblMessDiaChi.setForeground(Color.RED);
		lblMessDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessDiaChi.setBounds(545, 10, 275, 28);
		panel_7.add(lblMessDiaChi);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(443, 38, 377, 28);
		panel_7.add(textField_4);
		
		JLabel lblNewLabel_5_1_2 = new JLabel("SĐT");
		lblNewLabel_5_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1_2.setBounds(444, 76, 91, 28);
		panel_7.add(lblNewLabel_5_1_2);
		
		JLabel lblMessSDT = new JLabel("");
		lblMessSDT.setForeground(Color.RED);
		lblMessSDT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessSDT.setBounds(545, 76, 275, 28);
		panel_7.add(lblMessSDT);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(444, 104, 377, 28);
		panel_7.add(textField_5);
		
		JLabel lblNewLabel_5_1_3 = new JLabel("Email");
		lblNewLabel_5_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1_3.setBounds(879, 10, 91, 28);
		panel_7.add(lblNewLabel_5_1_3);
		
		JLabel lblMessEmail = new JLabel("");
		lblMessEmail.setForeground(Color.RED);
		lblMessEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessEmail.setBounds(966, 10, 290, 28);
		panel_7.add(lblMessEmail);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(879, 38, 377, 28);
		panel_7.add(textField_6);
		
		JPanel panel_chucnang = new JPanel();
		panel_chucnang.setBorder(null);
		panel_chucnang.setBackground(new Color(204, 204, 204));
		panel_chucnang.setBounds(10, 63, 264, 394);
		add(panel_chucnang);
		panel_chucnang.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 264, 31);
		panel_5.setBackground(new Color(255, 51, 51));
		panel_5.setPreferredSize(new Dimension(10, 50));
		panel_chucnang.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("CHỨC NĂNG");
		lblNewLabel_3.setBounds(10, 5, 244, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_5.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 29, 264, 365);
		panel_chucnang.add(panel_4);
		panel_4.setBackground(new Color(204, 204, 204));
		panel_4.setPreferredSize(new Dimension(200, 160));
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(10, 22, 70, 70);
		panel_4.add(btnNewButton);
		btnNewButton.setIcon(new ImageIcon(JPanelKhachHang.class.getResource("/img/add_36px.png")));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(10, 102, 70, 70);
		panel_4.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon(JPanelKhachHang.class.getResource("/img/erase_36px.png")));
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(100, 22, 70, 70);
		panel_4.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(JPanelKhachHang.class.getResource("/img/minus_36px.png")));
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(184, 22, 70, 70);
		panel_4.add(btnNewButton_3);
		btnNewButton_3.setIcon(new ImageIcon(JPanelKhachHang.class.getResource("/img/update_36px.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 183, 244, 175);
		panel_4.add(panel_1);
		panel_1.setPreferredSize(new Dimension(250, 180));
		panel_1.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "L\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(204, 204, 204));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MÃ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 20, 224, 27);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 46, 224, 37);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÊN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 93, 224, 27);
		panel_1.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 119, 224, 37);
		panel_1.add(textField_1);

	}
}

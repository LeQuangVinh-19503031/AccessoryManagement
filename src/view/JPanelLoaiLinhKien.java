package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPanelLoaiLinhKien extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public JPanelLoaiLinhKien() {
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1397, 53);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOẠI LINH KIỆN");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(0, 0, 1286, 53);
		panel.add(lblNewLabel);
		
		JPanel panel_chucnang = new JPanel();
		panel_chucnang.setLayout(null);
		panel_chucnang.setBorder(null);
		panel_chucnang.setBackground(new Color(204, 204, 204));
		panel_chucnang.setBounds(10, 63, 264, 674);
		add(panel_chucnang);
		
		JPanel panel_5_1 = new JPanel();
		panel_5_1.setLayout(null);
		panel_5_1.setPreferredSize(new Dimension(10, 50));
		panel_5_1.setBackground(new Color(255, 51, 51));
		panel_5_1.setBounds(0, 0, 264, 31);
		panel_chucnang.add(panel_5_1);
		
		JLabel lblNewLabel_3 = new JLabel("CHỨC NĂNG");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(10, 5, 244, 20);
		panel_5_1.add(lblNewLabel_3);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setPreferredSize(new Dimension(200, 160));
		panel_4_1.setBackground(new Color(204, 204, 204));
		panel_4_1.setBounds(0, 29, 264, 645);
		panel_chucnang.add(panel_4_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setPreferredSize(new Dimension(250, 180));
		panel_1_2.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "L\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(204, 204, 204));
		panel_1_2.setBounds(10, 170, 244, 465);
		panel_4_1.add(panel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("MÃ LINH KIỆN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 27, 79, 13);
		panel_1_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 50, 224, 37);
		panel_1_2.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÊN");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 97, 79, 13);
		panel_1_2.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 119, 224, 37);
		panel_1_2.add(textField_1);
		
		JButton btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/add_36px.png")));
		btnThem.setToolTipText("Thêm nhà cung cấp");
		btnThem.setPreferredSize(new Dimension(140, 40));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(10, 10, 70, 70);
		panel_4_1.add(btnThem);
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/minus_36px.png")));
		btnXoa.setPreferredSize(new Dimension(140, 40));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(90, 10, 70, 70);
		panel_4_1.add(btnXoa);
		
		JButton btnCapNhat = new JButton("");
		btnCapNhat.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/updateLK_36px.png")));
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		btnCapNhat.setPreferredSize(new Dimension(140, 40));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBounds(170, 10, 70, 70);
		panel_4_1.add(btnCapNhat);
		
		JButton btnXoaTrang = new JButton("");
		btnXoaTrang.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/erase_36px.png")));
		btnXoaTrang.setPreferredSize(new Dimension(140, 40));
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaTrang.setBounds(10, 90, 70, 70);
		panel_4_1.add(btnXoaTrang);
		
		JPanel panelTable = new JPanel();
		panelTable.setBorder(null);
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBounds(284, 63, 991, 294);
		add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panelTable.add(panel_7, BorderLayout.NORTH);
		panel_7.setBackground(new Color(255, 102, 51));
		
		JLabel lblNewLabel_9 = new JLabel("DANH SÁCH ĐƠN HÀNG");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_7.add(lblNewLabel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(new Color(204, 255, 255));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 LO\u1EA0I LINH KI\u1EC6N", "T\u00CAN LO\u1EA0I LINH KI\u1EC6N", "S\u1ED0 L\u01AF\u1EE2NG LINH KI\u1EC6N"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(102);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JPanel panel_inforKH = new JPanel();
		panel_inforKH.setLayout(null);
		panel_inforKH.setBorder(null);
		panel_inforKH.setBackground(new Color(204, 204, 204));
		panel_inforKH.setBounds(284, 367, 629, 181);
		add(panel_inforKH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 51, 51));
		panel_6.setBounds(0, 0, 1266, 30);
		panel_inforKH.add(panel_6);
		
		JLabel lblNewLabel_4 = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(5, 5, 979, 20);
		panel_6.add(lblNewLabel_4);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBackground(new Color(192, 192, 192));
		panel_7_1.setLayout(null);
		panel_7_1.setBounds(0, 30, 629, 150);
		panel_inforKH.add(panel_7_1);
		
		JLabel lblNewLabel_5 = new JLabel("Mã loại linh kiện");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 10, 100, 28);
		panel_7_1.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 38, 609, 28);
		panel_7_1.add(textField_4);
		
		JLabel lblMessMaKH = new JLabel("");
		lblMessMaKH.setForeground(Color.RED);
		lblMessMaKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessMaKH.setBounds(111, 10, 508, 28);
		panel_7_1.add(lblMessMaKH);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tên loại linh kiện");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(10, 76, 100, 28);
		panel_7_1.add(lblNewLabel_5_1);
		
		JLabel lblMessTenKH = new JLabel("");
		lblMessTenKH.setForeground(Color.RED);
		lblMessTenKH.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessTenKH.setBounds(111, 76, 508, 28);
		panel_7_1.add(lblMessTenKH);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(10, 104, 609, 28);
		panel_7_1.add(textField_5);

	}
}

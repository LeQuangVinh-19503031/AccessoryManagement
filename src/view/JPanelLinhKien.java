package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class JPanelLinhKien extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Create the panel.
	 */
	public JPanelLinhKien() {
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1283, 53);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LINH KIỆN");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1283, 53);
		panel.add(lblNewLabel);
		
		JPanel panelTable = new JPanel();
		panelTable.setBorder(null);
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBounds(284, 63, 989, 339);
		add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_7.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_7.setBackground(new Color(255, 102, 51));
		panelTable.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_9 = new JLabel("DANH SÁCH LINH KIỆN");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_7.add(lblNewLabel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(new Color(204, 255, 255));
		panelTable.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 LINH KI\u1EC6N", "T\u00CAN", "LO\u1EA0I", "NH\u00C0 CUNG C\u1EA4P", "\u0110\u01A0N V\u1ECA T\u00CDNH", "GI\u00C1 NH\u1EACP", "GI\u00C1 B\u00C1N", "S\u1ED0 L\u01AF\u1EE2NG", "M\u00D4 T\u1EA2"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(72);
		table.getColumnModel().getColumn(1).setPreferredWidth(130);
		table.getColumnModel().getColumn(3).setPreferredWidth(82);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(284, 412, 989, 276);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_3.setBackground(new Color(255, 99, 71));
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6 = new JLabel("THÔNG TIN LINH KIỆN");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblNewLabel_6);
		
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(null);
		panelThongTin.setBorder(null);
		panelThongTin.setBackground(Color.LIGHT_GRAY);
		panel_2.add(panelThongTin, BorderLayout.CENTER);
		
		JLabel lblNewLabel_2 = new JLabel("Mã linh kiện");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setAlignmentY(0.0f);
		lblNewLabel_2.setBounds(13, 10, 89, 26);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Loại linh kiện");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_1.setBounds(305, 11, 111, 26);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Tên linh kiện");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2.setBounds(17, 80, 89, 25);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Nhà cung cấp");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1.setBounds(305, 80, 89, 26);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Đơn vị tính");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2_2.setBounds(16, 146, 89, 26);
		panelThongTin.add(lblNewLabel_2_2_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setAlignmentY(0.0f);
		textField.setAlignmentX(0.0f);
		textField.setBounds(13, 37, 282, 32);
		panelThongTin.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setAlignmentY(0.0f);
		textField_1.setAlignmentX(0.0f);
		textField_1.setBounds(305, 38, 301, 32);
		panelThongTin.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setAlignmentY(0.0f);
		textField_2.setAlignmentX(0.0f);
		textField_2.setBounds(17, 104, 278, 32);
		panelThongTin.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setAlignmentY(0.0f);
		textField_3.setAlignmentX(0.0f);
		textField_3.setBounds(305, 105, 301, 32);
		panelThongTin.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setAlignmentY(0.0f);
		textField_4.setAlignmentX(0.0f);
		textField_4.setBounds(13, 172, 282, 32);
		panelThongTin.add(textField_4);
		
		JLabel lblMessDiaChiGiaoHang = new JLabel("");
		lblMessDiaChiGiaoHang.setForeground(Color.RED);
		lblMessDiaChiGiaoHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessDiaChiGiaoHang.setBounds(112, 146, 183, 26);
		panelThongTin.add(lblMessDiaChiGiaoHang);
		
		JLabel lblMessNgayGiao = new JLabel("");
		lblMessNgayGiao.setForeground(Color.RED);
		lblMessNgayGiao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessNgayGiao.setBounds(404, 80, 202, 26);
		panelThongTin.add(lblMessNgayGiao);
		
		JLabel lblMessMaNhanVien = new JLabel("");
		lblMessMaNhanVien.setForeground(Color.RED);
		lblMessMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessMaNhanVien.setBounds(116, 79, 179, 26);
		panelThongTin.add(lblMessMaNhanVien);
		
		JLabel lblMessMaKhachHang = new JLabel("");
		lblMessMaKhachHang.setForeground(Color.RED);
		lblMessMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessMaKhachHang.setBounds(414, 11, 192, 26);
		panelThongTin.add(lblMessMaKhachHang);
		
		JLabel lblMessMaHD = new JLabel("");
		lblMessMaHD.setForeground(Color.RED);
		lblMessMaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessMaHD.setBounds(112, 10, 183, 26);
		panelThongTin.add(lblMessMaHD);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Số lượng");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1.setBounds(305, 147, 62, 26);
		panelThongTin.add(lblNewLabel_2_2_1_1);
		
		JLabel lblMessNgayGiao_1 = new JLabel("");
		lblMessNgayGiao_1.setForeground(Color.RED);
		lblMessNgayGiao_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessNgayGiao_1.setBounds(404, 147, 202, 26);
		panelThongTin.add(lblMessNgayGiao_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setAlignmentY(0.0f);
		textField_6.setAlignmentX(0.0f);
		textField_6.setBounds(305, 172, 301, 32);
		panelThongTin.add(textField_6);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Giá nhập");
		lblNewLabel_2_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1_1.setBounds(616, 12, 99, 26);
		panelThongTin.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblMessNgayGiao_1_1 = new JLabel("");
		lblMessNgayGiao_1_1.setForeground(Color.RED);
		lblMessNgayGiao_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessNgayGiao_1_1.setBounds(725, 12, 254, 26);
		panelThongTin.add(lblMessNgayGiao_1_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setAlignmentY(0.0f);
		textField_7.setAlignmentX(0.0f);
		textField_7.setBounds(616, 37, 363, 32);
		panelThongTin.add(textField_7);
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("Giá bán");
		lblNewLabel_2_2_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1_1_1.setBounds(616, 79, 99, 26);
		panelThongTin.add(lblNewLabel_2_2_1_1_1_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setAlignmentY(0.0f);
		textField_8.setAlignmentX(0.0f);
		textField_8.setBounds(616, 104, 363, 32);
		panelThongTin.add(textField_8);
		
		JLabel lblMessNgayGiao_1_1_1 = new JLabel("");
		lblMessNgayGiao_1_1_1.setForeground(Color.RED);
		lblMessNgayGiao_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessNgayGiao_1_1_1.setBounds(725, 79, 254, 26);
		panelThongTin.add(lblMessNgayGiao_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1_1 = new JLabel("Mô tả");
		lblNewLabel_2_2_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1_1_1_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1_1_1_1.setBounds(616, 146, 99, 26);
		panelThongTin.add(lblNewLabel_2_2_1_1_1_1_1);
		
		JLabel lblMessNgayGiao_1_1_1_1 = new JLabel("");
		lblMessNgayGiao_1_1_1_1.setForeground(Color.RED);
		lblMessNgayGiao_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessNgayGiao_1_1_1_1.setBounds(725, 146, 254, 26);
		panelThongTin.add(lblMessNgayGiao_1_1_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setAlignmentY(0.0f);
		textField_9.setAlignmentX(0.0f);
		textField_9.setBounds(616, 171, 363, 65);
		panelThongTin.add(textField_9);
		
		JPanel panel_chucnang = new JPanel();
		panel_chucnang.setLayout(null);
		panel_chucnang.setBorder(null);
		panel_chucnang.setBackground(new Color(204, 204, 204));
		panel_chucnang.setBounds(10, 63, 264, 625);
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
		panel_4_1.setBounds(0, 29, 264, 595);
		panel_chucnang.add(panel_4_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setPreferredSize(new Dimension(250, 180));
		panel_1_2.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "L\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(204, 204, 204));
		panel_1_2.setBounds(10, 170, 244, 415);
		panel_4_1.add(panel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("MÃ LINH KIỆN");
		lblNewLabel_1.setBounds(10, 27, 79, 13);
		panel_1_2.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 50, 224, 37);
		panel_1_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÊN");
		lblNewLabel_1_1.setBounds(10, 97, 79, 13);
		panel_1_2.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_10 = new JTextField();
		textField_10.setBounds(10, 119, 151, 37);
		panel_1_2.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("NHÀ CUNG CẤP");
		lblNewLabel_1_2.setBounds(10, 166, 91, 13);
		panel_1_2.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_11 = new JTextField();
		textField_11.setBounds(10, 189, 151, 37);
		panel_1_2.add(textField_11);
		textField_11.setColumns(10);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("LOẠI LINH KIỆN");
		lblNewLabel_1_2_1.setBounds(10, 236, 91, 13);
		panel_1_2.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_12 = new JTextField();
		textField_12.setBounds(10, 259, 151, 37);
		panel_1_2.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon(JPanelLinhKien.class.getResource("/img/add_36px.png")));
		btnThem.setBounds(10, 10, 70, 70);
		panel_4_1.add(btnThem);
		btnThem.setToolTipText("Thêm nhà cung cấp");
		btnThem.setPreferredSize(new Dimension(140, 40));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(JPanelLinhKien.class.getResource("/img/minus_36px.png")));
		btnXoa.setBounds(90, 10, 70, 70);
		panel_4_1.add(btnXoa);
		btnXoa.setPreferredSize(new Dimension(140, 40));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCapNhat = new JButton("");
		btnCapNhat.setIcon(new ImageIcon(JPanelLinhKien.class.getResource("/img/update_36px.png")));
		btnCapNhat.setBounds(170, 10, 70, 70);
		panel_4_1.add(btnCapNhat);
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		btnCapNhat.setPreferredSize(new Dimension(140, 40));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnXoaTrang = new JButton("");
		btnXoaTrang.setIcon(new ImageIcon(JPanelLinhKien.class.getResource("/img/erase_36px.png")));
		btnXoaTrang.setBounds(10, 90, 70, 70);
		panel_4_1.add(btnXoaTrang);
		btnXoaTrang.setPreferredSize(new Dimension(140, 40));
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));

	}

}

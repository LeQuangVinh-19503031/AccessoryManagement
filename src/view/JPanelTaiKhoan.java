package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JPanelTaiKhoan extends JPanel {
	private JTextField textFieldTaiKhoan;
	private JTextField textFieldMatKhau;
	private JTextField textFieldTimKiem;
	private JTable table;
	private DefaultTableModel modelTable = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"T\u00C0I KHO\u1EA2N", "M\u1EACT KH\u1EA8U"
			}
		);
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	/**
	 * Create the panel.
	 */
	public JPanelTaiKhoan() {
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1285, 53);
		add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("TÀI KHOẢN");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setLayout(null);
		panelChucNang.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNang.setBackground(new Color(204, 255, 255));
		panelChucNang.setBounds(560, 323, 155, 392);
		add(panelChucNang);
		
		JButton btnThem = new JButton("THÊM");
		btnThem.setToolTipText("Thêm nhà cung cấp");
		btnThem.setBounds(10, 22, 134, 42);
		panelChucNang.add(btnThem);
		
		JButton btnCapNhat = new JButton("CẬP NHẬT");
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		btnCapNhat.setBounds(10, 74, 134, 42);
		panelChucNang.add(btnCapNhat);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.setBounds(10, 126, 134, 42);
		panelChucNang.add(btnXoa);
		
		JButton btnXoaTrang = new JButton("XÓA TRẮNG");
		btnXoaTrang.setBounds(10, 178, 134, 42);
		panelChucNang.add(btnXoaTrang);
		
		JPanel panelTable = new JPanel();
		panelTable.setLayout(null);
		panelTable.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH T\u00C0I KHO\u1EA2N", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBounds(10, 71, 540, 644);
		add(panelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(new Color(204, 255, 255));
		scrollPane.setBounds(10, 21, 520, 613);
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 NH\u00C2N VI\u00CAN", "T\u00CAN NH\u00C2N VI\u00CAN", "T\u00C0I KHO\u1EA2N", "M\u1EACT KH\u1EA8U"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(null);
		panelThongTin.setBorder(new TitledBorder(null, "TH\u00D4NG TIN NH\u00C0 CUNG C\u1EA4P", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTin.setBackground(new Color(204, 255, 255));
		panelThongTin.setBounds(725, 323, 539, 392);
		add(panelThongTin);
		
		JLabel lblNewLabel_2 = new JLabel("Tài khoản");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setAlignmentY(0.0f);
		lblNewLabel_2.setBounds(10, 213, 117, 32);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mật khẩu");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_1.setBounds(10, 295, 117, 32);
		panelThongTin.add(lblNewLabel_2_1);
		
		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setColumns(10);
		textFieldTaiKhoan.setAlignmentY(0.0f);
		textFieldTaiKhoan.setAlignmentX(0.0f);
		textFieldTaiKhoan.setBounds(137, 216, 364, 32);
		panelThongTin.add(textFieldTaiKhoan);
		
		textFieldMatKhau = new JTextField();
		textFieldMatKhau.setColumns(10);
		textFieldMatKhau.setAlignmentY(0.0f);
		textFieldMatKhau.setAlignmentX(0.0f);
		textFieldMatKhau.setBounds(137, 295, 364, 32);
		panelThongTin.add(textFieldMatKhau);
		
		JLabel lblMessTaiKhoan = new JLabel("");
		lblMessTaiKhoan.setBounds(137, 184, 364, 32);
		panelThongTin.add(lblMessTaiKhoan);
		lblMessTaiKhoan.setForeground(Color.RED);
		
		JLabel lblMessMatKhau = new JLabel("");
		lblMessMatKhau.setBounds(137, 264, 364, 32);
		panelThongTin.add(lblMessMatKhau);
		lblMessMatKhau.setForeground(Color.RED);
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setEditable(false);
		textFieldMaNV.setBounds(137, 50, 364, 32);
		panelThongTin.add(textFieldMaNV);
		textFieldMaNV.setColumns(10);
		
		textFieldTenNV = new JTextField();
		textFieldTenNV.setEditable(false);
		textFieldTenNV.setColumns(10);
		textFieldTenNV.setBounds(137, 126, 364, 32);
		panelThongTin.add(textFieldTenNV);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã nhân viên");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2.setBounds(10, 50, 117, 32);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Tên nhân viên");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setAlignmentY(0.0f);
		lblNewLabel_2_3.setBounds(10, 126, 117, 32);
		panelThongTin.add(lblNewLabel_2_3);
		
		JPanel panelChucNangNhanh = new JPanel();
		panelChucNangNhanh.setLayout(null);
		panelChucNangNhanh.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG NHANH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNangNhanh.setBackground(new Color(204, 255, 255));
		panelChucNangNhanh.setBounds(560, 227, 704, 86);
		add(panelChucNangNhanh);
		
		JLabel lblNewLabel_1 = new JLabel("TÌM KIẾM MÃ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 26, 118, 38);
		panelChucNangNhanh.add(lblNewLabel_1);
		
		textFieldTimKiem = new JTextField();
		textFieldTimKiem.setBounds(165, 28, 514, 35);
		panelChucNangNhanh.add(textFieldTimKiem);
		textFieldTimKiem.setColumns(10);

	}
}

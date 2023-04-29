package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public class JPanelNhanVien extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table;
	private DefaultTableModel modelTable = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3", "H\u1ECC V\u00C0 T\u00CAN", "M\u00C3 PH\u00D2NG BAN", "M\u00C3 QU\u1EA2N L\u00DD"
			}
		);
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField txtLQaungVinh;
	/**
	 * Create the panel.
	 */
	public JPanelNhanVien() {
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1285, 53);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHÂN VIÊN");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(0, 0, 1285, 53);
		lblNewLabel.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setIgnoreRepaint(true);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		panelTitle.add(lblNewLabel);
		
		JPanel panelTable = new JPanel();
		panelTable.setLayout(null);
		panelTable.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBounds(10, 63, 1265, 225);
		add(panelTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(new Color(204, 255, 255));
		scrollPane.setBounds(10, 22, 1245, 193);
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3", "H\u1ECC V\u00C0 T\u00CAN", "M\u00C3 PH\u00D2NG BAN", "M\u00C3 QU\u1EA2N L\u00DD", "NG\u00C0Y V\u00C0O L\u00C0M", "NG\u00C0Y SINH", "GI\u1EDAI T\u00CDNH", "\u0110\u1ECAA CH\u1EC8", "S\u0110T", "EMAIL", "CCCD/CMND"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panelThongTin = new JPanel();
		panelThongTin.setLayout(null);
		panelThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TH\u00D4NG TIN NH\u00C2N VI\u00CAN", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelThongTin.setBackground(new Color(204, 255, 255));
		panelThongTin.setBounds(199, 384, 1076, 313);
		add(panelThongTin);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setAlignmentY(0.0f);
		lblNewLabel_2.setBounds(10, 22, 109, 32);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ và tên");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_1.setBounds(356, 22, 100, 32);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã phòng ban");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2.setBounds(10, 94, 109, 32);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Địa chỉ");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1.setBounds(356, 238, 100, 32);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Mã quản lý");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2_2.setBounds(10, 166, 109, 32);
		panelThongTin.add(lblNewLabel_2_2_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setAlignmentY(0.0f);
		textField.setAlignmentX(0.0f);
		textField.setBounds(10, 54, 280, 32);
		panelThongTin.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setAlignmentY(0.0f);
		textField_1.setAlignmentX(0.0f);
		textField_1.setBounds(356, 54, 317, 32);
		panelThongTin.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setAlignmentY(0.0f);
		textField_2.setAlignmentX(0.0f);
		textField_2.setBounds(10, 125, 280, 32);
		panelThongTin.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setAlignmentY(0.0f);
		textField_3.setAlignmentX(0.0f);
		textField_3.setBounds(356, 269, 710, 32);
		panelThongTin.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setAlignmentY(0.0f);
		textField_4.setAlignmentX(0.0f);
		textField_4.setBounds(10, 197, 280, 32);
		panelThongTin.add(textField_4);
		
		JLabel lblMessDiaChi = new JLabel("");
		lblMessDiaChi.setForeground(Color.RED);
		lblMessDiaChi.setBounds(120, 166, 170, 32);
		panelThongTin.add(lblMessDiaChi);
		
		JLabel lblMessSdt = new JLabel("");
		lblMessSdt.setForeground(Color.RED);
		lblMessSdt.setBounds(466, 238, 207, 32);
		panelThongTin.add(lblMessSdt);
		
		JLabel lblMessEmail = new JLabel("");
		lblMessEmail.setForeground(Color.RED);
		lblMessEmail.setBounds(120, 94, 170, 32);
		panelThongTin.add(lblMessEmail);
		
		JLabel lblMessTen = new JLabel("");
		lblMessTen.setForeground(Color.RED);
		lblMessTen.setBounds(455, 22, 218, 32);
		panelThongTin.add(lblMessTen);
		
		JLabel lblMessMa = new JLabel("");
		lblMessMa.setForeground(Color.RED);
		lblMessMa.setBounds(120, 22, 170, 32);
		panelThongTin.add(lblMessMa);
		
		JLabel lblMessSdt_1 = new JLabel("");
		lblMessSdt_1.setForeground(Color.RED);
		lblMessSdt_1.setBounds(859, 94, 207, 32);
		panelThongTin.add(lblMessSdt_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_1_1.setBounds(749, 22, 100, 32);
		panelThongTin.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Giới tính");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1.setBounds(749, 94, 100, 32);
		panelThongTin.add(lblNewLabel_2_2_1_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setAlignmentY(0.0f);
		textField_6.setAlignmentX(0.0f);
		textField_6.setBounds(749, 125, 317, 32);
		panelThongTin.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setAlignmentY(0.0f);
		textField_7.setAlignmentX(0.0f);
		textField_7.setBounds(749, 54, 317, 32);
		panelThongTin.add(textField_7);
		
		JLabel lblMessTen_1 = new JLabel("");
		lblMessTen_1.setForeground(Color.RED);
		lblMessTen_1.setBounds(859, 22, 207, 32);
		panelThongTin.add(lblMessTen_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setAlignmentY(0.0f);
		textField_8.setAlignmentX(0.0f);
		textField_8.setBounds(10, 269, 280, 32);
		panelThongTin.add(textField_8);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Ngày vào làm");
		lblNewLabel_2_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_2_1.setBounds(10, 238, 109, 32);
		panelThongTin.add(lblNewLabel_2_2_2_1);
		
		JLabel lblMessDiaChi_1 = new JLabel("");
		lblMessDiaChi_1.setForeground(Color.RED);
		lblMessDiaChi_1.setBounds(120, 238, 170, 32);
		panelThongTin.add(lblMessDiaChi_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setAlignmentY(0.0f);
		textField_9.setAlignmentX(0.0f);
		textField_9.setBounds(356, 197, 317, 32);
		panelThongTin.add(textField_9);
		
		JLabel lblMessTen_2 = new JLabel("");
		lblMessTen_2.setForeground(Color.RED);
		lblMessTen_2.setBounds(466, 166, 207, 32);
		panelThongTin.add(lblMessTen_2);
		
		JLabel lblMessSdt_2 = new JLabel("");
		lblMessSdt_2.setForeground(Color.RED);
		lblMessSdt_2.setBounds(466, 94, 207, 32);
		panelThongTin.add(lblMessSdt_2);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setAlignmentY(0.0f);
		textField_10.setAlignmentX(0.0f);
		textField_10.setBounds(356, 125, 317, 32);
		panelThongTin.add(textField_10);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Email");
		lblNewLabel_2_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_2.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_2.setBounds(356, 94, 100, 32);
		panelThongTin.add(lblNewLabel_2_2_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setAlignmentY(0.0f);
		lblNewLabel_2_1_2.setBounds(356, 166, 100, 32);
		panelThongTin.add(lblNewLabel_2_1_2);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setAlignmentY(0.0f);
		textField_11.setAlignmentX(0.0f);
		textField_11.setBounds(749, 197, 317, 32);
		panelThongTin.add(textField_11);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("CCCD/CMND");
		lblNewLabel_2_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1_1.setBounds(749, 166, 100, 32);
		panelThongTin.add(lblNewLabel_2_2_1_1_1);
		
		JLabel lblMessSdt_1_1 = new JLabel("");
		lblMessSdt_1_1.setForeground(Color.RED);
		lblMessSdt_1_1.setBounds(859, 166, 207, 32);
		panelThongTin.add(lblMessSdt_1_1);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBounds(10, 384, 179, 313);
		add(panelChucNang);
		panelChucNang.setLayout(null);
		panelChucNang.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNang.setBackground(new Color(204, 255, 255));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setPreferredSize(new Dimension(120, 200));
		scrollPane_1.setMinimumSize(new Dimension(120, 200));
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setSize(new Dimension(120, 100));
		scrollPane_1.setMaximumSize(new Dimension(120, 200));
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(10, 20, 159, 283);
		panelChucNang.add(scrollPane_1);
		
		JPanel panel = new JPanel();
		panel.setAutoscrolls(true);
		panel.setFocusCycleRoot(true);
		panel.setFocusTraversalPolicyProvider(true);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setMaximumSize(new Dimension(0, 1200));
		panel.setMinimumSize(new Dimension(10, 500));
		panel.setPreferredSize(new Dimension(100, 500));
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.setBackground(new Color(204, 255, 255));
		scrollPane_1.setViewportView(panel);
		
		JButton btnThem = new JButton("THÊM ");
		btnThem.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnThem.setPreferredSize(new Dimension(140, 50));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 10, 10);
		fl_panel.setAlignOnBaseline(true);
		panel.setLayout(fl_panel);
		panel.add(btnThem);
		btnThem.setToolTipText("Thêm nhà cung cấp");
		
		JButton btnCapNhat = new JButton("CẬP NHẬT");
		btnCapNhat.setPreferredSize(new Dimension(140, 50));
		panel.add(btnCapNhat);
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		
		JButton btnXoaTrang = new JButton("XÓA TRẮNG");
		btnXoaTrang.setPreferredSize(new Dimension(140, 50));
		panel.add(btnXoaTrang);
		
		JButton btnXoa = new JButton("XÓA");
		btnXoa.setPreferredSize(new Dimension(140, 50));
		panel.add(btnXoa);
		
		JButton btnThayDoiTaiKhoanMatKhau = new JButton("XEM MẬT KHẨU");
		btnThayDoiTaiKhoanMatKhau.setPreferredSize(new Dimension(140, 50));
		panel.add(btnThayDoiTaiKhoanMatKhau);
		
		JPanel panelChucNangNhanh = new JPanel();
		panelChucNangNhanh.setBounds(10, 298, 1265, 76);
		add(panelChucNangNhanh);
		panelChucNangNhanh.setLayout(null);
		panelChucNangNhanh.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "L\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelChucNangNhanh.setBackground(new Color(204, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("MÃ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 26, 58, 32);
		panelChucNangNhanh.add(lblNewLabel_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(78, 27, 152, 32);
		panelChucNangNhanh.add(textField_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÊN");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(255, 26, 58, 32);
		panelChucNangNhanh.add(lblNewLabel_1_1);
		
		txtLQaungVinh = new JTextField();
		txtLQaungVinh.setColumns(10);
		txtLQaungVinh.setBounds(323, 27, 152, 32);
		panelChucNangNhanh.add(txtLQaungVinh);
		
		JLabel lblNewLabel_1_2 = new JLabel("MÃ QUẢN LÝ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(501, 26, 83, 32);
		panelChucNangNhanh.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("GIỚI TÍNH");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setBounds(988, 26, 83, 32);
		panelChucNangNhanh.add(lblNewLabel_1_3);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("NAM");
		rdbtnNewRadioButton.setBackground(new Color(204, 255, 255));
		rdbtnNewRadioButton.setBounds(1077, 26, 58, 32);
		panelChucNangNhanh.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnN = new JRadioButton("NỮ");
		rdbtnN.setBackground(new Color(204, 255, 255));
		rdbtnN.setBounds(1148, 26, 58, 32);
		panelChucNangNhanh.add(rdbtnN);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("MÃ PHÒNG BAN");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(746, 26, 83, 32);
		panelChucNangNhanh.add(lblNewLabel_1_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(594, 26, 114, 32);
		panelChucNangNhanh.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(839, 26, 114, 32);
		panelChucNangNhanh.add(comboBox_1);

	}
}

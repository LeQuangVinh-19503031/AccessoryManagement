package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
import javax.swing.text.Document;

import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import connectDB.ConnectDB;
import dao.DonHang_DAO;
import dao.NhanVien_DAO;
import dao.PhongBan_DAO;
import model.DonHang;
import model.NhanVien;
import model.PhongBan;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;

public class JPanelNhanVien extends JPanel implements DocumentListener, MouseListener{
	private JRadioButton buttonLocNam, buttonLocNu, buttonNam, buttonNu;
	private ButtonGroup groupLoc, groupInput;
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	private JTextField textFieldDCNV;
	private JTextField textField_LocMaNV;
	private JTable table;
	private DefaultTableModel modelTable =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 NH\u00C2N VI\u00CAN", "H\u1ECC V\u00C0 T\u00CAN", "PH\u00D2NG BAN", "QU\u1EA2N L\u00DD", "NG\u00C0Y V\u00C0O L\u00C0M", "NG\u00C0Y SINH", "GI\u1EDAI T\u00CDNH", "\u0110\u1ECAA CH\u1EC8", "SDT", "EMAIL", "CCCD", "T\u00C0I KHO\u1EA2N", "M\u1EACT KH\u1EA8U"
			}
		);
	private JTextField textFieldNamSinh;
	private JTextField textFieldNamVaoLam;
	private JTextField textFieldSDTNV;
	private JTextField textFieldEmailNV;
	private JTextField textFieldCCCD;
	private JTextField textFieldLocTenNV;
	private JLabel lblMessSDT, lblMessMaNV, lblMessMaQL, lblMessDiaChi, lblMessMaPB, lblMessTenNV, lblMessGT, lblMessNSNV, lblMessNgayVaoLam, lblMessCCCD;
	private ArrayList<NhanVien> model;
	
	private JLabel lblMessEmail;
	private ArrayList<String> listPB;
	private ArrayList<String> listQL;
	private JComboBox<String> comboBoxNgaySinh;
	private JComboBox<String> comboBoxThangSinh;
	private JComboBox<String> comboBoxThangVaoLam;
	private JComboBox<String> comboBoxNgayVaoLam;
	private JButton btnThem;
	private JButton btnCapNhat;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnThayDoiTaiKhoanMatKhau;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_chucnang;
	private JPanel panel;
	private JPanel panel_2;
	private JLabel lblNewLabel_4;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel_5;
	private JComboBox<String> ccbQL_Loc = new JComboBox<String>();
	private JComboBox<String> ccbPB_Loc = new JComboBox<String>();
	private JComboBox<String> ccbPB_Input = new JComboBox<String>();
	private JComboBox<String> ccbQL_Input = new JComboBox<String>();
	/**
	 * Create the panel.
	 */
	public JPanelNhanVien() {
		
		setBackground(new Color(64, 224, 208));
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
		panelTable.setBorder(null);
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBounds(10, 63, 1265, 225);
		add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(new Color(204, 255, 255));
		panelTable.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelTable);
		table.getColumnModel().getColumn(0).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setPreferredWidth(66);
		table.getColumnModel().getColumn(6).setPreferredWidth(58);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setPreferredWidth(63);
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panelTable.add(panel_1, BorderLayout.NORTH);
		
		lblNewLabel_3 = new JLabel("New label");
		panel_1.add(lblNewLabel_3);
		groupInput = new ButtonGroup();
		
		groupLoc = new ButtonGroup();
		
		table.addMouseListener(this);
		
		panel = new JPanel();
		panel.setBounds(10, 298, 263, 396);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 69, 0));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.NORTH);
		
		lblNewLabel_4 = new JLabel("CHỨC NĂNG");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_4);
		
		panel_chucnang = new JPanel();
		panel.add(panel_chucnang, BorderLayout.CENTER);
		panel_chucnang.setBorder(null);
		panel_chucnang.setBackground(new Color(192, 192, 192));
		panel_chucnang.setLayout(null);
		
		btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon(JPanelNhanVien.class.getResource("/img/add_36px.png")));
		btnThem.setBounds(10, 10, 60, 60);
		panel_chucnang.add(btnThem);
		btnThem.setBorder(new EmptyBorder(5, 5, 5, 5));
		btnThem.setPreferredSize(new Dimension(140, 50));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNhanVien();
			}
		});
		btnThem.setToolTipText("Thêm nhà cung cấp");
		
		btnXoaTrang = new JButton("");
		btnXoaTrang.setIcon(new ImageIcon(JPanelNhanVien.class.getResource("/img/erase_36px.png")));
		btnXoaTrang.setBounds(10, 90, 60, 60);
		panel_chucnang.add(btnXoaTrang);
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		btnXoaTrang.setPreferredSize(new Dimension(140, 50));
		
		btnCapNhat = new JButton("");
		btnCapNhat.setIcon(new ImageIcon(JPanelNhanVien.class.getResource("/img/update_36px.png")));
		btnCapNhat.setBounds(170, 10, 60, 60);
		panel_chucnang.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = table.getSelectedRow();
				if(n >= 0) {
					capnhatNV(n);
				}else {
					JOptionPane.showMessageDialog(null, "Chọn 1 hàng trước !");
				}
			}
		});
		btnCapNhat.setPreferredSize(new Dimension(140, 50));
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		
		btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(JPanelNhanVien.class.getResource("/img/minus_36px.png")));
		btnXoa.setBounds(90, 10, 60, 60);
		panel_chucnang.add(btnXoa);
		btnXoa.setPreferredSize(new Dimension(140, 50));
		
		btnThayDoiTaiKhoanMatKhau = new JButton("CẬP NHẬT MẬT KHẨU");
		btnThayDoiTaiKhoanMatKhau.setBounds(90, 90, 60, 60);
		panel_chucnang.add(btnThayDoiTaiKhoanMatKhau);
		btnThayDoiTaiKhoanMatKhau.setPreferredSize(new Dimension(140, 50));
		
		panel_5 = new JPanel();
		panel_5.setBounds(0, 160, 263, 210);
		panel_chucnang.add(panel_5);
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 0), new Color(128, 128, 128)), "L\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MÃ");
		lblNewLabel_1.setBounds(10, 8, 46, 32);
		panel_5.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField_LocMaNV = new JTextField();
		textField_LocMaNV.setBounds(78, 10, 175, 32);
		panel_5.add(textField_LocMaNV);
		textField_LocMaNV.setColumns(10);
		
		textFieldLocTenNV = new JTextField();
		textFieldLocTenNV.setBounds(78, 50, 175, 32);
		panel_5.add(textFieldLocTenNV);
		textFieldLocTenNV.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÊN");
		lblNewLabel_1_1.setBounds(10, 50, 46, 32);
		panel_5.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1_2 = new JLabel("MÃ QUẢN LÝ");
		lblNewLabel_1_2.setBounds(10, 90, 93, 32);
		panel_5.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("MÃ PHÒNG BAN");
		lblNewLabel_1_2_1.setBounds(10, 130, 93, 32);
		panel_5.add(lblNewLabel_1_2_1);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1_3 = new JLabel("GIỚI TÍNH");
		lblNewLabel_1_3.setBounds(10, 167, 93, 32);
		panel_5.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		
		buttonLocNam = new JRadioButton("NAM");
		buttonLocNam.setBounds(123, 168, 58, 32);
		panel_5.add(buttonLocNam);
		buttonLocNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonLocNam.setBackground(new Color(192, 192, 192));
		groupLoc.add(buttonLocNam);
		
		buttonLocNu = new JRadioButton("NỮ");
		buttonLocNu.setBounds(195, 167, 58, 32);
		panel_5.add(buttonLocNu);
		buttonLocNu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonLocNu.setBackground(new Color(192, 192, 192));
		groupLoc.add(buttonLocNu);
		
		ccbQL_Loc.setBounds(113, 92, 140, 30);
		panel_5.add(ccbQL_Loc);
		
		ccbPB_Loc.setBounds(113, 132, 140, 30);
		panel_5.add(ccbPB_Loc);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(283, 298, 992, 396);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_4.setBackground(new Color(255, 69, 0));
		panel_3.add(panel_4, BorderLayout.NORTH);
		
		lblNewLabel_5 = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblNewLabel_5);
		
		JPanel panelThongTin = new JPanel();
		panel_3.add(panelThongTin, BorderLayout.CENTER);
		panelThongTin.setLayout(null);
		panelThongTin.setBorder(null);
		panelThongTin.setBackground(new Color(192, 192, 192));
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhân viên");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setAlignmentY(0.0f);
		lblNewLabel_2.setBounds(11, 32, 109, 32);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ và tên");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_1.setBounds(11, 74, 81, 32);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã phòng ban");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2.setBounds(310, 32, 121, 32);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Địa chỉ");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1.setBounds(11, 295, 55, 32);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Mã quản lý");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2_2.setBounds(665, 35, 88, 32);
		panelThongTin.add(lblNewLabel_2_2_2);
		
		textFieldMaNV = new JTextField();
		textFieldMaNV.setColumns(10);
		textFieldMaNV.setAlignmentY(0.0f);
		textFieldMaNV.setAlignmentX(0.0f);
		textFieldMaNV.setBounds(120, 32, 170, 32);
		panelThongTin.add(textFieldMaNV);
		
		textFieldTenNV = new JTextField();
		textFieldTenNV.setColumns(10);
		textFieldTenNV.setAlignmentY(0.0f);
		textFieldTenNV.setAlignmentX(0.0f);
		textFieldTenNV.setBounds(11, 106, 280, 32);
		panelThongTin.add(textFieldTenNV);
		
		textFieldDCNV = new JTextField();
		textFieldDCNV.setColumns(10);
		textFieldDCNV.setAlignmentY(0.0f);
		textFieldDCNV.setAlignmentX(0.0f);
		textFieldDCNV.setBounds(11, 326, 600, 32);
		panelThongTin.add(textFieldDCNV);
		
		lblMessMaQL = new JLabel("");
		lblMessMaQL.setForeground(Color.RED);
		lblMessMaQL.setBounds(667, 3, 306, 32);
		panelThongTin.add(lblMessMaQL);
		
		lblMessDiaChi = new JLabel("");
		lblMessDiaChi.setForeground(Color.RED);
		lblMessDiaChi.setBounds(76, 295, 535, 32);
		panelThongTin.add(lblMessDiaChi);
		
		lblMessMaPB = new JLabel("");
		lblMessMaPB.setForeground(Color.RED);
		lblMessMaPB.setBounds(310, 0, 301, 32);
		panelThongTin.add(lblMessMaPB);
		
		lblMessTenNV = new JLabel("");
		lblMessTenNV.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblMessTenNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMessTenNV.setForeground(Color.RED);
		lblMessTenNV.setBounds(102, 74, 189, 32);
		panelThongTin.add(lblMessTenNV);
		
		lblMessMaNV = new JLabel("");
		lblMessMaNV.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMessMaNV.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblMessMaNV.setForeground(Color.RED);
		lblMessMaNV.setBounds(10, 0, 280, 32);
		panelThongTin.add(lblMessMaNV);
		
		lblMessGT = new JLabel("");
		lblMessGT.setForeground(Color.RED);
		lblMessGT.setBounds(675, 74, 308, 32);
		panelThongTin.add(lblMessGT);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_1_1.setBounds(11, 148, 81, 32);
		panelThongTin.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Giới tính");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1.setBounds(665, 106, 81, 32);
		panelThongTin.add(lblNewLabel_2_2_1_1);
		
		lblMessNSNV = new JLabel("");
		lblMessNSNV.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblMessNSNV.setForeground(Color.RED);
		lblMessNSNV.setBounds(102, 148, 189, 32);
		panelThongTin.add(lblMessNSNV);
		
		textFieldNamVaoLam = new JTextField();
		textFieldNamVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNamVaoLam.setMargin(new Insets(2, 5, 2, 5));
		textFieldNamVaoLam.setToolTipText("Năm");
		textFieldNamVaoLam.setColumns(10);
		textFieldNamVaoLam.setAlignmentY(0.0f);
		textFieldNamVaoLam.setAlignmentX(0.0f);
		textFieldNamVaoLam.setBounds(524, 179, 87, 32);
		panelThongTin.add(textFieldNamVaoLam);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Ngày vào làm");
		lblNewLabel_2_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_2_1.setBounds(307, 148, 109, 32);
		panelThongTin.add(lblNewLabel_2_2_2_1);
		
		lblMessNgayVaoLam = new JLabel("");
		lblMessNgayVaoLam.setForeground(Color.RED);
		lblMessNgayVaoLam.setBounds(417, 146, 194, 32);
		panelThongTin.add(lblMessNgayVaoLam);
		
		textFieldSDTNV = new JTextField();
		textFieldSDTNV.setColumns(10);
		textFieldSDTNV.setAlignmentY(0.0f);
		textFieldSDTNV.setAlignmentX(0.0f);
		textFieldSDTNV.setBounds(310, 253, 301, 32);
		panelThongTin.add(textFieldSDTNV);
		
		lblMessSDT = new JLabel("");
		lblMessSDT.setForeground(Color.RED);
		lblMessSDT.setBounds(420, 221, 191, 32);
		panelThongTin.add(lblMessSDT);
		
		lblMessEmail = new JLabel("");
		lblMessEmail.setForeground(Color.RED);
		lblMessEmail.setBounds(375, 74, 236, 32);
		panelThongTin.add(lblMessEmail);
		
		textFieldEmailNV = new JTextField();
		textFieldEmailNV.setColumns(10);
		textFieldEmailNV.setAlignmentY(0.0f);
		textFieldEmailNV.setAlignmentX(0.0f);
		textFieldEmailNV.setBounds(310, 105, 301, 32);
		panelThongTin.add(textFieldEmailNV);
		
		JLabel lblNewLabel_2_2_1_2 = new JLabel("Email");
		lblNewLabel_2_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_2.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_2.setBounds(310, 74, 55, 32);
		panelThongTin.add(lblNewLabel_2_2_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setAlignmentY(0.0f);
		lblNewLabel_2_1_2.setBounds(310, 221, 100, 32);
		panelThongTin.add(lblNewLabel_2_1_2);
		
		textFieldCCCD = new JTextField();
		textFieldCCCD.setColumns(10);
		textFieldCCCD.setAlignmentY(0.0f);
		textFieldCCCD.setAlignmentX(0.0f);
		textFieldCCCD.setBounds(11, 253, 280, 32);
		panelThongTin.add(textFieldCCCD);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("CCCD");
		lblNewLabel_2_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1_1.setBounds(11, 222, 48, 32);
		panelThongTin.add(lblNewLabel_2_2_1_1_1);
		
		lblMessCCCD = new JLabel("");
		lblMessCCCD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessCCCD.setForeground(Color.RED);
		lblMessCCCD.setBounds(63, 222, 228, 32);
		panelThongTin.add(lblMessCCCD);
		
		buttonNam = new JRadioButton("NAM"); 
		buttonNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonNam.setBackground(new Color(192, 192, 192));
		buttonNam.setBounds(796, 105, 81, 32);
		panelThongTin.add(buttonNam);
		
		buttonNu = new JRadioButton("NỮ");
		buttonNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonNu.setBackground(new Color(192, 192, 192));
		buttonNu.setBounds(909, 105, 63, 32);
		panelThongTin.add(buttonNu);
		groupInput.add(buttonNam);
		groupInput.add(buttonNu);
		
		comboBoxNgaySinh = new JComboBox<String>();
		comboBoxNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxNgaySinh.setModel(new DefaultComboBoxModel(new String[] {"Ngày", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxNgaySinh.setBounds(11, 180, 81, 32);
		panelThongTin.add(comboBoxNgaySinh);
		
		comboBoxThangSinh = new JComboBox<String>();
		comboBoxThangSinh.setModel(new DefaultComboBoxModel(new String[] {"Tháng", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxThangSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxThangSinh.setBounds(102, 181, 91, 32);
		panelThongTin.add(comboBoxThangSinh);
		
		textFieldNamSinh = new JTextField();
		textFieldNamSinh.setMargin(new Insets(2, 5, 2, 5));
		textFieldNamSinh.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNamSinh.setToolTipText("Năm");
		textFieldNamSinh.setBounds(203, 181, 88, 32);
		panelThongTin.add(textFieldNamSinh);
		textFieldNamSinh.setColumns(10);
		textFieldNamSinh.setAlignmentY(0.0f);
		textFieldNamSinh.setAlignmentX(0.0f);
		
		comboBoxThangVaoLam = new JComboBox<String>();
		comboBoxThangVaoLam.setModel(new DefaultComboBoxModel(new String[] {"Tháng", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboBoxThangVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxThangVaoLam.setBounds(408, 179, 97, 32);
		panelThongTin.add(comboBoxThangVaoLam);
		
		comboBoxNgayVaoLam = new JComboBox<String>();
		comboBoxNgayVaoLam.setModel(new DefaultComboBoxModel(new String[] {"Ngày", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBoxNgayVaoLam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxNgayVaoLam.setBounds(307, 178, 81, 33);
		panelThongTin.add(comboBoxNgayVaoLam);
		
		ccbPB_Input.setBounds(420, 32, 191, 32);
		panelThongTin.add(ccbPB_Input);
		
		ccbQL_Input.setBounds(763, 32, 191, 32);
		panelThongTin.add(ccbQL_Input);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(675, 179, 170, 130);
		panelThongTin.add(panel_6);
		textFieldNamSinh.getDocument().addDocumentListener(this);
		
		textFieldMaNV.getDocument().addDocumentListener(this);
		textFieldTenNV.getDocument().addDocumentListener(this);
		textFieldNamVaoLam.getDocument().addDocumentListener(this);
		textFieldCCCD.getDocument().addDocumentListener(this);
		textFieldDCNV.getDocument().addDocumentListener(this);
		textFieldEmailNV.getDocument().addDocumentListener(this);
		textFieldSDTNV.getDocument().addDocumentListener(this);
		
		allUpdateOfPanel();
		this.setVisible(true);
	}
	
	private void allUpdateOfPanel() {
		updateTable();
		updateComboboxPB();
		updateComboboxQL();
	}

	protected void capnhatNV(int n) {
		if(textFieldCCCD.isEnabled()) {
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
			LocalDateTime now = LocalDateTime.now();
			NhanVien a = new NhanVien();
			if(!textFieldMaNV.isEditable()) {	
				xoaTrang();
				jTextFieldEditable(true);
				this.textFieldMaNV.setEditable(true);
			}else {
				if(checkfieldHopLe()) {
					jTextFieldEditable(false);
					try {
						
						String ngayVaoLam = comboBoxNgayVaoLam.getSelectedItem()+"-"+comboBoxThangVaoLam.getSelectedItem()+"-"+textFieldNamVaoLam.getText();
						String ngaySinh = comboBoxNgaySinh.getSelectedItem()+"-"+comboBoxThangSinh.getSelectedItem()+"-"+textFieldNamSinh.getText();
						
						a.setMa(textFieldMaNV.getText().toUpperCase());
						a.setTen(textFieldTenNV.getText().toUpperCase());
						a.setMaPB(ccbPB_Input.getSelectedItem()+"".toUpperCase());
						a.setMaQL(ccbQL_Input.getSelectedItem()+"".toUpperCase());
						a.setNgayVaoLam(df.parse(ngayVaoLam));
						a.setNgaySinh(df.parse(ngaySinh));
						a.setLuongCB(Integer.parseInt(textFieldDCNV.getText()));
						a.setDienThoai(textFieldSDTNV.getText().toUpperCase());
						a.setEmail(textFieldEmailNV.getText());
						a.setCccd(textFieldCCCD.getText().toUpperCase());
						if(buttonNam.isSelected())
							a.setGioiTinh("NAM");
						else
							a.setGioiTinh("NỮ");
						a.setUser("");
						a.setPass("");

					} catch (Exception e) {
						a = null;
						e.printStackTrace();
					} finally {
						if(a!=null) {
							ConnectDB con = new ConnectDB();
							con.connect();
							boolean res = NhanVien_DAO.updateNV(a);
							con.disconect();
							if(res) {
								updateTable();
								xoaTrang();
								table.setRowSelectionInterval(n, n);
							}else {
								JOptionPane.showMessageDialog(null, "CẬP NHẬT THẤT BẠI");
							}
						}
					}
				}
			}
			
			btnThem.setEnabled(true);
			
		}else {
			disableField(true);
			this.textFieldMaNV.setEditable(false);
			btnThem.setEnabled(false);
		}
		
	}

	protected void themNhanVien() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		NhanVien a = new NhanVien();
		if(!textFieldMaNV.isEditable()) {	
			xoaTrang();
			jTextFieldEditable(true);
			this.textFieldMaNV.setEditable(true);
		}else {
			if(checkfieldHopLe()) {
				jTextFieldEditable(false);
				try {
					
					String ngayVaoLam = comboBoxNgayVaoLam.getSelectedItem()+"-"+comboBoxThangVaoLam.getSelectedItem()+"-"+textFieldNamVaoLam.getText();
					String ngaySinh = comboBoxNgaySinh.getSelectedItem()+"-"+comboBoxThangSinh.getSelectedItem()+"-"+textFieldNamSinh.getText();
					
					a.setMa(textFieldMaNV.getText().toUpperCase());
					a.setTen(textFieldTenNV.getText().toUpperCase());
					a.setMaPB(ccbPB_Input.getSelectedItem()+"".toUpperCase());
					a.setMaQL(ccbQL_Input.getSelectedItem()+"".toUpperCase());
					a.setNgayVaoLam(df.parse(ngayVaoLam));
					a.setNgaySinh(df.parse(ngaySinh));
					a.setLuongCB(Integer.parseInt(textFieldDCNV.getText()));
					a.setDienThoai(textFieldSDTNV.getText().toUpperCase());
					a.setEmail(textFieldEmailNV.getText());
					a.setCccd(textFieldCCCD.getText().toUpperCase());
					if(buttonNam.isSelected())
						a.setGioiTinh("NAM");
					else
						a.setGioiTinh("NỮ");
					a.setUser("");
					a.setPass("");

				} catch (Exception e) {
					a = null;
					e.printStackTrace();
				} finally {
					if(a!=null) {
						ConnectDB con = new ConnectDB();
						con.connect();
						boolean res = NhanVien_DAO.insertNV(a);
						con.disconect();
						if(res) {
							updateTable();
							xoaTrang();
							jTextFieldEditable(false);
							table.setRowSelectionInterval(2,2);
							this.setVisible(true);							
							
						}else {
							JOptionPane.showMessageDialog(null, "THÊM THẤT BẠI");
						}
					}
				}
			}
		}

		updateTable();
		
	}
	
	private boolean checkfieldHopLe() {
		if(textFieldMaNV.getText().length() > 2) {
			if(textFieldMaNV.getText().toUpperCase().matches("NV\\d+")) {
				lblMessMaNV.setText("");
			}else {
				lblMessMaNV.setText("Chưa đúng. VD: NV0123");
			}
		}else {
			lblMessMaNV.setText("Chưa đúng định dạng !");
			return false;
		}
		
		return true;
	}

	private void jTextFieldEditable(boolean choose) {
		textFieldMaNV.setEditable(choose);
		textFieldTenNV.setEditable(choose);
		ccbPB_Input.setEditable(choose);
		ccbQL_Input.setEditable(choose);
		textFieldNamVaoLam.setEditable(choose);
		textFieldNamSinh.setEditable(choose);
		textFieldDCNV.setEditable(choose);
		textFieldSDTNV.setEditable(choose);
		textFieldEmailNV.setEditable(choose);
		textFieldCCCD.setEditable(choose);
				
		buttonNam.setRequestFocusEnabled(choose);
		buttonNu.setRequestFocusEnabled(choose);
		
		comboBoxNgaySinh.setEditable(choose);
		comboBoxNgayVaoLam.setEditable(choose);
		comboBoxThangSinh.setEditable(choose);
		comboBoxThangVaoLam.setEditable(choose);
		
	}
	private void xoaTrang() {
		textField_LocMaNV.setText("");
		textFieldCCCD.setText("");
		textFieldDCNV.setText("");
		textFieldEmailNV.setText("");
		textFieldLocTenNV.setText("");
		textFieldMaNV.setText("");
		textFieldSDTNV.setText("");
		textFieldTenNV.setText("");
		
		groupInput.clearSelection();
		groupLoc.clearSelection();
		
		ccbPB_Input.setSelectedIndex(-1);
		ccbQL_Input.setSelectedIndex(-1);
		
		comboBoxNgaySinh.setSelectedIndex(0);
		comboBoxThangSinh.setSelectedIndex(0);
		textFieldNamSinh.setText("");
		
		comboBoxNgayVaoLam.setSelectedIndex(0);
		comboBoxThangVaoLam.setSelectedIndex(0);
		textFieldNamVaoLam.setText("");
		
	}
	private void updateTable() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		uploadFromDB();
		modelTable.setRowCount(0);
		for (NhanVien a : model) {
			
			modelTable.addRow(new Object[] {
					a.getMa(),
					a.getTen(),
					a.getMaPB(),
					a.getMaQL(),
					df.format(a.getNgayVaoLam()),
					df.format(a.getNgaySinh()),
					a.getGioiTinh(),
					a.getLuongCB(),
					a.getDienThoai(),
					a.getEmail(),
					a.getCccd(),
					a.getUser(),
					a.getPass()
			});
			
		}
		this.setVisible(true);
	}
	
	private void updateComboboxPB() {
		
		ccbPB_Input.removeAllItems();
		ccbPB_Loc.removeAllItems();
		for (String string : listPB) {
			ccbPB_Input.addItem(string);
			ccbPB_Loc.addItem(string);
		}
		ccbPB_Input.setSelectedIndex(-1);
		ccbPB_Loc.setSelectedIndex(-1);
	}
	
	private void updateComboboxQL() {
		
		ccbQL_Input.removeAllItems();
		ccbQL_Loc.removeAllItems();
		for (String string : listQL) {
			ccbQL_Input.addItem(string);
			ccbQL_Loc.addItem(string);
		}
		ccbQL_Input.setSelectedIndex(-1);
		ccbQL_Loc.setSelectedIndex(-1);
	}
	
	private void uploadFromDB() {
		ConnectDB c = new ConnectDB();
		c.connect();
		model = NhanVien_DAO.getAllFromDB();
		listPB = PhongBan_DAO.getAllIDDepartmentFromDB();
		listQL = NhanVien_DAO.getAllMaNVFromDB();
		c.disconect();
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		
//		textFieldNgayVaoLam.getDocument().addDocumentListener(this);
//		textFieldNSNV.getDocument().addDocumentListener(this);
//		textFieldCCCD.getDocument().addDocumentListener(this);
//		textFieldDCNV.getDocument().addDocumentListener(this);
//		textFieldEmailNV.getDocument().addDocumentListener(this);
//		textFieldSDTNV.getDocument().addDocumentListener(this);		
		
		Document src = e.getDocument();
		String maNV = textFieldMaNV.getText();
		String ten = textFieldTenNV.getText();
		String email = textFieldEmailNV.getText();
		String cccd = textFieldCCCD.getText();
		String diachi = textFieldDCNV.getText();
		String sdt = textFieldSDTNV.getText();
		
		if(textFieldCCCD.isEnabled()) {

			if(src.equals(textFieldMaNV.getDocument()))
				checkHopleMaNV(maNV);
			
			else if(src.equals(textFieldTenNV.getDocument()))
				checkHopLeTenNV(ten);
			else if(src.equals(textFieldEmailNV.getDocument())) {
				checkHopLeEmail(email);
			}else if(src.equals(textFieldCCCD.getDocument()))
				checkHopLeCCCD(cccd);
			else if(src.equals(textFieldDCNV.getDocument()))
				checkHopLeDC(diachi);
			else if(src.equals(textFieldSDTNV.getDocument()))
				checkHopLeSDT(sdt);
		}
		
	}

	private void checkHopLeSDT(String sdt) {
		if(sdt.length() > 5) 
			if(sdt.matches("[+]*\\d+") && (sdt.length()>8 && sdt.length()<15))
				lblMessSDT.setText("");
			else 
				lblMessSDT.setText("VD: 0123456234 !");
		else 
			lblMessSDT.setText("Chưa đúng định dạng !");
	}

	private void checkHopLeDC(String diachi) {
		if(diachi.length() > 2) 
			if(diachi.contains(" "))
				lblMessDiaChi.setText("");
			else 
				lblMessDiaChi.setText("VD: AN PHÚ !");
		else 
			lblMessDiaChi.setText("Chưa đúng định dạng !");
		
	}

	private void checkHopLeCCCD(String cccd) {
		if(cccd.length() > 4) 
			if(cccd.matches("\\d{7,15}"))
				lblMessCCCD.setText("");
			else 
				lblMessCCCD.setText("VD: 123123123 !");
		else 
			lblMessCCCD.setText("Chưa đúng định dạng !");
	}

	private void checkHopLeEmail(String email) {
		if(email.length() > 2) 
			if(email.matches("[a-zA-Z0-9]+@[a-zA-Z]+(.[a-zA-Z]+)+"))
				lblMessEmail.setText("");
			else 
				lblMessEmail.setText("Sai. VD: abc@gmail.com !");
		else 
			lblMessEmail.setText("Chưa đúng định dạng !");
	}

	private void checkHopLeTenNV(String ten) {
		if(ten.length() > 2) 
			if(ten.matches(".+( .+)+"))
				lblMessTenNV.setText("");
			else 
				lblMessTenNV.setText("Sai. VD: NGUYỄN VĂN A !");
		else 
			lblMessTenNV.setText("Chưa đúng định dạng !");
		
	}

	private void checkHopleMaNV(String maNV) {
		if(maNV.length() > 2) 
			if(!checkContainsNV(maNV))
				if(maNV.toUpperCase().matches("NV\\d+")) 
					lblMessMaNV.setText("");
				else 
					lblMessMaNV.setText("Sai. VD: NV0123");
			else 
				lblMessMaNV.setText("Đã tồn tại mã nhân viên "+maNV);
		else 
			lblMessMaNV.setText("Chưa đúng định dạng !");
		
	}

	private boolean checkContainsNV(String str) {
		for (NhanVien a : model) {
			if(a.getMa().equalsIgnoreCase(str))
				return true;
		}
		return false;
	}
	public void disableField(boolean choose) {
		textFieldMaNV.setEnabled(choose);
		ccbQL_Input.setEnabled(choose);
		ccbPB_Input.setEnabled(choose);
		textFieldTenNV.setEnabled(choose);
		textFieldCCCD.setEnabled(choose);
		textFieldEmailNV.setEnabled(choose);
		textFieldSDTNV.setEnabled(choose);
		textFieldDCNV.setEnabled(choose);
		
		comboBoxNgaySinh.setEnabled(choose);
		comboBoxThangSinh.setEnabled(choose);
		textFieldNamSinh.setEnabled(choose);
		
		comboBoxNgayVaoLam.setEnabled(choose);
		comboBoxThangVaoLam.setEnabled(choose);
		textFieldNamVaoLam.setEnabled(choose);
		
		buttonNam.setEnabled(choose);
		buttonNu.setEnabled(choose);
	}
	
	public NhanVien showTableToField() {
		disableField(false);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		NhanVien a = new NhanVien();
		int n = table.getSelectedRow();
		if(n >= 0)
				try {

					String ngayVaoLam = comboBoxNgayVaoLam.getSelectedItem()+"-"+comboBoxThangVaoLam.getSelectedItem()+"-"+textFieldNamVaoLam.getText();
					String ngaySinh = comboBoxNgaySinh.getSelectedItem()+"-"+comboBoxThangSinh.getSelectedItem()+"-"+textFieldNamSinh.getText();
					
					a.setMa(modelTable.getValueAt(n, 0)+"".toUpperCase());
					a.setTen(modelTable.getValueAt(n, 1)+"".toUpperCase());
					a.setMaPB(modelTable.getValueAt(n, 2)+"".toUpperCase());
					a.setMaQL(modelTable.getValueAt(n, 3)+"".toUpperCase());
					a.setNgayVaoLam(df.parse(modelTable.getValueAt(n, 4)+""));
					a.setNgaySinh(df.parse(modelTable.getValueAt(n, 5)+""));
					a.setLuongCB(Integer.parseInt(modelTable.getValueAt(n, 7)+""));
					a.setDienThoai(modelTable.getValueAt(n, 8)+"");
					a.setEmail(modelTable.getValueAt(n, 9)+"");
					a.setCccd(modelTable.getValueAt(n, 10)+"");
					a.setUser("");
					a.setPass("");
					if((modelTable.getValueAt(n, 6)+"").equalsIgnoreCase("NAM"))
						a.setGioiTinh("NAM");
					else
						a.setGioiTinh("NỮ");

				} catch (Exception e) {
					a = null;
					e.printStackTrace();
				}finally {
					if(a!=null) {
						textFieldMaNV.setText(a.getMa());
						textFieldTenNV.setText(a.getTen());
						ccbPB_Input.setSelectedItem(a.getMaPB());
						ccbQL_Input.setSelectedItem(a.getMaQL());
						textFieldEmailNV.setText(a.getEmail());
						textFieldCCCD.setText(a.getCccd());

						String ns = df.format(a.getNgaySinh());
						System.out.println(ns.substring(0, 2));
						comboBoxNgaySinh.setSelectedItem(ns.substring(0, 2));
						comboBoxThangSinh.setSelectedItem(ns.substring(3, 5));
						textFieldNamSinh.setText(ns.substring(6, ns.length()));
						
						String nvl = df.format(a.getNgayVaoLam());
						System.out.println(nvl);
						comboBoxNgayVaoLam.setSelectedItem(nvl.substring(0, 2));
						comboBoxThangVaoLam.setSelectedItem(nvl.substring(3, 5));
						textFieldNamVaoLam.setText(nvl.substring(6, nvl.length()));

						textFieldDCNV.setText(a.getLuongCB()+"");
						textFieldSDTNV.setText(a.getDienThoai());
						if(a.getGioiTinh().equalsIgnoreCase("nam")) {
							buttonNam.setSelected(true);						
						}
						else {
							buttonNu.setSelected(true);							
						}
						
						
						this.setVisible(true);
					}
				}
		else
			JOptionPane.showMessageDialog(null, "Vui long chọn 1 hàng !");
		
		return a;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if(src.equals(table)) {
			showTableToField();
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

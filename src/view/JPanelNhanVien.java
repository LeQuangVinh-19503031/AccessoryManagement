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
import model.TaiKhoan;

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

public class JPanelNhanVien extends JPanel implements DocumentListener, MouseListener, ActionListener{
	private JRadioButton buttonLocNam, buttonLocNu, buttonNam, buttonNu;
	private ButtonGroup groupLoc, groupInput;
	private JTextField textFieldMaNV;
	private JTextField textFieldTenNV;
	private JTextField textFieldLuong;
	private JTextField textField_LocMaNV;
	private JTable table;
	private DefaultTableModel modelTable =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 NH\u00C2N VI\u00CAN", "H\u1ECC V\u00C0 T\u00CAN", "PH\u00D2NG BAN", "QU\u1EA2N L\u00DD", "NG\u00C0Y V\u00C0O L\u00C0M", "NG\u00C0Y SINH", "GI\u1EDAI T\u00CDNH", "L\u01AF\u01A0NG", "SDT", "EMAIL", "CCCD", "T\u00C0I KHO\u1EA2N", "M\u1EACT KH\u1EA8U"
			}
		);
	private JTextField textFieldNamSinh;
	private JTextField textFieldNamVaoLam;
	private JTextField textFieldSDTNV;
	private JTextField textFieldEmailNV;
	private JTextField textFieldCCCD;
	private JTextField textFieldLocTenNV;
	private JLabel lblMessSDT, lblMessMaNV, lblMessMaQL, lblMessLuong, lblMessMaPB, lblMessTenNV, lblMessGT, lblMessNSNV, lblMessNgayVaoLam, lblMessCCCD;
	private ArrayList<NhanVien> model;
	private ArrayList<NhanVien> listFilter = new ArrayList<NhanVien>();
	
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
	private JTextField textFieldTaiKhoan;
	private JTextField textFieldMatKhau;
	private JLabel lblMessTaiKhoan;
	private JLabel lblMatKhau;
	private JRadioButton btnHuyGT;
	private TaiKhoan tk;
	/**
	 * Create the panel.
	 */
	public JPanelNhanVien(TaiKhoan a) {
		this.tk = a;
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(10, 0, 1261, 53);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NHÂN VIÊN");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(0, 0, 1261, 53);
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
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setPreferredWidth(66);
		table.getColumnModel().getColumn(7).setPreferredWidth(58);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setPreferredWidth(63);
		scrollPane.setViewportView(table);
		
		panel_1 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_1.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_1.setBackground(new Color(255, 69, 0));
		panelTable.add(panel_1, BorderLayout.NORTH);
		
		lblNewLabel_3 = new JLabel("DANH SÁCH NHÂN VIÊN");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblNewLabel_3);
		groupInput = new ButtonGroup();
		
		groupLoc = new ButtonGroup();
		
		table.addMouseListener(this);
		
		panel = new JPanel();
		panel.setBounds(10, 298, 263, 385);
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
		btnXoaTrang.setBounds(10, 80, 60, 60);
		panel_chucnang.add(btnXoaTrang);
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
				jTextFieldEnable(true);
			}

		});
		btnXoaTrang.setPreferredSize(new Dimension(140, 50));
		
		btnCapNhat = new JButton("");
		btnCapNhat.setIcon(new ImageIcon(JPanelNhanVien.class.getResource("/img/update_36px.png")));
		btnCapNhat.setBounds(80, 80, 60, 60);
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
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()>0)
					xoa(table.getSelectedRow());
				else
					JOptionPane.showMessageDialog(null, e);
			}
		});
		btnXoa.setIcon(new ImageIcon(JPanelNhanVien.class.getResource("/img/minus_36px.png")));
		btnXoa.setBounds(80, 10, 60, 60);
		panel_chucnang.add(btnXoa);
		btnXoa.setPreferredSize(new Dimension(140, 50));
		
		panel_5 = new JPanel();
		panel_5.setBounds(0, 150, 263, 200);
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
		textField_LocMaNV.getDocument().addDocumentListener(this);
		
		textFieldLocTenNV = new JTextField();
		textFieldLocTenNV.setBounds(78, 50, 175, 32);
		panel_5.add(textFieldLocTenNV);
		textFieldLocTenNV.setColumns(10);
		textFieldLocTenNV.getDocument().addDocumentListener(this);
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
		buttonLocNam.setBounds(78, 168, 58, 26);
		panel_5.add(buttonLocNam);
		buttonLocNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonLocNam.setBackground(new Color(192, 192, 192));
		groupLoc.add(buttonLocNam);
		
		buttonLocNu = new JRadioButton("NỮ");
		buttonLocNu.setBounds(138, 167, 58, 27);
		panel_5.add(buttonLocNu);
		buttonLocNu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		buttonLocNu.setBackground(new Color(192, 192, 192));
		groupLoc.add(buttonLocNu);
		
		ccbQL_Loc.setBounds(113, 92, 140, 30);
		panel_5.add(ccbQL_Loc);
		
		ccbPB_Loc.setBounds(113, 132, 140, 30);
		panel_5.add(ccbPB_Loc);
		
		btnHuyGT = new JRadioButton("HỦY");
		btnHuyGT.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnHuyGT.setBackground(Color.LIGHT_GRAY);
		btnHuyGT.setBounds(198, 167, 55, 27);
		panel_5.add(btnHuyGT);
		groupLoc.add(btnHuyGT);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(283, 298, 992, 385);
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
		lblNewLabel_2.setBounds(21, 32, 100, 32);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Họ và tên");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_1.setBounds(21, 74, 81, 32);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã phòng ban");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2.setBounds(320, 32, 109, 32);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Lương");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1.setBounds(677, 148, 55, 32);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Mã quản lý");
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setAlignmentY(0.0f);
		lblNewLabel_2_2_2.setBounds(677, 32, 88, 32);
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
		
		textFieldLuong = new JTextField();
		textFieldLuong.setColumns(10);
		textFieldLuong.setAlignmentY(0.0f);
		textFieldLuong.setAlignmentX(0.0f);
		textFieldLuong.setBounds(665, 179, 289, 32);
		panelThongTin.add(textFieldLuong);
		
		lblMessMaQL = new JLabel("");
		lblMessMaQL.setForeground(Color.RED);
		lblMessMaQL.setBounds(667, 0, 306, 32);
		panelThongTin.add(lblMessMaQL);
		
		lblMessLuong = new JLabel("");
		lblMessLuong.setForeground(Color.RED);
		lblMessLuong.setBounds(730, 148, 224, 32);
		panelThongTin.add(lblMessLuong);
		
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
		lblMessGT.setBounds(752, 74, 231, 32);
		panelThongTin.add(lblMessGT);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Ngày sinh");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_1_1.setBounds(21, 148, 81, 32);
		panelThongTin.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Giới tính");
		lblNewLabel_2_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1_1.setAlignmentY(0.0f);
		lblNewLabel_2_2_1_1.setBounds(677, 74, 71, 32);
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
		lblNewLabel_2_2_2_1.setBounds(320, 148, 109, 32);
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
		lblNewLabel_2_2_1_2.setBounds(320, 74, 48, 32);
		panelThongTin.add(lblNewLabel_2_2_1_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Số điện thoại");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1_2.setAlignmentY(0.0f);
		lblNewLabel_2_1_2.setBounds(319, 221, 100, 32);
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
		lblNewLabel_2_2_1_1_1.setBounds(21, 221, 48, 32);
		panelThongTin.add(lblNewLabel_2_2_1_1_1);
		
		lblMessCCCD = new JLabel("");
		lblMessCCCD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessCCCD.setForeground(Color.RED);
		lblMessCCCD.setBounds(67, 222, 224, 32);
		panelThongTin.add(lblMessCCCD);
		
		buttonNam = new JRadioButton("NAM"); 
		buttonNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonNam.setBackground(new Color(192, 192, 192));
		buttonNam.setBounds(752, 106, 81, 32);
		panelThongTin.add(buttonNam);
		
		buttonNu = new JRadioButton("NỮ");
		buttonNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		buttonNu.setBackground(new Color(192, 192, 192));
		buttonNu.setBounds(853, 104, 63, 32);
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
		
		ccbPB_Input.setBounds(428, 32, 183, 32);
		panelThongTin.add(ccbPB_Input);
		
		ccbQL_Input.setBounds(763, 29, 191, 32);
		panelThongTin.add(ccbQL_Input);
		
		JLabel lblNewLabel_6 = new JLabel("Tài khoản");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(677, 230, 78, 23);
		panelThongTin.add(lblNewLabel_6);
		
		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setBounds(665, 253, 289, 32);
		panelThongTin.add(textFieldTaiKhoan);
		textFieldTaiKhoan.setColumns(10);
		
		lblMessTaiKhoan = new JLabel("");
		lblMessTaiKhoan.setForeground(new Color(255, 0, 0));
		lblMessTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessTaiKhoan.setBounds(753, 230, 201, 23);
		panelThongTin.add(lblMessTaiKhoan);
		
		JLabel lblNewLabel_6_1 = new JLabel("Mật khẩu");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(677, 295, 78, 23);
		panelThongTin.add(lblNewLabel_6_1);
		
		lblMatKhau = new JLabel("");
		lblMatKhau.setForeground(Color.RED);
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMatKhau.setBounds(753, 295, 201, 23);
		panelThongTin.add(lblMatKhau);
		
		textFieldMatKhau = new JTextField();
		textFieldMatKhau.setColumns(10);
		textFieldMatKhau.setBounds(665, 318, 289, 32);
		panelThongTin.add(textFieldMatKhau);
		textFieldNamSinh.getDocument().addDocumentListener(this);
		
		textFieldMaNV.getDocument().addDocumentListener(this);
		textFieldTenNV.getDocument().addDocumentListener(this);
		textFieldCCCD.getDocument().addDocumentListener(this);
		textFieldLuong.getDocument().addDocumentListener(this);
		textFieldEmailNV.getDocument().addDocumentListener(this);
		textFieldSDTNV.getDocument().addDocumentListener(this);
		textFieldMatKhau.getDocument().addDocumentListener(this);
		textFieldTaiKhoan.getDocument().addDocumentListener(this);
		textFieldNamVaoLam.getDocument().addDocumentListener(this);
		textFieldNamSinh.getDocument().addDocumentListener(this);
		
		allUpdateOfPanel();

		ccbQL_Loc.addActionListener(this);
		ccbPB_Loc.addActionListener(this);
		textField_LocMaNV.getDocument().addDocumentListener(this);
		textFieldLocTenNV.getDocument().addDocumentListener(this);
		btnHuyGT.addMouseListener(this);
		buttonLocNam.addMouseListener(this);
		buttonLocNu.addMouseListener(this);
		
		if(searchTK(a.getUser()).getMaPB().equalsIgnoreCase("NSU")) {
			btnCapNhat.setEnabled(true);
			btnThem.setEnabled(true);
			btnXoa.setEnabled(true);
			btnXoaTrang.setEnabled(true);
		}else {
			btnCapNhat.setEnabled(false);
			btnThem.setEnabled(false);
			btnXoa.setEnabled(false);
			btnXoaTrang.setEnabled(false);
		}

		this.setVisible(true);
		
	}
	
	protected void xoa(int n) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		NhanVien a = new NhanVien();	
		try {
			
			String ngayVaoLam = comboBoxNgayVaoLam.getSelectedItem()+"-"+comboBoxThangVaoLam.getSelectedItem()+"-"+textFieldNamVaoLam.getText();
			String ngaySinh = comboBoxNgaySinh.getSelectedItem()+"-"+comboBoxThangSinh.getSelectedItem()+"-"+textFieldNamSinh.getText();
			a.setMa(textFieldMaNV.getText().toUpperCase());
			a.setTen(textFieldTenNV.getText().toUpperCase());
			a.setMaPB(ccbPB_Input.getSelectedItem()+"".toUpperCase());
			a.setMaQL(ccbQL_Input.getSelectedItem()+"".toUpperCase());
			a.setNgayVaoLam(df.parse(ngayVaoLam));
			a.setNgaySinh(df.parse(ngaySinh));
			a.setLuongCB(Integer.parseInt(textFieldLuong.getText()));
			a.setDienThoai(textFieldSDTNV.getText().toUpperCase());
			a.setEmail(textFieldEmailNV.getText());
			a.setCccd(textFieldCCCD.getText().toUpperCase());
			a.setUser(textFieldTaiKhoan.getText());
			a.setPass(textFieldMatKhau.getText());
			if(buttonNam.isSelected())
				a.setGioiTinh("NAM");
			else
				a.setGioiTinh("NỮ");
			
		} catch (Exception e) {
			a = null;
			e.printStackTrace();
		} finally {
			int choose = JOptionPane.showConfirmDialog(null, "Xóa nhân viên "+a.getMa(), "Xóa", JOptionPane.YES_NO_OPTION);
			if(choose == JOptionPane.YES_OPTION) {
				if(a!=null) {
					ConnectDB con = new ConnectDB();
					con.connect();
					boolean res = NhanVien_DAO.removeNV(a);
					con.disconect();
					if(res) {
						updateTable();
						xoaTrang();
					}else {
						JOptionPane.showMessageDialog(null, "XÓA THẤT BẠI !");
					}
				}
			}
		}
		
	}

	private void allUpdateOfPanel() {
		updateTable();
		updateComboboxPB();
		updateComboboxQL();
	}

	protected void capnhatNV(int n) {
			
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
			LocalDateTime now = LocalDateTime.now();
			NhanVien a = new NhanVien();
			if(!textFieldCCCD.isEnabled()) {	
				jTextFieldEnable(true);
				this.textFieldMaNV.setEnabled(false);
			}else {
				if(checkfieldHopLe()) 
					try {
					
						String ngayVaoLam = comboBoxNgayVaoLam.getSelectedItem()+"-"+comboBoxThangVaoLam.getSelectedItem()+"-"+textFieldNamVaoLam.getText();
						String ngaySinh = comboBoxNgaySinh.getSelectedItem()+"-"+comboBoxThangSinh.getSelectedItem()+"-"+textFieldNamSinh.getText();
						a.setMa(textFieldMaNV.getText().toUpperCase());
						a.setTen(textFieldTenNV.getText().toUpperCase());
						a.setMaPB(ccbPB_Input.getSelectedItem()+"".toUpperCase());
						a.setMaQL(ccbQL_Input.getSelectedItem()+"".toUpperCase());
						a.setNgayVaoLam(df.parse(ngayVaoLam));
						a.setNgaySinh(df.parse(ngaySinh));
						a.setLuongCB(Integer.parseInt(textFieldLuong.getText()));
						a.setDienThoai(textFieldSDTNV.getText().toUpperCase());
						a.setEmail(textFieldEmailNV.getText());
						a.setCccd(textFieldCCCD.getText().toUpperCase());
						a.setUser(textFieldTaiKhoan.getText());
						a.setPass(textFieldMatKhau.getText());
						if(buttonNam.isSelected())
							a.setGioiTinh("NAM");
						else
							a.setGioiTinh("NỮ");

					} catch (Exception e) {
						a = null;
						e.printStackTrace();
					} finally {
						int choose = JOptionPane.showConfirmDialog(null, "Cập nhật nhân viên "+a.getMa(), "Cập nhật", JOptionPane.YES_NO_OPTION);
						if(choose == JOptionPane.YES_OPTION) {
							if(a!=null) {
								ConnectDB con = new ConnectDB();
								con.connect();
								boolean res = NhanVien_DAO.updateNV(a);
								con.disconect();
								if(res) {
									updateTable();
									xoaTrang();
									table.setRowSelectionInterval(n, n);
									if(searchTK(tk.getUser()).equals(searchNV(a.getMa()))) {
										JOptionPane.showMessageDialog(null, "Bạn cần đăng nhập lại !", "Đăng nhập lại", JOptionPane.CANCEL_OPTION);
									}
								}else {
									JOptionPane.showMessageDialog(null, "CẬP NHẬT THẤT BẠI");
								}
						}
						jTextFieldEnable(false);
						this.textFieldMaNV.setEnabled(true);
					}
				}
		}
	}

	protected void themNhanVien() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		NhanVien a = new NhanVien();
		if(!textFieldMaNV.isEnabled()) {	
			xoaTrang();
			jTextFieldEnable(true);
			this.textFieldMaNV.setEditable(true);
		}else {
			if(checkfieldHopLe()) {
				jTextFieldEnable(false);
				try {
					
					String ngayVaoLam = comboBoxNgayVaoLam.getSelectedItem()+"-"+comboBoxThangVaoLam.getSelectedItem()+"-"+textFieldNamVaoLam.getText();
					String ngaySinh = comboBoxNgaySinh.getSelectedItem()+"-"+comboBoxThangSinh.getSelectedItem()+"-"+textFieldNamSinh.getText();
					
					a.setMa(textFieldMaNV.getText().toUpperCase());
					a.setTen(textFieldTenNV.getText().toUpperCase());
					a.setMaPB(ccbPB_Input.getSelectedItem()+"".toUpperCase());
					a.setMaQL(ccbQL_Input.getSelectedItem()+"".toUpperCase());
					a.setNgayVaoLam(df.parse(ngayVaoLam));
					a.setNgaySinh(df.parse(ngaySinh));
					a.setLuongCB(Integer.parseInt(textFieldLuong.getText()));
					a.setDienThoai(textFieldSDTNV.getText().toUpperCase());
					a.setEmail(textFieldEmailNV.getText());
					a.setCccd(textFieldCCCD.getText().toUpperCase());
					a.setUser(textFieldTaiKhoan.getText());
					a.setPass(textFieldMatKhau.getText());
					
					if(buttonNam.isSelected())
						a.setGioiTinh("NAM");
					else
						a.setGioiTinh("NỮ");

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
							jTextFieldEnable(false);
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

	private void jTextFieldEnable(boolean choose) {
		textFieldMaNV.setEnabled(choose);
		textFieldTenNV.setEnabled(choose);
		ccbPB_Input.setEnabled(choose);
		ccbQL_Input.setEnabled(choose);
		textFieldNamVaoLam.setEnabled(choose);
		textFieldNamSinh.setEnabled(choose);
		textFieldLuong.setEnabled(choose);
		textFieldSDTNV.setEnabled(choose);
		textFieldEmailNV.setEnabled(choose);
		textFieldCCCD.setEnabled(choose);
		textFieldMatKhau.setEnabled(choose);
		textFieldTaiKhoan.setEnabled(choose);
		buttonNam.setEnabled(choose);
		buttonNu.setEnabled(choose);
		
		comboBoxNgaySinh.setEnabled(choose);
		comboBoxThangSinh.setEnabled(choose);
		textFieldNamSinh.setEnabled(choose);
		
		comboBoxNgayVaoLam.setEnabled(choose);
		comboBoxThangVaoLam.setEnabled(choose);
		textFieldNamVaoLam.setEnabled(choose);
	}
	private void xoaTrang() {
		textField_LocMaNV.setText("");
		textFieldCCCD.setText("");
		textFieldLuong.setText("");
		textFieldEmailNV.setText("");
		textFieldLocTenNV.setText("");
		textFieldMaNV.setText("");
		textFieldSDTNV.setText("");
		textFieldTenNV.setText("");
		textFieldTaiKhoan.setText("");
		textFieldMatKhau.setText("");
		comboBoxNgaySinh.setSelectedIndex(0);
		comboBoxThangSinh.setSelectedIndex(0);
		comboBoxNgayVaoLam.setSelectedIndex(0);
		comboBoxThangVaoLam.setSelectedIndex(0);
		ccbPB_Input.setSelectedIndex(-1);
		ccbQL_Input.setSelectedIndex(-1);
		textFieldNamSinh.setText("");
		textFieldNamVaoLam.setText("");
		groupInput.clearSelection();
		groupLoc.clearSelection();
		
		lblMessTaiKhoan.setText("");
		lblMatKhau.setText("");
		lblMessCCCD.setText("");
		lblMessLuong.setText("");
		lblMessEmail.setText("");
		lblMessGT.setText("");
		lblMessMaNV.setText("");
		lblMessMaPB.setText("");
		lblMessMaQL.setText("");
		lblMessNgayVaoLam.setText("");
		lblMessNSNV.setText("");
		lblMessSDT.setText("");
		lblMessTenNV.setText("");

	}
	
	private void updateTable() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		uploadFromDB();
		modelTable.setRowCount(0);
		for (NhanVien a : model) {
			
			modelTable.addRow(new Object[] {
					a.getMa().toUpperCase(),
					a.getTen().toUpperCase(),
					a.getMaPB().toUpperCase(),
					a.getMaQL().toUpperCase(),
					df.format(a.getNgayVaoLam()),
					df.format(a.getNgaySinh()),
					a.getGioiTinh().toUpperCase(),
					a.getLuongCB()+"",
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
		ccbPB_Loc.addItem("");
		ccbQL_Loc.addItem("");
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
		listFilter = model;
		c.disconect();
		
	}

	@Override
	public void insertUpdate(DocumentEvent e) {	
		
		Document src = e.getDocument();
		String maNV = textFieldMaNV.getText();
		String ten = textFieldTenNV.getText();
		String email = textFieldEmailNV.getText();
		String cccd = textFieldCCCD.getText();
		String diachi = textFieldLuong.getText();
		String sdt = textFieldSDTNV.getText();
		String tk = textFieldTaiKhoan.getText();
		String mk = textFieldMatKhau.getText();
		String namVaoLam = textFieldNamVaoLam.getText();
		String ns = textFieldNamSinh.getText();
		
		
		if(textFieldCCCD.isEnabled()) {

			if(src.equals(textFieldMaNV.getDocument()))
				if(maNV.length()>0)
					checkHopleMaNV(maNV);
				else
					lblMessMaNV.setText("");
			else if(src.equals(textFieldTenNV.getDocument()))
				checkHopLeTenNV(ten);
			else if(src.equals(textFieldEmailNV.getDocument())) {
				checkHopLeEmail(email);
			}else if(src.equals(textFieldCCCD.getDocument()))
				checkHopLeCCCD(cccd);
			else if(src.equals(textFieldLuong.getDocument()))
				checkHopLeLuong(diachi);
			else if(src.equals(textFieldSDTNV.getDocument()))
				checkHopLeSDT(sdt);
			else if(src.equals(textFieldTaiKhoan.getDocument()))
				checkHopLeTaiKhoan(tk);
			else if(src.equals(textFieldMatKhau.getDocument())) {
				checkHopLeMatKhau(mk);
			}else if(src.equals(textFieldNamVaoLam.getDocument())) {
				String ngaysinh = comboBoxNgaySinh.getSelectedItem()+"";
				String thangSinh = comboBoxThangSinh.getSelectedItem()+"";
				checkNamVaoLamHopLe(ngaysinh,thangSinh,namVaoLam);
			}else if(src.equals(textFieldNamSinh.getDocument())) {				
				String ngay = comboBoxNgayVaoLam.getSelectedItem()+"";
				String thang = comboBoxThangVaoLam.getSelectedItem()+"";
				checkNamSinhHopLe(ngay, thang, ns);
			}
		}
		
		if(src.equals(textField_LocMaNV.getDocument())) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getMa().toUpperCase().contains(textField_LocMaNV.getText())) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
			if(textField_LocMaNV.getText().equals(""))
				updateTable();
		}else if(src.equals(textFieldLocTenNV.getDocument())) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getTen().toUpperCase().contains(textFieldLocTenNV.getText().toUpperCase())) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
			if(textFieldLocTenNV.getText().equals(""))
				updateTable();
		}
		
	}

	private void checkNamSinhHopLe(String ngay, String thang, String nam) {
		if(nam.matches("[0-9]{4}")) {
			int n = Integer.parseInt(nam);
			if(n>= 1950 && n <= 2023) {
				lblMessNSNV.setText("");
			}else
				lblMessNSNV.setText("Sai mốc thời gian !");
		}else
			lblMessNSNV.setText("Là dãy từ 0-9 !");
		
	}

	private void checkNamVaoLamHopLe(String ngay, String thang, String namVaoLam) {
		if(namVaoLam.matches("[0-9]{4}")) {
			int n = Integer.parseInt(namVaoLam);
			if(n>= 1950 && n <= 2023) {
				lblMessNgayVaoLam.setText("");
			}else
				lblMessNgayVaoLam.setText("Sai mốc thời gian !");
		}else
			lblMessNgayVaoLam.setText("Là 1 năm gồm 4 chữ số !");
	}

	private void checkHopLeMatKhau(String mk) {
		if(mk.length()<4)
			lblMessTaiKhoan.setText("Độ dài quá nhỏ !");
		else {
			if(mk.matches("[A-Za-z0-9]+"))
				lblMessTaiKhoan.setText("");
			else
				lblMessTaiKhoan.setText("Có thể chứa chữ hoa, thường và số !");
		}
	}

	private void checkHopLeTaiKhoan(String tk) {
		if(tk.length()<4)
			lblMessTaiKhoan.setText("Độ dài quá nhỏ !");
		else {
			if(tk.matches("[A-Za-z0-9]+"))
				lblMessTaiKhoan.setText("");
			else
				lblMessTaiKhoan.setText("Có thể chứa chữ hoa, thường và số !");
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

	private void checkHopLeLuong(String luong) {
		if(luong.matches("\\d+")) 
			if(Integer.parseInt(luong) < 1000000)
				lblMessLuong.setText("Lương quá nhỏ !");
			else
				lblMessLuong.setText("");
		else 
			lblMessLuong.setText("Chưa đúng định dạng !");
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
	
	public NhanVien showTableToField() {
		xoaTrang();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		NhanVien a = new NhanVien();
		int n = table.getSelectedRow();
		if(n >= 0)
				try {
					jTextFieldEnable(false);
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
					a.setUser(modelTable.getValueAt(n, 11)+"");
					a.setPass(modelTable.getValueAt(n, 12)+"");
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
						comboBoxNgaySinh.setSelectedItem(ns.substring(0, 2));
						comboBoxThangSinh.setSelectedItem(ns.substring(3, 5));
						textFieldNamSinh.setText(ns.substring(6, ns.length()));
						
						String nvl = df.format(a.getNgayVaoLam());
						comboBoxNgayVaoLam.setSelectedItem(nvl.substring(0, 2));
						comboBoxThangVaoLam.setSelectedItem(nvl.substring(3, 5));
						textFieldNamVaoLam.setText(nvl.substring(6, nvl.length()));

						textFieldLuong.setText(a.getLuongCB()+"");
						textFieldSDTNV.setText(a.getDienThoai());
						if(a.getGioiTinh().equalsIgnoreCase("nam")) {
							buttonNam.setSelected(true);						
						}
						else {
							buttonNu.setSelected(true);							
						}
						textFieldTaiKhoan.setText(a.getUser());
						textFieldMatKhau.setText(a.getPass());
						
						this.setVisible(true);
					}
				}
		else
			JOptionPane.showMessageDialog(null, "Vui long chọn 1 hàng !");
		
		return a;
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		String maNV = textFieldMaNV.getText();
		String ten = textFieldTenNV.getText();
		String email = textFieldEmailNV.getText();
		String cccd = textFieldCCCD.getText();
		String diachi = textFieldLuong.getText();
		String sdt = textFieldSDTNV.getText();
		String tk = textFieldTaiKhoan.getText();
		String mk = textFieldMatKhau.getText();
		String namVaoLam = textFieldNamVaoLam.getText();
		String ns = textFieldNamSinh.getText();
		
		
		if(textFieldCCCD.isEnabled()) {

			if(src.equals(textFieldMaNV.getDocument()))
				if(maNV.length()>0)
					checkHopleMaNV(maNV);
				else
					lblMessMaNV.setText("");
			else if(src.equals(textFieldTenNV.getDocument()))
				checkHopLeTenNV(ten);
			else if(src.equals(textFieldEmailNV.getDocument())) {
				checkHopLeEmail(email);
			}else if(src.equals(textFieldCCCD.getDocument()))
				checkHopLeCCCD(cccd);
			else if(src.equals(textFieldLuong.getDocument()))
				checkHopLeLuong(diachi);
			else if(src.equals(textFieldSDTNV.getDocument()))
				checkHopLeSDT(sdt);
			else if(src.equals(textFieldTaiKhoan.getDocument()))
				checkHopLeTaiKhoan(tk);
			else if(src.equals(textFieldMatKhau.getDocument())) {
				checkHopLeMatKhau(mk);
			}else if(src.equals(textFieldNamVaoLam.getDocument())) {
				String ngaysinh = comboBoxNgaySinh.getSelectedItem()+"";
				String thangSinh = comboBoxThangSinh.getSelectedItem()+"";
				checkNamVaoLamHopLe(ngaysinh,thangSinh,namVaoLam);
			}else if(src.equals(textFieldNamSinh.getDocument())) {				
				String ngay = comboBoxNgayVaoLam.getSelectedItem()+"";
				String thang = comboBoxThangVaoLam.getSelectedItem()+"";
				checkNamSinhHopLe(ngay, thang, ns);
			}
		}
		
		if(src.equals(textField_LocMaNV.getDocument())) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getMa().toUpperCase().contains(textField_LocMaNV.getText())) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
			if(textField_LocMaNV.getText().equals(""))
				updateTable();
		}else if(src.equals(textFieldLocTenNV.getDocument())) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getTen().toUpperCase().contains(textFieldLocTenNV.getText().toUpperCase())) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
			if(textFieldLocTenNV.getText().equals(""))
				updateTable();
		}
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		String maNV = textFieldMaNV.getText();
		String ten = textFieldTenNV.getText();
		String email = textFieldEmailNV.getText();
		String cccd = textFieldCCCD.getText();
		String diachi = textFieldLuong.getText();
		String sdt = textFieldSDTNV.getText();
		String tk = textFieldTaiKhoan.getText();
		String mk = textFieldMatKhau.getText();
		String namVaoLam = textFieldNamVaoLam.getText();
		String ns = textFieldNamSinh.getText();
		
		
		if(textFieldCCCD.isEnabled()) {

			if(src.equals(textFieldMaNV.getDocument()))
				if(maNV.length()>0)
					checkHopleMaNV(maNV);
				else
					lblMessMaNV.setText("");
			else if(src.equals(textFieldTenNV.getDocument()))
				checkHopLeTenNV(ten);
			else if(src.equals(textFieldEmailNV.getDocument())) {
				checkHopLeEmail(email);
			}else if(src.equals(textFieldCCCD.getDocument()))
				checkHopLeCCCD(cccd);
			else if(src.equals(textFieldLuong.getDocument()))
				checkHopLeLuong(diachi);
			else if(src.equals(textFieldSDTNV.getDocument()))
				checkHopLeSDT(sdt);
			else if(src.equals(textFieldTaiKhoan.getDocument()))
				checkHopLeTaiKhoan(tk);
			else if(src.equals(textFieldMatKhau.getDocument())) {
				checkHopLeMatKhau(mk);
			}else if(src.equals(textFieldNamVaoLam.getDocument())) {
				String ngaysinh = comboBoxNgaySinh.getSelectedItem()+"";
				String thangSinh = comboBoxThangSinh.getSelectedItem()+"";
				checkNamVaoLamHopLe(ngaysinh,thangSinh,namVaoLam);
			}else if(src.equals(textFieldNamSinh.getDocument())) {				
				String ngay = comboBoxNgayVaoLam.getSelectedItem()+"";
				String thang = comboBoxThangVaoLam.getSelectedItem()+"";
				checkNamSinhHopLe(ngay, thang, ns);
			}
		}
		
		if(src.equals(textField_LocMaNV.getDocument())) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getMa().toUpperCase().contains(textField_LocMaNV.getText())) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
			if(textField_LocMaNV.getText().equals(""))
				updateTable();
		}else if(src.equals(textFieldLocTenNV.getDocument())) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getTen().toUpperCase().contains(textFieldLocTenNV.getText().toUpperCase())) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
			if(textFieldLocTenNV.getText().equals(""))
				updateTable();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object src = e.getSource();
		if(src.equals(table)) {
			showTableToField();
		}else if(btnHuyGT.equals(src))
			updateTable();
		else if(buttonLocNam.equals(src)) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getGioiTinh().toUpperCase().equals("NAM")) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
		}else if(buttonLocNu.equals(src)) {
			modelTable.setRowCount(0);
			for (NhanVien a : listFilter) {
				if(a.getGioiTinh().toUpperCase().equals("NỮ")) {
					DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});
				}
			}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src.equals(ccbQL_Loc)) {
			DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
			modelTable.setRowCount(0);
			for (NhanVien a : model) {
				if(a.getMaQL().equalsIgnoreCase(ccbQL_Loc.getSelectedItem()+"")) {
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});			
				}
					
			}
			if((ccbQL_Loc.getSelectedItem()+"").equals("")) {
				updateTable();
			}
		}else if(src.equals(ccbPB_Loc)) {
			DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
			modelTable.setRowCount(0);
			for (NhanVien a : model) {
				if(a.getMaPB().equalsIgnoreCase(ccbPB_Loc.getSelectedItem()+"")) {
					modelTable.addRow(new Object[] {
							a.getMa().toUpperCase(),
							a.getTen().toUpperCase(),
							a.getMaPB().toUpperCase(),
							a.getMaQL().toUpperCase(),
							df.format(a.getNgayVaoLam()),
							df.format(a.getNgaySinh()),
							a.getGioiTinh().toUpperCase(),
							a.getLuongCB()+"",
							a.getDienThoai(),
							a.getEmail(),
							a.getCccd(),
							a.getUser(),
							a.getPass()
					});			
				}
					
			}
			if((ccbPB_Loc.getSelectedItem()+"").equals("")) {
				updateTable();
			}
		}
		
	}
	
	public NhanVien searchNV(String id) {
		for (NhanVien nhanVien : model) {
			if(nhanVien.getMa().equalsIgnoreCase(id))
				return nhanVien;
		}
		return null;
	}
	
	public NhanVien searchTK(String idUser) {
		for (NhanVien nhanVien : model) {
			if(nhanVien.getUser().equalsIgnoreCase(idUser))
				return nhanVien;
		}
		return null;
	}
	
}

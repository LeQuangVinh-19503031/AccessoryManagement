package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import connectDB.ConnectDB;
import dao.DonHang_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import model.DonHang;
import model.KhachHang;
import model.NhanVien;
import model.TaiKhoan;

import java.awt.Dimension;
import java.awt.FlowLayout;

public class JPanelDonHang extends JPanel implements DocumentListener, MouseListener{

	private JTextField textFieldTim;
	private JTable table_1;
	private DefaultTableModel modelTable =new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 H\u00D3A \u0110\u01A0N", "M\u00C3 KH\u00C1CH H\u00C0NG", "M\u00C3 NH\u00C2N VI\u00CAN", "NG\u00C0Y L\u1EACP", "NG\u00C0Y GIAO", "\u0110\u1ECAA CH\u1EC8 GIAO H\u00C0NG"
			}
		);
	
	private JTextField textFieldMaHD;
	private JTextField textFieldMaKhachHang;
	private JTextField textFieldMaNhanVien;
	private JTextField textFieldNgayGiao;
	private JTextField textFieldDiaChiGiaoHang;
	private JLabel lblMessMaHD, lblMessMaKhachHang, lblMessMaNhanVien, lblMessNgayGiao, lblMessDiaChiGiaoHang;
	private JButton btnThem, btnCapNhat, btnXoa, btnXoaTrang;
	private ArrayList<DonHang> model;
	private ArrayList<NhanVien> listNV;
	private ArrayList<KhachHang> listKH;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtEmailKH;
	private JTextField txtSDTKH;
	private JTextField txtDCKH;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtMaQL;
	private JTextField txtMaPB;
	private JPanel panel;
	private JScrollPane scrollPane_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_6;
	private JPanel panel_4;
	private JLabel lblNewLabel_7;
	private JPanel panel_5;
	private JLabel lblNewLabel_8;
	private JPanel panel_6;
	private JPanel panel_7;
	private JLabel lblNewLabel_9;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblNewLabel_10;
	private JPanel panel_10;
	private JPanel panel_11;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField textMaKH_Loc;
	private JLabel lblNewLabel_13;
	private JTextField textMaNV_Loc;
	private int slDonHang = 0;
	private TaiKhoan taikhoan;
	public JPanelDonHang(TaiKhoan a) {
		this.taikhoan = a;
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(10, 0, 1266, 53);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ĐƠN HÀNG");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setBounds(10, 0, 1256, 53);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBorder(null);
		panelTable.setBounds(10, 398, 941, 289);
		add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 255, 255));
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		panelTable.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table_1);
		table_1.setModel(modelTable);
		
		panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 102, 51));
		FlowLayout flowLayout_3 = (FlowLayout) panel_7.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panelTable.add(panel_7, BorderLayout.NORTH);
		
		lblNewLabel_9 = new JLabel("DANH SÁCH ĐƠN HÀNG");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_7.add(lblNewLabel_9);
		table_1.addMouseListener(this);
		
		JPanel panelChucNangNhanh = new JPanel();
		panelChucNangNhanh.setBackground(new Color(192, 192, 192));
		panelChucNangNhanh.setBorder(null);
		panelChucNangNhanh.setBounds(10, 315, 723, 73);
		add(panelChucNangNhanh);
		panelChucNangNhanh.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 723, 25);
		FlowLayout flowLayout_2 = (FlowLayout) panel_5.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_5.setBackground(new Color(255, 140, 0));
		panelChucNangNhanh.add(panel_5);
		
		lblNewLabel_8 = new JLabel("LỌC");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblNewLabel_8);
		
		panel_6 = new JPanel();
		panel_6.setBackground(new Color(192, 192, 192));
		panel_6.setBounds(0, 23, 723, 50);
		panelChucNangNhanh.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mã hóa đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 20, 70, 13);
		panel_6.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		textFieldTim = new JTextField();
		textFieldTim.setBounds(90, 9, 125, 31);
		panel_6.add(textFieldTim);
		textFieldTim.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Mã khách hàng");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(225, 20, 88, 13);
		panel_6.add(lblNewLabel_12);
		
		textMaKH_Loc = new JTextField();
		textMaKH_Loc.setColumns(10);
		textMaKH_Loc.setBounds(323, 9, 151, 31);
		panel_6.add(textMaKH_Loc);
		
		lblNewLabel_13 = new JLabel("Mã nhân viên");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(484, 20, 79, 13);
		panel_6.add(lblNewLabel_13);
		
		textMaNV_Loc = new JTextField();
		textMaNV_Loc.setColumns(10);
		textMaNV_Loc.setBounds(573, 9, 140, 31);
		panel_6.add(textMaNV_Loc);
		
		textFieldTim.getDocument().addDocumentListener(this);
		
		panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(743, 63, 208, 324);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setPreferredSize(new Dimension(150, 450));
		scrollPane_1.setViewportView(panel_1);
		
		btnThem = new JButton("THÊM");
		panel_1.add(btnThem);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setPreferredSize(new Dimension(140, 40));
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themHoaDon();
			}
			
		});
		btnThem.setToolTipText("Thêm nhà cung cấp");
		
		btnCapNhat = new JButton("CẬP NHẬT");
		btnCapNhat.setPreferredSize(new Dimension(140, 40));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhatHoaDon();
			}

		});
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		
		btnXoa = new JButton("XÓA");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setPreferredSize(new Dimension(140, 40));
		panel_1.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaHoaDon();
			}
		});
		
		btnXoaTrang = new JButton("XÓA TRẮNG");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaTrang.setPreferredSize(new Dimension(140, 40));
		panel_1.add(btnXoaTrang);
		
		panel_4 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_4.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_4.setBackground(new Color(255, 69, 0));
		panel.add(panel_4, BorderLayout.NORTH);
		
		lblNewLabel_7 = new JLabel("CHỨC NĂNG");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_4.add(lblNewLabel_7);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 63, 723, 242);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 99, 71));
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_3, BorderLayout.NORTH);
		
		lblNewLabel_6 = new JLabel("THÔNG TIN ĐƠN HÀNG");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_3.add(lblNewLabel_6);
		
		
		JPanel panelThongTin = new JPanel();
		panel_2.add(panelThongTin, BorderLayout.CENTER);
		panelThongTin.setBorder(null);
		panelThongTin.setBackground(new Color(192, 192, 192));
		panelThongTin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã hóa đơn");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(13, 10, 89, 26);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã khách hàng");
		lblNewLabel_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(368, 10, 101, 26);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã nhân viên");
		lblNewLabel_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(17, 80, 89, 25);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Ngày giao hàng");
		lblNewLabel_2_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_1.setBounds(368, 80, 99, 26);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Nơi giao hàng");
		lblNewLabel_2_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2_2.setBounds(16, 146, 89, 26);
		panelThongTin.add(lblNewLabel_2_2_2);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldMaHD.setEnabled(false);
		textFieldMaHD.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMaHD.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMaHD.setBounds(13, 37, 343, 32);
		panelThongTin.add(textFieldMaHD);
		textFieldMaHD.setColumns(10);
		
		
		textFieldMaKhachHang = new JTextField();
		textFieldMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldMaKhachHang.setEnabled(false);
		textFieldMaKhachHang.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMaKhachHang.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMaKhachHang.setColumns(10);
		textFieldMaKhachHang.setBounds(368, 37, 343, 32);
		panelThongTin.add(textFieldMaKhachHang);
		
		
		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldMaNhanVien.setEnabled(false);
		textFieldMaNhanVien.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMaNhanVien.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMaNhanVien.setColumns(10);
		textFieldMaNhanVien.setBounds(13, 105, 343, 32);
		panelThongTin.add(textFieldMaNhanVien);
		
		
		textFieldNgayGiao = new JTextField();
		textFieldNgayGiao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldNgayGiao.setEnabled(false);
		textFieldNgayGiao.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldNgayGiao.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldNgayGiao.setColumns(10);
		textFieldNgayGiao.setBounds(368, 105, 343, 32);
		panelThongTin.add(textFieldNgayGiao);
		
		
		textFieldDiaChiGiaoHang = new JTextField();
		textFieldDiaChiGiaoHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textFieldDiaChiGiaoHang.setEnabled(false);
		textFieldDiaChiGiaoHang.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldDiaChiGiaoHang.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldDiaChiGiaoHang.setColumns(10);
		textFieldDiaChiGiaoHang.setBounds(13, 175, 343, 32);
		panelThongTin.add(textFieldDiaChiGiaoHang);
		
		lblMessDiaChiGiaoHang = new JLabel("");
		lblMessDiaChiGiaoHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessDiaChiGiaoHang.setBounds(112, 146, 244, 26);
		panelThongTin.add(lblMessDiaChiGiaoHang);
		lblMessDiaChiGiaoHang.setForeground(new Color(255, 0, 0));
		
		lblMessNgayGiao = new JLabel("");
		lblMessNgayGiao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessNgayGiao.setBounds(477, 80, 236, 26);
		panelThongTin.add(lblMessNgayGiao);
		lblMessNgayGiao.setForeground(new Color(255, 0, 0));
		
		lblMessMaNhanVien = new JLabel("");
		lblMessMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessMaNhanVien.setBounds(116, 79, 244, 26);
		panelThongTin.add(lblMessMaNhanVien);
		lblMessMaNhanVien.setForeground(new Color(255, 0, 0));
		
		lblMessMaKhachHang = new JLabel("");
		lblMessMaKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessMaKhachHang.setBounds(477, 10, 236, 26);
		panelThongTin.add(lblMessMaKhachHang);
		lblMessMaKhachHang.setForeground(new Color(255, 0, 0));
		
		lblMessMaHD = new JLabel("");
		lblMessMaHD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMessMaHD.setBounds(112, 10, 244, 26);
		panelThongTin.add(lblMessMaHD);
		lblMessMaHD.setForeground(new Color(255, 0, 0));
		
		
		panel_8 = new JPanel();
		panel_8.setBackground(new Color(192, 192, 192));
		panel_8.setBounds(961, 63, 315, 324);
		add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		panel_9 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_9.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		panel_9.setBackground(new Color(255, 99, 71));
		panel_8.add(panel_9, BorderLayout.NORTH);
		
		lblNewLabel_10 = new JLabel("THÔNG TIN KHÁCH HÀNG");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_9.add(lblNewLabel_10);
		
		JPanel panelKhachHang = new JPanel();
		panel_8.add(panelKhachHang, BorderLayout.CENTER);
		panelKhachHang.setBackground(new Color(192, 192, 192));
		panelKhachHang.setBorder(null);
		panelKhachHang.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Mã");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 32, 57, 29);
		panelKhachHang.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1.setBounds(10, 85, 57, 29);
		panelKhachHang.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email");
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2.setBounds(10, 137, 57, 29);
		panelKhachHang.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4 = new JLabel("SDT");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 188, 57, 29);
		panelKhachHang.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Địa chỉ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 240, 57, 29);
		panelKhachHang.add(lblNewLabel_5);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(77, 32, 210, 29);
		panelKhachHang.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(77, 85, 210, 29);
		panelKhachHang.add(txtTenKH);
		
		txtEmailKH = new JTextField();
		txtEmailKH.setPreferredSize(new Dimension(20, 19));
		txtEmailKH.setEditable(false);
		txtEmailKH.setBounds(77, 137, 210, 29);
		panelKhachHang.add(txtEmailKH);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setEditable(false);
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(77, 188, 210, 29);
		panelKhachHang.add(txtSDTKH);
		
		txtDCKH = new JTextField();
		txtDCKH.setEditable(false);
		txtDCKH.setColumns(10);
		txtDCKH.setBounds(77, 240, 210, 29);
		panelKhachHang.add(txtDCKH);
		
		panel_10 = new JPanel();
		panel_10.setBounds(961, 398, 315, 289);
		add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 99, 71));
		FlowLayout flowLayout_5 = (FlowLayout) panel_11.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		panel_10.add(panel_11, BorderLayout.NORTH);
		
		lblNewLabel_11 = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_11.add(lblNewLabel_11);
		
		JPanel panelNhanVien = new JPanel();
		panel_10.add(panelNhanVien, BorderLayout.CENTER);
		panelNhanVien.setBackground(new Color(192, 192, 192));
		panelNhanVien.setBorder(null);
		panelNhanVien.setLayout(null);
		
		JLabel lblNewLabel_3_3 = new JLabel("Mã");
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_3.setBounds(10, 38, 55, 29);
		panelNhanVien.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Họ và Tên");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_1_1.setBounds(10, 87, 66, 29);
		panelNhanVien.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Mã quản lý");
		lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3_2_1.setBounds(10, 143, 77, 29);
		panelNhanVien.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã phòng ban");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(10, 200, 91, 29);
		panelNhanVien.add(lblNewLabel_4_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(111, 38, 194, 29);
		panelNhanVien.add(txtMaNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(111, 89, 194, 29);
		panelNhanVien.add(txtTenNV);
		
		txtMaQL = new JTextField();
		txtMaQL.setEditable(false);
		txtMaQL.setColumns(10);
		txtMaQL.setBounds(111, 144, 194, 29);
		panelNhanVien.add(txtMaQL);
		
		txtMaPB = new JTextField();
		txtMaPB.setEditable(false);
		txtMaPB.setColumns(10);
		txtMaPB.setBounds(111, 201, 194, 29);
		panelNhanVien.add(txtMaPB);
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		
		model = new ArrayList<DonHang>();
		updateTable();

		textFieldMaHD.getDocument().addDocumentListener(this);
		textFieldMaKhachHang.getDocument().addDocumentListener(this);
		textFieldMaNhanVien.getDocument().addDocumentListener(this);
		textFieldNgayGiao.getDocument().addDocumentListener(this);
		textFieldDiaChiGiaoHang.getDocument().addDocumentListener(this);
		textMaKH_Loc.getDocument().addDocumentListener(this);
		textMaNV_Loc.getDocument().addDocumentListener(this);
		
	}
	
	protected void xoaHoaDon() {
		
		
		int n = JOptionPane.showConfirmDialog(null, "Xác nhận xóa đơn hàng "+textFieldMaHD.getText()+" ?", "Xóa hóa đơn", JOptionPane.YES_NO_OPTION);
		if(n == JOptionPane.YES_OPTION) {
			ConnectDB c =  new ConnectDB();
			c.connect();
			DonHang_DAO.xoa(textFieldMaHD.getText());
			c.disconect();
			updateTable();

		}
		
	}

	private void updateTable() {
		uploadDB();
		uploadDB_NV_KH();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		modelTable.setRowCount(0);
		for (DonHang a : model) {
			modelTable.addRow(new Object[] {
					a.getMaHD(),
					a.getMaKH(),
					a.getMaNV(),
					df.format(a.getNgayLapHD()),
					df.format(a.getNgayGiao()),
					a.getDiaChiGiaoHang()
			});
		}
		slDonHang = model.size();
		this.setVisible(true);
	
	}

	private void uploadDB() {
		ConnectDB con = new ConnectDB();
		con.connect();
		model = DonHang_DAO.getAllHoaDonFromDB();
		con.disconect();
	}
	
	public void jTextFieldEditable(boolean choose) {
		
		textFieldMaHD.setEnabled(choose);
		textFieldMaKhachHang.setEnabled(choose);
		textFieldMaNhanVien.setEnabled(choose);
		textFieldNgayGiao.setEnabled(choose);
		textFieldDiaChiGiaoHang.setEnabled(choose);
		
		textFieldMaHD.setEditable(choose);
		textFieldMaKhachHang.setEditable(choose);
		textFieldMaNhanVien.setEditable(choose);
		textFieldNgayGiao.setEditable(choose);
		textFieldDiaChiGiaoHang.setEditable(choose);
		
	}
	
	private boolean checkfieldHopLe() {
		
		if(textFieldMaHD.getText().length() > 2 && textFieldMaHD.getText().toUpperCase().matches("[A-Z0-9]+")) {
			if(checkContainHD(textFieldMaHD.getText())) {
				lblMessMaHD.setText("Đã tồn tại mã hóa đơn này !");
				return false;
			}
			else
				lblMessMaHD.setText("");
			
		}else {
			lblMessMaHD.setText("Chưa đúng định dạng !");
			return false;
		}
		
		if(textFieldMaKhachHang.getText().length()> 2) {
			if(checkContainKH(textFieldMaKhachHang.getText()))
				lblMessMaKhachHang.setText("");
			else {
				lblMessMaKhachHang.setText("Chưa có khách hàng "+textFieldMaKhachHang.getText()+" trong hệ thống !");
				return false;
			}
		}else {
			lblMessMaKhachHang.setText("Chưa đúng định dạng !");
			return false;			
		}
		
		if(textFieldMaNhanVien.getText().length()> 2 ) {
			if(checkContainNV(textFieldMaNhanVien.getText()))
				lblMessMaNhanVien.setText("");
			else {
				lblMessMaNhanVien.setText("Chưa có khách hàng "+textFieldMaNhanVien.getText()+" trong hệ thống !");
				return false;				
			}
		}else {
			lblMessMaNhanVien.setText("Chưa đúng định dạng !");
			return false;			
		}
		
		if(textFieldNgayGiao.getText().matches("\\d{2}-\\d{2}-\\d{4}")) {
			lblMessNgayGiao.setText("");
		}else {
			lblMessNgayGiao.setText("Chưa đúng định dạng ! [dd-MM-yyyy]");
			return false;			
		}
		
		if(textFieldDiaChiGiaoHang.getText().length()> 2) {
			lblMessDiaChiGiaoHang.setText("");
		}else {
			lblMessDiaChiGiaoHang.setText("Chưa đúng định dạng !");
			return false;			
		}
		
		return true;

	}
	
	public void themHoaDon() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");  
		LocalDateTime now = LocalDateTime.now();
		String maNV = search_NVDangHD(this.taikhoan);
		DonHang a = new DonHang();
		if(slDonHang<10)
			textFieldMaHD.setText("DH0"+(slDonHang + 1));
		else
			textFieldMaHD.setText("DH"+(slDonHang + 1));
		textFieldMaNhanVien.setText(maNV);
		if(!textFieldMaHD.isEnabled()) {	
			xoaTrang();
			jTextFieldEditable(true);
			this.textFieldMaHD.setEditable(true);
			if(slDonHang<10)
				textFieldMaHD.setText("DH0"+(slDonHang + 1));
			else
				textFieldMaHD.setText("DH"+(slDonHang + 1));
			textFieldMaNhanVien.setText(maNV);
		}else {
			if(checkfieldHopLe()) {
				jTextFieldEditable(false);
				try {
					a.setMaHD(textFieldMaHD.getText());
					a.setMaKH(textFieldMaKhachHang.getText());
					a.setMaNV(textFieldMaNhanVien.getText());
					a.setNgayLapHD(df.parse(dtf.format(now)));
					a.setNgayGiao(df.parse(textFieldNgayGiao.getText()));
					a.setDiaChiGiaoHang(textFieldDiaChiGiaoHang.getText());
				} catch (Exception e) {
					a = null;
					e.printStackTrace();
				} finally {
					if(a!=null) {
						ConnectDB con = new ConnectDB();
						con.connect();
						boolean res = DonHang_DAO.insertDB(a);
						con.disconect();
						if(res) {
							updateTable();
							xoaTrang();
							JOptionPane.showMessageDialog(null, "THÊM THÀNH CÔNG");
							jTextFieldEditable(false);
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
	
	private String search_NVDangHD(TaiKhoan x) {
		for (NhanVien a : listNV) {
			if(a.getUser().equals(x.getUser()) && a.getPass().equalsIgnoreCase(x.getPass()))
				return a.getMa();
		}
		return null;
	}
	
	public void jButtomEnableForUpdate(boolean choose) {
		btnThem.setEnabled(choose);
		btnXoaTrang.setEnabled(choose);
	}
	
	public void capNhatHoaDon() {
		
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		int n = table_1.getSelectedRow();
		DonHang a = new DonHang();
		if(n>=0)
			if(textFieldNgayGiao.isEditable()) {
				jButtomEnableForUpdate(true);
				this.btnXoa.setEnabled(true);
				try {
					
					a.setMaHD(textFieldMaHD.getText().toUpperCase());
					a.setMaKH(textFieldMaKhachHang.getText().toUpperCase());
					a.setMaNV(textFieldMaNhanVien.getText().toUpperCase());
					a.setNgayLapHD(df.parse(modelTable.getValueAt(n, 3)+""));
					a.setNgayGiao(df.parse(textFieldNgayGiao.getText()));
					a.setDiaChiGiaoHang(textFieldDiaChiGiaoHang.getText().toUpperCase());
					
				} catch (Exception e) {
					e.printStackTrace();
					a = null;
				}finally {
					
					if(a!=null) {
						int confirm = JOptionPane.showConfirmDialog(null, "Cập nhật hóa đơn "+a.getMaHD()+" ?", "Cập nhật", JOptionPane.YES_NO_OPTION);

						if(confirm == JOptionPane.YES_OPTION) {
							ConnectDB con = new ConnectDB();
							con.connect();
							Boolean res = DonHang_DAO.updateDB(a);
							con.disconect();
							if(res) {
								xoaTrang();
								jTextFieldEditable(false);
								updateTable();
								this.setVisible(true);
							}
						}
					}
				}
				
			}else {
				
				jButtomEnableForUpdate(false);
				this.btnXoa.setEnabled(false);
				jTextFieldEditable(true);
				this.textFieldMaHD.setEditable(false);
				
			}
		else {
			JOptionPane.showMessageDialog(null, "CHỌN 1 HÀNG ĐỂ DÙNG CHỨC NĂNG SỬA !");
		}		
	}

	private void xoaTrang() {
		textFieldMaHD.setText("");
		textFieldMaKhachHang.setText("");
		textFieldMaNhanVien.setText("");
		textFieldNgayGiao.setText("");
		textFieldDiaChiGiaoHang.setText("");

		lblMessMaHD.setText("");
		lblMessMaKhachHang.setText("");
		lblMessMaNhanVien.setText("");
		lblMessNgayGiao.setText("");
		lblMessDiaChiGiaoHang.setText("");

		
		txtDCKH.setText("");
		txtEmailKH.setText("");
		txtMaKH.setText("");
		txtMaNV.setText("");
		txtMaPB.setText("");
		txtMaQL.setText("");
		txtSDTKH.setText("");
		txtTenKH.setText("");
		txtTenNV.setText("");
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textFieldMaHD.getDocument())) {
			if(textFieldMaHD.getText().length() > 2 && textFieldMaHD.getText().toUpperCase().matches("[A-Z0-9]+")) {
				if(checkContainHD(textFieldMaHD.getText())) {
					lblMessMaHD.setText("Đã tồn tại mã hóa đơn này !");
				}
				else
					lblMessMaHD.setText("");
		}else
			lblMessMaHD.setText("Chưa đúng định đạng !");
			
		}else if(src.equals(textFieldMaKhachHang.getDocument())) {
			if(textFieldMaKhachHang.getText().length()> 2) {
				if(checkContainKH(textFieldMaKhachHang.getText()))
					lblMessMaKhachHang.setText("");
				else
					lblMessMaKhachHang.setText("Chưa có khách hàng "+textFieldMaKhachHang.getText()+" trong hệ thống !");
			}else
				lblMessMaKhachHang.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldMaNhanVien.getDocument())) {
			if(textFieldMaNhanVien.getText().length()> 2 ) {
				if(checkContainNV(textFieldMaNhanVien.getText()))
					lblMessMaNhanVien.setText("");
				else
					lblMessMaNhanVien.setText("Chưa có khách hàng "+textFieldMaNhanVien.getText()+" trong hệ thống !");
			}else
				lblMessMaNhanVien.setText("Chưa đúng định dạng !");
		} else if(src.equals(textFieldNgayGiao.getDocument())) {
			if(textFieldNgayGiao.getText().matches("\\d{2}-\\d{2}-\\d{4}")) {
				lblMessNgayGiao.setText("");
			}else
				lblMessNgayGiao.setText("\"dd-MM-yyyy\" !");
		}else if(src.equals(textFieldDiaChiGiaoHang.getDocument())) {
			if(textFieldDiaChiGiaoHang.getText().length()> 2) {
				lblMessDiaChiGiaoHang.setText("");
			}else
				lblMessDiaChiGiaoHang.setText("Chưa đúng định dạng !");
		}
		else if(src.equals(textMaKH_Loc.getDocument())) {
			modelTable.setRowCount(0);
			for (DonHang a : model) {
				if(a.getMaKH().toUpperCase().contains(textMaKH_Loc.getText().toUpperCase())) {
					modelTable.addRow(new Object[] {
							a.getMaHD(),
							a.getMaKH(),
							a.getMaNV(),
							a.getNgayLapHD(),
							a.getNgayGiao(),
							a.getDiaChiGiaoHang().toUpperCase()
					});
				}
			}
			if(textMaKH_Loc.getText().equals(""))
				updateTable();
		}else if(src.equals(textMaNV_Loc.getDocument())) {
			modelTable.setRowCount(0);
			for (DonHang a : model) {
				if(a.getMaNV().toUpperCase().contains(textMaNV_Loc.getText().toUpperCase())) {
					System.out.println(1);
					modelTable.addRow(new Object[] {
							a.getMaHD(),
							a.getMaKH(),
							a.getMaNV(),
							a.getNgayLapHD(),
							a.getNgayGiao(),
							a.getDiaChiGiaoHang().toUpperCase()
					});
				}
			}
			if(textMaNV_Loc.getText().equals(""))
				updateTable();
		}
		
		if(!textFieldDiaChiGiaoHang.isEditable()) {
			lblMessMaHD.setText("");
			lblMessMaKhachHang.setText("");
			lblMessMaNhanVien.setText("");
			lblMessNgayGiao.setText("");
			lblMessDiaChiGiaoHang.setText("");
		}
		
		if(src.equals(textFieldTim.getDocument())) {
			timKiemMa();
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textFieldMaHD.getDocument())) {
			if(textFieldMaHD.getText().length() > 2 && textFieldMaHD.getText().toUpperCase().matches("[A-Z0-9]+")) {
				if(checkContainHD(textFieldMaHD.getText())) {
					lblMessMaHD.setText("Đã tồn tại mã hóa đơn này !");
				}
				else
					lblMessMaHD.setText("");
		}else
			lblMessMaHD.setText("Chưa đúng định đạng !");
			
		}else if(src.equals(textFieldMaKhachHang.getDocument())) {
			if(textFieldMaKhachHang.getText().length()> 2) {
				if(checkContainKH(textFieldMaKhachHang.getText()))
					lblMessMaKhachHang.setText("");
				else
					lblMessMaKhachHang.setText("Chưa có khách hàng "+textFieldMaKhachHang.getText()+" trong hệ thống !");
			}else
				lblMessMaKhachHang.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldMaNhanVien.getDocument())) {
			if(textFieldMaNhanVien.getText().length()> 2 ) {
				if(checkContainNV(textFieldMaNhanVien.getText()))
					lblMessMaNhanVien.setText("");
				else
					lblMessMaNhanVien.setText("Chưa có khách hàng "+textFieldMaNhanVien.getText()+" trong hệ thống !");
			}else
				lblMessMaNhanVien.setText("Chưa đúng định dạng !");
		} else if(src.equals(textFieldNgayGiao.getDocument())) {
			if(textFieldNgayGiao.getText().matches("\\d{2}-\\d{2}-\\d{4}")) {
				lblMessNgayGiao.setText("");
			}else
				lblMessNgayGiao.setText("\"dd-MM-yyyy\" !");
		}else if(src.equals(textFieldDiaChiGiaoHang.getDocument())) {
			if(textFieldDiaChiGiaoHang.getText().length()> 2) {
				lblMessDiaChiGiaoHang.setText("");
			}else
				lblMessDiaChiGiaoHang.setText("Chưa đúng định dạng !");
		}else if(src.equals(textMaKH_Loc.getDocument())) {
			modelTable.setRowCount(0);
			for (DonHang a : model) {
				if(a.getMaKH().toUpperCase().contains(textMaKH_Loc.getText().toUpperCase())) {
					modelTable.addRow(new Object[] {
							a.getMaHD(),
							a.getMaKH(),
							a.getMaNV(),
							a.getNgayLapHD(),
							a.getNgayGiao(),
							a.getDiaChiGiaoHang().toUpperCase()
					});
				}
			}
			if(textMaKH_Loc.getText().equals(""))
				updateTable();
		}else if(src.equals(textMaNV_Loc.getDocument())) {
			modelTable.setRowCount(0);
			for (DonHang a : model) {
				if(a.getMaNV().toUpperCase().contains(textMaNV_Loc.getText().toUpperCase())) {
					System.out.println(1);
					modelTable.addRow(new Object[] {
							a.getMaHD(),
							a.getMaKH(),
							a.getMaNV(),
							a.getNgayLapHD(),
							a.getNgayGiao(),
							a.getDiaChiGiaoHang().toUpperCase()
					});
				}
			}
			if(textMaNV_Loc.getText().equals(""))
				updateTable();
		}
		
		if(!textFieldDiaChiGiaoHang.isEditable()) {
			lblMessMaHD.setText("");
			lblMessMaKhachHang.setText("");
			lblMessMaNhanVien.setText("");
			lblMessNgayGiao.setText("");
			lblMessDiaChiGiaoHang.setText("");
		}
		
		if(src.equals(textFieldTim.getDocument())) {
			timKiemMa();
		}
		
	}
	
	private boolean checkContainNV(String text) {
		for (NhanVien a : listNV) {
			if(a.getMa().equalsIgnoreCase(text)) {
				txtMaNV.setText(a.getMa());
				txtTenNV.setText(a.getTen());
				txtMaQL.setText(a.getMaQL());
				txtMaPB.setText(a.getMaPB());
				return true;
			}
		}
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtMaQL.setText("");
		txtMaPB.setText("");
		return false;
	}
	
	private boolean checkContainKH(String text) {
		for (KhachHang a : listKH) {
			if(a.getMa().toUpperCase().equalsIgnoreCase(text.toUpperCase())) {
				txtMaKH.setText(a.getMa());
				txtTenKH.setText(a.getTen());
				txtSDTKH.setText(a.getSdt());
				txtEmailKH.setText(a.getEmail());
				txtDCKH.setText(a.getDiaChi());
				return true;
			}else {
				continue;
			}
		}
		return false;
	}

	private boolean checkContainHD(String id) {
		for (DonHang a : model) {
			if(a.getMaHD().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}

	public void uploadDB_NV_KH() {
		ConnectDB c = new ConnectDB();
		c.connect();
		listKH = KhachHang_DAO.getAllKhachHangFromDB();
		listNV = NhanVien_DAO.getAllFromDB();
		c.disconect();
	}


	@Override
	public void changedUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textFieldMaHD.getDocument())) {
			if(textFieldMaHD.getText().length() > 2 && textFieldMaHD.getText().toUpperCase().matches("[A-Z0-9]+")) {
				if(checkContainHD(textFieldMaHD.getText())) {
					lblMessMaHD.setText("Đã tồn tại mã hóa đơn này !");
				}
				else
					lblMessMaHD.setText("");
		}else
			lblMessMaHD.setText("Chưa đúng định đạng !");
			
		}else if(src.equals(textFieldMaKhachHang.getDocument())) {
			if(textFieldMaKhachHang.getText().length()> 2) {
				if(checkContainKH(textFieldMaKhachHang.getText()))
					lblMessMaKhachHang.setText("");
				else
					lblMessMaKhachHang.setText("Chưa có khách hàng "+textFieldMaKhachHang.getText()+" trong hệ thống !");
			}else
				lblMessMaKhachHang.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldMaNhanVien.getDocument())) {
			if(textFieldMaNhanVien.getText().length()> 2 ) {
				if(checkContainNV(textFieldMaNhanVien.getText()))
					lblMessMaNhanVien.setText("");
				else
					lblMessMaNhanVien.setText("Chưa có khách hàng "+textFieldMaNhanVien.getText()+" trong hệ thống !");
			}else
				lblMessMaNhanVien.setText("Chưa đúng định dạng !");
		} else if(src.equals(textFieldNgayGiao.getDocument())) {
			if(textFieldNgayGiao.getText().matches("\\d{2}-\\d{2}-\\d{4}")) {
				lblMessNgayGiao.setText("");
			}else
				lblMessNgayGiao.setText("\"dd-MM-yyyy\" !");
		}else if(src.equals(textFieldDiaChiGiaoHang.getDocument())) {
			if(textFieldDiaChiGiaoHang.getText().length()> 2) {
				lblMessDiaChiGiaoHang.setText("");
			}else
				lblMessDiaChiGiaoHang.setText("Chưa đúng định dạng !");
		}else if(src.equals(textMaKH_Loc.getDocument())) {
			modelTable.setRowCount(0);
			for (DonHang a : model) {
				if(a.getMaKH().toUpperCase().contains(textMaKH_Loc.getText().toUpperCase())) {
					modelTable.addRow(new Object[] {
							a.getMaHD(),
							a.getMaKH(),
							a.getMaNV(),
							a.getNgayLapHD(),
							a.getNgayGiao(),
							a.getDiaChiGiaoHang().toUpperCase()
					});
				}
			}
			if(textMaKH_Loc.getText().equals(""))
				updateTable();
		}else if(src.equals(textMaNV_Loc.getDocument())) {
			modelTable.setRowCount(0);
			for (DonHang a : model) {
				if(a.getMaNV().toUpperCase().contains(textMaNV_Loc.getText().toUpperCase())) {
					modelTable.addRow(new Object[] {
							a.getMaHD(),
							a.getMaKH(),
							a.getMaNV(),
							a.getNgayLapHD(),
							a.getNgayGiao(),
							a.getDiaChiGiaoHang().toUpperCase()
					});
				}
			}
			if(textMaNV_Loc.getText().equals(""))
				updateTable();
		}
		
		if(!textFieldDiaChiGiaoHang.isEditable()) {
			lblMessMaHD.setText("");
			lblMessMaKhachHang.setText("");
			lblMessMaNhanVien.setText("");
			lblMessNgayGiao.setText("");
			lblMessDiaChiGiaoHang.setText("");
		}
		
		if(src.equals(textFieldTim.getDocument())) {
			timKiemMa();
		}
		
	}
	
	public void timKiemMa() {
		
		xoaTrang();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String a = textFieldTim.getText();
		if(a.length() == 0) {
			updateTable();
			this.setVisible(true);
		}else {
			modelTable.setRowCount(0);
			for (DonHang x : model) {
				if(x.getMaHD().toUpperCase().contains(a.toUpperCase())) {
					modelTable.addRow(new Object[] {
							x.getMaHD(),
							x.getMaKH(),
							x.getMaNV(),
							df.format(x.getNgayLapHD()),
							df.format(x.getNgayGiao()),
							x.getDiaChiGiaoHang()
					});
				}
			}
		}
		this.setVisible(true);
	}
	
	public void showInforIntoTextFiled() {
		
		jTextFieldEditable(false);
		this.textFieldMaHD.setEditable(false);
		int n = table_1.getSelectedRow();
		textFieldMaHD.setText(modelTable.getValueAt(n, 0)+"");
		textFieldMaKhachHang.setText(modelTable.getValueAt(n, 1)+"");
		textFieldMaNhanVien.setText(modelTable.getValueAt(n, 2)+"");
		textFieldNgayGiao.setText(modelTable.getValueAt(n, 4)+"");
		textFieldDiaChiGiaoHang.setText(modelTable.getValueAt(n, 5)+"");
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		showInforIntoTextFiled();
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

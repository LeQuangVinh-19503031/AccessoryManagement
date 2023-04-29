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
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import connectDB.ConnectDB;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhaCungCap_DAO;
import dao.NhanVien_DAO;
import model.HoaDon;
import model.KhachHang;
import model.ModelListHoaDon;
import model.ModelListNhaCungCap;
import model.NhaCungCap;
import model.NhanVien;

import javax.swing.border.EtchedBorder;

public class JPanelHoaDon extends JPanel implements DocumentListener, MouseListener{

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
	private ModelListHoaDon model;
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

	public JPanelHoaDon() {
	
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1285, 53);
		add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("ĐƠN HÀNG");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel, BorderLayout.SOUTH);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNang.setBackground(new Color(204, 255, 255));
		panelChucNang.setBounds(10, 367, 590, 78);
		add(panelChucNang);
		panelChucNang.setLayout(null);
		
		btnThem = new JButton("THÊM");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themHoaDon();
			}
			
		});
		btnThem.setToolTipText("Thêm nhà cung cấp");
		btnThem.setBounds(10, 22, 134, 42);
		panelChucNang.add(btnThem);
		
		btnCapNhat = new JButton("CẬP NHẬT");
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhatNhaCungCap();
			}

		});
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		btnCapNhat.setBounds(154, 22, 134, 42);
		panelChucNang.add(btnCapNhat);
		
		btnXoa = new JButton("XÓA");
		btnXoa.setBounds(298, 22, 134, 42);
		panelChucNang.add(btnXoa);
		
		btnXoaTrang = new JButton("XÓA TRẮNG");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		btnXoaTrang.setBounds(442, 22, 134, 42);
		panelChucNang.add(btnXoaTrang);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "DANH S\u00C1CH \u0110\u01A0N H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTable.setBounds(10, 63, 1006, 294);
		add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 255, 255));
		scrollPane.setBounds(10, 21, 980, 262);
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		panelTable.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table_1);
		table_1.setModel(modelTable);
		table_1.addMouseListener(this);
		
		
		JPanel panelThongTin = new JPanel();
		panelThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "TH\u00D4NG TIN \u0110\u01A0N H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelThongTin.setBackground(new Color(204, 255, 255));
		panelThongTin.setBounds(10, 455, 1006, 247);
		add(panelThongTin);
		panelThongTin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã hóa đơn");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(30, 54, 153, 32);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Mã khách hàng");
		lblNewLabel_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(511, 54, 153, 32);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Mã nhân viên");
		lblNewLabel_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(30, 127, 153, 32);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Ngày giao hàng");
		lblNewLabel_2_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(511, 127, 153, 32);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Địa chỉ giao hàng");
		lblNewLabel_2_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(30, 197, 143, 32);
		panelThongTin.add(lblNewLabel_2_2_2);
		
		textFieldMaHD = new JTextField();
		textFieldMaHD.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMaHD.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMaHD.setBounds(183, 54, 304, 32);
		panelThongTin.add(textFieldMaHD);
		textFieldMaHD.setColumns(10);
		
		textFieldMaHD.getDocument().addDocumentListener(this);
		
		textFieldMaKhachHang = new JTextField();
		textFieldMaKhachHang.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMaKhachHang.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMaKhachHang.setColumns(10);
		textFieldMaKhachHang.setBounds(664, 54, 304, 32);
		panelThongTin.add(textFieldMaKhachHang);
		
		textFieldMaKhachHang.getDocument().addDocumentListener(this);
		
		textFieldMaNhanVien = new JTextField();
		textFieldMaNhanVien.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMaNhanVien.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMaNhanVien.setColumns(10);
		textFieldMaNhanVien.setBounds(183, 127, 304, 32);
		panelThongTin.add(textFieldMaNhanVien);
		
		textFieldMaNhanVien.getDocument().addDocumentListener(this);
		
		textFieldNgayGiao = new JTextField();
		textFieldNgayGiao.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldNgayGiao.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldNgayGiao.setColumns(10);
		textFieldNgayGiao.setBounds(664, 127, 304, 32);
		panelThongTin.add(textFieldNgayGiao);
		
		textFieldNgayGiao.getDocument().addDocumentListener(this);
		
		textFieldDiaChiGiaoHang = new JTextField();
		textFieldDiaChiGiaoHang.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldDiaChiGiaoHang.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldDiaChiGiaoHang.setColumns(10);
		textFieldDiaChiGiaoHang.setBounds(183, 200, 304, 32);
		panelThongTin.add(textFieldDiaChiGiaoHang);
		
		lblMessDiaChiGiaoHang = new JLabel("");
		lblMessDiaChiGiaoHang.setBounds(183, 169, 304, 32);
		panelThongTin.add(lblMessDiaChiGiaoHang);
		lblMessDiaChiGiaoHang.setForeground(new Color(255, 0, 0));
		
		lblMessNgayGiao = new JLabel("");
		lblMessNgayGiao.setBounds(664, 96, 304, 32);
		panelThongTin.add(lblMessNgayGiao);
		lblMessNgayGiao.setForeground(new Color(255, 0, 0));
		
		lblMessMaNhanVien = new JLabel("");
		lblMessMaNhanVien.setBounds(183, 96, 304, 32);
		panelThongTin.add(lblMessMaNhanVien);
		lblMessMaNhanVien.setForeground(new Color(255, 0, 0));
		
		lblMessMaKhachHang = new JLabel("");
		lblMessMaKhachHang.setBounds(664, 23, 304, 32);
		panelThongTin.add(lblMessMaKhachHang);
		lblMessMaKhachHang.setForeground(new Color(255, 0, 0));
		
		lblMessMaHD = new JLabel("");
		lblMessMaHD.setBounds(183, 23, 304, 32);
		panelThongTin.add(lblMessMaHD);
		lblMessMaHD.setForeground(new Color(255, 0, 0));
		
		textFieldDiaChiGiaoHang.getDocument().addDocumentListener(this);
		
		JPanel panelChucNangNhanh = new JPanel();
		panelChucNangNhanh.setBackground(new Color(204, 255, 255));
		panelChucNangNhanh.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG NHANH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNangNhanh.setBounds(610, 367, 406, 78);
		add(panelChucNangNhanh);
		panelChucNangNhanh.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TÌM KIẾM MÃ");
		lblNewLabel_1.setBounds(10, 26, 129, 32);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelChucNangNhanh.add(lblNewLabel_1);
		
		textFieldTim = new JTextField();
		textFieldTim.setBounds(138, 26, 244, 32);
		panelChucNangNhanh.add(textFieldTim);
		textFieldTim.setColumns(10);
		
		textFieldTim.getDocument().addDocumentListener(this);
		
		JPanel panelKhachHang = new JPanel();
		panelKhachHang.setBackground(new Color(204, 255, 255));
		panelKhachHang.setBorder(new TitledBorder(null, "TH\u00D4NG TIN KH\u00C1CH H\u00C0NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelKhachHang.setBounds(1026, 63, 250, 294);
		add(panelKhachHang);
		panelKhachHang.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Mã");
		lblNewLabel_3.setBounds(10, 32, 57, 21);
		panelKhachHang.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Tên");
		lblNewLabel_3_1.setBounds(10, 80, 57, 21);
		panelKhachHang.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("Email");
		lblNewLabel_3_2.setBounds(10, 133, 57, 21);
		panelKhachHang.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_4 = new JLabel("SDT");
		lblNewLabel_4.setBounds(10, 185, 57, 21);
		panelKhachHang.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Địa chỉ");
		lblNewLabel_5.setBounds(10, 236, 57, 21);
		panelKhachHang.add(lblNewLabel_5);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(77, 32, 148, 21);
		panelKhachHang.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(77, 80, 148, 21);
		panelKhachHang.add(txtTenKH);
		
		txtEmailKH = new JTextField();
		txtEmailKH.setEditable(false);
		txtEmailKH.setColumns(10);
		txtEmailKH.setBounds(77, 133, 148, 21);
		panelKhachHang.add(txtEmailKH);
		
		txtSDTKH = new JTextField();
		txtSDTKH.setEditable(false);
		txtSDTKH.setColumns(10);
		txtSDTKH.setBounds(77, 185, 148, 21);
		panelKhachHang.add(txtSDTKH);
		
		txtDCKH = new JTextField();
		txtDCKH.setEditable(false);
		txtDCKH.setColumns(10);
		txtDCKH.setBounds(77, 236, 148, 21);
		panelKhachHang.add(txtDCKH);
		
		JPanel panelNhanVien = new JPanel();
		panelNhanVien.setBackground(new Color(204, 255, 255));
		panelNhanVien.setBorder(new TitledBorder(null, "TH\u00D4NG TIN NH\u00C2N VI\u00CAN", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelNhanVien.setBounds(1026, 367, 250, 335);
		add(panelNhanVien);
		panelNhanVien.setLayout(null);
		
		JLabel lblNewLabel_3_3 = new JLabel("Mã");
		lblNewLabel_3_3.setBounds(10, 38, 77, 21);
		panelNhanVien.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Họ và Tên");
		lblNewLabel_3_1_1.setBounds(10, 86, 77, 21);
		panelNhanVien.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("Mã quản lý");
		lblNewLabel_3_2_1.setBounds(10, 162, 77, 21);
		panelNhanVien.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã phòng ban");
		lblNewLabel_4_1.setBounds(10, 214, 77, 21);
		panelNhanVien.add(lblNewLabel_4_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setColumns(10);
		txtMaNV.setBounds(97, 38, 128, 21);
		panelNhanVien.add(txtMaNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(10, 107, 215, 21);
		panelNhanVien.add(txtTenNV);
		
		txtMaQL = new JTextField();
		txtMaQL.setEditable(false);
		txtMaQL.setColumns(10);
		txtMaQL.setBounds(97, 162, 128, 21);
		panelNhanVien.add(txtMaQL);
		
		txtMaPB = new JTextField();
		txtMaPB.setEditable(false);
		txtMaPB.setColumns(10);
		txtMaPB.setBounds(97, 214, 128, 21);
		panelNhanVien.add(txtMaPB);
		
		model = new ModelListHoaDon();
		updateTable();
		
	}
	
	private void updateTable() {
		uploadDB();
		uploadDB_NV_KH();
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		modelTable.setRowCount(0);
		for (HoaDon a : model.getList()) {
			modelTable.addRow(new Object[] {
					a.getMaHD(),
					a.getMaKH(),
					a.getMaNV(),
					df.format(a.getNgayLapHD()),
					df.format(a.getNgayGiao()),
					a.getDiaChiGiaoHang()
			});
		}
	
	}

	private void uploadDB() {
		ConnectDB con = new ConnectDB();
		con.connect();
		model.setList(HoaDon_DAO.getAllHoaDonFromDB());
		con.disconect();
	}
	
	public void jTextFieldEditable(boolean choose) {
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
		   System.out.println(dtf.format(now));  
		HoaDon a = new HoaDon();
		if(!textFieldMaHD.isEditable()) {	
			xoaTrang();
			jTextFieldEditable(true);
			this.textFieldMaHD.setEditable(true);
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
						boolean res = HoaDon_DAO.insertDB(a);
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
	
	public void jButtomEnableForUpdate(boolean choose) {
		btnThem.setEnabled(choose);
		btnXoaTrang.setEnabled(choose);
	}
	
	public void capNhatNhaCungCap() {
		int n = table_1.getSelectedRow();
		NhaCungCap a = new NhaCungCap();
		if(n>=0)
			if(textFieldNgayGiao.isEditable()) {
				jButtomEnableForUpdate(true);
				this.btnXoa.setEnabled(true);
				try {
					
					a.setMa(textFieldMaHD.getText().toUpperCase());
					a.setTen(textFieldMaKhachHang.getText().toUpperCase());
					a.setEmail(textFieldMaNhanVien.getText());
					a.setSdt(textFieldNgayGiao.getText());
					a.setDiaChi(textFieldDiaChiGiaoHang.getText().toUpperCase());
					
				} catch (Exception e) {
					e.printStackTrace();
					a = null;
				}finally {
					
					if(a!=null) {
						
						int confirm = JOptionPane.showConfirmDialog(null, "Cập nhật nhà cung cấp "+a.getMa(), "Cập nhật", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							modelTable.setValueAt(a.getMa(), n, 0);
							modelTable.setValueAt(a.getTen(), n, 1);
							modelTable.setValueAt(a.getEmail(), n, 2);
							modelTable.setValueAt(a.getSdt(), n, 3);
							modelTable.setValueAt(a.getDiaChi(), n, 4);
							
							ConnectDB con = new ConnectDB();
							con.connect();
							Boolean res = NhaCungCap_DAO.update(a);
							con.disconect();
							if(res) {
								updateTable();
								xoaTrang();
								jTextFieldEditable(false);
								JOptionPane.showMessageDialog(null, "Cập nhật thành công !", "Cập nhật", JOptionPane.PLAIN_MESSAGE);
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
				lblMessNgayGiao.setText("Chưa đúng định dạng ! [dd-MM-yyyy]");
		}else if(src.equals(textFieldDiaChiGiaoHang.getDocument())) {
			if(textFieldDiaChiGiaoHang.getText().length()> 2) {
				lblMessDiaChiGiaoHang.setText("");
			}else
				lblMessDiaChiGiaoHang.setText("Chưa đúng định dạng !");
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
				lblMessNgayGiao.setText("Chưa đúng định dạng ! [dd-MM-yyyy]");
		}else if(src.equals(textFieldDiaChiGiaoHang.getDocument())) {
			if(textFieldDiaChiGiaoHang.getText().length()> 2) {
				lblMessDiaChiGiaoHang.setText("");
			}else
				lblMessDiaChiGiaoHang.setText("Chưa đúng định dạng !");
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
			if(a.getMa().equalsIgnoreCase(text)) {
				txtMaKH.setText(a.getMa());
				txtTenKH.setText(a.getTen());
				txtSDTKH.setText(a.getSdt());
				txtEmailKH.setText(a.getEmail());
				txtDCKH.setText(a.getDiaChi());
				return true;
			}
		}
		return false;
	}

	private boolean checkContainHD(String id) {
		for (HoaDon a : model.getList()) {
			if(a.getMaHD().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}

	private void uploadDB_NV_KH() {
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
				lblMessNgayGiao.setText("Chưa đúng định dạng ! [dd-MM-yyyy]");
		}else if(src.equals(textFieldDiaChiGiaoHang.getDocument())) {
			if(textFieldDiaChiGiaoHang.getText().length()> 2) {
				lblMessDiaChiGiaoHang.setText("");
			}else
				lblMessDiaChiGiaoHang.setText("Chưa đúng định dạng !");
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
			for (HoaDon x : model.getList()) {
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
		textFieldNgayGiao.setText(modelTable.getValueAt(n, 3)+"");
		textFieldDiaChiGiaoHang.setText(modelTable.getValueAt(n, 4)+"");
		
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

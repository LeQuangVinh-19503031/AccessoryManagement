package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import connectDB.ConnectDB;
import dao.DonHang_DAO;
import dao.HoaDonChiTiet_DAO;
import dao.LinhKien_DAO;
import model.DonHang;
import model.DonHangChiTiet;
import model.LinhKien;

import javax.swing.ScrollPaneConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JPanelChiTietDonHang extends JPanel implements DocumentListener{
	private JTable tableLinhKien;
	private JTable tableHoaDonChiTiet;
	@SuppressWarnings("serial")
	private DefaultTableModel modelTableHDCT = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 H\u00D3A \u0110\u01A0N", "M\u00C3 LINH KI\u1EC6N", "GI\u00C1 B\u00C1N", "S\u1ED0 L\u01AF\u1EE2NG", "GI\u1EA2M GI\u00C1", "TH\u00C0NH TI\u1EC0N"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	@SuppressWarnings("serial")
	private DefaultTableModel modelTableLK = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 LINH KI\u1EC6N", "T\u00CAN LINH KI\u1EC6N", "S\u1ED0 L\u01AF\u1EE2NG", "\u0110\u01A0N V\u1ECA T\u00CDNH"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};	
	
	@SuppressWarnings("serial")
	private DefaultTableModel modelTableDH = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3 H\u00D3A \u0110\u01A0N", "M\u00C3 KH\u00C1CH H\u00C0NG", "NG\u00C0Y L\u1EACP"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	private ArrayList<DonHangChiTiet> modelHDCT;
	private ArrayList<LinhKien> modelLK;
	private ArrayList<DonHang> modelDH;
	private JTextField textFieldTimMaDH;
	private JTextField txtMaHD;
	private JTextField txtMaLK;
	private JTextField txtGiaBan;
	private JTextField txtThanhTien;
	private JSpinner spinnerGiamGia;
	private JSpinner spinnerSoLuong;
	private JTable tableHoaDon;
	private JTextField textTimMaLK;
	/**
	 * Create the panel.
	 */
	public JPanelChiTietDonHang() {
		modelHDCT = new ArrayList<DonHangChiTiet>();
		modelLK = new ArrayList<LinhKien>();
		modelDH = new ArrayList<DonHang>();
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(10, 0, 1264, 53);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CHI TIẾT ĐƠN HÀNG");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 1264, 53);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 54));
		panel_3.setBackground(new Color(51, 51, 51));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mã đơn hàng");
		lblNewLabel_4.setBounds(10, 17, 88, 17);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_4);
		
		textFieldTimMaDH = new JTextField();
		textFieldTimMaDH.setBounds(108, 11, 83, 34);
		panel_3.add(textFieldTimMaDH);
		textFieldTimMaDH.setColumns(10);
		
		JButton btnInHan = new JButton("");
		btnInHan.setBounds(424, 5, 69, 45);
		btnInHan.setIcon(new ImageIcon(JPanelChiTietDonHang.class.getResource("/img/print_36px.png")));
		btnInHan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnInHan);
		
		JButton btnXaTrng = new JButton("");
		btnXaTrng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		btnXaTrng.setBounds(503, 5, 69, 45);
		btnXaTrng.setIcon(new ImageIcon(JPanelChiTietDonHang.class.getResource("/img/erase_36px.png")));
		btnXaTrng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnXaTrng);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capnhat();
			}
		});
		btnCpNht.setBounds(582, 5, 69, 45);
		btnCpNht.setIcon(new ImageIcon(JPanelChiTietDonHang.class.getResource("/img/renew_36px.png")));
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnCpNht);
		
		JButton btnXa = new JButton("");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoa();
			}
		});
		btnXa.setBounds(661, 5, 69, 45);
		btnXa.setIcon(new ImageIcon(JPanelChiTietDonHang.class.getResource("/img/minus_36px.png")));
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnXa);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnNewButton.setBounds(740, 5, 69, 45);
		btnNewButton.setIcon(new ImageIcon(JPanelChiTietDonHang.class.getResource("/img/add_36px.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_4_1 = new JLabel("Mã linh kiện");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(201, 17, 81, 17);
		panel_3.add(lblNewLabel_4_1);
		
		textTimMaLK = new JTextField();
		textTimMaLK.setColumns(10);
		textTimMaLK.setBounds(292, 11, 96, 34);
		panel_3.add(textTimMaLK);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		panel_1.add(splitPane_1, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		splitPane_1.setLeftComponent(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 165, 0));
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_5.add(panel_7, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("DANH SÁCH ĐƠN HÀNG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_7.add(lblNewLabel_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		panel_5.add(scrollPane_3, BorderLayout.CENTER);
		scrollPane_3.setPreferredSize(new Dimension(300, 300));
		
		tableHoaDon = new JTable();
		tableHoaDon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createInforForfileMaDH();
			}
		});
		tableHoaDon.setModel(modelTableDH);
		scrollPane_3.setViewportView(tableHoaDon);
		
		JPanel panel_6 = new JPanel();
		splitPane_1.setRightComponent(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 165, 0));
		FlowLayout flowLayout_1 = (FlowLayout) panel_8.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel_6.add(panel_8, BorderLayout.NORTH);
		
		JLabel lblNewLabel_6 = new JLabel("DANH SÁCH LINH KIỆN");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_8.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_6.add(scrollPane, BorderLayout.CENTER);
		
		tableLinhKien = new JTable();
		tableLinhKien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createInforForMaLK();
			}
		});
		tableLinhKien.setModel(modelTableLK);
		scrollPane.setViewportView(tableLinhKien);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 102));
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		tableHoaDonChiTiet = new JTable();
		tableHoaDonChiTiet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showInforInield();
			}
		});
		tableHoaDonChiTiet.setModel(modelTableHDCT);
		tableHoaDonChiTiet.getColumnModel().getColumn(0).setResizable(false);
		tableHoaDonChiTiet.getColumnModel().getColumn(0).setPreferredWidth(74);
		tableHoaDonChiTiet.getColumnModel().getColumn(1).setResizable(false);
		scrollPane_1.setViewportView(tableHoaDonChiTiet);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 0));
		FlowLayout flowLayout_2 = (FlowLayout) panel_9.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		panel_2.add(panel_9, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("DANH SÁCH HÓA ĐƠN CHI TIẾT");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_9.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 51));
		panel_4.setBounds(841, 63, 433, 360);
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		JTextPane txtpane = new JTextPane();
		scrollPane_2.setViewportView(txtpane);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 0, 128));
		FlowLayout flowLayout_3 = (FlowLayout) panel_10.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("PHIẾU HÓA ĐƠN");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		panel_10.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblNewLabel_5 = new JLabel("Mã hóa đơn");
		lblNewLabel_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(841, 433, 85, 24);
		add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("Mã linh kiện");
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(1060, 433, 100, 24);
		add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Giá bán");
		lblNewLabel_5_2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5_2.setBounds(841, 494, 85, 24);
		add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Số lượng");
		lblNewLabel_5_3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5_3.setBounds(1060, 578, 85, 24);
		add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("Giảm giá");
		lblNewLabel_5_4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5_4.setBounds(1060, 528, 100, 24);
		add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("Thành tiền");
		lblNewLabel_5_5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel_5_5.setBounds(841, 599, 85, 24);
		add(lblNewLabel_5_5);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(841, 467, 198, 27);
		add(txtMaHD);
		txtMaHD.setColumns(10);
		
		txtMaLK = new JTextField();
		txtMaLK.setColumns(10);
		txtMaLK.setBounds(1060, 467, 214, 27);
		add(txtMaLK);
		
		txtGiaBan = new JTextField();
		txtGiaBan.setColumns(20);
		txtGiaBan.setBounds(841, 528, 198, 27);
		add(txtGiaBan);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(841, 633, 433, 27);
		add(txtThanhTien);
		
		spinnerGiamGia = new JSpinner();
		spinnerGiamGia.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tinhThanhTien();
			}
		});
		spinnerGiamGia.setModel(new SpinnerNumberModel(0, 0, 100, 5));
		spinnerGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerGiamGia.setBounds(1170, 529, 104, 24);
		add(spinnerGiamGia);
		
		spinnerSoLuong = new JSpinner();
		spinnerSoLuong.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tinhThanhTien();
			}
		});
		spinnerSoLuong.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerSoLuong.setBounds(1171, 579, 103, 24);
		add(spinnerSoLuong);
		
		updateTable();
		
		this.setVisible(true);
		
		txtGiaBan.getDocument().addDocumentListener(this);
		
	}
	
	int soluongcu = 0;
	protected void capnhat() {
		// TODO Auto-generated method stub
		int n = tableHoaDonChiTiet.getSelectedRow();
		if(n>=0) {
			if(this.txtThanhTien.isEnabled()) {
				DonHangChiTiet a = new DonHangChiTiet();
				try {
					a.setGiaBan(Long.parseLong(txtGiaBan.getText()));
					a.setGiamGia(Integer.parseInt(spinnerGiamGia.getValue()+""));
					a.setGiaSauKhiGiam(Long.parseLong(txtThanhTien.getText()));
					a.setMaHoaDon(txtMaHD.getText());
					a.setMaLinhKien(txtMaLK.getText());
					a.setSoLuong(Integer.parseInt(spinnerSoLuong.getValue()+""));
				} catch (NumberFormatException e) {
					a = null;
					e.printStackTrace();
				}finally {
					if(a!=null) {
						int ch = JOptionPane.showConfirmDialog(null, "Cập nhật đơn hàng "+a.getMaHoaDon()+" \ncó mã linh kiện là : "+a.getMaLinhKien()+" ?", "Cập nhật", JOptionPane.YES_OPTION);
						if(ch == JOptionPane.YES_OPTION) {
							ConnectDB c = new ConnectDB();
							c.connect();
							HoaDonChiTiet_DAO.capNhat(a);
							int sl = soluonghienTai(a.getMaLinhKien());
							System.out.println(a.getSoLuong());
							if(a.getSoLuong()> soluongcu) {
								int x = a.getSoLuong() - soluongcu;
								System.out.println("X"+x);
								giamSoLuongLinhKien(a.getMaLinhKien(), sl-(a.getSoLuong()-soluongcu));
							}
							c.disconect();
							this.txtMaHD.setEnabled(true);
							this.txtMaLK.setEnabled(true);
							this.txtGiaBan.setEnabled(true);
							this.txtMaHD.setEnabled(true);
							this.txtThanhTien.setEnabled(true);
							this.spinnerGiamGia.setEnabled(true);
							this.spinnerSoLuong.setEnabled(true);
							xoaTrang();
							updateTable();
						}
					}
				}
			}else {
				soluongcu = Integer.parseInt(spinnerSoLuong.getValue()+"");
				System.out.println(soluongcu);
				this.txtMaHD.setEnabled(true);
				this.txtMaLK.setEnabled(true);
				this.txtGiaBan.setEnabled(true);
				this.txtMaHD.setEnabled(true);
				this.txtThanhTien.setEnabled(true);
				this.spinnerGiamGia.setEnabled(true);
				this.spinnerSoLuong.setEnabled(true);
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Chọn hàng trong danh sách \nhóa đơn chi tiết để cập nhật !");
		}
	}

	private void showInforInield() {
		// TODO Auto-generated method stub
		tableHoaDon.setRowSelectionAllowed(false);
		tableLinhKien.setRowSelectionAllowed(false);
		int n = tableHoaDonChiTiet.getSelectedRow();
		txtMaHD.setText(tableHoaDonChiTiet.getValueAt(n, 0)+"");
		txtMaLK.setText(tableHoaDonChiTiet.getValueAt(n, 1)+"");
		txtGiaBan.setText(tableHoaDonChiTiet.getValueAt(n, 2)+"");
		spinnerSoLuong.setValue(Integer.parseInt(tableHoaDonChiTiet.getValueAt(n, 3)+""));
		spinnerGiamGia.setValue(Integer.parseInt(tableHoaDonChiTiet.getValueAt(n, 4)+""));
		txtThanhTien.setText(tableHoaDonChiTiet.getValueAt(n, 5)+"");
		
		this.txtMaHD.setEnabled(false);
		this.txtMaLK.setEnabled(false);
		this.txtGiaBan.setEnabled(false);
		this.txtMaHD.setEnabled(false);
		this.txtThanhTien.setEnabled(false);
		this.spinnerGiamGia.setEnabled(false);
		this.spinnerSoLuong.setEnabled(false);
	}

	protected void xoa() {
		// TODO Auto-generated method stub
		int n = tableHoaDonChiTiet.getSelectedRow();
		if(n>=0) {
			DonHangChiTiet a = new DonHangChiTiet();
			try {
				a.setMaHoaDon(tableHoaDonChiTiet.getValueAt(n, 0)+"");
				a.setMaLinhKien(tableHoaDonChiTiet.getValueAt(n, 1)+"");
				a.setGiaBan(Long.parseLong(tableHoaDonChiTiet.getValueAt(n, 2)+""));
				a.setSoLuong(Integer.parseInt(tableHoaDonChiTiet.getValueAt(n, 3)+""));
				a.setGiamGia(Integer.parseInt(tableHoaDonChiTiet.getValueAt(n, 4)+""));
				a.setGiaSauKhiGiam(Long.parseLong(tableHoaDonChiTiet.getValueAt(n, 5)+""));
			} catch (NumberFormatException e) {
				a = null;
				e.printStackTrace();
			}finally {
				if(a!=null) {
					int choose = JOptionPane.showConfirmDialog(null, "Xóa hóa đơn có "+a.getMaHoaDon()+", "+a.getMaLinhKien()+" ?", "Xác nhận xóa", JOptionPane.YES_OPTION);
					if(choose == JOptionPane.YES_OPTION) {
						ConnectDB c = new ConnectDB();
						c.connect();
						HoaDonChiTiet_DAO.xoaCTDH(a.getMaHoaDon(), a.getMaLinhKien());
						c.disconect();
						updateTable();
					}
				}
				xoaTrang();
			}
		}else {
			JOptionPane.showMessageDialog(null, "Chọn hàng cần xóa !");
		}
	}

	@SuppressWarnings("unused")
	protected void them() {
		if(!txtGiaBan.getText().equals("") 
				&& !txtMaHD.getText().equals("") 
				&& !txtMaLK.getText().equals("")) 
		{
			DonHangChiTiet a = new DonHangChiTiet();
			try {
				a.setGiaBan(Long.parseLong(txtGiaBan.getText()));
				a.setGiamGia(Integer.parseInt(spinnerGiamGia.getValue()+""));
				a.setGiaSauKhiGiam(Long.parseLong(txtThanhTien.getText()));
				a.setMaHoaDon(txtMaHD.getText());
				a.setMaLinhKien(txtMaLK.getText());
				a.setSoLuong(Integer.parseInt(spinnerSoLuong.getValue()+""));
			} catch (NumberFormatException e) {
				a = null;
				e.printStackTrace();
			}finally {
				int sl = soluonghienTai(a.getMaLinhKien());
				if(a!=null) {
					ConnectDB con = new ConnectDB();
					con.connect();
					boolean res = HoaDonChiTiet_DAO.insert(a);
					con.disconect();
					if(res) {
						updateTable();
						giamSoLuongLinhKien(a.getMaLinhKien(), sl-a.getSoLuong());
						
						xoaTrang();
						JOptionPane.showMessageDialog(null, "THÊM THÀNH CÔNG");
						this.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Bạn có thể cập nhật số lượng tại "+a.getMaHoaDon()+", "+a.getMaLinhKien()+" !");
						
					}
				}
			}
		} else
			JOptionPane.showMessageDialog(null, "Chưa đủ thông tin !");
		
	}

	private Integer soluonghienTai(String ma) {
		for (LinhKien a : modelLK) {
			if(a.getMa().equalsIgnoreCase(ma))
				return a.getSoLuongTon();
		}
		return null;
		
	}

	private void xoaTrang() {
		txtMaHD.setText("");
		txtMaLK.setText("");
		txtThanhTien.setText("");
		txtGiaBan.setText("");
		spinnerGiamGia.setValue(0);
		spinnerSoLuong.setValue(1);
		tableHoaDonChiTiet.setSelectionMode(0);
		tableHoaDon.setSelectionMode(0);
		tableLinhKien.setSelectionMode(0);
		
		this.txtMaHD.setEnabled(true);
		this.txtMaLK.setEnabled(true);
		
		tableHoaDon.setRowSelectionAllowed(true);
		tableLinhKien.setRowSelectionAllowed(true);
	}

	private void giamSoLuongLinhKien(String maLK, int soluong) {
		ConnectDB c = new ConnectDB();
		c.connect();
		LinhKien_DAO.giamSoluongLK(maLK, soluong);
		c.disconect();
	}

	protected void createInforForMaLK() {
		int n = tableLinhKien.getSelectedRow();
		txtMaLK.setText(modelTableLK.getValueAt(n, 0)+"");
		long gia1DVT = searchPriceOf_LK(modelTableLK.getValueAt(n, 0)+"").getGiaBan();
		txtGiaBan.setText(gia1DVT+"");
	}
	private LinhKien searchPriceOf_LK(String string) {
		for (LinhKien a : modelLK) {
			if(a.getMa().equalsIgnoreCase(string))
				return a;
		}
		return null;
		
	}
	protected void createInforForfileMaDH() {
		int n = tableHoaDon.getSelectedRow();
		txtMaHD.setText(tableHoaDon.getValueAt(n, 0)+"");
	}
	private void updateTable() {
		uploadHDCT_LK();
		modelTableHDCT.setRowCount(0);
		for (DonHangChiTiet a : modelHDCT) {
			modelTableHDCT.addRow(new Object[] {
					a.getMaHoaDon(),
					a.getMaLinhKien(),
					a.getGiaBan(),
					a.getSoLuong(),
					a.getGiamGia(),
					a.getGiaSauKhiGiam()
			});
		}
		modelTableLK.setRowCount(0);
		for (LinhKien a : modelLK) {
			modelTableLK.addRow(new Object[] {
				a.getMa(),
				a.getTen(),
				a.getSoLuongTon(),
				a.getDonViTinh()
			});
		}
		modelTableDH.setRowCount(0);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		for (DonHang a : modelDH) {
			modelTableDH.addRow(new Object[] {
				a.getMaHD(),
				a.getMaKH(),
				df.format(a.getNgayLapHD())
			});
		}
		
	}
	
	
	private void uploadHDCT_LK() {
		ConnectDB c = new ConnectDB();
		c.connect();
		modelHDCT = HoaDonChiTiet_DAO.getAllFromDB();
		modelLK = LinhKien_DAO.getAllHoaDonFromDB();
		modelDH = DonHang_DAO.getAllHoaDonFromDB();
		c.disconect();
		
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		if(src.equals(txtGiaBan.getDocument())) {
			tinhThanhTien();
		}
		
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
	}
	private void tinhThanhTien() {
		
		if(!txtGiaBan.getText().equals("")) {
			int soluong = Integer.parseInt(spinnerSoLuong.getValue()+"");
			int giamgia = Integer.parseInt(spinnerGiamGia.getValue()+"");
			LinhKien a = searchPriceOf_LK(txtMaLK.getText());
			long thanhtien = a.getGiaBan()*soluong;
			thanhtien -= ((thanhtien/100)*giamgia);
			txtThanhTien.setText(thanhtien+"");
		}
			
	}
}

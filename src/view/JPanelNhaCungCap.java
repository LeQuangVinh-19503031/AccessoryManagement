package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import model.NhaCungCap;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class JPanelNhaCungCap extends JPanel implements DocumentListener, MouseListener{
	private JTextField textFieldTim;
	private JTable table_1;
	private DefaultTableModel modelTable = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3", "T\u00CAN", "EMAIL", "SDT", "\u0110\u1ECAA CH\u1EC8"
			}
		);
	
	private JTextField textFieldMa;
	private JTextField textFieldTen;
	private JTextField textFieldEmail;
	private JTextField textFieldSdt;
	private JTextField textFieldDiaChi;
	private JLabel lblMessMa, lblMessTen, lblMessEmail, lblMessSdt, lblMessDiaChi;
	private JButton btnThem, btnCapNhat, btnXoa, btnXoaTrang;
	private ArrayList<NhaCungCap> model;
	private JPanel panel;
	private JLabel lblNewLabel_3;
	private JPanel panel_chucnang;
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1_1;
	private JTextField textField;
	private JPanel panel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	/**
	 * @wbp.nonvisual location=164,104
	 */

	/**
	 * Create the panel.
	 */
	public JPanelNhaCungCap() {
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1285, 53);
		add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("NHÀ CUNG CẤP");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel);
		
		JPanel panelTable = new JPanel();
		panelTable.setBackground(new Color(192, 192, 192));
		panelTable.setAutoscrolls(true);
		panelTable.setBorder(null);
		panelTable.setBounds(284, 63, 991, 390);
		add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 25, 991, 365);
		scrollPane.setBackground(new Color(204, 255, 255));
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		panelTable.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table_1);
		table_1.setModel(modelTable);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1265, 25);
		panel.setBackground(new Color(255, 69, 0));
		panelTable.add(panel);
		panel.setLayout(null);
		
		lblNewLabel_3 = new JLabel("DANH SÁCH NHÀ CUNG CẤP");
		lblNewLabel_3.setBounds(5, 5, 977, 15);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblNewLabel_3);
		table_1.addMouseListener(this);
		
		panel_chucnang = new JPanel();
		panel_chucnang.setBorder(null);
		panel_chucnang.setBackground(new Color(204, 204, 204));
		panel_chucnang.setBounds(10, 63, 264, 390);
		add(panel_chucnang);
		panel_chucnang.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 69, 0));
		panel_chucnang.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		lblNewLabel_4 = new JLabel("CHỨC NĂNG");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel_1.add(lblNewLabel_4);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(200, 160));
		panel_2.setBackground(new Color(204, 204, 204));
		panel_chucnang.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setPreferredSize(new Dimension(250, 180));
		panel_3.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "L\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(new Color(204, 204, 204));
		panel_3.setBounds(10, 183, 244, 175);
		panel_2.add(panel_3);
		
		lblNewLabel_5 = new JLabel("MÃ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 20, 224, 27);
		panel_3.add(lblNewLabel_5);
		
		lblNewLabel_1_1 = new JLabel("TÊN");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 93, 224, 27);
		panel_3.add(lblNewLabel_1_1);
		
		textFieldTim = new JTextField();
		textFieldTim.setBounds(10, 51, 224, 32);
		panel_3.add(textFieldTim);
		textFieldTim.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(10, 130, 224, 32);
		panel_3.add(textField);
		
		textFieldTim.getDocument().addDocumentListener(this);
		
		btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon(JPanelNhaCungCap.class.getResource("/img/add_36px.png")));
		btnThem.setBounds(10, 10, 70, 70);
		panel_2.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNhaCungCap();
			}
			
		});
		btnThem.setToolTipText("Thêm nhà cung cấp");
		
		btnCapNhat = new JButton("");
		btnCapNhat.setIcon(new ImageIcon(JPanelNhaCungCap.class.getResource("/img/update_36px.png")));
		btnCapNhat.setBounds(10, 90, 70, 70);
		panel_2.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				capNhatNhaCungCap();
			}

		});
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		
		btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(JPanelNhaCungCap.class.getResource("/img/minus_36px.png")));
		btnXoa.setBounds(90, 10, 70, 70);
		panel_2.add(btnXoa);
		
		btnXoaTrang = new JButton("");
		btnXoaTrang.setIcon(new ImageIcon(JPanelNhaCungCap.class.getResource("/img/erase_36px.png")));
		btnXoaTrang.setBounds(90, 90, 70, 70);
		panel_2.add(btnXoaTrang);
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(192, 192, 192));
		panel_4.setBounds(10, 463, 1265, 223);
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelThongTin = new JPanel();
		panel_4.add(panelThongTin, BorderLayout.CENTER);
		panelThongTin.setBorder(null);
		panelThongTin.setBackground(new Color(192, 192, 192));
		panelThongTin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhà cung cấp");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(57, 29, 143, 32);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên nhà cung cấp");
		lblNewLabel_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(642, 29, 143, 32);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(57, 92, 143, 32);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Số điện thoại");
		lblNewLabel_2_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(642, 88, 143, 32);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Địa chỉ");
		lblNewLabel_2_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(57, 151, 143, 32);
		panelThongTin.add(lblNewLabel_2_2_2);
		
		textFieldMa = new JTextField();
		textFieldMa.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMa.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMa.setBounds(210, 30, 386, 32);
		panelThongTin.add(textFieldMa);
		textFieldMa.setColumns(10);
		
		textFieldMa.getDocument().addDocumentListener(this);
		
		textFieldTen = new JTextField();
		textFieldTen.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldTen.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldTen.setColumns(10);
		textFieldTen.setBounds(795, 30, 386, 32);
		panelThongTin.add(textFieldTen);
		
		textFieldTen.getDocument().addDocumentListener(this);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(210, 90, 386, 32);
		panelThongTin.add(textFieldEmail);
		
		textFieldEmail.getDocument().addDocumentListener(this);
		
		textFieldSdt = new JTextField();
		textFieldSdt.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldSdt.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldSdt.setColumns(10);
		textFieldSdt.setBounds(795, 91, 386, 32);
		panelThongTin.add(textFieldSdt);
		
		textFieldSdt.getDocument().addDocumentListener(this);
		
		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldDiaChi.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(210, 152, 386, 32);
		panelThongTin.add(textFieldDiaChi);
		
		lblMessDiaChi = new JLabel("");
		lblMessDiaChi.setBounds(210, 121, 386, 32);
		panelThongTin.add(lblMessDiaChi);
		lblMessDiaChi.setForeground(new Color(255, 0, 0));
		
		lblMessSdt = new JLabel("");
		lblMessSdt.setBounds(795, 59, 386, 32);
		panelThongTin.add(lblMessSdt);
		lblMessSdt.setForeground(new Color(255, 0, 0));
		
		lblMessEmail = new JLabel("");
		lblMessEmail.setBounds(210, 59, 386, 32);
		panelThongTin.add(lblMessEmail);
		lblMessEmail.setForeground(new Color(255, 0, 0));
		
		lblMessTen = new JLabel("");
		lblMessTen.setBounds(795, -2, 386, 32);
		panelThongTin.add(lblMessTen);
		lblMessTen.setForeground(new Color(255, 0, 0));
		
		lblMessMa = new JLabel("");
		lblMessMa.setBounds(210, -2, 386, 32);
		panelThongTin.add(lblMessMa);
		lblMessMa.setForeground(new Color(255, 0, 0));
		
		panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 69, 0));
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_4.add(panel_5, BorderLayout.NORTH);
		
		lblNewLabel_1 = new JLabel("THÔNG TIN NHÀ CUNG CẤP");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblNewLabel_1);
		
		textFieldDiaChi.getDocument().addDocumentListener(this);
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		
		model = new ArrayList<NhaCungCap>();
		updateTable();
		
	}
	
	private void updateTable() {
		uploadDB();
		modelTable.setRowCount(0);
		for (NhaCungCap a : model) {
			modelTable.addRow(new Object[] {
					a.getMa(),
					a.getTen(),
					a.getEmail(),
					a.getSdt(),
					a.getDiaChi()
			});
		}
	
	}

	private void uploadDB() {
		ConnectDB con = new ConnectDB();
		con.connect();
		model=NhaCungCap_DAO.getAllFromDB();
		con.disconect();
	}
	
	public void jTextFieldEditable(boolean choose) {
		textFieldMa.setEditable(choose);
		textFieldTen.setEditable(choose);
		textFieldEmail.setEditable(choose);
		textFieldSdt.setEditable(choose);
		textFieldDiaChi.setEditable(choose);
		
		
	}
	
	private boolean checkfieldHopLe() {
		
		if(!textFieldMa.getText().matches("\\w+")) {
			lblMessMa.setText("Lỗi mã nhà cung cấp !");
			return false;
		} else
			lblMessMa.setText("");
		
		if(textFieldTen.getText().length() < 2){
			lblMessTen.setText("Lỗi tên nhà cung cấp !");
			return false;
		} else 
			lblMessTen.setText("");
		
		if(textFieldEmail.getText().length() < 2) {
			lblMessEmail.setText("Lỗi email nhà cung cấp !");
			return false;
		}else 
			lblMessEmail.setText("");
		
		if(!textFieldSdt.getText().matches("\\d+")) {
			lblMessSdt.setText("Lỗi số điện thoại nhà cung cấp !");
			return false;
		}else
			lblMessSdt.setText("");
		
		if(textFieldDiaChi.getText().length() < 3) {
			lblMessDiaChi.setText("Lỗi địa chỉ nhà cung cấp !");
			return false;
		} else
			lblMessDiaChi.setText("");
		return true;

	}
	
	public void themNhaCungCap() {
		NhaCungCap a = new NhaCungCap();
		if(!textFieldMa.isEditable()) {			
			jTextFieldEditable(true);
			this.textFieldMa.setEditable(true);
		}else {
			if(checkfieldHopLe()) {
				jTextFieldEditable(false);
				try {
					a.setMa(textFieldMa.getText().toUpperCase());
					a.setTen(textFieldTen.getText().toUpperCase());
					a.setEmail(textFieldEmail.getText());
					a.setSdt(textFieldSdt.getText());
					a.setDiaChi(textFieldDiaChi.getText().toUpperCase());
				} catch (Exception e) {
					a = null;
					e.printStackTrace();
				} finally {
					if(a!=null) {
						ConnectDB con = new ConnectDB();
						con.connect();
						boolean res = NhaCungCap_DAO.insertNCC(a);
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
			if(textFieldSdt.isEditable()) {
				jButtomEnableForUpdate(true);
				this.btnXoa.setEnabled(true);
				try {
					
					a.setMa(textFieldMa.getText().toUpperCase());
					a.setTen(textFieldTen.getText().toUpperCase());
					a.setEmail(textFieldEmail.getText());
					a.setSdt(textFieldSdt.getText());
					a.setDiaChi(textFieldDiaChi.getText().toUpperCase());
					
				} catch (Exception e) {
					e.printStackTrace();
					a = null;
				}finally {
					
					if(a!=null) {
						
						int confirm = JOptionPane.showConfirmDialog(null, "Cập nhật nhà cung cấp "+a.getMa(), "Cập nhật", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							
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
				this.textFieldMa.setEditable(false);
			}
		else {
			JOptionPane.showMessageDialog(null, "CHỌN 1 HÀNG ĐỂ DÙNG CHỨC NĂNG SỬA !");
		}		
	}

	private void xoaTrang() {
		textFieldMa.setText("");
		textFieldTen.setText("");
		textFieldEmail.setText("");
		textFieldSdt.setText("");
		textFieldDiaChi.setText("");
			lblMessMa.setText("");
			lblMessTen.setText("");
			lblMessEmail.setText("");
			lblMessSdt.setText("");
			lblMessDiaChi.setText("");
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textFieldMa.getDocument())) {
			if(textFieldMa.getText().length() > 2 && textFieldMa.getText().toUpperCase().matches("[A-Z0-9]+([-]*[A-Z0-9]+)*")) {
				lblMessMa.setText("");
			}else
				lblMessMa.setText("Chưa đúng định đạng !");
		}else if(src.equals(textFieldTen.getDocument())) {
			if(textFieldTen.getText().length()> 2) {
				lblMessTen.setText("");
			}else
				lblMessTen.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldEmail.getDocument())) {
			if(textFieldEmail.getText().length()> 1  && textFieldEmail.getText().contains("@") && textFieldEmail.getText().contains(".")) {
				lblMessEmail.setText("");
			}else
				lblMessEmail.setText("Chưa đúng định dạng !");
		} else if(src.equals(textFieldSdt.getDocument())) {
			if(textFieldSdt.getText().matches("[+]*\\d+[-]*\\d+") && textFieldSdt.getText().length() > 7 && textFieldSdt.getText().length() < 15) {
				lblMessSdt.setText("");
			}else
				lblMessSdt.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldDiaChi.getDocument())) {
			if(textFieldDiaChi.getText().length()> 2) {
				lblMessDiaChi.setText("");
			}else
				lblMessDiaChi.setText("Chưa đúng định dạng !");
		}
		
		if(!textFieldDiaChi.isEditable()) {
			lblMessMa.setText("");
			lblMessTen.setText("");
			lblMessEmail.setText("");
			lblMessSdt.setText("");
			lblMessDiaChi.setText("");
		}
		
		if(src.equals(textFieldTim.getDocument())) {
			timKiemMa();
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textFieldMa.getDocument())) {
			if(textFieldMa.getText().length() > 2 && textFieldMa.getText().toUpperCase().matches("[A-Z0-9]+([-]*[A-Z0-9]+)*")) {
				lblMessMa.setText("");
			}else
				lblMessMa.setText("Chưa đúng định đạng !");
		}else if(src.equals(textFieldTen.getDocument())) {
			if(textFieldTen.getText().length()> 2) {
				lblMessTen.setText("");
			}else
				lblMessTen.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldEmail.getDocument())) {
			if(textFieldEmail.getText().length()> 1  && textFieldEmail.getText().contains("@") && textFieldEmail.getText().contains(".")) {
				lblMessEmail.setText("");
			}else
				lblMessEmail.setText("Chưa đúng định dạng !");
		} else if(src.equals(textFieldSdt.getDocument())) {
			if(textFieldSdt.getText().matches("[+]*\\d+[-]*\\d+") && textFieldSdt.getText().length() > 7 && textFieldSdt.getText().length() < 15) {
				lblMessSdt.setText("");
			}else
				lblMessSdt.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldDiaChi.getDocument())) {
			if(textFieldDiaChi.getText().length()> 2) {
				lblMessDiaChi.setText("");
			}else
				lblMessDiaChi.setText("Chưa đúng định dạng !");
		}
		
		if(src.equals(textFieldTim.getDocument())) {
			timKiemMa();
		}
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textFieldMa.getDocument())) {
			if(textFieldMa.getText().length() > 2 && textFieldMa.getText().toUpperCase().matches("[A-Z0-9]+([-]*[A-Z0-9]+)*")) {
				lblMessMa.setText("");
			}else
				lblMessMa.setText("Chưa đúng định đạng !");
		}else if(src.equals(textFieldTen.getDocument())) {
			if(textFieldTen.getText().length()> 2) {
				lblMessTen.setText("");
			}else
				lblMessTen.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldEmail.getDocument())) {
			if(textFieldEmail.getText().length()> 1  && textFieldEmail.getText().contains("@") && textFieldEmail.getText().contains(".")) {
				lblMessEmail.setText("");
			}else
				lblMessEmail.setText("Chưa đúng định dạng !");
		} else if(src.equals(textFieldSdt.getDocument())) {
			if(textFieldSdt.getText().matches("[+]*\\d+[-]*\\d+") && textFieldSdt.getText().length() > 7 && textFieldSdt.getText().length() < 15 ) {
				lblMessSdt.setText("");
			}else
				lblMessSdt.setText("Chưa đúng định dạng !");
		}else if(src.equals(textFieldDiaChi.getDocument())) {
			if(textFieldDiaChi.getText().length()> 2) {
				lblMessDiaChi.setText("");
			}else
				lblMessDiaChi.setText("Chưa đúng định dạng !");
		}
		
		if(src.equals(textFieldTim.getDocument())) {
			timKiemMa();
		}
		
	}
	
	public void timKiemMa() {
		xoaTrang();
		String a = textFieldTim.getText();
		if(a.length() == 0) {
			updateTable();
			this.setVisible(true);
		}else {
			modelTable.setRowCount(0);
			for (NhaCungCap x : model) {
				if(x.getMa().toUpperCase().contains(a.toUpperCase())) {
					modelTable.addRow(new Object[] {
							x.getMa(),
							x.getTen(),
							x.getEmail(),
							x.getSdt(),
							x.getDiaChi()
					});
				}
			}
		}
		this.setVisible(true);
	}
	
	public void showInforIntoTextFiled() {
		
		jTextFieldEditable(false);
		this.textFieldMa.setEditable(false);
		int n = table_1.getSelectedRow();
		textFieldMa.setText(modelTable.getValueAt(n, 0)+"");
		textFieldTen.setText(modelTable.getValueAt(n, 1)+"");
		textFieldEmail.setText(modelTable.getValueAt(n, 2)+"");
		textFieldSdt.setText(modelTable.getValueAt(n, 3)+"");
		textFieldDiaChi.setText(modelTable.getValueAt(n, 4)+"");
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

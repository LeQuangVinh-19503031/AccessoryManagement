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
import dao.HoaDon_DAO;
import dao.NhaCungCap_DAO;
import model.HoaDon;
import model.ModelListNhaCungCap;
import model.NhaCungCap;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.ListSelectionModel;
import java.awt.ComponentOrientation;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Component;

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
	private ModelListNhaCungCap model;
	/**
	 * @wbp.nonvisual location=164,104
	 */

	/**
	 * Create the panel.
	 */
	public JPanelNhaCungCap() {
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1285, 53);
		add(panelTitle);
		panelTitle.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("NHÀ CUNG CẤP");
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNang.setBackground(new Color(204, 255, 255));
		panelChucNang.setBounds(94, 367, 588, 78);
		add(panelChucNang);
		panelChucNang.setLayout(null);
		
		btnThem = new JButton("THÊM");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				themNhaCungCap();
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
		panelTable.setBorder(new TitledBorder(null, "DANH S\u00C1CH NH\u00C0 CUNG C\u1EA4P", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTable.setBounds(10, 63, 1265, 294);
		add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 255, 255));
		scrollPane.setBounds(10, 21, 1245, 262);
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		panelTable.add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table_1);
		table_1.setModel(modelTable);
		table_1.addMouseListener(this);
		
		
		JPanel panelThongTin = new JPanel();
		panelThongTin.setBorder(new TitledBorder(null, "TH\u00D4NG TIN NH\u00C0 CUNG C\u1EA4P", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTin.setBackground(new Color(204, 255, 255));
		panelThongTin.setBounds(94, 455, 1004, 242);
		add(panelThongTin);
		panelThongTin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mã nhà cung cấp");
		lblNewLabel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(30, 23, 143, 32);
		panelThongTin.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Tên nhà cung cấp");
		lblNewLabel_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(30, 68, 143, 32);
		panelThongTin.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(30, 113, 143, 32);
		panelThongTin.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Số điện thoại");
		lblNewLabel_2_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_1.setBounds(30, 155, 143, 32);
		panelThongTin.add(lblNewLabel_2_2_1);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Địa chỉ");
		lblNewLabel_2_2_2.setAlignmentY(Component.TOP_ALIGNMENT);
		lblNewLabel_2_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2_2.setBounds(30, 197, 143, 32);
		panelThongTin.add(lblNewLabel_2_2_2);
		
		textFieldMa = new JTextField();
		textFieldMa.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldMa.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldMa.setBounds(183, 23, 386, 32);
		panelThongTin.add(textFieldMa);
		textFieldMa.setColumns(10);
		
		textFieldMa.getDocument().addDocumentListener(this);
		
		textFieldTen = new JTextField();
		textFieldTen.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldTen.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldTen.setColumns(10);
		textFieldTen.setBounds(183, 68, 386, 32);
		panelThongTin.add(textFieldTen);
		
		textFieldTen.getDocument().addDocumentListener(this);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldEmail.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(183, 113, 386, 32);
		panelThongTin.add(textFieldEmail);
		
		textFieldEmail.getDocument().addDocumentListener(this);
		
		textFieldSdt = new JTextField();
		textFieldSdt.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldSdt.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldSdt.setColumns(10);
		textFieldSdt.setBounds(183, 158, 386, 32);
		panelThongTin.add(textFieldSdt);
		
		textFieldSdt.getDocument().addDocumentListener(this);
		
		textFieldDiaChi = new JTextField();
		textFieldDiaChi.setAlignmentY(Component.TOP_ALIGNMENT);
		textFieldDiaChi.setAlignmentX(Component.LEFT_ALIGNMENT);
		textFieldDiaChi.setColumns(10);
		textFieldDiaChi.setBounds(183, 200, 386, 32);
		panelThongTin.add(textFieldDiaChi);
		
		textFieldDiaChi.getDocument().addDocumentListener(this);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "KI\u1EC2M TRA L\u1ED6I", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(600, 0, 404, 242);
		panelThongTin.add(panel);
		
		lblMessMa = new JLabel("");
		lblMessMa.setForeground(new Color(255, 0, 0));
		lblMessMa.setBounds(20, 23, 361, 32);
		panel.add(lblMessMa);
		
		lblMessTen = new JLabel("");
		lblMessTen.setForeground(new Color(255, 0, 0));
		lblMessTen.setBounds(20, 68, 361, 32);
		panel.add(lblMessTen);
		
		lblMessEmail = new JLabel("");
		lblMessEmail.setForeground(new Color(255, 0, 0));
		lblMessEmail.setBounds(20, 113, 361, 32);
		panel.add(lblMessEmail);
		
		lblMessSdt = new JLabel("");
		lblMessSdt.setForeground(new Color(255, 0, 0));
		lblMessSdt.setBounds(20, 158, 361, 32);
		panel.add(lblMessSdt);
		
		lblMessDiaChi = new JLabel("");
		lblMessDiaChi.setForeground(new Color(255, 0, 0));
		lblMessDiaChi.setBounds(20, 200, 361, 32);
		panel.add(lblMessDiaChi);
		
		JPanel panelChucNangNhanh = new JPanel();
		panelChucNangNhanh.setBackground(new Color(204, 255, 255));
		panelChucNangNhanh.setBorder(new TitledBorder(null, "CH\u1EE8C N\u0102NG NHANH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChucNangNhanh.setBounds(692, 367, 406, 78);
		add(panelChucNangNhanh);
		panelChucNangNhanh.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TÌM KIẾM MÃ");
		lblNewLabel_1.setBounds(10, 26, 118, 38);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panelChucNangNhanh.add(lblNewLabel_1);
		
		textFieldTim = new JTextField();
		textFieldTim.setBounds(138, 27, 226, 38);
		panelChucNangNhanh.add(textFieldTim);
		textFieldTim.setColumns(10);
		
		textFieldTim.getDocument().addDocumentListener(this);
		
		model = new ModelListNhaCungCap();
		updateTable();
		
	}
	
	private void updateTable() {
		uploadDB();
		modelTable.setRowCount(0);
		for (NhaCungCap a : model.getList()) {
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
		model.setList(NhaCungCap_DAO.getAllFromDB());
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
			for (NhaCungCap x : model.getList()) {
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

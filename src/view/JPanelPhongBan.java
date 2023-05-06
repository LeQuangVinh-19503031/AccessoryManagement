package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import dao.PhongBan_DAO;
import model.NhaCungCap;
import model.PhongBan;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class JPanelPhongBan extends JPanel implements DocumentListener, MouseListener{
	private JTextField textLocMa;
	private JTextField textLocTen;
	private JTable table;
	private DefaultTableModel modelTable = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"M\u00E3 ph\u00F2ng ban", "T\u00EAn ph\u00F2ng ban"
					}
			);
	private JTextField textMaPB;
	private JTextField textTenPB;
	private ArrayList<PhongBan> model;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnCapNhat;
	private JButton btnXoaTrang;
	private JLabel lblMessMaPB;
	private JLabel lblMessTenPB;
	
	/**
	 * Create the panel.
	 */
	public JPanelPhongBan() {
		setBackground(new Color(64, 224, 208));
		setForeground(new Color(0, 0, 0));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1286, 53);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PHÒNG BAN");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1286, 53);
		panel.add(lblNewLabel);

		JPanel panel_chucnang = new JPanel();
		panel_chucnang.setLayout(null);
		panel_chucnang.setBorder(null);
		panel_chucnang.setBackground(new Color(204, 204, 204));
		panel_chucnang.setBounds(10, 63, 264, 674);
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
		panel_4_1.setBounds(0, 29, 264, 645);
		panel_chucnang.add(panel_4_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setPreferredSize(new Dimension(250, 180));
		panel_1_2.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "L\u1ECCC", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_2.setBackground(new Color(204, 204, 204));
		panel_1_2.setBounds(10, 170, 244, 465);
		panel_4_1.add(panel_1_2);
		
		JLabel lblNewLabel_1 = new JLabel("MÃ PHÒNG BAN");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 27, 103, 13);
		panel_1_2.add(lblNewLabel_1);
		
		textLocMa = new JTextField();
		textLocMa.setColumns(10);
		textLocMa.setBounds(10, 50, 224, 37);
		panel_1_2.add(textLocMa);
		
		JLabel lblNewLabel_1_1 = new JLabel("TÊN");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 97, 79, 13);
		panel_1_2.add(lblNewLabel_1_1);
		
		textLocTen = new JTextField();
		textLocTen.setColumns(10);
		textLocTen.setBounds(10, 119, 224, 37);
		panel_1_2.add(textLocTen);
		
		btnThem = new JButton("");
		btnThem.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/add_36px.png")));
		btnThem.setToolTipText("Thêm nhà cung cấp");
		btnThem.setPreferredSize(new Dimension(140, 40));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBounds(10, 10, 70, 70);
		panel_4_1.add(btnThem);
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		
		btnXoa = new JButton("");
		btnXoa.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/minus_36px.png")));
		btnXoa.setPreferredSize(new Dimension(140, 40));
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoa.setBounds(90, 10, 70, 70);
		panel_4_1.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		
		btnCapNhat = new JButton("");
		btnCapNhat.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/updateLK_36px.png")));
		btnCapNhat.setToolTipText("Cập nhật thông tin");
		btnCapNhat.setPreferredSize(new Dimension(140, 40));
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBounds(170, 10, 70, 70);
		panel_4_1.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		
		btnXoaTrang = new JButton("");
		btnXoaTrang.setIcon(new ImageIcon(JPanelLoaiLinhKien.class.getResource("/img/erase_36px.png")));
		btnXoaTrang.setPreferredSize(new Dimension(140, 40));
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnXoaTrang.setBounds(10, 90, 70, 70);
		panel_4_1.add(btnXoaTrang);
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		
		JPanel panelTable = new JPanel();
		panelTable.setBorder(null);
		panelTable.setBackground(new Color(204, 255, 255));
		panelTable.setAutoscrolls(true);
		panelTable.setBounds(284, 63, 991, 294);
		add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panelTable.add(panel_7, BorderLayout.NORTH);
		panel_7.setBackground(new Color(255, 102, 51));
		
		JLabel lblNewLabel_9 = new JLabel("DANH SÁCH PHÒNG BAN");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_7.add(lblNewLabel_9);
		
		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(new Color(204, 255, 255));
		
		table = new JTable();
		table.setModel(modelTable);
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);
		
		JPanel panel_inforKH = new JPanel();
		panel_inforKH.setLayout(null);
		panel_inforKH.setBorder(null);
		panel_inforKH.setBackground(new Color(204, 204, 204));
		panel_inforKH.setBounds(284, 367, 629, 181);
		add(panel_inforKH);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(new Color(255, 51, 51));
		panel_6.setBounds(0, 0, 1266, 30);
		panel_inforKH.add(panel_6);
		
		JLabel lblNewLabel_4 = new JLabel("THÔNG TIN PHÒNG BAN");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(5, 5, 979, 20);
		panel_6.add(lblNewLabel_4);
		
		JPanel panel_7_1 = new JPanel();
		panel_7_1.setBackground(new Color(192, 192, 192));
		panel_7_1.setLayout(null);
		panel_7_1.setBounds(0, 30, 629, 150);
		panel_inforKH.add(panel_7_1);
		
		JLabel lblNewLabel_5 = new JLabel("Mã phòng ban");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 10, 100, 28);
		panel_7_1.add(lblNewLabel_5);
		
		textMaPB = new JTextField();
		textMaPB.setColumns(10);
		textMaPB.setBounds(10, 38, 609, 28);
		panel_7_1.add(textMaPB);
		
		lblMessMaPB = new JLabel("");
		lblMessMaPB.setForeground(Color.RED);
		lblMessMaPB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessMaPB.setBounds(111, 10, 508, 28);
		panel_7_1.add(lblMessMaPB);
		
		JLabel lblNewLabel_5_1 = new JLabel("Tên phòng ban");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5_1.setBounds(10, 76, 100, 28);
		panel_7_1.add(lblNewLabel_5_1);
		
		lblMessTenPB = new JLabel("");
		lblMessTenPB.setForeground(Color.RED);
		lblMessTenPB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMessTenPB.setBounds(111, 76, 508, 28);
		panel_7_1.add(lblMessTenPB);
		
		textTenPB = new JTextField();
		textTenPB.setColumns(10);
		textTenPB.setBounds(10, 104, 609, 28);
		panel_7_1.add(textTenPB);

		model = new ArrayList<PhongBan>();
		updateTable();
	}
	
	
	private void updateTable() {
		uploadDB();
		modelTable.setRowCount(0);
		for (PhongBan a : model) {
			modelTable.addRow(new Object[] {
					a.getMaPB(),
					a.getTenPB()
			});
		}
	
	}

	private void uploadDB() {
		ConnectDB con = new ConnectDB();
		con.connect();
		model=PhongBan_DAO.getAllFromDB();
		con.disconect();
	}
	
	public void jTextFieldEditable(boolean choose) {
		textMaPB.setEditable(choose);
		textTenPB.setEditable(choose);
	}
	
	private boolean checkfieldHopLe() {
		
		if(!textMaPB.getText().matches("\\w+")) {
			lblMessMaPB.setText("Lỗi mã nhà cung cấp !");
			return false;
		} else
			lblMessMaPB.setText("");
		
		if(textTenPB.getText().length() < 2){
			lblMessTenPB.setText("Lỗi tên nhà cung cấp !");
			return false;
		} else 
			lblMessTenPB.setText("");
		return true;

	}
	
	public void themPhongBan() {
		NhaCungCap a = new NhaCungCap();
		if(!textMaPB.isEditable()) {			
			jTextFieldEditable(true);
			this.textMaPB.setEditable(true);
		}else {
			if(checkfieldHopLe()) {
				jTextFieldEditable(false);
				try {
					a.setMa(textMaPB.getText().toUpperCase());
					a.setTen(textTenPB.getText().toUpperCase());
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
	
	public void capNhatPhongBan() {//////////////////copy tu cap nhat nha cung cap
		int n = table.getSelectedRow();
		PhongBan a = new PhongBan();
		if(n>=0)
			if(textMaPB.isEditable()) {/////////////////
				jButtomEnableForUpdate(true);
				this.btnXoa.setEnabled(true);
				try {
					
					a.setMaPB(textMaPB.getText().toUpperCase());
					a.setTenPB(textTenPB.getText().toUpperCase());
					
				} catch (Exception e) {
					e.printStackTrace();
					a = null;
				}finally {
					
					if(a!=null) {
						
						int confirm = JOptionPane.showConfirmDialog(null, "Cập nhật nhà cung cấp "+a.getMaPB(), "Cập nhật", JOptionPane.YES_NO_OPTION);
						if(confirm == JOptionPane.YES_OPTION) {
							
							ConnectDB con = new ConnectDB();
							con.connect();
							Boolean res = PhongBan_DAO.update(a);
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
				this.textMaPB.setEditable(false);
			}
		else {
			JOptionPane.showMessageDialog(null, "CHỌN 1 HÀNG ĐỂ DÙNG CHỨC NĂNG SỬA !");
		}		
	}

	private void xoaTrang() {
		textMaPB.setText("");
		textTenPB.setText("");
			lblMessMaPB.setText("");
			lblMessTenPB.setText("");
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textMaPB.getDocument())) {
			if(textMaPB.getText().length() > 2 && textMaPB.getText().toUpperCase().matches("[A-Z0-9]+([-]*[A-Z0-9]+)*")) {
				lblMessMaPB.setText("");
			}else
				lblMessMaPB.setText("Chưa đúng định đạng !");
		}else if(src.equals(textTenPB.getDocument())) {
			if(textTenPB.getText().length()> 2) {
				lblMessTenPB.setText("");
			}else
				lblMessTenPB.setText("Chưa đúng định dạng !");
		}
		
		
		if(src.equals(textLocMa.getDocument())) {
			timKiemMa();
		}
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textMaPB.getDocument())) {
			if(textMaPB.getText().length() > 2 && textMaPB.getText().toUpperCase().matches("[A-Z0-9]+([-]*[A-Z0-9]+)*")) {
				lblMessMaPB.setText("");
			}else
				lblMessMaPB.setText("Chưa đúng định đạng !");
		}else if(src.equals(textTenPB.getDocument())) {
			if(textTenPB.getText().length()> 2) {
				lblMessTenPB.setText("");
			}else
				lblMessTenPB.setText("Chưa đúng định dạng !");
		}
		
		if(src.equals(textLocMa.getDocument())) {
			timKiemMa();
		}
		
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		Document src = e.getDocument();
		
		if(src.equals(textMaPB.getDocument())) {
			if(textMaPB.getText().length() > 2 && textMaPB.getText().toUpperCase().matches("[A-Z0-9]+([-]*[A-Z0-9]+)*")) {
				lblMessMaPB.setText("");
			}else
				lblMessMaPB.setText("Chưa đúng định đạng !");
		}else if(src.equals(textTenPB.getDocument())) {
			if(textTenPB.getText().length()> 2) {
				lblMessTenPB.setText("");
			}else
				lblMessTenPB.setText("Chưa đúng định dạng !");
		}
		
		if(src.equals(textLocMa.getDocument())) {
			timKiemMa();
		}
		
	}
	
	public void timKiemMa() {
		xoaTrang();
		String a = textLocMa.getText();
		if(a.length() == 0) {
			updateTable();
			this.setVisible(true);
		}else {
			modelTable.setRowCount(0);
			for (PhongBan x : model) {
				if(x.getMaPB().toUpperCase().contains(a.toUpperCase())) {
					modelTable.addRow(new Object[] {
							x.getMaPB(),
							x.getTenPB()
					});
				}
			}
		}
		this.setVisible(true);
	}
	
	public void showInforIntoTextFiled() {
		
		jTextFieldEditable(false);
		this.textMaPB.setEditable(false);
		int n = table.getSelectedRow();
		textMaPB.setText(modelTable.getValueAt(n, 0)+"");
		textTenPB.setText(modelTable.getValueAt(n, 1)+"");
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

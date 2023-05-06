package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JToggleButton;
import javax.swing.JList;
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

import connectDB.ConnectDB;
import dao.HoaDonChiTiet_DAO;
import dao.LinhKien_DAO;
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
import javax.swing.SpinnerNumberModel;

public class JPanelHoaDonChiTiet extends JPanel {
	private JTable tableLinhKien;
	private JTable tableHoaDonChiTiet;
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
	private DefaultTableModel modelTableLK = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00C3", "T\u00CAN", "LO\u1EA0I LINH KI\u1EC6N", "NH\u00C0 CUNG C\u1EA4P", "S\u1ED0 L\u01AF\u1EE2NG"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};	
	private ArrayList<DonHangChiTiet> modelHDCT;
	private ArrayList<LinhKien> modelLK;
	private JTextField textField;
	private JTextField txtMaHD;
	private JTextField txtMaLK;
	private JTextField txtGiaBan;
	private JTextField txtThanhTien;
	private JSpinner spinnerGiamGia;
	private JSpinner spinnerSoLuong;
	/**
	 * Create the panel.
	 */
	public JPanelHoaDonChiTiet() {
		modelHDCT = new ArrayList<DonHangChiTiet>();
		modelLK = new ArrayList<LinhKien>();
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
		
		JLabel lblNewLabel_1 = new JLabel("LINH KIỆN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		
		tableLinhKien = new JTable();
		tableLinhKien.setModel(modelTableLK);
		tableLinhKien.getColumnModel().getColumn(0).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(0).setPreferredWidth(55);
		tableLinhKien.getColumnModel().getColumn(1).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(1).setPreferredWidth(114);
		tableLinhKien.getColumnModel().getColumn(2).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(2).setPreferredWidth(85);
		tableLinhKien.getColumnModel().getColumn(3).setResizable(false);
		tableLinhKien.getColumnModel().getColumn(3).setPreferredWidth(82);
		tableLinhKien.getColumnModel().getColumn(4).setResizable(false);
		scrollPane.setViewportView(tableLinhKien);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(10, 54));
		panel_3.setBackground(new Color(51, 51, 51));
		panel_1.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Mã hóa đơn");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(10, 11, 81, 33);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(96, 10, 129, 34);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(449, 5, 69, 45);
		btnNewButton.setIcon(new ImageIcon(JPanelHoaDonChiTiet.class.getResource("/img/add_36px.png")));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnNewButton);
		
		JButton btnXa = new JButton("");
		btnXa.setBounds(523, 5, 69, 45);
		btnXa.setIcon(new ImageIcon(JPanelHoaDonChiTiet.class.getResource("/img/minus_36px.png")));
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnXa);
		
		JButton btnCpNht = new JButton("");
		btnCpNht.setBounds(597, 5, 69, 45);
		btnCpNht.setIcon(new ImageIcon(JPanelHoaDonChiTiet.class.getResource("/img/renew_36px.png")));
		btnCpNht.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnCpNht);
		
		JButton btnXaTrng = new JButton("");
		btnXaTrng.setBounds(671, 5, 69, 45);
		btnXaTrng.setIcon(new ImageIcon(JPanelHoaDonChiTiet.class.getResource("/img/erase_36px.png")));
		btnXaTrng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnXaTrng);
		
		JButton btnInHan = new JButton("");
		btnInHan.setBounds(745, 5, 69, 45);
		btnInHan.setIcon(new ImageIcon(JPanelHoaDonChiTiet.class.getResource("/img/print_36px.png")));
		btnInHan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_3.add(btnInHan);
		
		JLabel lblNewLabel_4_1 = new JLabel("Giảm giá từ");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4_1.setBounds(235, 11, 81, 33);
		panel_3.add(lblNewLabel_4_1);
		
		JSpinner spinnerGiamGia_1 = new JSpinner();
		spinnerGiamGia_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerGiamGia_1.setBounds(326, 10, 69, 34);
		panel_3.add(spinnerGiamGia_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 153, 102));
		splitPane.setRightComponent(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_2 = new JLabel("HÓA ĐƠN CHI TIẾT");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_2, BorderLayout.NORTH);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		tableHoaDonChiTiet = new JTable();
		tableHoaDonChiTiet.setModel(modelTableHDCT);
		tableHoaDonChiTiet.getColumnModel().getColumn(0).setResizable(false);
		tableHoaDonChiTiet.getColumnModel().getColumn(0).setPreferredWidth(74);
		tableHoaDonChiTiet.getColumnModel().getColumn(1).setResizable(false);
		scrollPane_1.setViewportView(tableHoaDonChiTiet);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 153, 51));
		panel_4.setBounds(841, 63, 433, 360);
		add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		panel_4.add(scrollPane_2, BorderLayout.CENTER);
		
		JTextPane txtpane = new JTextPane();
		scrollPane_2.setViewportView(txtpane);
		
		JLabel lblNewLabel_3 = new JLabel("PHIẾU HÓA ĐƠN");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_4.add(lblNewLabel_3, BorderLayout.NORTH);
		
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
		lblNewLabel_5_3.setBounds(841, 565, 85, 24);
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
		txtGiaBan.setColumns(10);
		txtGiaBan.setBounds(841, 528, 198, 27);
		add(txtGiaBan);
		
		txtThanhTien = new JTextField();
		txtThanhTien.setColumns(10);
		txtThanhTien.setBounds(841, 633, 433, 27);
		add(txtThanhTien);
		
		spinnerGiamGia = new JSpinner();
		spinnerGiamGia.setModel(new SpinnerNumberModel(0, 0, 100, 5));
		spinnerGiamGia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerGiamGia.setBounds(1170, 529, 100, 24);
		add(spinnerGiamGia);
		
		spinnerSoLuong = new JSpinner();
		spinnerSoLuong.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spinnerSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerSoLuong.setBounds(936, 566, 103, 24);
		add(spinnerSoLuong);
		
		updateTable();
		
		this.setVisible(true);
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
				a.getMaLLK(),
				a.getMaNCC(),
				a.getSoLuongTon()
			});
		}

		
	}
	private void uploadHDCT_LK() {
		ConnectDB c = new ConnectDB();
		c.connect();
		modelHDCT = HoaDonChiTiet_DAO.getAllFromDB();
		modelLK = LinhKien_DAO.getAllHoaDonFromDB();
		c.disconect();
		
	}
}

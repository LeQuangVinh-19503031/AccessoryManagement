package view;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class JPanelThongKe extends JPanel {
	private JTextField textNgay;
	private JTextField textThang;
	private JTextField textNam;
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public JPanelThongKe() {
		setBackground(new Color(64, 224, 208));
		setLayout(null);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(204, 204, 255));
		panelTitle.setBounds(0, 0, 1285, 53);
		add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("THỐNG KÊ DOANH THU");
		lblNewLabel.setBounds(0, 0, 1285, 53);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel);
		
		JPanel panelThangNam = new JPanel();
		panelThangNam.setBounds(10, 63, 1258, 99);
		panelThangNam.setBackground(new Color(204, 204, 204));
		add(panelThangNam);
		panelThangNam.setLayout(null);
		
		JLabel lblNgay = new JLabel("Ngày:");
		lblNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgay.setBounds(106, 10, 62, 25);
		panelThangNam.add(lblNgay);
		
		JLabel lblThang = new JLabel("Tháng:");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThang.setBounds(475, 10, 71, 25);
		panelThangNam.add(lblThang);
		
		JLabel lblNam = new JLabel("Năm:");
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNam.setBounds(858, 10, 62, 25);
		panelThangNam.add(lblNam);
		
		textNgay = new JTextField();
		textNgay.setBounds(178, 14, 193, 26);
		panelThangNam.add(textNgay);
		textNgay.setColumns(10);
		
		textThang = new JTextField();
		textThang.setBounds(556, 14, 193, 26);
		panelThangNam.add(textThang);
		textThang.setColumns(10);
		
		textNam = new JTextField();
		textNam.setBounds(930, 14, 193, 26);
		panelThangNam.add(textNam);
		textNam.setColumns(10);
		
		JCheckBox chckbxTKtheoNgay = new JCheckBox("Thống kê theo ngày");
		chckbxTKtheoNgay.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTKtheoNgay.setBackground(new Color(204, 204, 204));
		chckbxTKtheoNgay.setBounds(106, 61, 142, 21);
		panelThangNam.add(chckbxTKtheoNgay);
		
		JCheckBox chckbxTKtheoThang = new JCheckBox("Thống kê theo tháng");
		chckbxTKtheoThang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTKtheoThang.setBackground(new Color(204, 204, 204));
		chckbxTKtheoThang.setBounds(475, 61, 142, 21);
		panelThangNam.add(chckbxTKtheoThang);
		
		JCheckBox chckbxTKtheoNam = new JCheckBox("Thống kê theo năm");
		chckbxTKtheoNam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chckbxTKtheoNam.setBackground(new Color(204, 204, 204));
		chckbxTKtheoNam.setBounds(858, 61, 142, 21);
		panelThangNam.add(chckbxTKtheoNam);
		
		JPanel panelChucNang = new JPanel();
		panelChucNang.setBackground(new Color(204, 204, 204));
		panelChucNang.setBounds(10, 176, 1258, 78);
		add(panelChucNang);
		panelChucNang.setLayout(null);
		
		JLabel lblDoanhThu = new JLabel("Doanh thu:");
		lblDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDoanhThu.setBounds(105, 27, 110, 25);
		panelChucNang.add(lblDoanhThu);
		
		textField = new JTextField();
		textField.setBounds(212, 27, 201, 26);
		panelChucNang.add(textField);
		textField.setColumns(10);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThongKe.setBounds(617, 26, 116, 27);
		panelChucNang.add(btnThongKe);
		
		JButton btnXuatExcel = new JButton("Xuất Excel");
		btnXuatExcel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXuatExcel.setBounds(815, 26, 116, 27);
		panelChucNang.add(btnXuatExcel);
		
		JButton btnInBaoCao = new JButton("In báo cáo");
		btnInBaoCao.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInBaoCao.setBounds(1009, 26, 116, 27);
		panelChucNang.add(btnInBaoCao);
		
		JPanel panelTable = new JPanel();
		panelTable.setBounds(10, 273, 1258, 408);
		panelTable.setBackground(new Color(204, 204, 204));
		add(panelTable);
		panelTable.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 1238, 403);
		panelTable.add(scrollPane);
		scrollPane.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(new Color(204, 255, 255));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"STT", "M\u00E3 h\u00F3a \u0111\u01A1n", "Nh\u00E2n vi\u00EAn", "Kh\u00E1ch h\u00E0ng", "T\u1ED5ng ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, Long.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBackground(Color.WHITE);
		scrollPane.setViewportView(table);

	}
}

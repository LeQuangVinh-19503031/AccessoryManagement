package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class JPanelTrangChu extends JPanel {

	/**
	 * Create the panel.
	 */
	public JPanelTrangChu() {
		setBackground(new Color(153, 204, 51));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(51, 0, 1197, 53);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("TRANG CHỦ");
		panel.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Consolas", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 255));
		panel_1.setBounds(51, 92, 1197, 98);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTenDeTai = new JLabel("NHÓM 15: QUẢN LÝ MUA BÁN LINH KIỆN");
		panel_1.add(lblTenDeTai, BorderLayout.CENTER);
		lblTenDeTai.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenDeTai.setFont(new Font("Consolas", Font.BOLD, 38));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		panel_2.setBounds(51, 257, 1197, 53);
		add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGVhuongdan = new JLabel("GIẢNG VIÊN HƯỚNG DẪN: TÔN LONG PHƯỚC");
		lblGVhuongdan.setBounds(55, 0, 1132, 53);
		panel_2.add(lblGVhuongdan);
		lblGVhuongdan.setHorizontalAlignment(SwingConstants.CENTER);
		lblGVhuongdan.setFont(new Font("Consolas", Font.BOLD, 30));
		
		JPanel panelThongTinThanhVien = new JPanel();
		panelThongTinThanhVien.setBackground(new Color(204, 204, 255));
		panelThongTinThanhVien.setBounds(51, 307, 1197, 325);
		add(panelThongTinThanhVien);
		panelThongTinThanhVien.setLayout(null);
		
		JLabel lblThanhVienNhom = new JLabel("Thành viên nhóm:");
		lblThanhVienNhom.setHorizontalAlignment(SwingConstants.CENTER);
		lblThanhVienNhom.setBounds(225, 0, 451, 70);
		panelThongTinThanhVien.add(lblThanhVienNhom);
		lblThanhVienNhom.setFont(new Font("Consolas", Font.BOLD, 30));
		
		JLabel lblTenTungNguoi = new JLabel("-Dương Thế Ngọc");
		lblTenTungNguoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenTungNguoi.setFont(new Font("Consolas", Font.BOLD, 30));
		lblTenTungNguoi.setBounds(334, 60, 444, 70);
		panelThongTinThanhVien.add(lblTenTungNguoi);
		
		JLabel lblvQucHuy = new JLabel("-Võ Quốc Huy");
		lblvQucHuy.setHorizontalAlignment(SwingConstants.CENTER);
		lblvQucHuy.setFont(new Font("Consolas", Font.BOLD, 30));
		lblvQucHuy.setBounds(334, 183, 393, 70);
		panelThongTinThanhVien.add(lblvQucHuy);
		
		JLabel lbllQuangVinh = new JLabel("-Lê Quang Vinh");
		lbllQuangVinh.setHorizontalAlignment(SwingConstants.CENTER);
		lbllQuangVinh.setFont(new Font("Consolas", Font.BOLD, 30));
		lbllQuangVinh.setBounds(334, 119, 427, 70);
		panelThongTinThanhVien.add(lbllQuangVinh);
		
		JLabel lblphmChXun = new JLabel("-Phạm Chí Xuân");
		lblphmChXun.setHorizontalAlignment(SwingConstants.CENTER);
		lblphmChXun.setFont(new Font("Consolas", Font.BOLD, 30));
		lblphmChXun.setBounds(334, 245, 427, 70);
		panelThongTinThanhVien.add(lblphmChXun);

	}
}

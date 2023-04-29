package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Frame;
import javax.swing.JPanel;
import java.awt.Window.Type;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.ComponentOrientation;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class WindowMain {

	public JFrame frmQunLMua;
	private JPanel panelContent;
	private JPanel panelNhaCungCap, panelLinhKien, panelTrangChu, panelLoaiLinhKien, panelHoaDon, panelNhanVien, panelPhongBan, panelHoaDonChiTiet, panelTaiKhoan, panelKhachHang;
	
	int width = 250, height = 773;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowMain window = new WindowMain();
					window.frmQunLMua.setLocationRelativeTo(null);
					window.frmQunLMua.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQunLMua = new JFrame();
		frmQunLMua.setResizable(false);
		frmQunLMua.setTitle("QUẢN LÝ MUA BÁN LINH KIỆN");
		frmQunLMua.setIconImage(Toolkit.getDefaultToolkit().getImage(WindowMain.class.getResource("/img/java_icon.ico")));
		frmQunLMua.setName("frameMain");
		frmQunLMua.setSize(1300, 800);
		frmQunLMua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMenu = new JPanel();
		
		panelContent = new JPanel();
		frmQunLMua.getContentPane().setLayout(null);

		panelMenu.setBackground(new Color(192, 192, 192));
		panelMenu.setBounds(0, 0, 1, 763);
		frmQunLMua.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		// 250, 773
		JLayeredPane panelLogo = new JLayeredPane();
		panelLogo.setPreferredSize(new Dimension(0, 100));
		panelLogo.setBounds(0, 41, 250, 107);
		panelMenu.add(panelLogo);
		panelLogo.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(58, 0, 80, 77);
		panel_2.setBackground(new Color(128, 255, 128));
		panelLogo.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(148, 10, 71, 48);
		panel_7.setBackground(new Color(255, 128, 128));
		panelLogo.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(20, 52, 54, 42);
		panel_8.setBackground(new Color(255, 255, 128));
		panelLogo.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(80, 52, 88, 38);
		panel_9.setBackground(new Color(128, 128, 255));
		panelLogo.add(panel_9);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(147, 80, 72, 20);
		panel_11.setBackground(Color.WHITE);
		panelLogo.add(panel_11);
		
		JPanel panelMenuItem = new JPanel();
		panelMenuItem.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelMenuItem.setBackground(Color.GRAY);
		panelMenuItem.setBounds(0, 158, 250, 539);
		panelMenu.add(panelMenuItem);
		panelMenuItem.setLayout(new GridLayout(10, 0, 10, 10));
		
		JButton btnTrangChu = new JButton("TRANG CHỦ");
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelTrangChu");
				frmQunLMua.setVisible(true); 
			}
		});
		panelMenuItem.add(btnTrangChu);
		
		JButton btnLinhKien = new JButton("LINH KIỆN");
		btnLinhKien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelLinhKien");
				frmQunLMua.setVisible(true);
			}
		});

		panelMenuItem.add(btnLinhKien);
		
		JButton btnHoaDon = new JButton("HÓA ĐƠN");
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelHoaDon");
				frmQunLMua.setVisible(true); 
			}
		});
		panelMenuItem.add(btnHoaDon);
		
		JButton btnChiTietHoaDon = new JButton("CHI TIẾT HÓA ĐƠN");
		btnChiTietHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelHoaDonChiTiet");
				frmQunLMua.setVisible(true); 
			}
		});
		panelMenuItem.add(btnChiTietHoaDon);
		
		JButton btnNhaCungCap = new JButton("NHÀ CUNG CẤP");
		btnNhaCungCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelNhaCungCap");
				frmQunLMua.setVisible(true);
			}
		});
		panelMenuItem.add(btnNhaCungCap);
		
		JButton btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelNhanVien");
				frmQunLMua.setVisible(true); 
			}
		});
		panelMenuItem.add(btnNhanVien);
		
		JButton btnTaiKhoan = new JButton("TÀI KHOẢN");
		btnTaiKhoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelTaiKhoan");
				frmQunLMua.setVisible(true); 
			}
		});
		panelMenuItem.add(btnTaiKhoan);
		
		JButton btnPhongBan = new JButton("PHÒNG BAN");
		btnPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelPhongBan");
				frmQunLMua.setVisible(true); 
			}
		});
		panelMenuItem.add(btnPhongBan);
		
		JButton btnKhachHang = new JButton("KHÁCH HÀNG");
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelKhachHang");
				frmQunLMua.setVisible(true); 
			}
		});
		panelMenuItem.add(btnKhachHang);
		
		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		panelMenuItem.add(btnDangXuat);
		
		JPanel panelUser = new JPanel();
		panelUser.setBackground(new Color(192, 192, 192));
		panelUser.setBounds(0, 696, 250, 67);
		panelMenu.add(panelUser);
		panelUser.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(192, 192, 192));
		panelUser.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JLabel lblUserEmployee = new JLabel("New label");
		lblUserEmployee.setIcon(new ImageIcon(WindowMain.class.getResource("/img/homeWest/user_32px.png")));
		panel_19.add(lblUserEmployee, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setIcon(new ImageIcon(WindowMain.class.getResource("/img/homeWest/settings_24px.png")));
		panel_19.add(btnNewButton, BorderLayout.EAST);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(192, 192, 192));
		panelUser.add(panel_20, BorderLayout.SOUTH);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Phân quyền:");
		lblNewLabel_3.setMinimumSize(new Dimension(55, 25));
		lblNewLabel_3.setMaximumSize(new Dimension(60, 29));
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(lblNewLabel_3, BorderLayout.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setPreferredSize(new Dimension(140, 13));
		panel_20.add(lblNewLabel_4, BorderLayout.EAST);
		
		JPanel panelCloseMenu = new JPanel();
		panelCloseMenu.setBackground(new Color(192, 192, 192));
		panelCloseMenu.setBounds(0, 0, 250, 41);
		panelMenu.add(panelCloseMenu);
		panelCloseMenu.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeMenu();
			}

			private void closeMenu() {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						for (int i = width; i >= 0 ; i-=10) {
							panelMenu.setSize(i, height);
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
				}).start();
			}
		});
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(WindowMain.class.getResource("/img/homeCenter/close_24px.png")));
		lblNewLabel_2.setBounds(195, 0, 45, 41);
		panelCloseMenu.add(lblNewLabel_2);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 255, 128));
		panelTitle.setBounds(0, 0, 1286, 58);
		frmQunLMua.getContentPane().add(panelTitle);
		panelTitle.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openMenu();
				panelHoaDon.setVisible(false);
				panelNhaCungCap.setVisible(false);
				panelNhanVien.setVisible(false);
				panelTaiKhoan.setVisible(false);
				panelKhachHang.setVisible(false);
				panelLinhKien.setVisible(false);
				panelLoaiLinhKien.setVisible(false);
				panelHoaDonChiTiet.setVisible(false);
				panelPhongBan.setVisible(false);
			}

			private void openMenu() {
				new Thread(new Runnable() {
					// 250, 773
					@Override
					public void run() {
						for (int i = 0; i <= width; i+=20) {
							panelMenu.setSize(i, height);
							try {
								Thread.sleep(1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
					}
				}).start();
				
			}
		});
		lblNewLabel.setIcon(new ImageIcon(WindowMain.class.getResource("/img/homeCenter/menu_32px.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 70, 58);
		panelTitle.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("            | QUẢN LÝ MUA BÁN LINH KIỆN");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(80, 0, 1206, 58);
		panelTitle.add(lblNewLabel_1);
		
		panelContent.setBounds(0, 66, 1286, 697);
		frmQunLMua.getContentPane().add(panelContent);
		panelContent.setLayout(new CardLayout(0, 0));
		
		panelTrangChu = new JPanelTrangChu();
		panelTrangChu.setBackground(new Color(204, 255, 255));
		panelContent.add(panelTrangChu, "panelTrangChu");
		panelTrangChu.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(0, 0, 1286, 53);
		panelTrangChu.add(panel);
		panel.setLayout(null);
		
		panelLinhKien = new JPanelLinhKien();
		panelLinhKien.setBackground(new Color(204, 204, 255));
		panelContent.add(panelLinhKien, "panelLinhKien");
		
		panelNhaCungCap = new JPanelNhaCungCap();
		panelContent.add(panelNhaCungCap, "panelNhaCungCap");
		panelNhaCungCap.setLayout(null);
		
		panelLoaiLinhKien = new JPanelLoaiLinhKien();
		panelContent.add(panelLoaiLinhKien, "panelLoaiLinhKien");
		panelLoaiLinhKien.setLayout(null);
		
		panelHoaDon = new JPanelHoaDon();
		panelContent.add(panelHoaDon, "panelHoaDon");
		panelHoaDon.setLayout(null);
		
		panelNhanVien = new JPanelNhanVien();
		panelContent.add(panelNhanVien, "panelNhanVien");
		panelNhanVien.setLayout(null);
		
		panelPhongBan = new JPanelPhongBan();
		panelContent.add(panelPhongBan, "panelPhongBan");
		panelPhongBan.setLayout(null);
		
		panelHoaDonChiTiet = new JPanelHoaDonChiTiet();
		panelContent.add(panelHoaDonChiTiet, "panelHoaDonChiTiet");
		panelHoaDonChiTiet.setLayout(null);
		
		panelTaiKhoan = new JPanelTaiKhoan();
		panelContent.add(panelTaiKhoan, "panelTaiKhoan");
		panelTaiKhoan.setLayout(null);
		
		panelLinhKien = new JPanelLinhKien();
		panelLinhKien.setBackground(new Color(204, 204, 255));
		panelContent.add(panelLinhKien, "panelLinhKien");
		panelLinhKien.setLayout(null);
			
		panelKhachHang = new JPanelKhachHang();
		panelKhachHang.setBackground(new Color(204, 204, 255));
		panelContent.add(panelKhachHang, "panelKhachHang");
		panelKhachHang.setLayout(null);
	
	}
	
}

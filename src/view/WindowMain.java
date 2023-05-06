package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.border.EmptyBorder;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import model.NhanVien;
import model.TaiKhoan;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class WindowMain implements ActionListener{
	
	private static WindowMain window;
	private JFrame frmTrangChu;
	private JFrame frmLogin;
	private JFrame frameChangeAccount;
	private static JPanel panelContent;
	private JPanel panelNhaCungCap, panelThongKe, panelLinhKien, panelTrangChu, panelLoaiLinhKien, panelHoaDon, panelNhanVien, panelPhongBan, panelHoaDonChiTiet, panelKhachHang;
	private JButton buttonThoat, buttonLogin;
	int width = 1286, height = 125;
	private JTextField taiKhoanfield;
	private JPasswordField passfield;
	private ArrayList<TaiKhoan> listTK;
	private ArrayList<NhanVien> listNV;
	private JLabel lblUserEmployee;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					window = new WindowMain();
					window.frmLogin.setLocationRelativeTo(null);
					window.frmLogin.setVisible(true);

				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public WindowMain() {
		initLogin();
//		initChangePassword();
//		initialize();

	}
	
	private void initChangePassword() {
		frameChangeAccount = new JFrame();
		frameChangeAccount.setSize(500, 300);
		frameChangeAccount.setIconImage(Toolkit.getDefaultToolkit().getImage(WindowMain.class.getResource("/img/homeWest/user_settings_24px.png")));
		frameChangeAccount.setTitle("THAY ĐỔI MẬT KHẨU");
		frameChangeAccount.getContentPane().setBackground(new Color(204, 255, 255));
		frameChangeAccount.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 153, 204));
		panel.setBounds(0, 197, 909, 65);
		frameChangeAccount.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnXong = new JButton("CẬP NHẬT");
		btnXong.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnXong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameChangeAccount.setVisible(false);
				frmTrangChu.repaint();
			}
		});
		btnXong.setBounds(209, 10, 123, 45);
		panel.add(btnXong);
		
		JButton btnHuy = new JButton("HỦY");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameChangeAccount.setVisible(false);
				frmTrangChu.repaint();
			}
		});
		btnHuy.setBounds(342, 11, 123, 45);
		panel.add(btnHuy);
		
		JLabel lblNewLabel_7 = new JLabel("Mật khẩu hiện tại");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(10, 30, 123, 36);
		frameChangeAccount.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7_1.setBounds(10, 101, 123, 36);
		frameChangeAccount.getContentPane().add(lblNewLabel_7_1);
		
		textField = new JTextField();
		textField.setBounds(143, 30, 311, 36);
		frameChangeAccount.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(143, 101, 311, 36);
		frameChangeAccount.getContentPane().add(textField_1);
	}
	
	private void initLogin() {
		frmLogin = new JFrame();
		frmLogin.setBackground(new Color(153, 153, 153));
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(WindowMain.class.getResource("/img/homeWest/user_32px.png")));
		frmLogin.setTitle("ĐĂNG NHẬP");
		frmLogin.setSize(600, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel jPanel = new JPanel();
		jPanel.setBackground(new Color(224, 255, 255));
		jPanel.setBounds(0, 0, 586, 207);
		frmLogin.getContentPane().add(jPanel);
		
		JPanel jPanel2 = new JPanel();
		jPanel2.setBackground(new Color(64, 224, 208));
		jPanel2.setBounds(0, 203, 586, 60);
		frmLogin.getContentPane().add(jPanel2);
		
		JLabel label = new JLabel("   ");
		label.setBounds(576, 63, 10, 90);
		frmLogin.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(" ");
		label_1.setBounds(0, 0, 586, 13);
		frmLogin.getContentPane().add(label_1);
		jPanel2.setLayout(null);
		
		buttonLogin = new JButton("ĐĂNG NHẬP");
		buttonLogin.setBounds(366, 9, 100, 40);
		jPanel2.add(buttonLogin);
		buttonLogin.addActionListener(this);
		
		JLabel label_2 = new JLabel("   ");
		label_2.setBounds(288, 23, 10, 13);
		jPanel2.add(label_2);
		
		buttonThoat = new JButton("THOÁT");
		buttonThoat.setBounds(476, 10, 100, 40);
		jPanel2.add(buttonThoat);
		buttonThoat.addActionListener(this);
		jPanel.setLayout(null);
		
		JLabel jLabelTaiKhoan = new JLabel("TÀI KHOẢN", SwingConstants.CENTER);
		jLabelTaiKhoan.setBounds(26, 60, 122, 35);
		jPanel.add(jLabelTaiKhoan);
		taiKhoanfield = new JTextField();
		taiKhoanfield.setBounds(158, 60, 388, 35);
		jPanel.add(taiKhoanfield);
		
		JLabel jLabelMatKhau = new JLabel("MẬT KHẨU", SwingConstants.CENTER);
		jLabelMatKhau.setBounds(26, 115, 122, 35);
		jPanel.add(jLabelMatKhau);
		passfield = new JPasswordField();
		passfield.setBounds(158, 115, 388, 35);
		jPanel.add(passfield);
		
		buttonLogin.setPreferredSize(new Dimension(100, 50));
		buttonThoat.setPreferredSize(buttonLogin.getPreferredSize());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equalsIgnoreCase("ĐĂNG NHẬP")) {
			
			checkLogin(new TaiKhoan(taiKhoanfield.getText(), passfield.getText()));
		}else if(src.equalsIgnoreCase("THOÁT")) {
			System.exit(1);
		}
		
	}
	
	private void checkLogin(TaiKhoan tK) {
		updateDB();
		tK.setUser(taiKhoanfield.getText());
		tK.setPass(passfield.getText());
		if(listTK.contains(tK)) {
			initialize();
			window.frmLogin.setVisible(false);
			window.frmTrangChu.setLocationRelativeTo(null);
			window.frmTrangChu.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Sai mật khẩu !");
		}
		
	}
	
	private void updateDB() {
		ConnectDB c = new ConnectDB();
		c.connect();
		listTK = NhanVien_DAO.getAllAccountPass();
		listNV = NhanVien_DAO.getAllFromDB();
		c.disconect();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrangChu = new JFrame();
		frmTrangChu.getContentPane().setBackground(new Color(64, 224, 208));
		frmTrangChu.setBackground(new Color(0, 0, 0));
		frmTrangChu.setResizable(false);
		frmTrangChu.setTitle("QUẢN LÝ MUA BÁN LINH KIỆN");
		frmTrangChu.setIconImage(Toolkit.getDefaultToolkit().getImage(WindowMain.class.getResource("/img/java_icon.ico")));
		frmTrangChu.setName("frameMain");
		frmTrangChu.setSize(1300, 800);
		frmTrangChu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 1286, 125
		JPanel panelMenu = new JPanel();
		
		panelContent = new JPanel();
		frmTrangChu.getContentPane().setLayout(null);
		
		panelMenu.setBackground(new Color(192, 192, 192));
		panelMenu.setBounds(0, 0, 1286, 120);
		frmTrangChu.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JLayeredPane panelLogo = new JLayeredPane();
		panelLogo.setBounds(10, 10, 162, 107);
		panelMenu.add(panelLogo);
		panelLogo.setPreferredSize(new Dimension(0, 100));
		panelLogo.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(33, 0, 80, 77);
		panel_2.setBackground(new Color(255, 0, 0));
		panelLogo.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(81, 0, 71, 48);
		panel_7.setBackground(new Color(255, 255, 0));
		panelLogo.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 52, 54, 42);
		panel_8.setBackground(new Color(255, 255, 255));
		panelLogo.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(64, 59, 88, 38);
		panel_9.setBackground(new Color(0, 0, 0));
		panelLogo.add(panel_9);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(90, 87, 72, 20);
		panel_11.setBackground(new Color(0, 255, 0));
		panelLogo.add(panel_11);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(1231, 91, 45, 24);
		panelMenu.add(lblNewLabel_2);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeMenu();
			}
			
			private void closeMenu() {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						for (int i = height; i >= 0 ; i-=2) {
							panelMenu.setSize(width, i);
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
		
		JPanel panelUser = new JPanel();
		panelUser.setBounds(1061, 10, 215, 67);
		panelMenu.add(panelUser);
		panelUser.setBackground(new Color(192, 192, 192));
		panelUser.setLayout(null);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(0, 0, 215, 45);
		panel_19.setBackground(new Color(192, 192, 192));
		panelUser.add(panel_19);
		panel_19.setLayout(null);
		
		lblUserEmployee = new JLabel(taiKhoanfield.getText());
		lblUserEmployee.setBounds(0, 0, 32, 45);
		lblUserEmployee.setIcon(new ImageIcon(WindowMain.class.getResource("/img/homeWest/user_32px.png")));
		panel_19.add(lblUserEmployee);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(32, 0, 183, 45);
		panel_19.add(lblNewLabel_5);
		lblNewLabel_5.setText(lblUserEmployee.getText());
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(0, 46, 215, 21);
		panel_20.setBackground(new Color(192, 192, 192));
		panelUser.add(panel_20);
		panel_20.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Phòng ban: ");
		lblNewLabel_3.setBounds(0, 0, 69, 21);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setMinimumSize(new Dimension(55, 25));
		lblNewLabel_3.setMaximumSize(new Dimension(60, 29));
		lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_20.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(searchPBTK());
		lblNewLabel_4.setBounds(69, 0, 146, 21);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setPreferredSize(new Dimension(140, 13));
		panel_20.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initChangePassword();
				frameChangeAccount.setLocationRelativeTo(null);
				frameChangeAccount.setVisible(true);
			}
		});
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(WindowMain.class.getResource("/img/homeWest/settings_24px.png")));
		lblNewLabel_6.setBounds(1176, 91, 45, 24);
		panelMenu.add(lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(400, 100));
		scrollPane.setMaximumSize(new Dimension(400, 100));
		scrollPane.setPreferredSize(new Dimension(400, 100));
		scrollPane.setBounds(182, 10, 869, 123);
		panelMenu.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setPreferredSize(new Dimension(500, 300));
		panel_1.setMinimumSize(new Dimension(500, 500));
		panel_1.setMaximumSize(new Dimension(0, 1200));
		panel_1.setFocusTraversalPolicyProvider(true);
		panel_1.setFocusTraversalKeysEnabled(false);
		panel_1.setFocusCycleRoot(true);
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setAutoscrolls(true);
		panel_1.setAlignmentY(1.0f);
		panel_1.setAlignmentX(0.0f);
		panel_1.setLayout(null);
		
		JButton btnNhanVien = new JButton("NHÂN VIÊN");
		btnNhanVien.setBounds(344, 10, 157, 44);
		panel_1.add(btnNhanVien);
		btnNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnPhongBan = new JButton("PHÒNG BAN");
		btnPhongBan.setBounds(511, 10, 157, 44);
		panel_1.add(btnPhongBan);
		btnPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnKhachHang = new JButton("KHÁCH HÀNG");
		btnKhachHang.setBounds(511, 64, 157, 44);
		panel_1.add(btnKhachHang);
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnThongKe = new JButton("THỐNG KÊ VÀ BÁO CÁO");
		btnThongKe.setBounds(344, 64, 157, 44);
		panel_1.add(btnThongKe);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnLinhKien = new JButton("LINH KIỆN");
		btnLinhKien.setBounds(177, 10, 157, 44);
		panel_1.add(btnLinhKien);
		btnLinhKien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnHoaDon = new JButton("ĐƠN HÀNG");
		btnHoaDon.setBounds(10, 64, 157, 44);
		panel_1.add(btnHoaDon);
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnTrangChu = new JButton("TRANG CHỦ");
		btnTrangChu.setBounds(10, 10, 157, 44);
		panel_1.add(btnTrangChu);
		btnTrangChu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnChiTietHoaDon = new JButton("CHI TIẾT ĐƠN HÀNG");
		btnChiTietHoaDon.setBounds(177, 64, 157, 44);
		panel_1.add(btnChiTietHoaDon);
		btnChiTietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnNhaCungCap = new JButton("NHÀ CUNG CẤP");
		btnNhaCungCap.setBounds(678, 10, 157, 44);
		panel_1.add(btnNhaCungCap);
		btnNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnDangXuat = new JButton("ĐĂNG XUẤT");
		btnDangXuat.setBounds(10, 118, 157, 47);
		panel_1.add(btnDangXuat);
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JPanel panelMenuItem = new JPanel();
		panelMenuItem.setBounds(726, 238, 816, 125);
		panel_1.add(panelMenuItem);
		panelMenuItem.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelMenuItem.setBackground(Color.GRAY);
		panelMenuItem.setLayout(null);
		
		JButton btnNewButton = new JButton("LOẠI LINH KIỆN");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelLoaiLinhKien");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(678, 64, 157, 44);
		panel_1.add(btnNewButton);
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmTrangChu.setVisible(false);
				frmLogin.setVisible(true);
			}
		});
		btnNhaCungCap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelNhaCungCap");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true);
			}
		});
		btnChiTietHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelHoaDonChiTiet");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true); 
			}
		});
		btnTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelTrangChu");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true); 
			}
		});
		btnHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelHoaDon");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true); 
			}
		});
		btnLinhKien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelLinhKien");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true);
			}
		});
		btnThongKe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelThongKe");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true); 
			}
		});
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelKhachHang");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true); 
			}
		});
		btnPhongBan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelPhongBan");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true); 
			}
		});
		btnNhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) (panelContent.getLayout());
				panelMenu.setSize(0, height);
				c.show(panelContent, "panelNhanVien");
				panelMenu.setSize(width, height);
				frmTrangChu.setVisible(true); 
			}
		});
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(255, 255, 128));
		panelTitle.setBounds(0, 0, 1286, 58);
		frmTrangChu.getContentPane().add(panelTitle);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setPreferredSize(new Dimension(100, 0));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				openMenu();

			}
			
			private void openMenu() {
				new Thread(new Runnable() {
					// 250, 773
					@Override
					public void run() {
						for (int i = 0; i <= height; i+=2) {
							panelMenu.setBounds(0, 0, width, i);
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
		panelTitle.setLayout(new BorderLayout(0, 0));
		lblNewLabel.setIcon(new ImageIcon(WindowMain.class.getResource("/img/homeCenter/menu_32px.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelTitle.add(lblNewLabel, BorderLayout.WEST);
		
		JLabel lblNewLabel_1 = new JLabel("QUẢN LÝ MUA BÁN LINH KIỆN");
		lblNewLabel_1.setSize(new Dimension(0, 50));
		lblNewLabel_1.setVerticalTextPosition(SwingConstants.TOP);
		lblNewLabel_1.setPreferredSize(new Dimension(143, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Segoe UI Semibold", Font.BOLD, 24));
		panelTitle.add(lblNewLabel_1, BorderLayout.CENTER);
		
		panelContent.setBounds(0, 66, 1286, 697);
		frmTrangChu.getContentPane().add(panelContent);
		panelContent.setLayout(new CardLayout(0, 0));
		
		panelTrangChu = new JPanelTrangChu();
		panelTrangChu.setBackground(new Color(0, 204, 153));
		panelContent.add(panelTrangChu, "panelTrangChu");
		panelTrangChu.setLayout(null);
		
		panelLinhKien = new JPanelLinhKien();
		panelContent.add(panelLinhKien, "panelLinhKien");
		
		panelNhaCungCap = new JPanelNhaCungCap();
		panelContent.add(panelNhaCungCap, "panelNhaCungCap");
		panelNhaCungCap.setLayout(null);
		
		panelLoaiLinhKien = new JPanelLoaiLinhKien();
		panelContent.add(panelLoaiLinhKien, "panelLoaiLinhKien");
		panelLoaiLinhKien.setLayout(null);
		
		panelHoaDon = new JPanelDonHang();
		panelContent.add(panelHoaDon, "panelHoaDon");
		panelHoaDon.setLayout(null);
		
		panelNhanVien = new JPanelNhanVien(searchPBTK());
		panelContent.add(panelNhanVien, "panelNhanVien");
		panelNhanVien.setLayout(null);
		
		panelPhongBan = new JPanelPhongBan();
		panelContent.add(panelPhongBan, "panelPhongBan");
		panelPhongBan.setLayout(null);
		
		panelHoaDonChiTiet = new JPanelHoaDonChiTiet();
		panelContent.add(panelHoaDonChiTiet, "panelHoaDonChiTiet");
		panelHoaDonChiTiet.setLayout(null);
		
		panelLinhKien = new JPanelLinhKien();
		panelContent.add(panelLinhKien, "panelLinhKien");
		panelLinhKien.setLayout(null);
		
		panelKhachHang = new JPanelKhachHang();
		panelContent.add(panelKhachHang, "panelKhachHang");
		panelKhachHang.setLayout(null);
		
		panelThongKe = new JPanelThongKe();
		panelContent.add(panelThongKe, "panelThongKe");
		panelThongKe.setLayout(null);
		
		
	}
	
	public String searchPBTK() {
		for (NhanVien nhanVien : listNV) {
			if(nhanVien.getUser().equalsIgnoreCase(taiKhoanfield.getText()))
				return nhanVien.getMaPB();
		}
		return null;
	}
	
	public NhanVien search(String id) {
		for (NhanVien nhanVien : listNV) {
			if(nhanVien.getMa().equalsIgnoreCase(id))
				return nhanVien;
		}
		return null;
	}
	
	
}

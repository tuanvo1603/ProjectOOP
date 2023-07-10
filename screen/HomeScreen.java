package screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import button.AestheticButton;

public class HomeScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeScreen frame = new HomeScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setAutoRequestFocus(false);
		setBackground(new Color(240, 240, 240));
		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(985, 527));
		setResizable(true);
		setPreferredSize(new Dimension(21, 11));
		setTitle("TEAM 5 VO DICH\r\n");
		getContentPane().setLayout(null);

		AestheticButton btnNewButton_4 = new AestheticButton("NHÂN VẬT LỊCH SỬ");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FiguresSearch nv = new FiguresSearch();
				dispose();
				nv.show();
			}
		});
		btnNewButton_4.setFont(new Font("Playfair Display", Font.BOLD, 12));
		btnNewButton_4.setBounds(10, 66, 170, 46);
		btnNewButton_4.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
		btnNewButton_4.setBackground(Color.WHITE);
		getContentPane().add(btnNewButton_4);


		AestheticButton btnNewButton = new AestheticButton("ĐỊA DANH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SiteSearch dd = new SiteSearch();
				dispose();
				dd.show();
				//dispose();
			}
		});
		btnNewButton.setFont(new Font("Playfair Display", Font.BOLD, 12));
		btnNewButton.setBounds(10, 122, 170, 46);
		getContentPane().add(btnNewButton);

		AestheticButton btnNewButton_1 = new AestheticButton("LỄ HỘI VĂN HÓA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FesSearch lh = new FesSearch();
				dispose();
				lh.show();
				//dispose();
			}
		});
		btnNewButton_1.setBounds(10, 178, 170, 46);
		btnNewButton_1.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_1);

		AestheticButton btnNewButton_5 = new AestheticButton("THOÁT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_5.setBounds(10, 402, 170, 50);
		btnNewButton_5 .setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_5);

		AestheticButton btnNewButton_6 = new AestheticButton("VUA\r\n");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KingSearch king = new KingSearch();
				dispose();
				king.show();
				//dispose();
			}
		});
		btnNewButton_6.setBounds(10, 234, 170, 46);
		btnNewButton_6.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_6);

		AestheticButton btnNewButton_3 = new AestheticButton("TRANG CHỦ\r\n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeScreen ab = new HomeScreen();
				dispose();
				ab.show();
				//dispose();
			}
		});
		btnNewButton_3.setBounds(10, 10, 170, 46);
		btnNewButton_3.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_3);

		AestheticButton btnNewButton_7 = new AestheticButton("TRIỀU ĐẠI\r\n");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ErasSearch td = new ErasSearch();
				dispose();
				td.show();
				//dispose();
			}
		});
		btnNewButton_7.setBounds(10, 290, 170, 46);
		btnNewButton_7.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_7);

		AestheticButton btnNewButton_8 = new AestheticButton("SỰ KIỆN\r\n");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WarSeach sk = new WarSeach();
				dispose();
				sk.show();
				//dispose();
			}
		});
		btnNewButton_8.setBounds(10, 346, 170, 46);
		btnNewButton_8.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_8);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giaoan.lik-trong-dong.png"));
		lblNewLabel_1.setBounds(-34, 0, 1005, 490);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\unnamed.jpg"));
		lblNewLabel.setBounds(630, 164, 235, 142);
		getContentPane().add(lblNewLabel);
	}

}

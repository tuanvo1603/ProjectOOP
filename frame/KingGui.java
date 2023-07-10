package frame;

import editstring.*;
import models.King;
import models.Era;
import screen.*;
import com.google.gson.Gson;
import button.AestheticButton;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class KingGui extends JFrame {
	private King king;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					KingGui1 frame = new KingGui1(king);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	public KingGui(King king) {
		this.king = king;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1113, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setAutoRequestFocus(false);
		setBackground(new Color(240, 240, 240));
		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(929, 520));
		setResizable(true);
		setPreferredSize(new Dimension(21, 11));
		setTitle("VUA\r\n");
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
		btnNewButton_4.setBounds(77, 79, 212, 46);
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
		btnNewButton.setBounds(77, 135, 212, 46);
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
		btnNewButton_1.setBounds(77, 191, 212, 46);
		btnNewButton_1.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_1);

		AestheticButton btnNewButton_5 = new AestheticButton("THOÁT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_5.setBounds(77, 415, 212, 46);
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
		btnNewButton_6.setBounds(77, 247, 212, 46);
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
		btnNewButton_3.setBounds(77, 23, 212, 46);
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
		btnNewButton_7.setBounds(77, 303, 212, 46);
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
		btnNewButton_8.setBounds(77, 359, 212, 46);
		btnNewButton_8.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_8);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giaoan.lik-trong-dong.png"));
		lblNewLabel_1.setBounds(-34, 0, 409, 490);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giphy.jpg"));
		lblNewLabel.setBounds(0, 0, 375, 500);
		contentPane.add(lblNewLabel);
//		JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		if(findPeriod(king.getTrieuDai())==null){
//			JLabel getDynastyLabel = new JLabel(king.getTrieuDai());
//			linkPanel.add(getDynastyLabel);
//		}else{
//			JLabel getDynastyLabel = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
//					" cursor: pointer;\">"+ king.getTrieuDai() + "</span></html>");
//			getDynastyLabel.addMouseListener(new MouseAdapter() {
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					dispose();
//					PeriodGui periodGui = new PeriodGui(findPeriod(king.getTrieuDai()));
//					periodGui.setVisible(true);
//
//				}
//			});
//			linkPanel.add(getDynastyLabel);
//
//		}

		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\unnamed.jpg"));
		lblNewLabel_9.setBounds(715, 0, 212, 92);
		contentPane.add(lblNewLabel_9);
		
		JTextArea txtrNinHiu = new JTextArea();
		txtrNinHiu.setText("Niên hiệu:	"+ king.getLabel());
		txtrNinHiu.setBounds(385, 332, 520, 46);
		txtrNinHiu.setLineWrap(true);
		contentPane.add(txtrNinHiu);
		
		JTextArea txtrThT = new JTextArea();
		txtrThT.setText("Thế tử:	"+ king.getOtherName());
		txtrThT.setBounds(385, 399, 520, 46);
		txtrThT.setLineWrap(true);
		contentPane.add(txtrThT);
		
		JTextArea txtrNmMt = new JTextArea();
		txtrNmMt.setText("Năm mất:	"+ king.getDeath());
		txtrNmMt.setBounds(385, 259, 520, 53);
		txtrNmMt.setLineWrap(true);
		contentPane.add(txtrNmMt);
		
		JTextArea txtrNmSinh = new JTextArea();
		txtrNmSinh.setText("Năm sinh:	"+king.getBirth());
		txtrNmSinh.setBounds(385, 203, 520, 46);
		txtrNmSinh.setLineWrap(true);
		contentPane.add(txtrNmSinh);
		
		JTextArea txtrNmTrV = new JTextArea();
		txtrNmTrV.setText("Năm trị vì:	"+king.getGoverment());
		txtrNmTrV.setBounds(385, 147, 520, 34);
		txtrNmTrV.setLineWrap(true);
		contentPane.add(txtrNmTrV);
		
		JTextArea txtrTriui = new JTextArea();
		txtrTriui.setText("Triều đại:"+king.getEra());
		txtrTriui.setBounds(530, 91, 375, 34);
		
		JLabel linkLabel = new JLabel("Triều đại:	" );
		JPanel linkPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		linkPanel.setBounds(385, 79, 520, 58);
		linkPanel.add(linkLabel);
		linkPanel.setBackground(Color.WHITE);
		if(findPeriod(king.getEra())==null){
			JLabel getDynastyLabel = new JLabel(king.getEra());
			linkPanel.add(getDynastyLabel);
		}else{
			JLabel getDynastyLabel = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
					" cursor: pointer;\">"+ king.getEra() + "</span></html>");
			getDynastyLabel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					PeriodGui periodGui = new PeriodGui(findPeriod(king.getEra()));
					periodGui.setVisible(true);

				}
			});
			linkPanel.add(getDynastyLabel);
		}
	
		contentPane.add(linkPanel);
	}

	public Era findPeriod(String str){
		File folder = new File("src\\main\\resources\\Json\\Era");
		File[] fileList = folder.listFiles();

		stringEdit s = new stringEdit();

		Gson gson = new Gson();
		Era period = null;
		for(File file : fileList){
			try{
				String content = new String(Files.readAllBytes(file.toPath()));
				Era pe = gson.fromJson(content, Era.class);
				if(s.compareString(str, pe.getEra())==1){
					period = pe;
					return period;
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return period;

	}
}

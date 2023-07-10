package screen;

import button.AestheticButton;
import editstring.*;
import frame.FesGui;
import models.Festival;

import com.google.gson.Gson;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class FesSearch extends JFrame {

	private JPanel contentPane;
	private JTable festivalTable;

	private DefaultTableModel tableModel;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FesSearch frame = new FesSearch();
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
	public FesSearch() {
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
		btnNewButton_4.setBounds(122, 79, 212, 46);
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
		btnNewButton.setBounds(122, 135, 212, 46);
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
		btnNewButton_1.setBounds(122, 191, 212, 46);
		btnNewButton_1.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_1);

		AestheticButton btnNewButton_5 = new AestheticButton("THOÁT");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_5.setBounds(122, 415, 212, 46);
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
		btnNewButton_6.setBounds(122, 247, 212, 46);
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
		btnNewButton_3.setBounds(122, 23, 212, 46);
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
		btnNewButton_7.setBounds(122, 303, 212, 46);
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
		btnNewButton_8.setBounds(122, 359, 212, 46);
		btnNewButton_8.setFont(new Font("Playfair Display", Font.BOLD, 12));
		getContentPane().add(btnNewButton_8);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giaoan.lik-trong-dong.png"));
		lblNewLabel_1.setBounds(-34, 0, 525, 490);
		getContentPane().add(lblNewLabel_1);

		JTextField txtNhpThngTin = new JTextField();
		txtNhpThngTin.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtNhpThngTin.setSize(358, 27);
		txtNhpThngTin.setLocation(531, 49);

		txtNhpThngTin.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128), 2), new EmptyBorder(5, 5, 5, 5)));
		getContentPane().add(txtNhpThngTin);

		Gson gson = new Gson();
		File folder = new File("src\\main\\resources\\Json\\Festivals");
		File[] fileList = folder.listFiles();
		ArrayList<Festival> fesList = new ArrayList<>();

		for (File file : fileList) {

			try {
				String content = new String(Files.readAllBytes(file.toPath()));
				Festival fes = gson.fromJson(content, Festival.class);
				fesList.add(fes);
			} catch (IOException e) {
				throw new RuntimeException(e);

			}
		}

		ArrayList<String> suggestionList = new ArrayList<>();
		for (Festival fes : fesList) {
			suggestionList.add(fes.getFestival());
		}

		StringSorterIgnoreCase strSort = new StringSorterIgnoreCase();
		strSort.sortAlphabeticallyIgnoreCase(suggestionList);


		tableModel = new DefaultTableModel(new Object[]{"Index", "Name"},0);

		for(int i = 0; i < suggestionList.size(); i++){
			String fesName = suggestionList.get(i);
			tableModel.addRow(new Object[]{i+1, fesName});
		}


		txtNhpThngTin.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				String text = txtNhpThngTin.getText().toLowerCase();
				tableModel.setRowCount(0);
				for (int i = 0; i < suggestionList.size(); i++) {
					String suggestion = suggestionList.get(i);
					if (suggestion.toLowerCase().startsWith(text)) {
						tableModel.addRow(new Object[]{i + 1, suggestion});
					}
				}
			}
		});

		Font fontSuggest = new Font("Serif", Font.PLAIN, 16);

		festivalTable = new JTable(tableModel);
		festivalTable.setFont(fontSuggest);
		festivalTable.setForeground(new Color(0,0,153));
		festivalTable.setBackground(new Color(255,229,204));
		JScrollPane scrollPane = new JScrollPane(festivalTable);
		scrollPane.setBackground(new Color(255,229,204));


		festivalTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					int rowIndex = festivalTable.getSelectedRow();
					String selectedText = (String) festivalTable.getValueAt(rowIndex, 1);
					for (Festival fes : fesList) {
						if (fes.getFestival().equalsIgnoreCase(selectedText)) {
							dispose();
							FesGui fesGui = new FesGui(fes);
							fesGui.setVisible(true);
						}
					}
				}
			}
		});

		festivalTable.getColumnModel().getColumn(0).setResizable(false);
		festivalTable.getColumnModel().getColumn(0).setPreferredWidth(15);
		festivalTable.getColumnModel().getColumn(1).setResizable(false);
		festivalTable.getColumnModel().getColumn(1).setPreferredWidth(370);

		scrollPane.setBounds(491, 114, 481, 376);

		contentPane.add(scrollPane);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giphy (4).gif"));
		lblNewLabel_2.setBounds(491, 0, 480, 174);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giphy.jpg"));
		lblNewLabel.setBounds(0, 0, 491, 490);
		contentPane.add(lblNewLabel);

	}
}

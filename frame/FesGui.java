package frame;

import screen.*;

import com.google.gson.Gson;
import button.AestheticButton;
import models.Festival;
import models.HistoricalFigure;

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

public class FesGui extends JFrame {
    private Festival festival;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
//public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FesGui frame = new FesGui(festival);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

    public FesGui(Festival festival) {
        this.festival = festival;
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
        setTitle("FesSearch\r\n");
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
        btnNewButton_4.setBounds(79, 79, 212, 46);
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
        btnNewButton.setBounds(79, 135, 212, 46);
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
        btnNewButton_1.setBounds(79, 191, 212, 46);
        btnNewButton_1.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_1);

        AestheticButton btnNewButton_5 = new AestheticButton("THOÁT");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_5.setBounds(79, 415, 212, 46);
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
        btnNewButton_6.setBounds(79, 247, 212, 46);
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
        btnNewButton_3.setBounds(79, 23, 212, 46);
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
        btnNewButton_7.setBounds(79, 303, 212, 46);
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
        btnNewButton_8.setBounds(79, 359, 212, 46);
        btnNewButton_8.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_8);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giaoan.lik-trong-dong.png"));
        lblNewLabel_1.setBounds(-34, 0, 390, 490);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giphy.jpg"));
        lblNewLabel.setBounds(0, 0, 356, 500);
        contentPane.add(lblNewLabel);

        JTextArea lblNewLabel_2 = new JTextArea("Tên lễ hội: "+festival.getFestival());
        lblNewLabel_2.setBounds(414, 87, 404, 46);
        contentPane.add(lblNewLabel_2);

        JTextArea lblNewLabel_5 = new JTextArea("Ngày tổ chức: " + festival.getDate());
        lblNewLabel_5.setSize(404, 68);
        lblNewLabel_5.setLocation(414, 203);
        contentPane.add(lblNewLabel_5);

        JTextArea lblNewLabel_6 = new JTextArea("Địa diểm: "+festival.getLocation());
        lblNewLabel_6.setSize(404, 58);
        lblNewLabel_6.setLocation(414, 281);
        contentPane.add(lblNewLabel_6);


        JTextArea lblNewLabel_8 = new JTextArea("Lần đầu tổ chức: "+festival.getFirst());
        lblNewLabel_8.setSize(491, 65);
        lblNewLabel_8.setLocation(414, 415);
        contentPane.add(lblNewLabel_8);
        JPanel linkPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        linkPanel.setBounds(572,135,333,68);
        linkPanel.setBackground(Color.WHITE);
        if(findFigures(festival.getRelatedFigures())==null){
        	JLabel getDynastyLabel = new JLabel(festival.getRelatedFigures());
            linkPanel.add(getDynastyLabel);
        }else{
        	JLabel getDynastyLabel = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ festival.getRelatedFigures() + "</span></html>");
            getDynastyLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    FiguresGui figuresGui = new FiguresGui(findFigures(festival.getRelatedFigures()));
                    figuresGui.setVisible(true);

                }
            });
            linkPanel.add(getDynastyLabel);

        }
        contentPane.add(linkPanel);

        JLabel lblNewLabel_9 = new JLabel("");
        lblNewLabel_9.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\unnamed.jpg"));
        lblNewLabel_9.setBounds(693, 0, 222, 109);
        contentPane.add(lblNewLabel_9);
        
        JTextArea textArea = new JTextArea(festival.getNote());
        
        textArea.setBounds(477, 343, 428, 68);
        textArea.setLineWrap(true);
        contentPane.add(textArea);
        
        
                JTextArea lblNewLabel_4 = new JTextArea("Nhân vật liên quan: ");
                lblNewLabel_4.setBounds(414, 147, 165, 22);
                contentPane.add(lblNewLabel_4);
                
                JTextArea txtrGhiCh = new JTextArea();
                txtrGhiCh.setText("Ghi chú:");
                txtrGhiCh.setBounds(414, 343, 94, 22);
                contentPane.add(txtrGhiCh);


    }

    public HistoricalFigure findFigures(String str){
        if(str.equalsIgnoreCase("Chưa rõ")) return null;
        File folder = new File("src\\main\\resources\\Json\\Figures");
        File[] fileList = folder.listFiles();
        Gson gson = new Gson();
        HistoricalFigure fig = null;

        for(File file : fileList){
            try{
                String content = new String(Files.readAllBytes(file.toPath()));
                HistoricalFigure figures = gson.fromJson(content, HistoricalFigure.class);
                if(figures == null) continue;
                if(figures.getName().equalsIgnoreCase(str) || figures.getRealName().equalsIgnoreCase(str)){
                    fig = figures;
                    return fig;
                }else{
                    for(String s : figures.getAlternameList()){
                        if(s.equalsIgnoreCase(str)){
                            fig = figures;
                            return fig;
                        }
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return fig;
    }
}


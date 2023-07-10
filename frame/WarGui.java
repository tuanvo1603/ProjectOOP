package frame;

import editstring.*;
import models.HistoricalFigure;
import models.Era;
import models.War;
import screen.*;

import com.google.gson.Gson;
import button.AestheticButton;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WarGui extends JFrame {
    private War war;

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

    public WarGui(War war) {
        this.war = war;
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
        setTitle("SUKIEN");
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
        btnNewButton_4.setBounds(60, 79, 212, 46);
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
        btnNewButton.setBounds(60, 135, 212, 46);
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
        btnNewButton_1.setBounds(60, 191, 212, 46);
        btnNewButton_1.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_1);

        AestheticButton btnNewButton_5 = new AestheticButton("THOÁT");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_5.setBounds(60, 415, 212, 46);
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
        btnNewButton_6.setBounds(60, 247, 212, 46);
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
        btnNewButton_3.setBounds(60, 22, 212, 46);
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
        btnNewButton_7.setBounds(60, 303, 212, 46);
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
        btnNewButton_8.setBounds(60, 359, 212, 46);
        btnNewButton_8.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_8);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giaoan.lik-trong-dong.png"));
        lblNewLabel_1.setBounds(-34, 0, 380, 490);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giphy.jpg"));
        lblNewLabel.setBounds(0, 0, 346, 500);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Cuộc chiến: "+war.getName());
        lblNewLabel_2.setBounds(378, 97, 514, 44);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_4 = new JLabel("Thủ lĩnh: ");
        JPanel linkPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        linkPanel.setBounds(378,151,514,30);
        linkPanel.setBackground(Color.WHITE);
        linkPanel.add(lblNewLabel_4);
        linkPanel.setBackground(Color.WHITE);
        if(findPeriod(war.getLeader())==null){
            JLabel getDynastyLabel = new JLabel(war.getLeader());
            linkPanel.add(getDynastyLabel);
        }else{
            JLabel getDynastyLabel = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ war.getLeader() + "</span></html>");
            getDynastyLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    PeriodGui periodGui = new PeriodGui(findPeriod(war.getLeader()));
                    periodGui.setVisible(true);

                }
            });
            linkPanel.add(getDynastyLabel);

        }
        contentPane.add(linkPanel);


        JLabel lblNewLabel_5 = new JLabel("Kẻ thù: ");
        JPanel linkEnemy = new JPanel(new FlowLayout(FlowLayout.LEFT));
        linkEnemy.setBackground(Color.WHITE);
        linkEnemy.setBounds(378,221,514,50);
        linkEnemy.add(lblNewLabel_5);
        linkEnemy.setBackground(Color.WHITE);
        if(findPeriod(war.getEnemy()) == null){
            JLabel enemy = new JLabel(war.getEnemy());
            linkEnemy.add(enemy);
        }else{
            JLabel enemy = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ war.getEnemy() + "</span></html>");
            enemy.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    PeriodGui periodGui = new PeriodGui(findPeriod(war.getEnemy()));
                    periodGui.setVisible(true);

                }
            });
            linkEnemy.add(enemy);
        }
        contentPane.add(linkEnemy);

        JLabel lblNewLabel_6 = new JLabel("Giai đoạn: "+war.getPeriod());
        lblNewLabel_6.setSize(514, 46);
        lblNewLabel_6.setLocation(378, 292);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Triều đại: ");
        JPanel linkPe = new JPanel(new FlowLayout(FlowLayout.LEFT));
        linkPe.setBackground(Color.WHITE);
        linkPe.setBounds(378,368,514,37);
        linkPe.add(lblNewLabel_7);
        linkPe.setBackground(Color.WHITE);
        if(findPeriod(war.getEra() ) == null){
            JLabel trieudai = new JLabel(war.getEra());
            linkEnemy.add(trieudai);
        }else{
            JLabel trieudai = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ war.getEra() + "</span></html>");
            trieudai.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    PeriodGui periodGui = new PeriodGui(findPeriod(war.getEra()));
                    periodGui.setVisible(true);

                }
            });
            linkEnemy.add(trieudai);
        }
        contentPane.add(linkPe);


        JLabel lblNewLabel_8 = new JLabel("Kết quả: "+war.getResult());
        lblNewLabel_8.setSize(514, 46);
        lblNewLabel_8.setLocation(378, 415);
        contentPane.add(lblNewLabel_8);



        JLabel lblNewLabel_9 = new JLabel("New label");
        lblNewLabel_9.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\unnamed.jpg"));
        lblNewLabel_9.setBounds(715, 0, 212, 92);
        contentPane.add(lblNewLabel_9);


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
                }else{
                    for(String vua : pe.getKings()){
                        if(s.compareString(str, vua)==1){
                            period = pe;
                            return period;
                        }
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return period;

    }
}

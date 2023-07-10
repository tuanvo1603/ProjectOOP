package frame;

import editstring.*;
import models.Festival;
import models.King;
import models.HistoricSite;
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

public class SiteGui extends JFrame {
    private HistoricSite sites;

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

    public SiteGui(HistoricSite sites) {
        this.sites = sites;
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
        setTitle("DIADANH");
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
        btnNewButton_4.setBounds(68, 79, 212, 46);
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
        btnNewButton.setBounds(68, 135, 212, 46);
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
        btnNewButton_1.setBounds(68, 191, 212, 46);
        btnNewButton_1.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_1);

        AestheticButton btnNewButton_5 = new AestheticButton("THOÁT");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_5.setBounds(68, 419, 212, 46);
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
        btnNewButton_6.setBounds(68, 247, 212, 46);
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
        btnNewButton_3.setBounds(68, 23, 212, 46);
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
        btnNewButton_7.setBounds(68, 303, 212, 46);
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
        btnNewButton_8.setBounds(68, 359, 212, 46);
        btnNewButton_8.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_8);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giaoan.lik-trong-dong.png"));
        lblNewLabel_1.setBounds(-34, 0, 402, 490);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giphy.jpg"));
        lblNewLabel.setBounds(0, 0, 368, 500);
        contentPane.add(lblNewLabel);
        JPanel linkPanel =new JPanel(new FlowLayout(FlowLayout.LEFT));
        linkPanel.setBackground(new Color(255, 255, 255));
        linkPanel.setBounds(378,151,514,30);
        linkPanel.setBackground(Color.WHITE);
        if(findFes(sites.getRelatedFestival())==null){
            JLabel getDynastyLabel = new JLabel(sites.getRelatedFestival());
            linkPanel.add(getDynastyLabel);
        }else{
            JLabel getDynastyLabel = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ sites.getRelatedFestival() + "</span></html>");
            getDynastyLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    FesGui fesGui = new FesGui(findFes(sites.getRelatedFestival()));

                }
            });
            linkPanel.add(getDynastyLabel);

        }
        contentPane.add(linkPanel);
        
        JLabel lblNewLabel_3 = new JLabel("Di tích: "+sites.getHistoricSite());
        linkPanel.add(lblNewLabel_3);


        JLabel lblNewLabel_5 = new JLabel("Địa điểm: "+sites.getLocation());
        lblNewLabel_5.setSize(514, 35);
        lblNewLabel_5.setLocation(378, 272);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Nhân vật liên quan: ");
        JPanel linkPanel2 =new JPanel(new FlowLayout(FlowLayout.LEFT));
        linkPanel2.setBounds(378,213,514,46);
        linkPanel2.add(lblNewLabel_6);
        linkPanel2.setBackground(Color.WHITE);
        for(String vua : sites.getRelatedThings()){
            String strVua = vua + ",\n";
            if(findKing(vua) != null){
                JLabel figl = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                        " cursor: pointer;\">"+ strVua + "</span></html>");
                linkPanel2.add(figl);
                figl.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                            dispose();
                         KingGui kingGui = new KingGui(findKing(vua));
                         kingGui.setVisible(true);
                    }
                });
            }else continue;
        }
        contentPane.add(linkPanel2);

        JLabel lblNewLabel_7 = new JLabel("Năm công nhận: "+sites.getApprovedYear());
        lblNewLabel_7.setSize(514, 35);
        lblNewLabel_7.setLocation(378, 357);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Mô tả: "+sites.getDescribe());
        lblNewLabel_8.setSize(514, 46);
        lblNewLabel_8.setLocation(378, 427);
        contentPane.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Loại di tích: "+sites.getType());
        lblNewLabel_9.setBounds(378, 397, 514, 35);
        contentPane.add(lblNewLabel_9);
        
                JLabel lblNewLabel_4 = new JLabel("Lễ hội liên quan: ");
                lblNewLabel_4.setBounds(378, 312, 514, 30);
                contentPane.add(lblNewLabel_4);
                
                JLabel lblNewLabel_10 = new JLabel("New label");
                lblNewLabel_10.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\unnamed.jpg"));
                lblNewLabel_10.setBounds(708, 11, 197, 73);
                contentPane.add(lblNewLabel_10);
                
                JPanel panel = new JPanel();
                panel.setBounds(378, 90, 514, 35);
                contentPane.add(panel);
                
                        JLabel lblNewLabel_2 = new JLabel("Ghi chú: "+sites.getNote());
                        panel.add(lblNewLabel_2);


    }

    public King findKing(String str){
        File folder = new File("src\\main\\resources\\Json\\King");
        File[] fileList = folder.listFiles();
        King king = null;
        Gson gson = new Gson();
        int count = 0;

        stringEdit s = new stringEdit();

        for(File file : fileList){
            try{
                String content = new String(Files.readAllBytes(file.toPath()));
                King vua = gson.fromJson(content, King.class);
                if(str.equalsIgnoreCase(vua.getName())){
                    king = vua;
                    return king;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        return king;

    }

    public Festival findFes(String str){
        File folder = new File("src\\main\\resources\\Json\\Festival");
        File[] fileList = folder.listFiles();
        Festival fesReturn = null;
        Gson gson = new Gson();
        int count = 0;

        stringEdit s = new stringEdit();

        for(File file : fileList){
            try{
                String content = new String(Files.readAllBytes(file.toPath()));
                Festival fes = gson.fromJson(content, Festival.class);
                if(s.compareString(str, fes.getFestival())==1){
                    fesReturn = fes;
                    return fesReturn;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        return fesReturn;
    }
}

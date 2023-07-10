package frame;

import editstring.*;
import models.HistoricalFigure;
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

public class FiguresGui extends JFrame {
    private HistoricalFigure figures;

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

    public FiguresGui(HistoricalFigure figures) {
        this.figures = figures;
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
        setTitle("NHANVAT");
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
        btnNewButton_4.setBounds(65, 79, 212, 46);
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
        btnNewButton.setBounds(65, 135, 212, 46);
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
        btnNewButton_1.setBounds(65, 191, 212, 46);
        btnNewButton_1.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_1);

        AestheticButton btnNewButton_5 = new AestheticButton("THOÁT");
        btnNewButton_5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_5.setBounds(65, 415, 212, 46);
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
        btnNewButton_6.setBounds(65, 247, 212, 46);
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
        btnNewButton_3.setBounds(65, 23, 212, 46);
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
        btnNewButton_7.setBounds(65, 303, 212, 46);
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
        btnNewButton_8.setBounds(65, 359, 212, 46);
        btnNewButton_8.setFont(new Font("Playfair Display", Font.BOLD, 12));
        getContentPane().add(btnNewButton_8);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giaoan.lik-trong-dong.png"));
        lblNewLabel_1.setBounds(-34, 0, 379, 490);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\giphy.jpg"));
        lblNewLabel.setBounds(0, 0, 345, 500);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_3 = new JLabel("Tên thật: "+figures.getRealName());
        lblNewLabel_3.setBounds(397, 107, 508, 46);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_5 = new JLabel("Tên thường gọi: "+figures.getAlternameString());
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Thông tin về ngày sinh: "+figures.getBirth());
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Thông tin về ngày mất: "+figures.getLost());
        lblNewLabel_7.setBounds(397, 260, 508, 46);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("Chức vụ: "+figures.getPosition());
        lblNewLabel_8.setBounds(397, 63, 307, 46);
        contentPane.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Thời gian tại chức: "+figures.getWorkTime());
        lblNewLabel_9.setBounds(397, 303, 508, 26);
        contentPane.add(lblNewLabel_9);
        JPanel linkPanel1 =new JPanel(new FlowLayout(FlowLayout.LEFT));
        linkPanel1.setBackground(Color.WHITE);
        linkPanel1.setBounds(397,421,508,40);
                
                        JLabel lblNewLabel_4 = new JLabel("Triều đại: ");
                        linkPanel1.add(lblNewLabel_4);
        if(findPeriod(figures.getEra())==null){
            JLabel getDynastyLabel = new JLabel(figures.getEra());
            linkPanel1.add(getDynastyLabel);
        }else{
            JLabel getDynastyLabel = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ figures.getEra() + "</span></html>");
            getDynastyLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    PeriodGui peGui = new PeriodGui(findPeriod(figures.getEra()));
                    peGui.setVisible(true);
                }
            });
            linkPanel1.add(getDynastyLabel);

        }
        contentPane.add(linkPanel1);


        JLabel lblNewLabel_10 = new JLabel("Cha: "+figures.getFather());
        lblNewLabel_10.setBounds(397, 183, 508, 31);
        lblNewLabel_5.setSize(508, 46);
        lblNewLabel_5.setLocation(397, 144);
        contentPane.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("Mẹ: "+figures.getMother());
        lblNewLabel_11.setBounds(397, 211, 508, 26);
        lblNewLabel_6.setSize(508, 31);
        lblNewLabel_6.setLocation(397, 240);
        contentPane.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("Thế hệ tiền nhiệm: ");
        JPanel  precededPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        precededPanel.setBounds(397,336,508,31);
        precededPanel.add(lblNewLabel_12);
        precededPanel.setBackground(Color.WHITE);
        if(findFigures(figures.getPreceded())==null){
            JLabel figl = new JLabel(figures.getPreceded());
            precededPanel.add(figl);
        }else{
            JLabel figl = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ figures.getPreceded() + "</span></html>");
            figl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    FiguresGui figuresGui = new FiguresGui(findFigures(figures.getPreceded()));
                    figuresGui.setVisible(true);
                }
            });
            precededPanel.add(figl);
        }
        contentPane.add(precededPanel);
        
        JLabel lblNewLabel_20 = new JLabel("Thế hệ kế nhiệm: ");
        JPanel  precededPanel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        precededPanel1.setBounds(397,380,508,31);
        precededPanel1.add(lblNewLabel_20);
        precededPanel1.setBackground(Color.WHITE);
        if(findFigures(figures.getSucceeded())==null){
            JLabel fig2 = new JLabel(figures.getSucceeded());
            precededPanel1.add(fig2);
        }else{
            JLabel fig2 = new JLabel("<html><span style=\"color: blue; text-decoration: underline;" +
                    " cursor: pointer;\">"+ figures.getSucceeded() + "</span></html>");
            fig2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    dispose();
                    FiguresGui figuresGui = new FiguresGui(findFigures(figures.getSucceeded()));
                    figuresGui.setVisible(true);
                }
            });
            precededPanel1.add(fig2);
        }
        contentPane.add(precededPanel1);
        
        JLabel lblNewLabel_14 = new JLabel("New label");
        lblNewLabel_14.setIcon(new ImageIcon("src\\main\\resources\\Pictures\\unnamed.jpg"));
        lblNewLabel_14.setBounds(714, 8, 191, 79);
        contentPane.add(lblNewLabel_14);
        
        JPanel panel = new JPanel();
        panel.setBounds(397, 34, 307, 35);
        panel.setBackground(Color.WHITE);
        contentPane.add(panel);
        
                JLabel lblNewLabel_2 = new JLabel("Nhân vật: "+figures.getName());
                panel.add(lblNewLabel_2);


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
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return period;

    }
}

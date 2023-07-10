
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import screen.HomeScreen;

public class Main extends JFrame {

        private JPanel contentPane;

        /**
         * Launch the application.
         */
        public static void main(String[] args) {
                EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        HomeScreen Application = new HomeScreen();
                                        Application.setVisible(true);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                        }
                });
        }


}

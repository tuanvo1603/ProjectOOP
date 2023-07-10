package button;

import java.awt.*;
import javax.swing.*;

public class AestheticButton extends JButton {

    private Color buttonColor = new Color(25, 25, 25);
    private Color buttonHoverColor = new Color(40, 40, 40);
    private Color buttonPressedColor = new Color(60, 60, 60);
    private int cornerRadius = 15;

    public AestheticButton(String text) {
        super(text);

        setForeground(Color.WHITE);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setOpaque(false);
        setPreferredSize(new Dimension(150, 50));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(buttonPressedColor);
        } else if (getModel().isRollover()) {
            g2.setColor(buttonHoverColor);
        } else {
            g2.setColor(buttonColor);
        }

        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        g2.setColor(getForeground());
        FontMetrics metrics = g2.getFontMetrics();
        Rectangle rect = new Rectangle(getWidth(), getHeight());
        int x = rect.x + (rect.width - metrics.stringWidth(getText())) / 2;
        int y = rect.y + ((rect.height - metrics.getHeight()) / 2) + metrics.getAscent();
        g2.drawString(getText(), x, y);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(buttonPressedColor.darker());
        } else if (getModel().isRollover()) {
            g2.setColor(buttonHoverColor.brighter());
        } else {
            g2.setColor(buttonColor.brighter());
        }

        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);

        g2.dispose();
    }
}

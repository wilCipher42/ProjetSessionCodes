package WindowBuilderTest;

import javax.swing.*;
import java.awt.*;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    public BackgroundPanel(String imagePath) {
        try {
            backgroundImage = new ImageIcon(getClass().getResource("../Icons/logo-bus.png")).getImage();
        } catch (Exception e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image.
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

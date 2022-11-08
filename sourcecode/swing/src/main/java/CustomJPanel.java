import javax.swing.*;
import java.awt.*;

public class CustomJPanel extends JPanel {
    CustomJPanel(){
        super.setPreferredSize(new Dimension(800,800));
    }

    public void paintComponent(Graphics g) {
       Graphics2D g2d = (Graphics2D) g;
       g2d.setPaint(Color.MAGENTA);
       g2d.fill(new Rectangle(100,100, 100,100));
    }
}

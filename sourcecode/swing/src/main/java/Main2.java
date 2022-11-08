import javax.swing.*;

public class Main2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Lab2");
        JPanel customPanel = new CustomJPanel();
        frame.add(customPanel);
        frame.setVisible(true);
    }
}

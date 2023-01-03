import javax.swing.*;
import java.awt.*;

public class ErrorFrame extends JFrame {
    public ErrorFrame(String errorText) {
        JLabel error = new JLabel(errorText);
        this.setTitle("Error");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(300,150);
        this.setVisible(true);
        ImageIcon logo = new ImageIcon("");
        this.setIconImage(logo.getImage());    //change frame icon
        this.add(error);
    }
}

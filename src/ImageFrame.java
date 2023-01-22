import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ImageFrame extends JFrame{

    //instance of DoctorListFrame
    DoctorListFrame dObj = new DoctorListFrame();

    //default Constructor
    public ImageFrame(String filepath) {
        //set frame title
        this.setTitle("Westminster Skin Consultation Clinic - Consultations");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
        //decrypt image
        dObj.decryptImage(filepath);
        ImageIcon image = new ImageIcon("decrypted" + filepath);
        Image newImage = image.getImage().getScaledInstance(600, 400,  java.awt.Image.SCALE_SMOOTH);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(newImage));
        this.add(label);
        this.setVisible(true);
        File file = new File("decrypted" + filepath);
        file.delete();
    }
}

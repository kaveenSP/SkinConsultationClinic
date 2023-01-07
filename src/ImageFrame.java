import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class ImageFrame extends JFrame{

    DoctorListFrame dObj = new DoctorListFrame();
    public ImageFrame(String filepath) {
        this.setTitle("Westminster Skin Consultation Clinic - Consultations");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600,400);
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

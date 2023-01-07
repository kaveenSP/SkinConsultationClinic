import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ConsultationListFrame extends JFrame implements ActionListener{
    private static WestminsterSkinConsultationManager obj = new WestminsterSkinConsultationManager();
    private DoctorListFrame dlfObj = new DoctorListFrame();
    JTable cTable;
    JButton image,delete;
    public ConsultationListFrame() throws Exception {
        this.setTitle("Westminster Skin Consultation Clinic - Consultations");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1080,720);
//        ImageIcon logo = new ImageIcon("");
//        this.setIconImage(logo.getImage());    //change frame icon
        this.setLayout(new BorderLayout());

//        JPanel cTopPanel = new JPanel();
//        cTopPanel.setBackground(Color.cyan);
//        cTopPanel.setPreferredSize(new Dimension(1080,55));
//        cTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel cTopPanel = new JPanel();
        cTopPanel.setBackground(new Color(255,161,119));
        cTopPanel.setPreferredSize(new Dimension(1080,55));

        JLabel cLeftMainText = new JLabel();
        cTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        cLeftMainText.setText("Westminster Skin Consultation Clinic");
        cLeftMainText.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        cTopPanel.add(cLeftMainText);



        JPanel cMiddlePanel = new JPanel();
        cMiddlePanel.setPreferredSize(new Dimension(1080,550));
        JButton viewImage = new JButton("View Image");
        String[] columnHeaders = {"First Name", "Surname", "Patient ID", "DOB", "Mobile Number", "Cost", "Consultation Date & Time", "Notes", "Doctor"};
        DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, WestminsterSkinConsultationManager.doctors.size() - WestminsterSkinConsultationManager.doctors.size());
        for (Consultation consultation : WestminsterSkinConsultationManager.consultations) {
            tableModel.addRow(new Object[]{consultation.getName(), consultation.getSurname(), consultation.getPatientId() ,consultation.getDateOfBirth(), consultation.getMobileNumber(), consultation.getCost(), consultation.getConsultationDateAndTime(), dlfObj.decryptNotes(consultation.getNotes()), consultation.getDoctorName()});
        }
        cTable = new JTable(tableModel);
        cTable.setAutoCreateRowSorter(true);
        cTable.setRowHeight(cTable.getRowHeight() + 15);
        JScrollPane pane = new JScrollPane(cTable);
        pane.setPreferredSize(new Dimension(1070,550));
        cMiddlePanel.add(pane);

        JPanel cBottomPanel = new JPanel();
        cBottomPanel.setBackground(new Color(245,199,184));
        cBottomPanel.setPreferredSize(new Dimension(1080,65));
//        save = new JButton("Save Changes");
//        save.addActionListener(this);
//        cBottomPanel.add(save);
//        cBottomPanel.add(Box.createHorizontalStrut(50));
        image = new JButton("View Image");
        image.addActionListener(this);
        cBottomPanel.add(image);

        delete = new JButton("Delete Consultation");
        delete.addActionListener(this);
        cBottomPanel.add(delete);


        this.add(cTopPanel, BorderLayout.NORTH);
        this.add(cMiddlePanel, BorderLayout.CENTER);
        this.add(cBottomPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == image) {
            int selectedRow = cTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please Select A Consultation From The Table");
            } else {
                String imageFilePath = WestminsterSkinConsultationManager.consultations.get(selectedRow).getFileName();
                System.out.println(imageFilePath);
                try {
                    File file = new File(imageFilePath);
                    new ImageFrame(imageFilePath);
                } catch (NullPointerException err) {
                    JOptionPane.showMessageDialog(null, "No Image Available For Selected Consultation");
                }
            }
        }
//        if(e.getSource() == save) {
//            for (int i = 0; i < WestminsterSkinConsultationManager.consultations.size(); i++) {
//                cTable.getModel().
//
//            }
//            obj.saveConsultationsDataToFile(WestminsterSkinConsultationManager.consultations);
//        }
        if(e.getSource() == delete) {
            int selectedRow = cTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(null, "Please Select A Consultation From The Table");
            } else {
                WestminsterSkinConsultationManager.consultations.remove(selectedRow);
                ((DefaultTableModel)cTable.getModel()).removeRow(selectedRow);
                obj.saveConsultationsDataToFile();
            }
        }
    }
}
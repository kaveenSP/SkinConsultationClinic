import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultationListFrame extends JFrame{
    private static WestminsterSkinConsultationManager obj = new WestminsterSkinConsultationManager();

    JTable cTable;
//    JButton save,delete;
    public ConsultationListFrame() {
        this.setTitle("Westminster Skin Consultation Clinic - Consultations");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1080,720);
        this.setVisible(true);
//        ImageIcon logo = new ImageIcon("");
//        this.setIconImage(logo.getImage());    //change frame icon
        this.setLayout(new BorderLayout());

//        JPanel cTopPanel = new JPanel();
//        cTopPanel.setBackground(Color.cyan);
//        cTopPanel.setPreferredSize(new Dimension(1080,55));
//        cTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel cTopPanel = new JPanel();
        cTopPanel.setBackground(Color.cyan);
        cTopPanel.setPreferredSize(new Dimension(1080,55));

        JLabel cLeftMainText = new JLabel();
        cTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        cLeftMainText.setText("Westminster Skin Consultation Clinic");
        cLeftMainText.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        cTopPanel.add(cLeftMainText);



        JPanel cMiddlePanel = new JPanel();
        cMiddlePanel.setPreferredSize(new Dimension(1080,550));

        String[] columnHeaders = {"First Name", "Surname", "Patient ID", "DOB", "Mobile Number", "Cost", "Consultation Date & Time", "Notes", "Doctor"};
        DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, WestminsterSkinConsultationManager.doctors.size() - WestminsterSkinConsultationManager.doctors.size());
        for (Consultation consultation : WestminsterSkinConsultationManager.consultations) {
            tableModel.addRow(new Object[]{consultation.getName(), consultation.getSurname(), consultation.getPatientId() ,consultation.getDateOfBirth(), consultation.getMobileNumber(), consultation.getCost(), consultation.getConsultationDateAndTime(), consultation.getNotes(), consultation.getDoctorName()});
        }
        cTable = new JTable(tableModel);
        cTable.setAutoCreateRowSorter(true);
        cTable.setRowHeight(cTable.getRowHeight() + 15);
        JScrollPane pane = new JScrollPane(cTable);
        pane.setPreferredSize(new Dimension(1070,550));
        cMiddlePanel.add(pane);

        JPanel cBottomPanel = new JPanel();
        cBottomPanel.setBackground(Color.RED);
        cBottomPanel.setPreferredSize(new Dimension(1080,65));
//        save = new JButton("Save Changes");
//        save.addActionListener(this);
//        cBottomPanel.add(save);
//        cBottomPanel.add(Box.createHorizontalStrut(50));
//        delete = new JButton("Delete Consultation");
//        delete.addActionListener(this);
//        cBottomPanel.add(delete);


        this.add(cTopPanel, BorderLayout.NORTH);
        this.add(cMiddlePanel, BorderLayout.CENTER);
        this.add(cBottomPanel, BorderLayout.SOUTH);
    }


//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == save) {
//            for (int i = 0; i < WestminsterSkinConsultationManager.consultations.size(); i++) {
//                cTable.getModel().
//
//            }
//            obj.saveConsultationsDataToFile(WestminsterSkinConsultationManager.consultations);
//        }
//        if(e.getSource() == delete) {
//            int selectedRow = cTable.getSelectedRow();
//            if (selectedRow == -1) {
//                new ErrorFrame("Select A Consultation");
//            } else {
//                WestminsterSkinConsultationManager.consultations.remove(selectedRow);
//                cTable.addNotify();
//            }
//        }
//    }
}

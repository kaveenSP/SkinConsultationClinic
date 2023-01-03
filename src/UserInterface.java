import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class UserInterface {

    private static ArrayList<Doctor> doctorsList = new ArrayList<Doctor>();

    private static WestminsterSkinConsultationManager obj = new WestminsterSkinConsultationManager();

    public static void main(String[] args) {
        obj.loadDoctorsDataFromFile(doctorsList);
        JFrame frame = new JFrame();
        frame.setTitle("Westminster Skin Consultation Clinic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080,720);
        frame.setVisible(true);
        ImageIcon logo = new ImageIcon("");
        frame.setIconImage(logo.getImage());    //change frame icon
        frame.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.cyan);
        topPanel.setPreferredSize(new Dimension(1080,55));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel leftMainText = new JLabel();
        leftMainText.setText("Westminster Skin Consultation Clinic");
        leftMainText.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        topPanel.add(leftMainText);
        topPanel.add(Box.createHorizontalStrut(340));
        JButton consultations = new JButton("Consultations");
        consultations.setBounds(60,270, 200, 50);
        topPanel.add(consultations);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        middlePanel.setPreferredSize(new Dimension(1080,350));
        String[] columnHeaders = {"First Name", "Surname", "DOB", "Mobile Number", "Medical Licence Number", "Specialization"};
        DefaultTableModel tableModel = new DefaultTableModel(columnHeaders,doctorsList.size() - 1);
        for (Doctor doctor : doctorsList) {
            tableModel.addRow(new Object[]{doctor.getName(), doctor.getSurname(), doctor.getDateOfBirth(), doctor.getMobileNumber(), doctor.getMedicalLicenceNumber(), doctor.getSpecialization(),});
        }
        JTable table = new JTable(tableModel);
        table.setRowHeight(table.getRowHeight() + 15);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(1070,400));
        middlePanel.add(pane);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(1080,285));
        bottomPanel.setLayout(new BorderLayout());
        JPanel bTopPanel = new JPanel();
        bTopPanel.setPreferredSize(new Dimension(1080,45));
        bTopPanel.setBackground(Color.PINK);
        bTopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton sort = new JButton("Sort");
        bTopPanel.add(sort);
        bTopPanel.add(Box.createHorizontalStrut(100));

        JLabel day = new JLabel("Day");
        bTopPanel.add(day);
        JTextField dayValue = new JTextField();
        dayValue.setPreferredSize(new Dimension(50,20));
        bTopPanel.add(dayValue);
        JLabel month = new JLabel("Month");
        bTopPanel.add(month);
        JTextField monthValue = new JTextField();
        monthValue.setPreferredSize(new Dimension(50,20));
        bTopPanel.add(monthValue);
        JLabel year = new JLabel("Year");
        bTopPanel.add(year);
        JTextField yearValue = new JTextField();
        yearValue.setPreferredSize(new Dimension(50,20));
        bTopPanel.add(yearValue);
        JLabel hour = new JLabel("Hour");
        bTopPanel.add(hour);
        JTextField hourValue = new JTextField();
        hourValue.setPreferredSize(new Dimension(50,20));
        bTopPanel.add(hourValue);
        JLabel minutes = new JLabel("Minutes");
        bTopPanel.add(minutes);
        JTextField minutesValue = new JTextField();
        minutesValue.setPreferredSize(new Dimension(50,20));
        bTopPanel.add(minutesValue);

        JButton availabilty = new JButton("Check Availability");
        bTopPanel.add(availabilty);
        JLabel availableDoctor = new JLabel();
        bTopPanel.add(availableDoctor);


        JPanel bMiddlePanel = new JPanel();
        bMiddlePanel.setPreferredSize(new Dimension(1080,150));
        bMiddlePanel.setBackground(Color.ORANGE);
        JLabel pName = new JLabel("Name");
        bMiddlePanel.add(pName);
        JTextField pNameValue = new JTextField();
        pNameValue.setPreferredSize(new Dimension(200,40));
        bMiddlePanel.add(pNameValue);
        JLabel pSurname = new JLabel("Surname");
        bMiddlePanel.add(pSurname);
        JTextField pSurnameValue = new JTextField();
        pSurnameValue.setPreferredSize(new Dimension(200,40));
        bMiddlePanel.add(pSurnameValue);
        JLabel pDOB = new JLabel("Date Of Birth");
        bMiddlePanel.add(pDOB);
        JTextField pMobileNumber = new JTextField();
        pMobileNumber.setPreferredSize(new Dimension(200,40));
        bMiddlePanel.add(pMobileNumber);
        JLabel pId = new JLabel("ID");
        bMiddlePanel.add(pId);
        JTextField pIdValue = new JTextField();
        pIdValue.setPreferredSize(new Dimension(200,40));
        bMiddlePanel.add(pIdValue);

        JLabel consultationHours = new JLabel("Consultation Hours");
        bMiddlePanel.add(consultationHours);
        JTextField consultationHoursValue = new JTextField();
        consultationHoursValue.setPreferredSize(new Dimension(100,40));
        bMiddlePanel.add(consultationHoursValue);
        bMiddlePanel.add(Box.createHorizontalStrut(100));
        JLabel consultationCost = new JLabel("Consultation Cost : ");
        bMiddlePanel.add(consultationCost);
        JLabel consultationCostValue = new JLabel();
        bMiddlePanel.add(consultationCostValue);

        JTextArea notesValue = new JTextArea(5,70);
        bMiddlePanel.add(notesValue);

        JPanel bBottomPanel = new JPanel();
        bBottomPanel.setPreferredSize(new Dimension(1080,45));
        JButton addConsultation = new JButton("Add Consultation");
        bBottomPanel.add(addConsultation);


        bottomPanel.add(bTopPanel, BorderLayout.NORTH);
        bottomPanel.add(bMiddlePanel, BorderLayout.CENTER);
        bottomPanel.add(bBottomPanel, BorderLayout.SOUTH);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(middlePanel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);


    }


}

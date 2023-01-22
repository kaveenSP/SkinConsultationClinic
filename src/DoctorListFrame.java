import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class DoctorListFrame extends JFrame implements ActionListener{
    private static WestminsterSkinConsultationManager obj = new WestminsterSkinConsultationManager();

    private static LocalDateTime dateTime = null;
    private static String fileName;

    private JButton consultations,availabilty,addConsultation, calculateCost, upload;
    private JTable table;
    private JTextField yearValue, pNameValue, pSurnameValue, dobYearValue, pMobileNumber, pIdValue, consultationHoursValue;
    private JComboBox dobDayValue, dobMonthValue, dayValue, monthValue, hourValue, minutesValue;
    private JLabel availableDoctor, consultationCostValue;
    private  JTextArea notesValue;
    private int secretKey = 169;

    //default Constructor
    public DoctorListFrame() {
        //sets frame title
        this.setTitle("Westminster Skin Consultation Clinic");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1080,720);

        //sets frame layout
        this.setLayout(new BorderLayout());
        this.add(new JLabel("lol"));

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(255,161,119));
        topPanel.setPreferredSize(new Dimension(1080,55));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel leftMainText = new JLabel();
        leftMainText.setText("Westminster Skin Consultation Clinic");
        leftMainText.setFont(new Font(Font.DIALOG,Font.BOLD,30));
        topPanel.add(leftMainText);
        topPanel.add(Box.createHorizontalStrut(340));
        consultations = new JButton("Consultations");
        consultations.addActionListener(this);
        consultations.setBounds(60,270, 200, 50);
        topPanel.add(consultations);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        middlePanel.setPreferredSize(new Dimension(1080,350));

        //add table headers to consultation table
        String[] columnHeaders = {"First Name", "Surname", "DOB", "Mobile Number", "Medical Licence Number", "Specialization"};
        DefaultTableModel tableModel = new DefaultTableModel(columnHeaders, WestminsterSkinConsultationManager.doctors.size() - WestminsterSkinConsultationManager.doctors.size());

        //add data to consultations table
        for (Doctor doctor : WestminsterSkinConsultationManager.doctors) {
            tableModel.addRow(new Object[]{doctor.getName(), doctor.getSurname(), doctor.getDateOfBirth(), doctor.getMobileNumber(), doctor.getMedicalLicenceNumber(), doctor.getSpecialization(),});
        }
        table = new JTable(tableModel);
        table.setAutoCreateRowSorter(true);
        table.setRowHeight(table.getRowHeight() + 15);
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(1070,400));
        middlePanel.add(pane);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(1080,285));
        bottomPanel.setLayout(new BorderLayout());
        JPanel bTopPanel = new JPanel();
        bTopPanel.setPreferredSize(new Dimension(1080,45));
        bTopPanel.setBackground(new Color(245,199,184));

        JLabel day = new JLabel("Day");
        bTopPanel.add(day);
        String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        dayValue = new JComboBox<>(days);
        dayValue.setPreferredSize(new Dimension(70,20));
        bTopPanel.add(dayValue);
        JLabel month = new JLabel("Month");
        String[] months = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        bTopPanel.add(month);
        monthValue = new JComboBox<>(months);
        monthValue.setPreferredSize(new Dimension(70,20));
        bTopPanel.add(monthValue);
        JLabel year = new JLabel("Year");
        bTopPanel.add(year);
        yearValue = new JTextField();
        yearValue.setPreferredSize(new Dimension(50,20));
        bTopPanel.add(yearValue);
        JLabel hour = new JLabel("Hour");
        bTopPanel.add(hour);
        String[] hours = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","00"};
        hourValue = new JComboBox<>(hours);
        hourValue.setPreferredSize(new Dimension(70,20));
        bTopPanel.add(hourValue);
        JLabel minutes = new JLabel("Minutes");
        bTopPanel.add(minutes);
        String[] aMinutes = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
        minutesValue = new JComboBox<>(aMinutes);
        minutesValue.setPreferredSize(new Dimension(70,20));
        bTopPanel.add(minutesValue);
        availabilty = new JButton("Check Availability");
        availabilty.addActionListener(this);
        bTopPanel.add(availabilty);
        JLabel text = new JLabel("Selected Doctor : Dr. ");
        bTopPanel.add(text);
        availableDoctor = new JLabel("");
        bTopPanel.add(availableDoctor);

        JPanel bMiddlePanel = new JPanel();
        bMiddlePanel.setPreferredSize(new Dimension(1080,150));
        bMiddlePanel.setBackground(new Color(245,199,184));
        JLabel pName = new JLabel("Name");
        bMiddlePanel.add(pName);
        pNameValue = new JTextField();
        pNameValue.setPreferredSize(new Dimension(100,40));
        bMiddlePanel.add(pNameValue);
        JLabel pSurname = new JLabel("Surname");
        bMiddlePanel.add(pSurname);
        pSurnameValue = new JTextField();
        pSurnameValue.setPreferredSize(new Dimension(100,40));
        bMiddlePanel.add(pSurnameValue);
        JLabel pDOB = new JLabel("Date Of Birth : ");
        bMiddlePanel.add(pDOB);
        JLabel dobDay = new JLabel("DD");
        bMiddlePanel.add(dobDay);
        dobDayValue = new JComboBox<>(days);
        dobDayValue.setPreferredSize(new Dimension(70,40));
        bMiddlePanel.add(dobDayValue);
        JLabel dobMonth = new JLabel("MM");
        bMiddlePanel.add(dobMonth);
        dobMonthValue = new JComboBox<>(months);
        dobMonthValue.setPreferredSize(new Dimension(70,40));
        bMiddlePanel.add(dobMonthValue);
        JLabel dobYear = new JLabel("YYYY");
        bMiddlePanel.add(dobYear);
        dobYearValue = new JTextField();
        dobYearValue.setPreferredSize(new Dimension(80,40));
        bMiddlePanel.add(dobYearValue);
        JLabel mobileNumber = new JLabel("Mobile Number");
        bMiddlePanel.add(mobileNumber);
        pMobileNumber = new JTextField();
        pMobileNumber.setPreferredSize(new Dimension(100,40));
        bMiddlePanel.add(pMobileNumber);
        JLabel pId = new JLabel("ID");
        bMiddlePanel.add(pId);
        pIdValue = new JTextField();
        pIdValue.setPreferredSize(new Dimension(100,40));
        bMiddlePanel.add(pIdValue);

        JLabel consultationHours = new JLabel("Consultation Hours");
        bMiddlePanel.add(consultationHours);
        consultationHoursValue = new JTextField();
        consultationHoursValue.setPreferredSize(new Dimension(100,40));
        bMiddlePanel.add(consultationHoursValue);
        calculateCost = new JButton("Calculate Cost");
        calculateCost.addActionListener(this);
        bMiddlePanel.add(calculateCost);
        JLabel consultationCost = new JLabel("Consultation Cost : ");
        bMiddlePanel.add(consultationCost);
        consultationCostValue = new JLabel();
        bMiddlePanel.add(consultationCostValue);

        notesValue = new JTextArea(5,70);
        bMiddlePanel.add(notesValue);
        upload = new JButton("Upload Image");
        upload.addActionListener(this);
        bMiddlePanel.add(upload);

        JPanel bBottomPanel = new JPanel();
        bBottomPanel.setBackground(new Color(245,199,184));
        bBottomPanel.setPreferredSize(new Dimension(1080,45));
        addConsultation = new JButton("Add Consultation");
        addConsultation.addActionListener(this);
        bBottomPanel.add(addConsultation);


        bottomPanel.add(bTopPanel, BorderLayout.NORTH);
        bottomPanel.add(bMiddlePanel, BorderLayout.CENTER);
        bottomPanel.add(bBottomPanel, BorderLayout.SOUTH);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(middlePanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    /**Encrypt notes regarding patient condition
     * @param notes first name
     */
    public String encryptNotes(String notes){
        char[] characters = notes.toCharArray();
        String encryptedText = "";
        for(char c : characters) {
            c += secretKey;
            encryptedText += c;
        }
        return encryptedText;
    }

    /**Decrypt notes regarding patient condition
     * @param encryptedNotes first name
     * @return decryptedText decrypted notes
     */
    public String decryptNotes(String encryptedNotes) {
        char[] characters = new char[encryptedNotes.length()];
        for (int i = 0; i < encryptedNotes.length(); i++) {
            characters[i] = encryptedNotes.charAt(i);
        }
        String decryptedText = "";
        for(char c : characters) {
            c -= secretKey;
            decryptedText += c;
        }
        return decryptedText;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == consultations) {
            try {
                new ConsultationListFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        int _day, _month, _year, _hour, _minutes;

        if(e.getSource() == availabilty) {
            if (dayValue.getSelectedItem().toString().equals("") || monthValue.getSelectedItem().toString().equals("") || yearValue.getText().equals("") || hourValue.getSelectedItem().toString().equals("") || minutesValue.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fill Out Each Field");
            } else {
                try {
                    //conversion of String To Int
                    _day = Integer.parseInt(dayValue.getSelectedItem().toString());
                    _month = Integer.parseInt(monthValue.getSelectedItem().toString());
                    _year = Integer.parseInt(yearValue.getText());
                    _hour = Integer.parseInt(hourValue.getSelectedItem().toString());
                    _minutes = Integer.parseInt(minutesValue.getSelectedItem().toString());
                    dateTime = LocalDateTime.of(LocalDate.of(_year,_month,_day), LocalTime.of(_hour,_minutes));
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow == -1) {
                        JOptionPane.showMessageDialog(null, "Please Select A Doctor");
                    } else {
                        String doctorName = table.getModel().getValueAt(selectedRow, 0).toString() + " " + table.getModel().getValueAt(selectedRow, 1).toString();
                        boolean foundDoctor = false;

                        //checks if the doctor already has an appointment at the selected time
                        if (WestminsterSkinConsultationManager.consultations.size() != 0) {
                            for (int i = 0; i < WestminsterSkinConsultationManager.consultations.size(); i++) {
                                if (WestminsterSkinConsultationManager.consultations.get(i).getDoctorName().equalsIgnoreCase(doctorName)) {
                                    if (WestminsterSkinConsultationManager.consultations.get(i).getConsultationDateAndTime().equals(dateTime)) {
                                        foundDoctor = false;
                                        break;
                                    } else {
                                        foundDoctor = true;
                                    }
                                } else {
                                    foundDoctor = true;
                                }
                            }

                            if (foundDoctor) {
                                availableDoctor.setText(doctorName);
                            } else {
                                int random = (int)(Math.random() * WestminsterSkinConsultationManager.doctors.size());

                                while (true) {
                                    if((WestminsterSkinConsultationManager.doctors.get(random).getName() + " " + WestminsterSkinConsultationManager.doctors.get(random).getSurname()).equalsIgnoreCase(doctorName)) {
                                        if (WestminsterSkinConsultationManager.consultations.get(random).getConsultationDateAndTime().equals(dateTime)) {
                                            random = (int) (Math.random() * WestminsterSkinConsultationManager.doctors.size());
                                        }
                                    } else {
                                        availableDoctor.setText(WestminsterSkinConsultationManager.doctors.get(random).getName() + " " + WestminsterSkinConsultationManager.doctors.get(random).getSurname());
                                        break;
                                    }
                                }
                            }
                        } else {
                            availableDoctor.setText(doctorName);
                        }
                    }
                    //Validates User Input
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Details");
                } catch (IndexOutOfBoundsException er) {
                    System.out.println("");
                }
            }
        }

        //calculates consultation cost
        if(e.getSource() == calculateCost) {
            String consultationHours = consultationHoursValue.getText();
            String patName = pNameValue.getText();
            String patSurname = pSurnameValue.getText();
            if (patName.equals("") || patSurname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Patient Name");
            } else if (consultationHours.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Enter Number of Consultation Hours");
            } else {
                try {
                    String patFullName = patName + patSurname;
                    int _consultationHours = Integer.parseInt(consultationHours);
                    int costPerHour = 0;
                    if (WestminsterSkinConsultationManager.consultations.size() == 0) {
                        costPerHour = 15;
                    } else {
                        for (int i = 0; i < WestminsterSkinConsultationManager.consultations.size(); i++) {
                            if ((WestminsterSkinConsultationManager.consultations.get(i).getName() + WestminsterSkinConsultationManager.consultations.get(i).getSurname()).equalsIgnoreCase(patFullName)) {
                                costPerHour = 25;
                                break;
                            } else {
                                costPerHour = 15;
                            }
                        }
                    }
                    consultationCostValue.setText(Integer.toString(costPerHour*_consultationHours));
                    //Validates user input
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Details");
                }
            }
        }

        if(e.getSource() == addConsultation) {
            String _name = pNameValue.getText();
            String _surname = pSurnameValue.getText();
            String _dobDay = Objects.requireNonNull(dobDayValue.getSelectedItem()).toString();
            String _dobMonth = Objects.requireNonNull(dobMonthValue.getSelectedItem()).toString();
            String _dobYear = dobYearValue.getText();
            String _mobileNumber = pMobileNumber.getText();
            String _patientId = pIdValue.getText();
            String _doctor = availableDoctor.getText();
            String _cost = consultationCostValue.getText();
            String _notes = notesValue.getText();
            if(_name.equals("") || _surname.equals("") || _dobDay.equals("") || _dobMonth.equals("") || _dobYear.equals("") || _mobileNumber.equals("") || _patientId.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Fill Each Field");
            } else if(_doctor.equals("")) {
                JOptionPane.showMessageDialog(null, "Please Select A Doctor");
            } else {
                try {
                    //conversion of String to Int
                    int __day = Integer.parseInt(_dobDay);
                    int __month = Integer.parseInt(_dobMonth);
                    int __year = Integer.parseInt(_dobYear);
                    int __mobileNumber = Integer.parseInt(_mobileNumber);
                    int __patientId = Integer.parseInt(_patientId);
                    int __cost = Integer.parseInt(_cost);
                    LocalDate _dob = LocalDate.of(__year,__month,__day);

                    _notes = encryptNotes(_notes);
                    Consultation consultation = new Consultation(_name,_surname, _dob, __mobileNumber, __patientId, dateTime, __cost, _notes, _doctor, fileName);
                    fileName = "";
                    WestminsterSkinConsultationManager.consultations.add(consultation);
                    obj.saveConsultationsDataToFile();
                    JOptionPane.showMessageDialog(null, "Consultation Added Successfully");
                } catch (NumberFormatException er) {
                    JOptionPane.showMessageDialog(null, "Please Fill Each Field With Valid Details");
                } catch (Exception er) {
                    er.printStackTrace();
                }
            }
        }

        if(e.getSource() == upload) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);
            File file =  fileChooser.getSelectedFile();
            String filePath = file.getAbsolutePath();
            fileName = file.getName();
            encryptImage(filePath, fileName);
        }
    }

    /**Encrypt images regarding patient condition
     * @param fileName file name
     * @param filePath file path
     */
    public void encryptImage(String filePath, String fileName) {
        try {
            FileInputStream file = new FileInputStream(filePath);
            FileOutputStream outputStream = new FileOutputStream(fileName);

            //secret key
            byte key[] = "secret12".getBytes();
            SecretKeySpec spec = new SecretKeySpec(key, "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, spec);
            CipherOutputStream cos = new CipherOutputStream(outputStream, cipher);
            byte[] buffer = new byte[1024];
            int read;

            //write data
            while ((read = file.read(buffer)) != -1) {
                cos.write(buffer, 0, read);
            }
           file.close();
            outputStream.close();
            JOptionPane.showMessageDialog(null, "File Encrypted Successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**Decrypt images regarding patient condition
     * @param fileName file name
     */
    public void decryptImage(String fileName) {
        try {
            FileInputStream file = new FileInputStream(fileName);
            FileOutputStream outputStream = new FileOutputStream("decrypted" + fileName);

            //Secret Key
            byte key[] = "secret12".getBytes();
            SecretKeySpec spec = new SecretKeySpec(key, "DES");
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, spec);
            CipherOutputStream cos = new CipherOutputStream(outputStream, cipher);
            byte[] buffer = new byte[1024];
            int read;

            //read data
            while ((read = file.read(buffer)) != -1) {
                cos.write(buffer, 0, read);
            }
            file.close();
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

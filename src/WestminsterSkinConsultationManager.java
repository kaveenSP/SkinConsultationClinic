import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable {

    /**
     * Default constructor
     */
    public WestminsterSkinConsultationManager() {

    }

    public static ArrayList<Doctor> doctors = new ArrayList<Doctor>();  //contains Doctor Objects
    public static ArrayList<Consultation> consultations = new ArrayList<Consultation>();    //contains Consultation objects
    static Scanner input = new Scanner(System.in);

    /**
     * Main Method
     */
    public static void main(String[] args) throws Exception {

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loadDoctorsDataFromFile();
        manager.loadConsultationsDataFromFile();
        boolean checkLoop = true;   //control while loop below
        String choice; //user option is stored here

        System.out.println("| WESTMINSTER SKIN CONSULTATION CLINIC |");
        while(checkLoop) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("    A : ADD NEW DOCTOR");
            System.out.println("    D : REMOVE DOCTOR");
            System.out.println("    P : PRINT THE LIST OF DOCTORS");
            System.out.println("    S : SAVE DATA TO FILE");
            System.out.println("    C : CANCEL CONSULTATION");
            System.out.println("    V : VIEW CONSULTATIONS");
            System.out.println("    G : OPEN GRAPHICAL USER INTERFACE");
            System.out.println("    Q : QUIT THE PROGRAM");
            System.out.println("\nSelect Required Option : ");
            choice = input.nextLine();
            choice = choice.toLowerCase();
            System.out.println("-----------------------------------------------------------------------");

            switch(choice) {
                case "a":
                    manager.addNewDoctor();
                    break;
                case "d":
                    manager.deleteDoctor();
                    break;
                case "p":
                    manager.printDoctorList();
                    break;
                case "s":
                    manager.saveDoctorsDataToFile();
                    manager.saveConsultationsDataToFile();
                    break;
                case "c":
                    manager.cancelConsultation();
                    break;
                case "v":
                    manager.viewConsultations();
                    break;
                case "g":
                    new DoctorListFrame();
                    break;
                case "q":
                    checkLoop = false;
                    break;
                default :
                    System.out.println("Invalid Option Selected");
                    break;
            }
        }
    }

    /**Add new doctor to doctors arraylist. Maximum allowed doctors are 10.
     **/
    @Override
    public void addNewDoctor() {
        if (doctors.size() >= 10) {
            System.out.println("Doctor List Is Full");
        } else {
            try {
                while (true) {
                    //user inputs the first name of the doctor
                    System.out.println("Enter The First Name Of The Doctor");
                    String name = input.nextLine();
                    if (name.equals("") || name.equals(" ")) {
                        System.out.println("Name Field Cannot Be Empty !\n\nWould you like to try again ? (Y/N)");
                        String answer = input.nextLine();
                        if (answer.equalsIgnoreCase("Y")) {
                            continue;
                        } else if (answer.equalsIgnoreCase("N")) {
                            System.out.println("Doctor Has Not Been Added To The List.");
                            break;
                        } else {
                            System.out.println("\nInvalid Option Selected. You Will Now Be Redirected To The Main Menu.");
                            break;
                        }
                    } else {
                        while (true) {
                            //user inputs the surname of the doctor
                            System.out.println("Enter The Surname Of The Doctor");
                            String surname = input.nextLine();
                            if (surname.equals("") || surname.equals(" ")) {
                                System.out.println("Surname Field Cannot Be Empty !\n\nWould you like to try again ? (Y/N)");
                                String answer = input.nextLine();
                                if (answer.equalsIgnoreCase("Y")) {
                                    continue;
                                } else if (answer.equalsIgnoreCase("N")) {
                                    System.out.println("Doctor Has Not Been Added To The List.");
                                    break;
                                } else {
                                    System.out.println("\nInvalid Option Selected. You Will Now Be Redirected To The Main Menu.");
                                    break;
                                }
                            } else {
                                while (true) {
                                    //user inputs date of birth of the doctor
                                    System.out.println("Enter The Birth Year Of The Doctor");
                                    int year = input.nextInt();
                                    input.nextLine();
                                    System.out.println("Enter The Birth Month Of The Doctor");
                                    int month = input.nextInt();
                                    input.nextLine();
                                    System.out.println("Enter The Birth Date Of The Doctor");
                                    int date = input.nextInt();
                                    input.nextLine();
                                    LocalDate dateOfBirth = LocalDate.of(year, month, date);
                                    while (true) {
                                        //user inputs the mobile number of the doctor
                                        System.out.println("Enter The Mobile Number Of The Doctor");
                                        int mobileNumber = input.nextInt();
                                        input.nextLine();
                                        while (true) {
                                            System.out.println("Enter The Medical Licence Number Of The Doctor");
                                            int medicalLicenceNumber = input.nextInt();
                                            input.nextLine();
                                            while (true) {
                                                //user inputs the specialization of the doctor
                                                System.out.println("Enter The Specialization Of The Doctor");
                                                String specializaion = input.nextLine();
                                                if (specializaion.equals("") || specializaion.equals(" ")) {
                                                    System.out.println("Specialization Field Cannot Be Empty !\n\nWould you like to try again ? (Y/N)");
                                                    String answer = input.nextLine();
                                                    if (answer.equalsIgnoreCase("Y")) {
                                                        continue;
                                                    } else if (answer.equalsIgnoreCase("N")) {
                                                        System.out.println("Doctor Has Not Been Added To The List.");
                                                        break;
                                                    } else {
                                                        System.out.println("\nInvalid Option Selected. You Will Now Be Redirected To The Main Menu.");
                                                        break;
                                                    }
                                                } else {
                                                    //new doctor object created
                                                    Doctor doctor = new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenceNumber, specializaion);
                                                    doctors.add(doctor);
                                                    System.out.println("Dr." + doctor.getName() + " " + doctor.getSurname() + " Has Been Added To The List.");
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        break;
                                    }
                                    break;
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                //validation for inputs
            } catch (InputMismatchException e) {
                System.out.println("Invalid Value Detected !\n\nWould you like to try again ? (Y/N)");
                input.nextLine();
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    addNewDoctor();
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Doctor Has Not Been Added To The List !");
                } else {
                    System.out.println("\nInvalid Option Selected. You will now be redirected to the Menu.");
                }
                //validation for date of birth
            } catch (DateTimeException e) {
                System.out.println("Invalid Value Detected !\n\nWould you like to try again ? (Y/N)");
                input.nextLine();
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    addNewDoctor();
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Doctor Has Not Been Added To The List !");
                } else {
                    System.out.println("\nInvalid Option Selected. You will now be redirected to the Menu.");
                }
            }
        }
    }

    /**Removes a doctor from the arraylist doctors
     **/
    @Override
    public void deleteDoctor() {
        if(doctors.size() == 0) {
            System.out.println("Doctor List Is Empty");
        } else {
            try {
                //user inputs medical license number of the doctor
                System.out.println("Enter The Medical Licence Number Of The Doctor");
                int medLic = input.nextInt();
                input.nextLine();
                boolean removed = false;
                String doctorName = "";
                for (int i = 0; i < doctors.size(); i++) {
                    if (doctors.get(i).getMedicalLicenceNumber() == medLic) {
                        doctorName = doctors.get(i).getName() + " " + doctors.get(i).getSurname();
                        doctors.remove(i);
                        removed = true;
                    }
                    if (removed) {
                        System.out.println("Dr. " + doctorName + " Has Been Removed From Westminster Skin Consultation Clinic");
                        break;
                    }
                }
                //checks if medical licence number is wrong
                if (!removed) {
                    System.out.println("No Doctor Was Found With The Specified License Number");
                }
                //validates user input
            } catch (InputMismatchException e) {
                System.out.println("Invalid Value Detected !\n\nWould you like to try again ? (Y/N)");
                input.nextLine();
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    deleteDoctor();
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Doctor Has Not Been Removed !");
                } else {
                    System.out.println("\nInvalid Option Selected. You will now be redirected to the Menu.");
                }
            }
        }
    }

    /**Displays the list of doctors alphabetically sorted according to the surname
     **/
    @Override
    public void printDoctorList() {
        if(doctors.size() == 0) {
            System.out.println("No Doctors Available");
        } else {
            //sorting
            doctors.sort(new Comparator<Doctor>() {
                public int compare(Doctor d1, Doctor d2) {
                    return d1.getSurname().compareToIgnoreCase(d2.getSurname());
                }
            });
            //display sorted list
            for (int i = 0; i < doctors.size(); i++) {
                System.out.println("Dr." + doctors.get(i).getName() + " " + doctors.get(i).getSurname());
            }
        }
    }

    /**Save doctor details into a ser file
     **/
    @Override
    public void saveDoctorsDataToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("doctorList_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //writing to file
            for (Doctor pDoctor : doctors) {
                out.writeObject(pDoctor);
            }
            out.close();
            fileOut.close();
            System.out.println("Doctors Data Has Been Stored Successfully ");
        } catch (IOException e) {
            System.out.println("Something Went Wrong !");
            e.printStackTrace();
        }
    }

    /**loads doctors data from file
     **/
    @Override
    public void loadDoctorsDataFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("doctorList_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //read from file
            for (int i = 0; i < 10; i++) {
                doctors.add((Doctor) in.readObject());
            }
            System.out.println("Doctors Data Has Been Loaded Successfully");
            in.close();
            fileIn.close();
            //checks if file is already created
        } catch (FileNotFoundException e) {
            System.out.println("Doctors Data Has Not Been Stored Yet");
        } catch (IOException e) {
            System.out.println("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**Save consultation details into a ser file
     **/
    @Override
    public void saveConsultationsDataToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("consultations_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            //writing to file
            for (Consultation pDoctor : consultations) {
                out.writeObject(pDoctor);
            }
            out.close();
            fileOut.close();
            System.out.println("Consultation Data Has Been Stored Successfully ");
        } catch (IOException e) {
            System.out.println("Something Went Wrong !");
            e.printStackTrace();
        }
    }

    /**loads doctors data from file
     **/
    @Override
    public void loadConsultationsDataFromFile(){
        try {
            FileInputStream fileIn = new FileInputStream("consultations_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            //read from file
            for (int i = 0; i < 10; i++) {
                consultations.add((Consultation) in.readObject());
            }

            System.out.println("Consultation Data Has Been Loaded Successfully");
            in.close();
            fileIn.close();
            //checks if file is created before
        } catch (FileNotFoundException e) {
            System.out.println("Consultation Data Has Not Been Stored Yet");
        } catch (IOException e) {
            System.out.println("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**Displays Consultation details in terminal
     **/
    @Override
    public void viewConsultations() {
        if(consultations.size() == 0) {
            System.out.println("No Consultations Added");
        } else {
            //displays consultation data
            for (int i = 0; i < consultations.size(); i++) {
                System.out.println("Consultation 0" + (i + 1));
                System.out.println("Patient Name : " + consultations.get(i).getName() + " " + consultations.get(i).getSurname());
                System.out.println("Doctor Name : " + consultations.get(i).getDoctorName());
                System.out.println("Consultation Cost : " + consultations.get(i).getCost());
                System.out.println("Consultation Date : " + consultations.get(i).getConsultationDateAndTime());
                System.out.println("Patient ID : " + consultations.get(i).getPatientId());
                System.out.println("Patient DOB : " + consultations.get(i).getDateOfBirth());
                System.out.println("Patient Contact Number : " + consultations.get(i).getMobileNumber());
                System.out.println("----------------------------------------------");
            }
        }
    }

    /**Removes a consultations
     **/
    @Override
    public void cancelConsultation() {
        if(consultations.size() == 0) {
            System.out.println("Consultation List Is Empty");
        } else {
            try {
                while (true) {
                    //user inputs the full name of the doctor
                    System.out.println("Enter The Full Name Of The Doctor");
                    String name = input.nextLine();
                    if (name.equals("") || name.equals(" ")) {
                        System.out.println("Name Field Cannot Be Empty !\n\nWould you like to try again ? (Y/N)");
                        String answer = input.nextLine();
                        if (answer.equalsIgnoreCase("Y")) {
                            continue;
                        } else if (answer.equalsIgnoreCase("N")) {
                            System.out.println("Consultation Has Not Been Removed.");
                            break;
                        } else {
                            System.out.println("\nInvalid Option Selected. You Will Now Be Redirected To The Main Menu.");
                            break;
                        }
                    } else {
                        //user inputs the patient ID
                        System.out.println("Enter The Patient ID");
                        int patientId = input.nextInt();
                        input.nextLine();
                        boolean removed = false; //for validation of consultation removal
                        for (int i = 0; i < consultations.size(); i++) {
                            if (consultations.get(i).getDoctorName().equalsIgnoreCase(name) && consultations.get(i).getPatientId() == (patientId)) {
                                System.out.println("Consultation With Dr. " + consultations.get(i).getDoctorName() + " and Patient " + consultations.get(i).getName() + " " + consultations.get(i).getSurname() + " Has Been Removed");
                                consultations.remove(i);
                                removed = true;
                                break;
                            }
                        }
                        if (!removed) {
                            System.out.println("Consultation Not Found");
                        }
                        break;
                    }
                }
                //validate user input
            } catch (InputMismatchException e) {
                System.out.println("Invalid Value Detected !\n\nWould you like to try again ? (Y/N)");
                input.nextLine();
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    cancelConsultation();
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Consultation Has Not Been Removed !");
                } else {
                    System.out.println("\nInvalid Option Selected. You will now be redirected to the Menu.");
                }
            }
        }
    }
}
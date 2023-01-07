import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable {

    public WestminsterSkinConsultationManager() {

    }

    public static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    public static ArrayList<Consultation> consultations = new ArrayList<Consultation>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loadDoctorsDataFromFile();
        manager.loadConsultationsDataFromFile();
        boolean checkLoop = true;
        String choice;

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
                    doctors.add(manager.addNewDoctor());
                    break;
                case "d":
                    try {
                        System.out.println("Enter The Medical Licence Number Of The Doctor");
                        int medNo = input.nextInt();
                        input.nextLine();
                        manager.deleteDoctor(medNo);
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Invalid Value Detected !\n\nWould you like to try again ? (Y/N)");
                        input.nextLine();
                        String answer = input.nextLine();
                        if (answer.equalsIgnoreCase("Y")) {
                            System.out.println("Enter The Medical Licence Number Of The Doctor");
                            int medNo = input.nextInt();
                            input.nextLine();
                            manager.deleteDoctor(medNo);
                        } else if (answer.equalsIgnoreCase("N")) {
                            System.out.println("Doctor Has Not Been Removed !");
                        } else {
                            System.out.println("\nInvalid Option Selected. You will now be redirected to the Menu.");
                        }
            }
                    break;
                case "p":
                    manager.printDoctorList();
                    break;
                case "s":
                    manager.saveDoctorsDataToFile();
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

    @Override
    public Doctor addNewDoctor() {
        if (doctors.size() >= 10) {
            System.out.println("Doctor List Is Full");
            return null;
        } else {
            try {
                while (true) {
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
                                        System.out.println("Enter The Mobile Number Of The Doctor");
                                        int mobileNumber = input.nextInt();
                                        input.nextLine();
                                        while (true) {
                                            System.out.println("Enter The Medical Licence Number Of The Doctor");
                                            int medicalLicenceNumber = input.nextInt();
                                            input.nextLine();
                                            while (true) {
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
                                                    Doctor doctor = new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenceNumber, specializaion);
                                                    System.out.println("Dr." + doctor.getName() + " " + doctor.getSurname() + " Has Been Added To The List.");
                                                    return doctor;
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
            }
            return null;
        }
    }

    @Override
    public void deleteDoctor(int medicalLicenceNumber) {
        if(doctors.size() == 0) {
            System.out.println("Doctor List Is Empty");
        } else {
                int medLic = medicalLicenceNumber;
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
                if(!removed) {
                    System.out.println("No Doctor Was Found With The Specified License Number");
                }
        }
    }

    @Override
    public void printDoctorList() {
        Collections.sort(doctors,new Comparator<Doctor>() {
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareToIgnoreCase(d2.getSurname());
            }
        });
        for(int i = 0; i < doctors.size(); i++) {
            System.out.println("Dr." + doctors.get(i).getName() + " " + doctors.get(i).getSurname());
        }
    }

    @Override
    public void saveDoctorsDataToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("doctorList_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (Doctor pDoctor : doctors) {
                out.writeObject(pDoctor);
            }
            out.close();
            fileOut.close();
            System.out.println("Data Has Been Stored Successfully ");
        } catch (IOException e) {
            System.out.println("Something Went Wrong !");
            e.printStackTrace();
        }
    }

    @Override
    public void loadDoctorsDataFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("doctorList_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for (int i = 0; i < 10; i++) {
                doctors.add((Doctor) in.readObject());
            }

            System.out.println("Data Has Been Loaded Successfully");
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Data Has Not Been Stored Yet");
        } catch (IOException e) {
            System.out.println("Something Went Wrong !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveConsultationsDataToFile() {
        try {
            FileOutputStream fileOut = new FileOutputStream("consultations_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (Consultation pDoctor : consultations) {
                out.writeObject(pDoctor);
            }
            out.close();
            fileOut.close();
            System.out.println("Data Has Been Stored Successfully ");
        } catch (IOException e) {
            System.out.println("Something Went Wrong !");
            e.printStackTrace();
        }
    }

    @Override
    public void loadConsultationsDataFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("consultations_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for (int i = 0; i < 10; i++) {
                consultations.add((Consultation) in.readObject());
            }

            System.out.println("Data Has Been Loaded Successfully");
            in.close();
            fileIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Data Has Not Been Stored Yet");
        } catch (IOException e) {
            System.out.println("Something Went Wrong !");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void viewConsultations() {
        for (int i = 0; i < consultations.size(); i++) {
            System.out.println("Consultation" + (i+1));
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
    public void cancelConsultation() {
        while (true) {
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
                System.out.println("Enter The Patient ID");
                int patientId = input.nextInt();
                input.nextLine();
                for (int i = 0; i < consultations.size(); i++) {
                    if(consultations.get(i).getDoctorName().equalsIgnoreCase(name) && consultations.get(i).getPatientId() == (patientId)) {
                        consultations.remove(i);
                        break;
                    }
                }
                break;
            }
        }
    }
}
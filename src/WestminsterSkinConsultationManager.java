import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable {

    public WestminsterSkinConsultationManager() {

    }

    public static ArrayList<Doctor> doctors = new ArrayList<Doctor>();
    public static ArrayList<Consultation> consultations = new ArrayList<Consultation>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        WestminsterSkinConsultationManager manager = new WestminsterSkinConsultationManager();
        manager.loadDoctorsDataFromFile(doctors);
        manager.loadConsultationsDataFromFile(consultations);
        boolean checkLoop = true;
        String choice;

        System.out.println("| WESTMINSTER SKIN CONSULTATION CLINIC |");
        while(checkLoop) {
            System.out.println("-----------------------------------------------------------------------");
            System.out.println("    A : ADD NEW DOCTOR");
            System.out.println("    D : REMOVE DOCTOR");
            System.out.println("    P : PRINT THE LIST OF DOCTORS");
            System.out.println("    S : SAVE DATA TO FILE");
            System.out.println("    G : OPEN GRAPHICAL USER INTERFACE");
            System.out.println("    Q : QUIT THE PROGRAM");
            System.out.println("\nSelect Required Option : ");
            choice = input.nextLine();
            choice = choice.toLowerCase();
            System.out.println("-----------------------------------------------------------------------");

            switch(choice) {
                case "a":
                    manager.addNewDoctor(doctors);
                    break;
                case "d":
                    manager.deleteDoctor(doctors);
                    break;
                case "p":
                    manager.printDoctorList(doctors);
                    break;
                case "s":
                    manager.saveDoctorsDataToFile(doctors);
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
    public void addNewDoctor(ArrayList<Doctor> pDoctors) {
        if (pDoctors.size() >= 10) {
            System.out.println("Doctor List Is Full");
        } else {
            try {
                //String name, String surname, Date dateOfBirth, int mobileNumber, int medicalLicenceNumber, String specialization
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
                                    if (year == 0 || month == 0 || date == 0) {
                                        System.out.println("Date Of Birth Fields Cannot Be Empty !\n\nWould you like to try again ? (Y/N)");
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
                                            System.out.println("Enter The Mobile Number Of The Doctor");
                                            int mobileNumber = input.nextInt();
                                            input.nextLine();
                                            if (mobileNumber == 0) {
                                                System.out.println("Mobile Number Field Cannot Be Empty !\n\nWould you like to try again ? (Y/N)");
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
                                                    System.out.println("Enter The Medical Licence Number Of The Doctor");
                                                    int medicalLicenceNumber = input.nextInt();
                                                    input.nextLine();
                                                    if (medicalLicenceNumber == 0) {
                                                        System.out.println("Medical Licence Number Field Cannot Be Empty !\n\nWould you like to try again ? (Y/N)");
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
                                                                doctors.add(doctor);
                                                                System.out.println("Dr." + doctor.getName() + " " + doctor.getSurname() + " Has Been Added To The List.");
                                                                break;
                                                            }
                                                        }
                                                        break;
                                                    }
                                                }
                                                break;
                                            }
                                        }
                                        break;
                                    }
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
                    addNewDoctor(pDoctors);
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Doctor Has Not Been Added To The List !");
                } else {
                    System.out.println("\nInvalid Option Selected. You will now be redirected to the Menu.");
                }
            }
        }
    }

    @Override
    public void deleteDoctor(ArrayList<Doctor> pDoctors) {
        if(pDoctors.size() == 0) {
            System.out.println("Doctor List Is Empty");
        } else {
            try {
                System.out.println("Enter The Medical Licence Number Of The Doctor");
                int medLic = input.nextInt();
                input.nextLine();
                boolean removed = false;
                String doctorName = "";
                for (int i = 0; i < pDoctors.size(); i++) {
                    if (pDoctors.get(i).getMedicalLicenceNumber() == medLic) {
                        doctorName = pDoctors.get(i).getName() + " " + pDoctors.get(i).getSurname();
                        pDoctors.remove(i);
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid Value Detected !\n\nWould you like to try again ? (Y/N)");
                input.nextLine();
                String answer = input.nextLine();
                if (answer.equalsIgnoreCase("Y")) {
                    deleteDoctor(pDoctors);
                } else if (answer.equalsIgnoreCase("N")) {
                    System.out.println("Doctor Has Not Been Removed !");
                } else {
                    System.out.println("\nInvalid Option Selected. You will now be redirected to the Menu.");
                }
            }
        }
    }

    @Override
    public void printDoctorList(ArrayList<Doctor> pDoctors) {
        Collections.sort(pDoctors,new Comparator<Doctor>() {
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurname().compareToIgnoreCase(d2.getSurname());
            }
        });
        for(int i = 0; i < pDoctors.size(); i++) {
            System.out.println("Dr." + pDoctors.get(i).getName() + " " + pDoctors.get(i).getSurname());
        }
    }

    @Override
    public void saveDoctorsDataToFile(ArrayList<Doctor> pDoctors) {
        try {
            FileOutputStream fileOut = new FileOutputStream("doctorList_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (Doctor pDoctor : pDoctors) {
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
    public void loadDoctorsDataFromFile(ArrayList<Doctor> pDoctors) {
        try {
            FileInputStream fileIn = new FileInputStream("doctorList_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for (int i = 0; i < 10; i++) {
                pDoctors.add((Doctor) in.readObject());
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
    public void saveConsultationsDataToFile(ArrayList<Consultation> pConsultations) {
        try {
            FileOutputStream fileOut = new FileOutputStream("consultations_data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for (Consultation pDoctor : pConsultations) {
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
    public void loadConsultationsDataFromFile(ArrayList<Consultation> pConsultations) {
        try {
            FileInputStream fileIn = new FileInputStream("consultations_data.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for (int i = 0; i < 10; i++) {
                pConsultations.add((Consultation) in.readObject());
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
}
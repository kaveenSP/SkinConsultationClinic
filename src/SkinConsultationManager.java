import java.util.ArrayList;

public interface SkinConsultationManager {
    void addNewDoctor(ArrayList<Doctor> pDoctors);
    void deleteDoctor(ArrayList<Doctor> pDoctors);
    void printDoctorList(ArrayList<Doctor> pDoctors);
    void saveDoctorsDataToFile(ArrayList<Doctor> pDoctors);
    void loadDoctorsDataFromFile(ArrayList<Doctor> pDoctors);
    void saveConsultationsDataToFile(ArrayList<Consultation> pConsultations);
    void loadConsultationsDataFromFile(ArrayList<Consultation> pConsultations);
}

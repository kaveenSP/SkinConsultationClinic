public interface SkinConsultationManager {
    Doctor addNewDoctor();
    void deleteDoctor(int medicalLicenceNumber);
    void printDoctorList();
    void saveDoctorsDataToFile();
    void loadDoctorsDataFromFile();
    void saveConsultationsDataToFile();
    void loadConsultationsDataFromFile();
    void viewConsultations();
    void cancelConsultation();
}

public interface SkinConsultationManager {
    void addNewDoctor();
    void deleteDoctor();
    void printDoctorList();
    void saveDoctorsDataToFile();
    void loadDoctorsDataFromFile();
    void saveConsultationsDataToFile();
    void loadConsultationsDataFromFile();
    void viewConsultations();
    void cancelConsultation();
}

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Consultation extends Patient{
    private LocalDateTime consultationDateAndTime;
    private String doctorName;

    private String fileName;
    private int cost;
    private String notes;

    public Consultation() {

    }

    public Consultation(String name, String surname, LocalDate dateOfBirth, int mobileNumber, int patientId, LocalDateTime consultationDateAndTime, int cost, String notes, String doctorName, String filePath) {
        super(name,surname,dateOfBirth,mobileNumber,patientId);
        this.doctorName = doctorName;
        this.consultationDateAndTime = consultationDateAndTime;
        this.cost = cost;
        this.notes = notes;
        this.fileName = filePath;
    }

    public LocalDateTime getConsultationDateAndTime() {
        return consultationDateAndTime;
    }

    public void setConsultationDateAndTime(LocalDateTime consultationDateAndTime) {
        this.consultationDateAndTime = consultationDateAndTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String filePath) {
        this.fileName = filePath;
    }
}

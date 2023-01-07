import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Doctor extends Person implements Serializable {
    private int medicalLicenceNumber;
    private String specialization;

    public Doctor() {
    }

    public Doctor(String name, String surname, LocalDate dateOfBirth, int mobileNumber, int medicalLicenceNumber, String specialization) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialization = specialization;
    }

    public int getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    public void setMedicalLicenceNumber(int medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
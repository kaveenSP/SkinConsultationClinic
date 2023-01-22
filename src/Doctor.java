import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Person implements Serializable {
    private int medicalLicenceNumber;
    private String specialization;

    //default constructor
    public Doctor() {
    }

    /**creates a Doctor Object
    * @param name first name of the doctor
    * @param surname surname of the doctor
    * @param dateOfBirth dob of doctor
    * @param mobileNumber doctors mobile number
     * @param medicalLicenceNumber doctors medical license number
     * @param specialization doctors specialization
     * Overloaded Constructor*/
    public Doctor(String name, String surname, LocalDate dateOfBirth, int mobileNumber, int medicalLicenceNumber, String specialization) {
        //super class is Person
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenceNumber = medicalLicenceNumber;
        this.specialization = specialization;
    }
    /**returns medical licence number of the doctor
     * @return medicalLicenceNumber doctors medical license number*/
    public int getMedicalLicenceNumber() {
        return medicalLicenceNumber;
    }

    /**sets medical license number
     * @param medicalLicenceNumber doctors medical license number
     */
    public void setMedicalLicenceNumber(int medicalLicenceNumber) {
        this.medicalLicenceNumber = medicalLicenceNumber;
    }

    /**returns specialization of the doctor
     * @return specialization doctors specialization*/
    public String getSpecialization() {
        return specialization;
    }

    /**sets specialization of the doctor
     * @param specialization specialization of the doctor
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
import java.time.LocalDate;

public class Patient extends Person {
    private int patientId;

    //default constructor
    public Patient() {

    }

    /**creates a Patient Object
     * @param name first name of the doctor
     * @param surname surname of the doctor
     * @param dateOfBirth dob of doctor
     * @param mobileNumber doctors mobile number
     * @param patientId patient ID
     * Overloaded Constructor*/
    public Patient(String name, String surname, LocalDate dateOfBirth, int mobileNumber, int patientId) {
        super(name,surname,dateOfBirth,mobileNumber);
        this.patientId = patientId;
    }

    /**returns patientId
     * @return patientId unique ID for patient*/
    public int getPatientId() {
        return patientId;
    }

    /**sets patientId
     * @param patientId unique ID for patient
     */
    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}

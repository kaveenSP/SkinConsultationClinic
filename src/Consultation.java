import java.time.LocalDate;
import java.time.LocalDateTime;

public class Consultation extends Patient{
    private LocalDateTime consultationDateAndTime;
    private String doctorName;

    private String fileName;
    private int cost;
    private String notes;

    //default constructor
    public Consultation() {

    }

    /**Creates a consultation objec
     * @param name first name of the patient
     * @param surname surname of the patient
     * @param dateOfBirth dob of patient
     * @param mobileNumber patient mobile number
     * @param patientId patient ID
     * @param consultationDateAndTime cosnultation date and time
     * @param cost cost fore consultation
     * @param notes special notes
     * @param doctorName name of the doctor assigned for consultation
     * @param filePath file path of the encrypted image
     * overloaded constructor*/
    public Consultation(String name, String surname, LocalDate dateOfBirth, int mobileNumber, int patientId, LocalDateTime consultationDateAndTime, int cost, String notes, String doctorName, String filePath) {
        //superclass is patient
        super(name,surname,dateOfBirth,mobileNumber,patientId);
        this.doctorName = doctorName;
        this.consultationDateAndTime = consultationDateAndTime;
        this.cost = cost;
        this.notes = notes;
        this.fileName = filePath;
    }

    /**returns passenger expenses
     * @return consultation date and time*/
    public LocalDateTime getConsultationDateAndTime() {
        return consultationDateAndTime;
    }

    /**sets consultation date and time
     * @param consultationDateAndTime consultation date and time
     */
    public void setConsultationDateAndTime(LocalDateTime consultationDateAndTime) {
        this.consultationDateAndTime = consultationDateAndTime;
    }

    /**returns passenger expenses
     * @return cost for consultation
     * */
    public double getCost() {
        return cost;
    }

    /**sets consultation cost
     * @param cost consultation cost
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**returns consultation notes
     * @return notes notes for consultation
     * */
    public String getNotes() {
        return notes;
    }

    /**sets notes for consultation
     * @param notes notes for consultation
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**returns doctor name
     * @return doctorName doctors name
     * */
    public String getDoctorName() {
        return doctorName;
    }

    /**sets doctors name
     * @param doctorName doctors full name
     */
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    /**returns file name of encrypted image
     * @return fileName file name of encrypted image
     * */
    public String getFileName() {
        return fileName;
    }

    /**sets file name of encrypted image
     * @param filePath local file path of encrypted image
     */
    public void setFileName(String filePath) {
        this.fileName = filePath;
    }
}

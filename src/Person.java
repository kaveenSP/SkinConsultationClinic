import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    private String name, surname;
    private LocalDate dateOfBirth;
    private int mobileNumber;

    //default constructor
    public Person() {
    }

    /**creates a Doctor Object
    * @param name first name
    * @param surname surname
    * @param dateOfBirth dob
    * @param mobileNumber doctors
     * Overloaded Constructor*/
    public Person(String name, String surname, LocalDate dateOfBirth, int mobileNumber) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
    }

    /**returns first name
     * @return name first name*/
    public String getName() {
        return name;
    }

    /**sets name
     * @param name first name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**returns surname
     * @return surname last name*/
    public String getSurname() {
        return surname;
    }

    /**sets surname
     * @param surname lastname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**returns Date Of Birth
     * @return dateOfBirth Date Of Birth*/
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**sets dateOfBirth
     * @param dateOfBirth Date Of Birth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**returns mobileNumber
     * @return mobileNumber Contact Number*/
    public int getMobileNumber() {
        return mobileNumber;
    }

    /**sets mobileNumber
     * @param mobileNumber Contact Number
     */
    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}

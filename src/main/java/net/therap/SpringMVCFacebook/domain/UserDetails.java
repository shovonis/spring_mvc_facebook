package net.therap.SpringMVCFacebook.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import java.sql.Date;

/**
 * @author rifatul.islam
 * @since 6/18/14.
 */

@Embeddable
public class UserDetails {

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "DOB")
    private Date dob;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Lob
    @Column(name = "PRO_PIC")
    private byte[] profilePicture;

    @Lob
    @Column(name = "COV_PIC")
    private byte[] coverPicture;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public byte[] getCoverPicture() {
        return coverPicture;
    }

    public void setCoverPicture(byte[] coverPicture) {
        this.coverPicture = coverPicture;
    }
}

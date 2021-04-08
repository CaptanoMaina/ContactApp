package model;

/**
 *
 * @author Margaret
 */

import daos.IDisplayable;
import java.io.Serializable;
import java.util.Objects;

public class Contact implements IDisplayable, Serializable {
    public enum ContactType {
        PERSONAL, BUSINESS
    }

    private String firstName;
    private String lastName;

    private String telephoneNumber;
    private String email;

    private String dateCreated;
    private ContactType type;

    public Contact(
        String firstName, String lastName, String telephoneNumber, String email,
        String dateCreated, ContactType type
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;

        this.email = email;
        this.dateCreated = dateCreated;
        this.type = type;
    }

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

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ContactType getType() {
        return type;
    }

    public void setType(ContactType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Contact) {
            Contact contact = (Contact) object;
            return Objects.equals(firstName, contact.firstName) &&
                    Objects.equals(lastName, contact.lastName) &&
                    Objects.equals(telephoneNumber, contact.telephoneNumber) &&
                    Objects.equals(email, contact.email) &&
                    Objects.equals(dateCreated, contact.dateCreated) &&
                    Objects.equals(type, contact.type);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            firstName, lastName, telephoneNumber, email, dateCreated, type);
    }
    
    @Override
    public void display(){
        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("Telephone Number:" + telephoneNumber);
        System.out.println("Email Address:" + email);
        System.out.println("Date Created:" + dateCreated);
        System.out.println("Contact Type:" + type);
    }
}

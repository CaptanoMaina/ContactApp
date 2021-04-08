/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.Contact;

/**
 *
 * @author Margaret
 */
public class contactTest {
    
    public static void printContactType(Contact.ContactType contactType){
        if (contactType == Contact.ContactType.PERSONAL){
            System.out.println("Contact Type: Personal");
        }else {
            System.out.println("Contact Type: Business");
        }
        
    }
    public static void main(String args[]){
        Contact c = new Contact("Mary", "Camino", "572239", "m.camino@ymail.com",
        "06/09/1985", Contact.ContactType.PERSONAL);
        
        
        System.out.println("Retrieving the first name");
        System.out.println("First Name: " + c.getFirstName());

        System.out.println("Setting the first name to Nelly");
        c.setFirstName("Nelly");
        System.out.println("New First Name: " + c.getFirstName());
        
        System.out.println("Retrieving the last name");
        System.out.println("Last Name: " + c.getLastName());

        System.out.println("Setting the last name to Kipi");
        c.setLastName("Kipi");
        System.out.println("New Lastst Name: " + c.getLastName());
        
        System.out.println("Retrieving the telephone number");
        System.out.println("Telephone Number: " + c.getTelephoneNumber());

        System.out.println("Setting the telephone number to 679856");
        c.setTelephoneNumber("679856");
        System.out.println("New Telephone Number: " + c.getTelephoneNumber());
        
        System.out.println("Retrieving the email address");
        System.out.println("Email Address: " + c.getEmail());

        System.out.println("Setting the email address to n.kipi@ymail.com");
        c.setEmail("n.kipi@ymail.com");
        System.out.println("New Email Address: " + c.getEmail());
        
        System.out.println("Retrieving the date created");
        System.out.println("Date Created: " + c.getDateCreated());

        System.out.println("Setting the date created to 08/07/1990");
        c.setDateCreated("08/07/1990");
        System.out.println("New Date Created: " + c.getDateCreated());
        
        System.out.println("Retrieving the contact type");
        printContactType(c.getType());

        System.out.println("Setting the contact type to business");
        c.setType(Contact.ContactType.BUSINESS);
        printContactType(c.getType());
        
    }
}

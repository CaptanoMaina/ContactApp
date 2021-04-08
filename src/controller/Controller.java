package controller;

/**
 *
 * @author Margaret
 */

import java.util.Scanner;
import java.util.Date;

import model.ContactList;
import model.Contact;
import daos.DAO;

public class Controller {
    private final ContactList contactList;
    private final Scanner reader;

    public Controller() {
        reader = new Scanner(System.in);
        ContactList newList = new ContactList();
        
        newList.add(new Contact("Ibitope","Fatoki","900", "i.fatoki@gmail.com", "09/02/2020",Contact.ContactType.BUSINESS));
        newList.add(new Contact("Ugo","NNadi","200", "u.nnadi@gmail.com", "02/09/2020",Contact.ContactType.BUSINESS));
        newList.add(new Contact("Mohamed","Sultan","500", "m.sultan@gmail.com", "04/01/2021",Contact.ContactType.PERSONAL));
        newList.add(new Contact("Nelly","Maina","600", "n.maina@gmail.com", "07/08/2010",Contact.ContactType.PERSONAL));
        newList.add(new Contact("Bob","Nuru","960", "b.nuru@gmail.com", "01/01/2001",Contact.ContactType.BUSINESS));
        
        DAO.store("myContact", newList);
        this.contactList = DAO.load("myContact");
        

        listContacts();
    }

    private char readCharacter(String validCharacters) {
        char input;
        boolean state;
        do {
            state = false;

            input = reader.nextLine().toUpperCase().charAt(0);
            if (validCharacters.indexOf(input) == -1) {
                state = true;
                System.out.println("Please re-enter your choice: ");
            }
        } while (state);

        return input;
    }

    public char displayMenu() {
        System.out.print("\nA. Insert new contact");
        System.out.print("\nB. Remove last contact");
        System.out.print("\nC. Search by telephone number");
        System.out.print("\nD. Search by full name");
        System.out.print("\nQ. Quit\n");
        System.out.println("Enter choice: ");

        return readCharacter("ABCDQ");
    }

    public void run() {
        boolean ended = false;
        Contact contact = null;

        do {
            char choice = displayMenu();
            switch (choice) {
                case 'A':
                    addPlayer();
                    break;
                case 'B':
                    contact = contactList.remove();
                    System.out.println("Removed: ");
                    contact.display();
                    break;
                case 'C':
                    System.out.println("Enter a telephone number: ");
                    String telephoneNumber = reader.nextLine();

                    contact = contactList.findByTelephone(telephoneNumber);
                    if (contact == null) {
                        System.out.println("Did not find any contact with that telephone number");
                    } else {
                        System.out.println("Found: ");
                        contact.display();
                    }
                    break;
                case 'D':
                    System.out.println("Enter a full name: ");
                    String name = reader.nextLine();

                    contact = contactList.findByName(name);
                    if (contact == null) {
                        System.out.println("Did not find any contact with that telephone number");
                    } else {
                        System.out.println("Found: ");
                        contact.display();
                    }
                    break;
                case 'Q':
                    ended = true;

                    System.out.println("Enter filename: ");
                    String filename = reader.nextLine();
                    DAO.store(filename, contactList);
            }
        } while (!ended);
    }

    private void addPlayer() {
        System.out.println("What type of contact do you wish to add?");
        System.out.println("P: Personal");
        System.out.println("B: Business");

        char contactTypeChar = readCharacter("PB");
        Contact.ContactType contactType = null;
        if (contactTypeChar == 'P') {
            contactType = Contact.ContactType.PERSONAL;
        } else {
            contactType = Contact.ContactType.BUSINESS;
        }

        System.out.println("Enter First Name: ");
        String firstName = reader.nextLine();

        System.out.println("Enter Last Name: ");
        String lastName = reader.nextLine();

        System.out.println("Enter telephone number");
        String telephoneNumber = reader.nextLine();

        System.out.println("Enter email: ");
        String email = reader.nextLine();


        String dateCreated = new Date().toString();

        Contact newContact = new Contact(
            firstName, lastName, telephoneNumber, email, dateCreated, contactType);
        contactList.add(newContact);

        System.out.println("\nContact added successfully");
    }

    private void listContacts() {
        for (Contact contact : contactList) {
            contact.display();
            System.out.println();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import model.ContactList;
import model.Contact;
/**
 *
 * @author Margaret
 */
public class contactListTest {
    public static void main(String args[]){
    
        ContactList contactList = new ContactList();
        System.out.println("adding contacts");
        
        contactList.add(new Contact("Ibitope","Fatoki","900", "i.fatoki@gmail.com", "09/02/2020",Contact.ContactType.BUSINESS));
        contactList.add(new Contact("Ugo","NNadi","200", "u.nnadi@gmail.com", "02/09/2020",Contact.ContactType.BUSINESS));
        contactList.add(new Contact("Mohamed","Sultan","500", "m.sultan@gmail.com", "04/01/2021",Contact.ContactType.PERSONAL));
        contactList.add(new Contact("Nelly","Maina","600", "n.maina@gmail.com", "07/08/2010",Contact.ContactType.PERSONAL));
        contactList.add(new Contact("Bob","Nuru","960", "b.nuru@gmail.com", "01/01/2001",Contact.ContactType.BUSINESS));
        
        System.out.println("Contacts added successfully");
        
        System.out.println("removing the last contact from the list");
        Contact removedContact = contactList.remove();
        removedContact.display();
        
        System.out.println();
        
        System.out.println("Searching by Telephone Number: 600");
        Contact foundContact = contactList.findByTelephone("600");
        foundContact.display();
        
        System.out.println();
        
        System.out.println("Searching by full name: Ugo");
        Contact foundName = contactList.findByName("Ugo NNadi");
        foundName.display();
                
                
    }
}

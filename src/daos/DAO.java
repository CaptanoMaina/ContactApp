package daos;

/**
 *
 * @author Margaret
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.ContactList;

public class DAO {

    public static void store(String filename, ContactList contactList) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(contactList);

            out.close();
            file.close();
        } catch (IOException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static ContactList load(String filename) {
        ContactList contactList = null;
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            contactList = (ContactList) in.readObject();

            in.close();
            file.close();

        
        } catch (IOException e) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return contactList;
    }
}

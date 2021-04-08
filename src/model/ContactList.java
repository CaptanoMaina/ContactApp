package model;

/**
 *
 * @author Margaret
 */

import java.util.Iterator;
import java.io.Serializable;

import model.Contact;

public class ContactList implements Iterable<Contact>, Serializable {
    class Node implements Serializable {
        Node nextContact;
        Node prevContact;

        Contact contact;

        public Node(Contact contact) {
            this.contact = contact;

            nextContact = null;
            prevContact = null;
        }
    }

    private Node first;

    public ContactList() {
        first = null;
    }

    public Node getFirstNode() {
        return first;
    }

    public void add(Contact contact) {
        Node node = new Node(contact);

        // Check whether the List is empty
        if (first == null) {
            node.prevContact = node;
            node.nextContact = node;

            first = node;
        } else {
            Node last = first.prevContact;
            node.prevContact = last;
            node.nextContact = first;

            first.prevContact = node;
            last.nextContact = node;
        }
    }

    public Contact remove() {
        if (first == null) {
            return null;
        }

        Node oldLast = first.prevContact;
        Node newLast = oldLast.prevContact;
        if (oldLast == newLast) {
            first = null;
        } else {
            first.prevContact = newLast;
            newLast.nextContact = first;
        }

        return oldLast.contact;
    }

    public Contact findByTelephone(String telephoneNumber) {

        for (Contact contact : this) {
            String testNumber = contact.getTelephoneNumber();
            if (testNumber.equals(telephoneNumber)) {
                return contact;
            }
        }

        return null;
    }

    public Contact findByName(String fullName) {

        for (Contact contact : this) {
            String testName = contact.getFirstName() + " " + contact.getLastName();
            if (testName.equals(fullName)) {
                return contact;
            }
        }

        return null;
    }

    @Override
    public Iterator<Contact> iterator() {
        return new ContactListIterator(this);
    }
}

class ContactListIterator implements Iterator<Contact> {
    ContactList.Node first;
    ContactList.Node current;

    public ContactListIterator(ContactList list) {
        first = list.getFirstNode();
        current = null;
    }

    @Override
    public boolean hasNext() {
        if (first == null) {
            return false;
        }

        return current != first;
    }

    @Override
    public Contact next() {
        Contact result;
        if (current == null) {
            result = first.contact;
            current = first.nextContact;
        } else {
            result = current.contact;
            current = current.nextContact;
        }

        return result;
    }

    @Override
    public void remove() { 
        throw new UnsupportedOperationException(); 
    } 
}

/*
 * Author: Vonatarius Valerion
 * Project: Grand Strand Systems - Project One
 */

package com.grandstrand.services;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts = new HashMap<>();

    // add contacts with unique ID
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("contact cannot be null");
        }
        String id = contact.getContactId();
        if (contacts.containsKey(id)) {
            throw new IllegalArgumentException("contactId must be unique");
        }
        contacts.put(id, contact);
    }

    // delete contacts per contactId
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("contactId not found");
        }
        contacts.remove(contactId);
    }

    // update contact fields per contactId
    public void updateFirstName(String contactId, String firstName) {
        getContact(contactId).setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        getContact(contactId).setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        getContact(contactId).setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        getContact(contactId).setAddress(address);
    }

    // helper to find a contact (also helps testing)
    public Contact getContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("contactId cannot be null");
        }
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("contactId not found");
        }
        return contact;
    }

    // helper for tests
    public int size() {
        return contacts.size();
    }
}




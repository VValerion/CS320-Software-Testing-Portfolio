/*
 * Author: Vonatarius Valerion
 * Project: Grand Strand Systems - Project One
 */

package com.grandstrand.services.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.grandstrand.services.Contact;
import com.grandstrand.services.ContactService;

public class ContactServiceTest {

    @Test
    void testAddContactUniqueId() {
        ContactService service = new ContactService();

        Contact c1 = new Contact("1", "Von", "Valerion", "2149184025", "123 Main St");
        service.addContact(c1);

        assertEquals(1, service.size());

        Contact c2 = new Contact("1", "Jay", "Smith", "1234567890", "456 Oak St");
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();

        Contact c1 = new Contact("1", "Von", "Valerion", "2149184025", "123 Main St");
        service.addContact(c1);

        service.deleteContact("1");
        assertEquals(0, service.size());

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("1"));
    }

    @Test
    void testUpdateContactFields() {
        ContactService service = new ContactService();

        Contact c1 = new Contact("1", "Von", "Valerion", "2149184025", "123 Main St");
        service.addContact(c1);

        service.updateFirstName("1", "Tay");
        service.updateLastName("1", "Valerion");
        service.updatePhone("1", "1234567890");
        service.updateAddress("1", "Dallas TX");

        Contact updated = service.getContact("1");

        assertEquals("Tay", updated.getFirstName());
        assertEquals("Valerion", updated.getLastName());
        assertEquals("1234567890", updated.getPhone());
        assertEquals("Dallas TX", updated.getAddress());
        assertEquals("1", updated.getContactId());
    }

    @Test
    void testUpdateFailsWhenMissing() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () ->
                service.updateFirstName("missing", "Von"));
    }
}




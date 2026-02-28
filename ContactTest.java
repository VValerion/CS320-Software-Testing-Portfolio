/*
 * Author: Vonatarius Valerion
 * Project: Grand Strand Systems - Project One
 */

package com.grandstrand.services.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.grandstrand.services.Contact;

public class ContactTest {

    @Test
    void testCreateValidContact() {
        Contact c = new Contact(
                "123",
                "Von",
                "Valerion",
                "2149184025",
                "123 Main St"
        );

        assertEquals("123", c.getContactId());
        assertEquals("Von", c.getFirstName());
        assertEquals("Valerion", c.getLastName());
        assertEquals("2149184025", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test
    void testInvalidPhoneThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", "Von", "Valerion", "123", "123 Main St");
        });
    }

    @Test
    void testInvalidFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1", null, "Valerion", "2149184025", "123 Main St");
        });
    }
}




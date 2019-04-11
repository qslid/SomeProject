package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;
import ru.pft.stqa.addressbook.model.Contacts;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactCreateTests extends TestBase {


    @Test
    public void createNewContactTest() {
        Contacts before = app.contact().list();

        ContactInfo contact = new ContactInfo().withFirstName("FirstName").withLastName("LastName");

        app.contact().doCreateContact(contact);
        Contacts after = app.contact().list();
        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(before.withAdded(contact.withId(
                after.stream().mapToInt((g) -> g.getId()).max().getAsInt()
        ))));

    }

}

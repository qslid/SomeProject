package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;
import ru.pft.stqa.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void setup(){
        app.getNavigationHelper().gotoHomePage();
        if (!app.contact().isThereAnyContact()) {
            ContactInfo contact = new ContactInfo().withFirstName("FirstName").withLastName("LastName");
            app.contact().doCreateContact(contact);

        }
    }

    @Test
    public void deleteFirstContactFromUpdateForm() {
        Contacts before = app.contact().list();
        ContactInfo deletedContact = before.iterator().next();
        app.contact().gotoContactUpdateForm(deletedContact.getId());
        app.contact().submitDeletion();
        app.getNavigationHelper().gotoHomePage();
        Contacts after = app.contact().list();
        before.remove(deletedContact);
        assertThat(before.size(),equalTo(after.size()));
        assertThat(after, equalTo(before.without(deletedContact)));

    }


    @Test
    public void deleteFirstContactFromMainPage() {
        Contacts before = app.contact().list();
        ContactInfo deletedContact = before.iterator().next();
        app.contact().selectContactByID(deletedContact.getId());
        app.contact().submitDeletionOnMain();
        app.getNavigationHelper().gotoHomePage();
        Contacts after = app.contact().list();
        before.remove(deletedContact);
        assertThat(before.size(),equalTo(after.size()));
        assertThat(after, equalTo(before.without(deletedContact)));

    }
}

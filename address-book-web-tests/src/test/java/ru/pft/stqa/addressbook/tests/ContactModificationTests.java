package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;
import ru.pft.stqa.addressbook.model.Contacts;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size()==0) {
            app.contact().doCreateContact(new ContactInfo().withFirstName("FirstName").withLastName("LastName"));
        }
    }

    @Test
    public void contactModificationTest() {
        Contacts before = app.contact().list();
        ContactInfo modifiedContact = before.iterator().next();
        app.getNavigationHelper().gotoContactUpdateForm(modifiedContact.getId());

        ContactInfo contact = new ContactInfo().withFirstName("FirstName").withLastName("LastName");
        app.contact().fillContactForm(contact);
        app.contact().submitUpdate();
        app.getNavigationHelper().gotoHomePageByLink();

        Contacts after = app.contact().list();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }
}

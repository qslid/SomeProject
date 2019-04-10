package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

import java.util.HashSet;
import java.util.List;

public class ContactCreateTests extends TestBase {


    @Test
    public void createNewContactTest() {
        List<ContactInfo> before = app.contact().contactList();

        ContactInfo contact = new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year");

        app.contact().createContact(contact);
        List<ContactInfo> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() + 1);


        int max = 0;
        for (ContactInfo ci : after) {
            if (ci.getId() > max) max = ci.getId();
        }
        contact.setId(max);
        before.add(contact);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
        app.session().logOut();
    }

}

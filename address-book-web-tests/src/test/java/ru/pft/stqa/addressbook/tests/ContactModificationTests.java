package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTest() {
        if (!app.getContactHelper().isThereAnyContact()) {
            app.getContactHelper().createContact(new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
        }
        List<ContactInfo> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactUpdateForm(before.size() - 1);

        ContactInfo contact = new ContactInfo("firstName UPDATED", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year");

        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitUpdate();
        app.getNavigationHelper().gotoHomePageByLink();

        List<ContactInfo> after = app.getContactHelper().getContactList();
        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(after.size(), before.size());
        Assert.assertEquals(before, after);

    }
}

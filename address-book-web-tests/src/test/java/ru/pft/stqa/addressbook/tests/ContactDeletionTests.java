package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test
    public void deleteFirstContactFromUpdateForm() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.contact().isThereAnyContact()) {
            ContactInfo contact = new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year");
            app.contact().createContact(contact);
        }
        List<ContactInfo> before = app.contact().contactList();
        app.getNavigationHelper().gotoContactUpdateForm(before.size() - 1);
        app.contact().submitDeletion();
        app.getNavigationHelper().gotoHomePage();
        List<ContactInfo> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }


    @Test
    public void deleteFirstContactFromMainPage() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.contact().isThereAnyContact()) {
            ContactInfo contact = new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year");
            app.contact().createContact(contact);
        }
        List<ContactInfo> before = app.contact().contactList();

        app.contact().selectFirstContact();
        app.contact().submitDeletionOnMain();
        app.getNavigationHelper().gotoHomePage();
        List<ContactInfo> after = app.contact().contactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

    }
}

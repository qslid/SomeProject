package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test
    public void deleteFirstContactFromUpdateForm() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAnyContact()) {
            ContactInfo contact = new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year");
            app.getContactHelper().createContact(contact);
        }
        List<ContactInfo> before = app.getContactHelper().getContactList();
        app.getNavigationHelper().gotoContactUpdateForm(before.size() - 1);
        app.getContactHelper().submitDeletion();
        app.getNavigationHelper().gotoHomePage();
        List<ContactInfo> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        app.getSessionHelper().logOut();
    }


    @Test
    public void deleteFirstContactFromMainPage() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAnyContact()) {
            ContactInfo contact = new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year");
            app.getContactHelper().createContact(contact);
        }
        List<ContactInfo> before = app.getContactHelper().getContactList();

        app.getContactHelper().selectFirstContact();
        app.getContactHelper().submitDeletionOnMain();
        app.getNavigationHelper().gotoHomePage();
        List<ContactInfo> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

        app.getSessionHelper().logOut();
    }
}

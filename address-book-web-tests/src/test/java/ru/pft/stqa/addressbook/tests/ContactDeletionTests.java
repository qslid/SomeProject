package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

public class ContactDeletionTests extends TestBase {
    @Test
    public void deleteFirstContactFromUpdateForm(){
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAnyContact())
            app.getContactHelper().createContact(new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
        app.getNavigationHelper().gotoFirstContactUpdateForm();
        app.getContactHelper().submitDeletion();
        app.getSessionHelper().logOut();
    }


    @Test
    public void deleteFirstContactFromMainPage(){
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAnyContact())
            app.getContactHelper().createContact(new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
        app.getContactHelper().selectFirstContact();
        app.getContactHelper().submitDeletionOnMain();
        app.getSessionHelper().logOut();
    }
}

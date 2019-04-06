package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

public class ContactModificationTests extends TestBase {

    @Test
    public void contactModificationTest() {
        if (!app.getContactHelper().isThereAnyContact())
            app.getContactHelper().createContact(new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
        app.getNavigationHelper().gotoFirstContactUpdateForm();
        app.getContactHelper().fillContactForm(new ContactInfo("firstName UPDATED", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
        app.getContactHelper().submitUpdate();
        app.getNavigationHelper().gotoHomePageByLink();

    }
}

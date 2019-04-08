package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

public class ContactCreateTests extends TestBase {


    @Test
    public void createNewContactTest() {
        app.getContactHelper().createContact(new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
        app.getSessionHelper().logOut();
    }

}

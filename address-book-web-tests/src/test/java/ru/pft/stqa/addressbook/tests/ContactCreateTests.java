package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

public class ContactCreateTests extends TestBase {


    @Test
    public void createNewContactTest() throws Exception {
        app.getNavigationHelper().gotoNewContactForm();
        app.getContactHelper().fillContactForm(new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
        app.getContactHelper().submitContactForm();
        app.getNavigationHelper().gotoHomePage();
        app.getSessionHelper().logOut();
    }

}

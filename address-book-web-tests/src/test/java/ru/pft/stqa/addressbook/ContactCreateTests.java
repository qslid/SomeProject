package ru.pft.stqa.addressbook;

import org.testng.annotations.Test;

import static org.testng.Assert.fail;

public class ContactCreateTests extends TestBase {


  @Test
  public void createNewContactTest() throws Exception {
    gotoContactForm();
    fillContactForm(new ContactInfo("firstName", "middleName", "lastName", "nickname", "title", "company", "addressText", "homePhone", "mobilePhone", "workPhone", "faxPhone", "website", "day", "month", "year"));
    submitContactForm();
    gotoHomePage();
    logOut();
  }

}

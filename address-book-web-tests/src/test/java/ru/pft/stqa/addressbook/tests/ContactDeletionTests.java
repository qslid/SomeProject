package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {
    @Test
    public void deleteFirstContactFromUpdateForm(){
        app.getNavigationHelper().gotoHomePage();
        app.getNavigationHelper().gotoFirstContactUpdateForm();
        app.getContactHelper().submitDeletion();
        app.getSessionHelper().logOut();
    }


    @Test
    public void deleteFirstContactFromMainPage(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectFirstContact();
        app.getContactHelper().submitDeletionOnMain();
        app.getSessionHelper().logOut();
    }
}

package ru.pft.stqa.addressbook;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() throws Exception {
        gotoGroupsPage();
        gotoCreationGroupsPage();
        fillGroupData(new GroupInfo("Test", "header", "footer"));
        submitCreation();
        gotoGroupsPage();
        logOut();
    }


}


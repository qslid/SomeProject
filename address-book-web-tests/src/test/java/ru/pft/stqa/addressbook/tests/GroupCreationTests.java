package ru.pft.stqa.addressbook.tests;


import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() throws Exception {
        app.gotoGroupsPage();
        app.gotoCreationGroupsPage();
        app.fillGroupData(new GroupInfo("Test", "header", "footer"));
        app.submitCreation();
        app.gotoGroupsPage();
        app.logOut();
    }


}


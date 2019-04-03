package ru.pft.stqa.addressbook.tests;


import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() throws Exception {
        app.getNavigationHelper().gotoGroupsPage();
        app.getNavigationHelper().gotoCreationGroupsPage();
        app.getGroupsHelper().fillGroupData(new GroupInfo("Test", "header", "footer"));
        app.getGroupsHelper().submitCreation();
        app.getNavigationHelper().gotoGroupsPage();
        app.getSessionHelper().logOut();
    }


}


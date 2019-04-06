package ru.pft.stqa.addressbook.tests;


import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() {
        app.getGroupsHelper().gotoGroupsPage();
        app.getGroupsHelper().createGroup(new GroupInfo("Test", "header", "footer"));
        app.getSessionHelper().logOut();
    }




}


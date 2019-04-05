package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

public class GroupModificationTests extends TestBase {

    @Test
    public void testModificationGroup(){
        app.getNavigationHelper().gotoGroupsPage();
        app.getGroupsHelper().selectFirstGroup();
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupData(new GroupInfo("nameGroupMODIFIED",null,"footer mod"));
        app.getGroupsHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPageReturn();
        app.getSessionHelper().logOut();
    }
}

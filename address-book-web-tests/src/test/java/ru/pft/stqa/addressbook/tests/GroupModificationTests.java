package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testModificationGroup(){
        app.getGroupsHelper().gotoGroupsPage();
        if(!app.getGroupsHelper().isThereAnyGroup())
        {
            app.getGroupsHelper().createGroup(new GroupInfo("Test", "header", "footer"));
        }
        List <GroupInfo> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(1);
        app.getGroupsHelper().initGroupModification();
        app.getGroupsHelper().fillGroupData(new GroupInfo("nameGroupMODIFIED",null,"footer mod"));
        app.getGroupsHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPageReturn();
        List<GroupInfo> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size());
        app.getSessionHelper().logOut();
    }
}

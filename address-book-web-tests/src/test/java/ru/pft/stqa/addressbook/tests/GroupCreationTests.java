package ru.pft.stqa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.ArrayList;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() {
        app.getGroupsHelper().gotoGroupsPage();
        List <GroupInfo> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().createGroup(new GroupInfo("Test", "header", "footer"));
        List <GroupInfo> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() +1);
        app.getSessionHelper().logOut();
    }




}


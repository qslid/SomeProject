package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testModificationGroup() {
        app.getGroupsHelper().gotoGroupsPage();
        if (!app.getGroupsHelper().isThereAnyGroup()) {
            app.getGroupsHelper().createGroup(new GroupInfo("Test", "header", "footer"));
        }
        List<GroupInfo> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(before.size() - 1);
        app.getGroupsHelper().initGroupModification();

        GroupInfo group = new GroupInfo(before.get(before.size() - 1).getId(), "nameGroupMODIFIED", null, "footer mod");

        app.getGroupsHelper().fillGroupData(group);
        app.getGroupsHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPageReturn();
        List<GroupInfo> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
        app.getSessionHelper().logOut();
    }
}

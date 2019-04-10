package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testModificationGroup() {
        app.group().gotoGroupsPage();
        if (!app.group().isThereAnyGroup()) {
            app.group().create(new GroupInfo().withName("Name1").withFooter("Footer1").withHeader("Header2"));
        }
        List<GroupInfo> before = app.group().getGroupList();
        app.group().selectGroup(before.size() - 1);
        app.group().initGroupModification();

        GroupInfo group = new GroupInfo().withId(before.get(before.size() - 1).getId()).withName("nameGroupMODIFIED").withFooter("footer mod");
        app.group().fillGroupData(group);
        app.group().submitGroupModification();
        app.getNavigationHelper().gotoGroupPageReturn();
        List<GroupInfo> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
        app.session().logOut();
    }
}

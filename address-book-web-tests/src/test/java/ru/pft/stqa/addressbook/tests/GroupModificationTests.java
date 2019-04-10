package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.HashSet;
import java.util.Set;

public class GroupModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.group().gotoGroupsPage();
        if (!app.group().isThereAnyGroup()) {
            app.group().create(new GroupInfo().withName("Name1").withFooter("Footer1").withHeader("Header2"));
        }
    }


    @Test
    public void testModificationGroup() {
        Set<GroupInfo> before = app.group().all();
        GroupInfo modifiedGroup = before.iterator().next();
        GroupInfo group = new GroupInfo().withId(modifiedGroup.getId()).withName("nameGroupMODIFIED").withFooter("footer mod");
        app.group().modify(group);
        app.getNavigationHelper().gotoGroupPageReturn();
        Set<GroupInfo> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedGroup);
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
        app.session().logOut();
    }


}

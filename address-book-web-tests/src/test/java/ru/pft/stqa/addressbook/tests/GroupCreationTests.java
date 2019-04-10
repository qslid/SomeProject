package ru.pft.stqa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() {
        app.group().gotoGroupsPage();
        List<GroupInfo> before = app.group().getGroupList();
        GroupInfo group = new GroupInfo().withName("Test1");

        app.group().create(group);
        List<GroupInfo> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);


        int max = 0;
        for (GroupInfo gi : after) {
            if (gi.getId() > max) max = gi.getId();
        }
        group.withId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
        app.session().logOut();
    }


}


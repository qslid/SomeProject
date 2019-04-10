package ru.pft.stqa.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() {
        app.group().gotoGroupsPage();
        Set<GroupInfo> before = app.group().all();
        GroupInfo group = new GroupInfo().withName("Test1");

        app.group().create(group);
        Set<GroupInfo> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(
                after.stream().mapToInt((g) -> g.getId()).max().getAsInt()
        );
        before.add(group);
        Assert.assertEquals(before, after);
    }


}


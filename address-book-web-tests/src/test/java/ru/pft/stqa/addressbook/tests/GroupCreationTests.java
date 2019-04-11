package ru.pft.stqa.addressbook.tests;


import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;
import ru.pft.stqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() {
        app.group().gotoGroupsPage();
        Groups before = app.group().all();
        GroupInfo group = new GroupInfo().withName("Test1");

        app.group().create(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size() + 1));

;
        assertThat(after, equalTo(before.withAdded(group.withId(
                after.stream().mapToInt((g) -> g.getId()).max().getAsInt()
        ))));
    }


}


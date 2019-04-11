package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;
import ru.pft.stqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions() {
        app.group().gotoGroupsPage();
        if (app.group().all().size()==0) {
            app.group().create(new GroupInfo().withName("Name1").withFooter("Footer1").withHeader("Header2"));
        }
    }


    @Test
    public void testModificationGroup() {
        Groups before = app.group().all();
        GroupInfo modifiedGroup = before.iterator().next();
        GroupInfo group = new GroupInfo().withId(modifiedGroup.getId()).withName("nameGroupMODIFIED").withFooter("footer mod");
        app.group().modify(group);
        app.getNavigationHelper().gotoGroupPageReturn();
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
    }


}

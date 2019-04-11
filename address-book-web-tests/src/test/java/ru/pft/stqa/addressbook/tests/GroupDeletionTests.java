package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;
import ru.pft.stqa.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.group().gotoGroupsPage();
        if (!app.group().isThereAnyGroup()) {
            app.group().create(new GroupInfo().withName("Name1").withFooter("Footer1").withHeader("Header2"));
        }
    }

    @Test
    public void groupDeletionTest() throws Exception {

        Groups before = app.group().all();
        GroupInfo deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        app.getNavigationHelper().gotoGroupPageReturn();

        Groups after = app.group().all();
        assertEquals(after.size(), before.size() - 1);
        before.remove(deletedGroup);
        assertThat(before.size(),equalTo(after.size()));
        assertThat(after, equalTo(before.without(deletedGroup)));
    }


}

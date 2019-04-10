package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.Set;

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

        Set<GroupInfo> before = app.group().all();
        GroupInfo deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        app.getNavigationHelper().gotoGroupPageReturn();

        Set<GroupInfo> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(deletedGroup);
        Assert.assertEquals(before, after);
    }


}

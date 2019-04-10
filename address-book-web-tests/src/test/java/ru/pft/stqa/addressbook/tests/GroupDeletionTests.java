package ru.pft.stqa.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @Test
    public void groupDeletionTest() throws Exception {
        app.group().gotoGroupsPage();
        if (!app.group().isThereAnyGroup()) {
            app.group().create(new GroupInfo("Test", "header", "footer"));
        }
        List<GroupInfo> before = app.group().getGroupList();
        app.group().selectGroup(before.size() - 1);
        app.group().deleteGroup();
        assertEquals(app.group().getTextFromDeletedGroup(), "Group has been removed.\n" +
                "return to the group page");
        app.getNavigationHelper().gotoGroupPageReturn();
        List<GroupInfo> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        app.session().logOut();
    }

}

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
            app.group().create(new GroupInfo().withName("Name1").withFooter("Footer1").withHeader("Header2"));
        }
        List<GroupInfo> before = app.group().getGroupList();
        delete(before);
        List<GroupInfo> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
        app.session().logOut();
    }

}

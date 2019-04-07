package ru.pft.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @Test
    public void groupDeletionTest() throws Exception {
        app.getGroupsHelper().gotoGroupsPage();
        if(!app.getGroupsHelper().isThereAnyGroup())
        {
            app.getGroupsHelper().createGroup(new GroupInfo("Test", "header", "footer"));
        }
        List <GroupInfo> before = app.getGroupsHelper().getGroupList();
        app.getGroupsHelper().selectGroup(before.size() -1);
        app.getGroupsHelper().deleteGroup();
        assertEquals(app.wd.findElement(By.cssSelector("div.msgbox")).getText(), "Group has been removed.\n" +
                "return to the group page");
        app.getNavigationHelper().gotoGroupPageReturn();
        List<GroupInfo> after = app.getGroupsHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size() -1);
        app.getSessionHelper().logOut();
    }

}

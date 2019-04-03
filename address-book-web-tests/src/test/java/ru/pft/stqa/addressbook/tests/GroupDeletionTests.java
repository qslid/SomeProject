package ru.pft.stqa.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @Test
    public void groupDeletionTest() throws Exception {
        app.gotoGroupsPage();
        app.selectFirstGroup();
        app.deleteGroup();
        assertEquals(app.wd.findElement(By.cssSelector("div.msgbox")).getText(), "Group has been removed.\n" +
                "return to the group page");
        app.gotoGroupPageAfterDeletion();
        app.logOut();
    }

}
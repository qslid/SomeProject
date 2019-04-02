package ru.pft.stqa.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

    @Test
    public void groupDeletionTest() throws Exception {
        gotoGroupsPage();
        selectFirstGroup();
        deleteGroup();
        assertEquals(wd.findElement(By.cssSelector("div.msgbox")).getText(), "Group has been removed.\n" +
                "return to the group page");
        gotoGroupPageAfterDeletion();
        logOut();
    }

}

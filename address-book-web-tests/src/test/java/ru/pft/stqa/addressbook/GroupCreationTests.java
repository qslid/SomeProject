package ru.pft.stqa.addressbook;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {

    @Test
    public void addGroupTest() throws Exception {
        gotoGroupsPage();
        gotoCreationGroupsPage();
        fillGroupData(new GroupInfo("Test", "header", "footer"));
        submitCreation();
        gotoGroupsPage();
        logOut();
    }


    private void submitCreation() {
        wd.findElement(By.name("submit")).click();
    }

    private void fillGroupData(GroupInfo groupInfo) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupInfo.getNameGroup());
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupInfo.getHeader());
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupInfo.getFooter());
    }

    private void gotoCreationGroupsPage() {
        wd.findElement(By.name("new")).click();
    }

    private void gotoGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

}


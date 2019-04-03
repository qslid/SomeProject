package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.pft.stqa.addressbook.model.GroupInfo;

public class GroupsHelper extends HelperBase{
    private WebDriver wd;

    public GroupsHelper(WebDriver wd) {

        this.wd = wd;
    }

    public void fillGroupData(GroupInfo groupInfo) {
        type(By.name("group_name"), groupInfo.getNameGroup());
        type(By.name("group_header"),groupInfo.getHeader());
        type(By.name("group_footer"), groupInfo.getFooter());

    }

    private void type(By locator, String text) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void submitCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectFirstGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}

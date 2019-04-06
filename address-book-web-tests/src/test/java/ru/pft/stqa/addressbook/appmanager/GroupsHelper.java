package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.pft.stqa.addressbook.model.GroupInfo;

public class GroupsHelper extends HelperBase {

    public GroupsHelper(WebDriver wd) {
        super(wd);

    }

    public void fillGroupData(GroupInfo groupInfo) {
        type(groupInfo.getNameGroup(), By.name("group_name"));
        type(groupInfo.getHeader(), By.name("group_header"));
        type(groupInfo.getFooter(), By.name("group_footer"));

    }

    public void submitCreation() {
        click(By.name("submit"));
    }

    public void deleteGroup() {
        click(By.name("delete"));
    }

    public void selectFirstGroup() {
        click(By.name("selected[]"));
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public boolean isThereAnyGroup()
    {   return isElementPresent(By.name("selected[]"));
    }

    public void createGroup(GroupInfo groupInfo) {
            gotoCreationGroupsPage();
           fillGroupData(groupInfo);
            submitCreation();
            gotoGroupsPage();
        }

    public void gotoCreationGroupsPage() {
        click(By.name("new"));
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }
}

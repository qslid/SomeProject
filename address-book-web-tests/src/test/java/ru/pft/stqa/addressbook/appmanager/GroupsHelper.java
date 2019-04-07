package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
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

    public int countGroups() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupInfo> getGroupList() {
        List <GroupInfo> groups  = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement webElement : elements){
            String s = webElement.getText();
            GroupInfo group = new GroupInfo(s,null,null);
            groups.add(group);

        }
        return groups;
    }
}

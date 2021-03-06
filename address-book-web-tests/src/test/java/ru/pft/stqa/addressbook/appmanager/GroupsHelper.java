package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.pft.stqa.addressbook.model.GroupInfo;
import ru.pft.stqa.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

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

    public void selectGroupByID(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void modify(GroupInfo group) {
        selectGroupByID(group.getId());
        initGroupModification();
        fillGroupData(group);
        submitGroupModification();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }

    public boolean isThereAnyGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(GroupInfo groupInfo) {
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


    public Groups all() {
        Groups groups = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement webElement : elements) {
            String parsedName = webElement.getText();
            Integer id = Integer.parseInt(webElement.findElement(By.tagName("input")).getAttribute("value"));
            GroupInfo group = new GroupInfo().withId(id).withName(parsedName);
            groups.add(group);

        }
        return groups;
    }

    public void delete(int index) {
        selectGroup(index);
        deleteGroup();
        assertEquals(getTextFromDeletedGroup(), "Group has been removed.\n" +
                "return to the group page");
    }

    public void delete(GroupInfo group) {
        selectGroupByID(group.getId());
        deleteGroup();
    }

    public String getTextFromDeletedGroup() {
        return wd.findElement(By.cssSelector("div.msgbox")).getText();
    }


}

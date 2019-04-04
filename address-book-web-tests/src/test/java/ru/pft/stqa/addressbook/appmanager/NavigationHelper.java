package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoContactForm() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
        click(By.linkText("home page"));
    }

    public void gotoCreationGroupsPage() {
        click(By.name("new"));
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }

    public void gotoGroupPageAfterDeletion() {
        click(By.linkText("group page"));
    }
}

package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoNewContactForm() {
        click(By.linkText("add new"));
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }

    public void gotoHomePageByLink() {
        click(By.linkText("home page"));
    }

    public void gotoCreationGroupsPage() {
        click(By.name("new"));
    }

    public void gotoGroupsPage() {
        click(By.linkText("groups"));
    }

    public void gotoGroupPageReturn() {
        click(By.linkText("group page"));
    }

    public void gotoFirstContactUpdateForm() {
        click(By.xpath("(//img[@alt='Edit'])[1]"));
    }
}

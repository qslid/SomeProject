package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {

        this.wd = wd;
    }

    public void gotoContactForm() {
      wd.findElement(By.linkText("add new")).click();
    }

    public void gotoHomePage() {
      wd.findElement(By.linkText("home page")).click();
    }

    public void gotoCreationGroupsPage() {
        wd.findElement(By.name("new")).click();
    }

    public void gotoGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void gotoGroupPageAfterDeletion() {
        wd.findElement(By.linkText("group page")).click();
    }
}

package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }


    public void gotoHomePage() {
        click(By.linkText("home"));
    }

    public void gotoHomePageByLink() {
        click(By.linkText("home page"));
    }


    public void gotoGroupPageReturn() {
        click(By.linkText("group page"));
    }

    public void gotoFirstContactUpdateForm() {
        click(By.xpath("(//img[@alt='Edit'])[1]"));
    }
}

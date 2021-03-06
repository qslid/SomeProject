package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

}

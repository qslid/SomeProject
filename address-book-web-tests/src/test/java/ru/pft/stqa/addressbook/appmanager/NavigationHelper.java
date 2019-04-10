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

    public void gotoContactUpdateForm(int index) {
        List<WebElement> countContacts = wd.findElements(By.xpath("(//img[@alt='Edit'])"));
        if (countContacts.size() != 0) {
            countContacts.get(index).click();
        }
    }
}

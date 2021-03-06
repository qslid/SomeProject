package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;


public class ApplicationManager {
    public WebDriver wd;
    private NavigationHelper navigationHelper;

    private GroupsHelper groupsHelper;
    private SessionHelper sessionHelper;
    private ContactHelper contactHelper;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    private String browser;

    public ApplicationManager(String firefox) {

        browser = firefox;
    }

    public void init() {
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IEXPLORE)) {
            wd = new InternetExplorerDriver();
        }

        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get("http://autotest.h1n.ru/addressbook/index.php");

        groupsHelper = new GroupsHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);

        sessionHelper.login("admin", "secret");

    }


    public void stop() {
        session().logOut();
        wd.quit();
    }


    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = wd.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


    public GroupsHelper group() {
        return groupsHelper;
    }


    public SessionHelper session() {
        return sessionHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}

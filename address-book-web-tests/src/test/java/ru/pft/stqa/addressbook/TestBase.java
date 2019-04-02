package ru.pft.stqa.addressbook;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.fail;

public class TestBase {
    protected WebDriver wd;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    protected void logOut() {
        wd.findElement(By.linkText("Logout")).click();
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
      wd = new FirefoxDriver();
      wd.get("http://autotest.h1n.ru/addressbook/index.php");
      login("admin", "secret");
    }

    private void login(String username, String password) {
      wd.findElement(By.name("user")).click();
      wd.findElement(By.name("user")).clear();
      wd.findElement(By.name("user")).sendKeys(username);
      wd.findElement(By.name("pass")).clear();
      wd.findElement(By.name("pass")).sendKeys(password);
      wd.findElement(By.id("LoginForm")).submit();
    }

    protected void submitContactForm() {
      wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    protected void fillContactForm(ContactInfo contactInfo) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactInfo.getFirstName());
      wd.findElement(By.name("middlename")).click();
      wd.findElement(By.name("middlename")).clear();
      wd.findElement(By.name("middlename")).sendKeys(contactInfo.getMiddleName());
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactInfo.getLastName());
      wd.findElement(By.name("nickname")).clear();
      wd.findElement(By.name("nickname")).sendKeys(contactInfo.getNickname());
      wd.findElement(By.name("title")).click();
      wd.findElement(By.name("title")).clear();
      wd.findElement(By.name("title")).sendKeys(contactInfo.getTitle());
      wd.findElement(By.name("company")).clear();
      wd.findElement(By.name("company")).sendKeys(contactInfo.getCompany());
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactInfo.getAddressText());
      wd.findElement(By.name("home")).clear();
      wd.findElement(By.name("home")).sendKeys(contactInfo.getHomePhone());
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactInfo.getMobilePhone());
      wd.findElement(By.name("work")).click();
      wd.findElement(By.name("work")).clear();
      wd.findElement(By.name("work")).sendKeys(contactInfo.getWorkPhone());
      wd.findElement(By.name("fax")).click();
      wd.findElement(By.name("fax")).clear();
      wd.findElement(By.name("fax")).sendKeys(contactInfo.getFaxPhone());
      wd.findElement(By.name("homepage")).click();
      wd.findElement(By.name("homepage")).clear();
      wd.findElement(By.name("homepage")).sendKeys(contactInfo.getWebsite());
      wd.findElement(By.name("bday")).click();
      wd.findElement(By.name("bday")).click();
      wd.findElement(By.name("bmonth")).click();
      wd.findElement(By.name("bmonth")).click();
      wd.findElement(By.name("byear")).click();
      wd.findElement(By.name("byear")).clear();
      wd.findElement(By.name("byear")).sendKeys(contactInfo.getYear());
      wd.findElement(By.name("new_group")).click();
      wd.findElement(By.xpath("//body")).click();
    }

    protected void gotoContactForm() {
      wd.findElement(By.linkText("add new")).click();
    }

    protected void gotoHomePage() {
      wd.findElement(By.linkText("home page")).click();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();
    }


    private boolean isElementPresent(By by) {
      try {
        wd.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
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

    protected void submitCreation() {
        wd.findElement(By.name("submit")).click();
    }

    protected void fillGroupData(GroupInfo groupInfo) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupInfo.getNameGroup());
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupInfo.getHeader());
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupInfo.getFooter());
    }

    protected void gotoCreationGroupsPage() {
        wd.findElement(By.name("new")).click();
    }

    protected void gotoGroupsPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    protected void gotoGroupPageAfterDeletion() {
        wd.findElement(By.linkText("group page")).click();
    }

    protected void deleteGroup() {
        wd.findElement(By.name("delete")).click();
    }

    protected void selectFirstGroup() {
        wd.findElement(By.name("selected[]")).click();
    }
}

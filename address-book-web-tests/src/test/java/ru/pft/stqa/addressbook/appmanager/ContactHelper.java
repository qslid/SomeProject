package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.pft.stqa.addressbook.model.ContactInfo;
import ru.pft.stqa.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoNewContactForm() {
        click(By.linkText("add new"));
    }

    public void submitContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactInfo contactInfo) {
        type(contactInfo.getFirstName(), By.name("firstname"));
        type(contactInfo.getMiddleName(), By.name("middlename"));
        type(contactInfo.getLastName(), By.name("lastname"));
        click(By.xpath("//body"));
    }


    public void submitUpdate() {
        click(By.xpath("//input[22]"));
    }

    public void submitDeletion() {
        click(By.xpath("(//input[@name='update'])[3]"));
    }

    public void selectContactByID() {
        click(By.name("selected[]"));
    }



    public void submitDeletionOnMain() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }

    public void doCreateContact(ContactInfo contactInfo) {
        gotoNewContactForm();
        fillContactForm(contactInfo);
        submitContactForm();
        gotoHomePage();
    }

    public boolean isThereAnyContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public Contacts list() {
        Contacts contactsList = new Contacts();
        List<WebElement> tableElements = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr"));
        tableElements.remove(0); // избавляемся от заголовка в таблице
        for (WebElement webElement : tableElements) {
            String lastName = webElement.findElement(By.xpath("//td[2]")).getText();
            String fname = webElement.findElement(By.xpath("//td[3]")).getText();
            Integer id = Integer.parseInt(webElement.findElement(By.tagName("input")).getAttribute("value"));
            ContactInfo contact = new ContactInfo().withFirstName(fname).withLastName(lastName).withId(id);
            contactsList.add(contact);
        }
        return contactsList;
    }

    public void selectContactByID(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }
}

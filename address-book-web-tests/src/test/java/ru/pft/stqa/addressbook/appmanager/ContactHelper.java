package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.pft.stqa.addressbook.model.ContactInfo;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void submitContactForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactInfo contactInfo) {
        type(contactInfo.getFirstName(), By.name("firstname"));
        type(contactInfo.getMiddleName(), By.name("middlename"));
        type(contactInfo.getLastName(), By.name("lastname"));
        type(contactInfo.getNickname(), By.name("nickname"));
        type(contactInfo.getTitle(), By.name("title"));
        type(contactInfo.getCompany(), By.name("company"));
        type(contactInfo.getAddressText(), By.name("address"));
        type(contactInfo.getHomePhone(), By.name("home"));
        type(contactInfo.getMobilePhone(), By.name("mobile"));
        type(contactInfo.getWorkPhone(), By.name("work"));
        type(contactInfo.getFaxPhone(), By.name("fax"));
        type(contactInfo.getWebsite(), By.name("homepage"));
        type(contactInfo.getYear(), By.name("byear"));
        click(By.xpath("//body"));
    }


    public void submitUpdate() {
        click(By.xpath("(//input[@name='update'])[2]"));
    }

    public void submitDeletion() {
        click(By.xpath("(//input[@name='update'])[3]"));
    }

    public void selectFirstContact() {
        click(By.name("selected[]"));
    }

    public void submitDeletionOnMain() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }
}

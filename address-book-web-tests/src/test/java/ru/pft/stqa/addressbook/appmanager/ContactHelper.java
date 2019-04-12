package ru.pft.stqa.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.pft.stqa.addressbook.model.ContactInfo;
import ru.pft.stqa.addressbook.model.Contacts;

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
            String lastName = webElement.findElement(By.xpath(".//td[2]")).getText();
            String fname = webElement.findElement(By.xpath(".//td[3]")).getText();
            Integer id = Integer.parseInt(webElement.findElement(By.tagName("input")).getAttribute("value"));
            String allPhones = webElement.findElement(By.xpath(".//td[6]")).getText();
            String allAddresses = webElement.findElement(By.xpath(".//td[4]")).getText();
            String allEmails = webElement.findElement(By.xpath(".//td[5]")).getText();
            ContactInfo contact = new ContactInfo().withFirstName(fname).withLastName(lastName).withId(id).withAllPhones(allPhones).withAddress(allAddresses).withEmail1(allEmails);
            contactsList.add(contact);
        }
        return contactsList;
    }

    public void selectContactByID(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public ContactInfo infoFromEditGroup(ContactInfo contact) {
        gotoContactUpdateForm(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactInfo().withId(contact.getId()).withFirstName(firstname).withLastName(lastname).withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address).withEmail1(email1).withEmail2(email2).withEmail13(email3);
    }


    public void gotoContactUpdateForm(int id) {
        List<WebElement> countContacts = wd.findElements(By.xpath("(//img[@alt='Edit'])"));
        if (countContacts.size() != 0) {
            click(By.xpath("//a[@href='edit.php?id=" + id + "']"));
        }
}
}

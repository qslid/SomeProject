package ru.pft.stqa.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.pft.stqa.addressbook.model.ContactInfo;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactPhoneTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.getNavigationHelper().gotoHomePage();
        if (app.contact().list().size()==0) {
            app.contact().doCreateContact(new ContactInfo().withFirstName("FirstName").withLastName("LastName"));
        }
    }

    @Test
    public void contactPhonetest(){
        ContactInfo contactfromHome = app.contact().list().iterator().next();
        ContactInfo contactInfoFromEditForm = app.contact().infoFromEditGroup(contactfromHome);
        assertThat(contactfromHome.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    }

    @Test
    public void contactEMailtest(){
        ContactInfo contactfromHome = app.contact().list().iterator().next();
        ContactInfo contactInfoFromEditForm = app.contact().infoFromEditGroup(contactfromHome);
        assertThat(contactfromHome.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditForm)));

    }

    @Test
    public void contactAddresstest(){
        ContactInfo contactfromHome = app.contact().list().iterator().next();
        ContactInfo contactInfoFromEditForm = app.contact().infoFromEditGroup(contactfromHome);
        assertThat(cleared(contactfromHome.getAllAddresses()), equalTo(mergeAddress(contactInfoFromEditForm)));

    }

    private String mergeAddress(ContactInfo contact) {
            return Arrays.asList(contact.getAllAddresses())
                    .stream().filter((s) -> ! s.equals("")).
                            map(ContactPhoneTest::cleared)
                    .collect(Collectors.joining("\n"));
    }

    private String mergeEmail(ContactInfo contact) {
        return Arrays.asList(contact.getEmail1(),contact.getEmail2(),contact.getEmail3())
                .stream().filter((s) -> ! s.equals("")).
                        map(ContactPhoneTest::cleared)
                .collect(Collectors.joining("\n"));
    }


    private String mergePhones(ContactInfo contact) {
        return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
                .stream().filter((s) -> ! s.equals("")).
               map(ContactPhoneTest::cleared)
                .collect(Collectors.joining("\n"));
    }

    public static String cleared(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]","");
    }

}

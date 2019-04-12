package ru.pft.stqa.addressbook.model;

import java.util.Objects;

public class ContactInfo {
    private int id=0;
    private String firstName;
    private String middleName;
    private String lastName;
//    private String nickname;
//    private String title;
//    private String company;
//    private String addressText;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;
    private String allAddresses;
    private String allEmails;
    private String email3;
    private String email2;
    private String email1;

//    private String faxPhone;
//    private String website;
//    private String day;
//    private String month;
//    private String year;




    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactInfo withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getAllAddresses() {
        return allAddresses;
    }

    public ContactInfo withAddress(String allAddresses) {
        this.allAddresses = allAddresses;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getEmail3() {
        return email3;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail1() {
        return email1;
    }

    public ContactInfo withEmail1(String email) {
        this.email1 = email;
        return this;
    }

    public ContactInfo withEmail2(String email) {
        this.email2 = email;
        return this;
    }
    public ContactInfo withEmail13(String email) {
        this.email3 = email;
        return this;
    }


    public ContactInfo withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;

    }

    public ContactInfo withLastName(String lastName) {
        this.lastName = lastName;
        return this;

    }

    public ContactInfo withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }


    public String getHomePhone() {
        return homePhone;
    }

    public ContactInfo withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public ContactInfo withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactInfo withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactInfo that = (ContactInfo) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public ContactInfo withId(int id) {
        this.id = id;
        return this;
    }


}

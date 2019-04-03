package ru.pft.stqa.addressbook.model;

public class ContactInfo {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String nickname;
    private final String title;
    private final String company;
    private final String addressText;
    private final String homePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String faxPhone;
    private final String website;
    private final String day;
    private final String month;
    private final String year;

    public ContactInfo(String firstName, String middleName, String lastName, String nickname, String title, String company, String addressText, String homePhone, String mobilePhone, String workPhone, String faxPhone, String website, String day, String month, String year) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.addressText = addressText;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.faxPhone = faxPhone;
        this.website = website;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddressText() {
        return addressText;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFaxPhone() {
        return faxPhone;
    }

    public String getWebsite() {
        return website;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
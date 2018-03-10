package by.stqa.pft.addressbook.model;

import java.util.Objects;

import static java.lang.Integer.MAX_VALUE;

public class ContactData {
    private int id = Integer.MAX_VALUE;
    private String contactName;
    private  String contactLastname;
    private  String contactHomePhone;
    private  String contactMobilePhone;
    private  String contactWorkPhone;
    private String contactEmail;
    private String group;
    private String allPhones;
    private String allEmails;
    private String email1;
    private String email2;
    private String email3;

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }


    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }


    public ContactData withContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public ContactData withContactLastname(String contactLastname) {
        this.contactLastname = contactLastname;
        return this;
    }

    public ContactData withContactHomePhone(String contactHomePhone) {
        this.contactHomePhone = contactHomePhone;
        return this;
    }

    public ContactData  withContactMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
        return this;
    }
    public ContactData  withContactWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
        return this;
    }
    public ContactData withContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this;
    }
    public ContactData withId(int id) {

        this.id = id;
        return this;
    }

    public int getId() {

        return id;
    }

    public String getContactName() {
        return contactName;
    }

    public String getContactLastname() {
        return contactLastname;
    }

    public String getContactHomePhone() {
        return contactHomePhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactMobilePhone() {
        return contactMobilePhone;
    }

    public String getContactWorkPhone() {
        return contactWorkPhone;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getGroup() {
        return group;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(contactName, that.contactName) &&
                Objects.equals(contactLastname, that.contactLastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, contactName, contactLastname);
    }


    @Override
    public String toString() {
        return "ContactData{" +
                "contactName='" + contactName + '\'' +
                ", contactLastname='" + contactLastname + '\'' +
                '}';
    }


}

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

    public void setContactMobilePhone(String contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
    }

    public String getContactMobilePhone() {
        return contactMobilePhone;
    }

    public String getContactWorkPhone() {
        return contactWorkPhone;
    }

    public ContactData  withContactWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
        return this;
    }

    public void setContactWorkPhone(String contactWorkPhone) {
        this.contactWorkPhone = contactWorkPhone;
    }

    public ContactData withContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
        return this;
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

    public ContactData withGroup(String group) {
        this.group = group;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "contactName='" + contactName + '\'' +
                ", contactLastname='" + contactLastname + '\'' +
                '}';
    }

    public String getGroup() {
        return group;
    }
}

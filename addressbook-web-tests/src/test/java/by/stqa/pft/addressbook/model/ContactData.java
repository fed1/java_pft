package by.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private final String contactName;
    private final String contactLastname;
    private final String contactHomePhone;
    private final String contactEmail;
    private String group;

    public ContactData(int id, String contactName, String contactLastname, String contactHomePhone, String contactEmail, String group) {
        this.id = 0;
        this.contactName = contactName;
        this.contactLastname = contactLastname;
        this.contactHomePhone = contactHomePhone;
        this.contactEmail = contactEmail;
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public ContactData(String contactName, String contactLastname, String contactHomePhone, String contactEmail, String group) {
        this.id = 0;
        this.contactName = contactName;

        this.contactLastname = contactLastname;
        this.contactHomePhone = contactHomePhone;
        this.contactEmail = contactEmail;
        this.group = group;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(contactName, that.contactName) &&
                Objects.equals(contactLastname, that.contactLastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(contactName, contactLastname);
    }

    public String getGroup() {
        return group;
    }
}

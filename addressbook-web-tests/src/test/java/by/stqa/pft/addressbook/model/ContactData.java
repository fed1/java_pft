package by.stqa.pft.addressbook.model;

public class ContactData {
    private final String contactName;
    private final String contactLastname;
    private final String contactHomePhone;
    private final String contactEmail;
    private String group;

    public ContactData(String contactName, String contactLastname, String contactHomePhone, String contactEmail, String group) {
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

    public String getGroup() {
        return group;
    }
}

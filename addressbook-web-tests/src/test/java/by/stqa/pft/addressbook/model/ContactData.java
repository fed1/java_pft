package by.stqa.pft.addressbook.model;

public class ContactData {
    private final String contactName;
    private final String contactLastname;
    private final String contactHomePhone;
    private final String contactEmail;

    public ContactData(String contactName, String contactLastname, String contactHomePhone, String contactEmail) {
        this.contactName = contactName;
        this.contactLastname = contactLastname;
        this.contactHomePhone = contactHomePhone;
        this.contactEmail = contactEmail;
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
}

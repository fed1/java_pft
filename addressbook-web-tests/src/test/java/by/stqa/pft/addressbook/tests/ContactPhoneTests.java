package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones (){
        app.goTo().homepage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getContactHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactHomePhone())));
        assertThat(contact.getContactMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getContactMobilePhone())));
        assertThat(contact.getContactWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getContactWorkPhone())));
    }

    public String cleaned (String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]", "");
    }
}

package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ContactCommunicationDetailsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homepage();
        if (app.contact().all().size() == 0){
            ContactData newContact = new ContactData().
                    withContactName("Kate").withContactLastname("Nood").withContactHomePhone("+(37529)000 000").
                    withEmail1("box@box.by").withEmail2("tam@tam.by").withContactMobilePhone("33-67-90")
                    .withContactAddress("220055, г.Минск, ул.Зелёная, дом 60, кв.89").withGroup("test5");
            app.contact().create(newContact, true);
        }
    }

    @Test
    public void testContactCommunicationDetails(){
        app.goTo().homepage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
        assertThat(contact.getContactAddress(), equalTo(cleanedAddress(contactInfoFromEditForm.getContactAddress())));

    }
    
    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s)-> ! s.equals(""))
                .map(ContactCommunicationDetailsTests::cleanedEmail)
                .collect(Collectors.joining("\n"));
    }


    private String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getContactHomePhone(), contact.getContactMobilePhone(), contact.getContactWorkPhone())
               .stream().filter((s)-> ! s.equals(""))
               .map(ContactCommunicationDetailsTests::cleanedPhone)
               .collect(Collectors.joining("\n"));
    }

    public static String cleanedPhone(String phone){
        return phone.replaceAll("\\s","").replaceAll("[-()]", "");
    }
    public static String cleanedEmail (String email){
        return email.replaceAll("\\s","").replaceAll("[()]", "");
    }
    public static String cleanedAddress (String email){
        return email.replaceAll("\n","");
    }
}

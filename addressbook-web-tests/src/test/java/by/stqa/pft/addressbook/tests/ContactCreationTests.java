package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.Contacts;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

       Contacts before = app.contact().all();
       System.out.print("before = " + before.size()+ " ,");

       ContactData contact = new ContactData().
               withContactName("Kate").withContactLastname("Nood").withContactHomePhone("+37529000000").
               withContactEmail("box@box.by").withGroup("test5");

       app.contact().create((contact), true);
       Contacts after = app.contact().all();

       assertThat(after.size(), equalTo(before.size() + 1));
       assertThat(after, equalTo
               (before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


    }





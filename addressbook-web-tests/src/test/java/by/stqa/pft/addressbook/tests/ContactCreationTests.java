package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

       List<ContactData> before = app.getContactHelper().getContactList();
       ContactData contact = new ContactData("Jim2", "Beam2", "+37529000000",
               "box@box.by", "test1");
        app.getContactHelper().createContact((contact), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        before.add(contact);

       Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
       before.sort(byId);
       after.sort(byId);
       Assert.assertEquals(before, after);
    }



}

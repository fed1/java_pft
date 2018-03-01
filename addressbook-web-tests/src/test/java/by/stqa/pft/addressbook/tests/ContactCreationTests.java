package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

       List<ContactData> before = app.getContactHelper().getContactList();
       ContactData contact = new ContactData("Kate", "Nood", "+37529000000",
               "box@box.by", "test1");
        app.getContactHelper().createContact((contact), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());

        before.sort(byId);
        System.out.println(before.get(0).getId());
        System.out.println(before.get(1).getId());
        System.out.println(before.get(2).getId());
        System.out.println(before.get(3).getId());
        after.sort(byId);
        System.out.println(after.get(0).getId());
        System.out.println(after.get(1).getId());
        System.out.println(after.get(2).getId());
        System.out.println(after.get(3).getId());

       Assert.assertEquals(before, after);

    }



}

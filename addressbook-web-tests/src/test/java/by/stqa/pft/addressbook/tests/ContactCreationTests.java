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
        after.sort(byId);

      /*  class SortSpecial implements Comparator<ContactData> {
            public int compare(ContactData a, ContactData b)
            {
                String name1 = a.getContactLastname();
                String name2 = b.getContactLastname();
                return name1.compareToIgnoreCase(name2);
            }
        }
        Collections.sort(before, new SortSpecial());
        Collections.sort(after, new SortSpecial());
*/
       Assert.assertEquals(before, after);
       // System.out.println(before);
       // System.out.println(after);


    }



}

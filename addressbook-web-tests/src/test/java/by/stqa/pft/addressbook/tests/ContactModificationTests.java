package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @Test (enabled = false)
    public void testContactModification () {

        app.goTo().returnToHomepage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Ann", "Smith",
                    "+357290000000","box@mailbox.by", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);
        ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Jim", "Beam", "+37529000000",
                "box@box.by", "test1");

        app.getContactHelper().fillContactForm((contact), false);
        app.getContactHelper().submitContactModification();
        app.goTo().returnToHomepage();
        List<ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size()-1);
        before.add(contact);

        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());

        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);

}
}

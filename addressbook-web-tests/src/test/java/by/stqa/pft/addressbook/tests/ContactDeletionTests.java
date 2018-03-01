package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion () {

        app.getNavigationHelper().returnToHomepage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Ann", "Smith",
                    "+357290000000","box@mailbox.by", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size()-1);

        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToHomepage();

        List <ContactData> after = app.getContactHelper().getContactList();
        before.remove(before.size()-1);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}


/*
app.getContactHelper().selectContact(before.size()-1);
app.getContactHelper().deleteSelectedContacts();
app.getContactHelper().returnToContactPage();
List <ContactData> after = app.getContactHelper().getContactList();
Assert.assertEquals(after.size(), before.size() - 1);

before.remove(before.size()-1);
Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
before.sort(byId);
after.sort(byId);
Assert.assertEquals(before, after);

 */
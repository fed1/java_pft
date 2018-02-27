package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion () {

        app.getNavigationHelper().returnToHomepage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Ann", "Smith",
                    "+357290000000","box@mailbox.by", "test1"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToHomepage();

    }
}

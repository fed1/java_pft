package by.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase{

    @Test
    public void testContactDeletion () {

        app.getNavigationHelper().returnToHomepage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().returnToHomepage();

    }
}

package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification (){

        app.getNavigationHelper().returnToHomepage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("Sam2", "Adams2", "+375290000000", "mynewbox@tut.by"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomepage();

}
}

package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation()  {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Sam", "Adams", "+375290000000", "mynewbox@tut.by"));
        app.getContactHelper().submitContactCreation();
        app.returnToHomepage();
    }


}

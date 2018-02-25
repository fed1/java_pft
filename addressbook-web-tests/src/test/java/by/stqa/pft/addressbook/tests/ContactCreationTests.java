package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation()  {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Sam4", "Adams", "+375290000000", "mynewbox@tut.by", "test0009"),true);
        System.out.println("zapolnili");
        app.getContactHelper().submitContactCreation();
        app.returnToHomepage();
    }


}

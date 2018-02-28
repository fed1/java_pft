package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
    @Test
    public void testContactModification (){

        app.getNavigationHelper().returnToHomepage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("Ann", "Smith",
                    "+357290000000","box@mailbox.by", "test1"), true);
        }
        app.getContactHelper().initContactModification(0);
       // app.getContactHelper().selectContact(0);
        app.getContactHelper().fillContactForm(new ContactData("Sam2", "Adams2",
                "+375290000000", "mynewbox@tut.by", null), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().returnToHomepage();
        int b = app.getContactHelper().getContactCount();
        System.out.println("Всего контактов" + b);


}
}

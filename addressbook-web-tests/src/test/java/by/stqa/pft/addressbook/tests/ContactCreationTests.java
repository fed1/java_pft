package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {

        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("Sam", "Jones", "+37529000000",
                "box@box.by", "test1"), true);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }


}

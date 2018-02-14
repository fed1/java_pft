package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.model.ContactData;
import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class ContactCreationTests extends TestBase {


    @Test
    public void testContactCreation() {

        app.initContactCreation();
        fillContactForm(new ContactData("Garry", "Doe",
                                    "+375290000000", "mynewbox@tut.by"));
        app.submitContactCreation();
        app.returnToHomepage();
    }

    private void fillContactForm(ContactData contactData) {
        app.wd.findElement(By.name("firstname")).click();
        app.wd.findElement(By.name("firstname")).clear();
        app.wd.findElement(By.name("firstname")).sendKeys(contactData.getContactName());
        app.wd.findElement(By.name("lastname")).click();
        app.wd.findElement(By.name("lastname")).clear();
        app.wd.findElement(By.name("lastname")).sendKeys(contactData.getContactLastname());
        app.wd.findElement(By.name("home")).click();
        app.wd.findElement(By.name("home")).clear();
        app.wd.findElement(By.name("home")).sendKeys(contactData.getContactHomePhone());
        app.wd.findElement(By.name("email")).click();
        app.wd.findElement(By.name("email")).clear();
        app.wd.findElement(By.name("email")).sendKeys(contactData.getContactEmail());
    }


}

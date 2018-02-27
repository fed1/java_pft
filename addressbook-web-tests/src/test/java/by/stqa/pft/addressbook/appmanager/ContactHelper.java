package by.stqa.pft.addressbook.appmanager;

import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


   // private FirefoxDriver wd;

    public ContactHelper(WebDriver wd) {

        super(wd);
    }
    public void returnToHomepage() {
        click(By.linkText("home"));
    }
    public void submitContactCreation() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContactCreation() {
        click(By.linkText("add new")); // a form for adding new contacts is opened
    }

    public void fillContactForm(ContactData contactData, boolean creation) {

        type(By.name("firstname"), contactData.getContactName());
        type(By.name("lastname"), contactData.getContactLastname());
        type(By.name("home"), contactData.getContactHomePhone());
        type(By.name("email"), contactData.getContactEmail());

        if (creation){
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        }
        else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
        //click(By.name("edit"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void deleteContact() {
       click(By.xpath("//div/div[4]/form[2]/input[2]"));
    }

    public void createContact(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        System.out.println("zapolnili");
        submitContactCreation();
        returnToHomepage();

    }


    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount(){
        return wd.findElements(By.name("selected[]")).size();
    }
    public List<ContactData> getContactList() {
        List <ContactData> contacts = new ArrayList<ContactData>();
        List <WebElement> elements = wd.findElements(By.className("entry"));
        for (WebElement element : elements){
            String name = element.getAttribute("name");
            String lastname = element.getAttribute("lastname");
            ContactData contact = new ContactData(name, lastname,null, null, null);
            contacts.add(contact);
        }
        return contacts;
    }
}

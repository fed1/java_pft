package by.stqa.pft.addressbook.appmanager;

import by.stqa.pft.addressbook.model.ContactData;
import by.stqa.pft.addressbook.model.Contacts;
import by.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


   // private FirefoxDriver wd;

    public ContactHelper(WebDriver wd) {

        super(wd);
    }
    public void homepage() {
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
       // wd.findElement(By.cssSelector("div[title='Edit']")).click();
      //  wd.findElement(By.xpath("//*[@id='maintable']/tbody/tr['"+id+"']/td[8]/a/img"));
        //wd.findElement(By.linkText("edit.php?id=" + id)).findElement(By.tagName("img src")).click();
        //wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).get(index).click()
        //"div[title='my']"

    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void deleteContact() {
        // click(By.xpath("//div/div[4]/form[2]/input[2]"));
        wd.findElement(By.cssSelector("input[value='Delete']")).click();
        wd.switchTo().alert().accept();
    }

    public void create(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        homepage();

    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }


    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='"+ id + "']")).click();

    }
    public void select() {


        click(By.name("selected[]"));


    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List <WebElement> elements = wd.findElements(By.name("entry"));
        System.out.println("found elements: " + elements.size() );
        for (WebElement element : elements){
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contacts.add(new ContactData().withId(id).withContactName(name).withContactLastname(lastname));
        }
        return contacts;
    }
    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        homepage();
        }

    public void modify(ContactData contact) {
       selectContactById(contact.getId());
       // select();
        initContactModification();
        fillContactForm(contact,false);
        submitContactModification();
        homepage();
    }
}

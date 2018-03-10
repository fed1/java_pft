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
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List <WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
        //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id)));

    }
    public void select() {


        click(By.name("selected[]"));


    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List <WebElement> elements = wd.findElements(By.name("entry"));
        //System.out.println("found elements: " + elements.size() );
        for (WebElement element : elements){
           // List<WebElement> cells = element.findElements(By.tagName("td"));
            String name = element.findElements(By.tagName("td")).get(2).getText();
            String lastname = element.findElements(By.tagName("td")).get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String allPhones = element.findElements(By.tagName("td")).get(5).getText();
            String allEmails = element.findElements(By.tagName("td")).get(4).getText();
            contacts.add(new ContactData().withId(id).withContactName(name).withContactLastname(lastname)
                    .withAllPhones(allPhones).withAllEmails(allEmails));
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

    public ContactData infoFromEditForm(ContactData contact) {
        selectContactById(contact.getId());
        String firstname  = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname  = wd.findElement(By.name("lastname")).getAttribute("value");
        String homePhone  = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhone  = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhone  = wd.findElement(By.name("work")).getAttribute("value");
        String email1  = wd.findElement(By.name("email")).getAttribute("value");
        String email2  = wd.findElement(By.name("email2")).getAttribute("value");
        String email3  = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withContactName(firstname).withContactLastname(lastname)
        .withContactHomePhone(homePhone).withContactMobilePhone(mobilePhone).withContactWorkPhone(workPhone)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3);


    }
}

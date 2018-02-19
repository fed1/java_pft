package by.stqa.pft.addressbook.appmanager;

import by.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactHelper extends HelperBase {


    private FirefoxDriver wd;

    public ContactHelper(WebDriver wd) {

        super(wd);
    }

    public void submitContactCreation() {

        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void initContactCreation() {
        click(By.linkText("add new")); // a form for adding new contacts is opened
    }

    public void fillContactForm(ContactData contactData) {

        type(By.name("firstname"), contactData.getContactName());
        type(By.name("lastname"), contactData.getContactLastname());
        type(By.name("home"), contactData.getContactHomePhone());
        type(By.name("email"), contactData.getContactEmail());
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
}

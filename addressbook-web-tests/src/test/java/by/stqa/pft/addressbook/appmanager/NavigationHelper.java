package by.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase {

///private FirefoxDriver wd;
    public NavigationHelper(WebDriver wd) {

        super(wd);
    }


    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void returnToHomepage() {
        click(By.linkText("home")); // newly added contacts can be seen on the homepage
    }
}

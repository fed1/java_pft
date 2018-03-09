package by.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

///private FirefoxDriver wd;
    public NavigationHelper(WebDriver wd) {

        super(wd);
    }


    public void groupPage() {
        if(isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))){
            return;
        }
        click(By.linkText("groups"));
    }

    public void returnToHomepage() {
        if(isElementPresent(By.id("mainainable"))){
            return;
        }
        click(By.linkText("home")); // newly added contacts can be seen on the homepage
    }
}

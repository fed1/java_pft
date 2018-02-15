package by.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper {

private FirefoxDriver wd;
    public NavigationHelper(FirefoxDriver wd) {
        this.wd = wd;
    }


    public void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public void returnToHomepage() {
        wd.findElement(By.linkText("home page")).click(); // newly added contacts can be seen on the homepage
    }
}

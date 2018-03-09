package by.stqa.pft.addressbook.appmanager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    WebDriver wd;

    private SessionHelper sessionHelper;
    private GroupHelper groupHelper;
    private NavigationHelper navigationHelper;
    private ContactHelper contactHelper;
    private String browser;

    public ApplicationManager (String browser){
        this.browser = browser;
    }


    public void init() {

        if (browser.equals(BrowserType.FIREFOX)){
           // wd = new FirefoxDriver();
            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        } else if (browser.equals(BrowserType.CHROME)){
           ChromeOptions options = new ChromeOptions();
            options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe"); //C:\Program Files (x86)\Google\Chrome\Application
          wd = new ChromeDriver(options);

          //  wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }
            // wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook");
        groupHelper = new GroupHelper(wd);
        contactHelper = new ContactHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        sessionHelper.login("admin", "secret");

    }



    public void stop() {
        wd.quit();
    }


    public GroupHelper group() {
        return groupHelper;
    }

    public ContactHelper contact() {
        return contactHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public void groupPage() {
        navigationHelper.groupPage();
    }

    public void returnToHomepage() {
        navigationHelper.homepage();
    }
}

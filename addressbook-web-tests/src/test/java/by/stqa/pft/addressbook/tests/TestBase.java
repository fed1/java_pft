package by.stqa.pft.addressbook.tests;

import by.stqa.pft.addressbook.appmanager.ApplicationManager;
import by.stqa.pft.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.remote.BrowserType;


public class TestBase {

    //protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);
    //protected final ApplicationManager app = new ApplicationManager(BrowserType.IE);
    protected final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeMethod
    public void setUp() throws Exception {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }



}

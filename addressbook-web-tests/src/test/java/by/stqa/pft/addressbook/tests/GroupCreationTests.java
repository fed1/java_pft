package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.GroupData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        app.gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test0009", "test0009-1", "test0004-1"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}

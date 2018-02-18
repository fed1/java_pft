package by.stqa.pft.addressbook.tests;


import by.stqa.pft.addressbook.model.GroupData;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification (){
        app.gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test0999", "test077-1", "test0456-1"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
    }
}

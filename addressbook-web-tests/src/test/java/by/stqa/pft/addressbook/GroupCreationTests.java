package by.stqa.pft.addressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test0008", "test0009", "test0004"));
        submitGroupCreation();
        returnToGroupPage();
    }

}

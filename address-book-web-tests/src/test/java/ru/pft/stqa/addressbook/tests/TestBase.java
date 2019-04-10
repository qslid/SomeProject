package ru.pft.stqa.addressbook.tests;


import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.pft.stqa.addressbook.appmanager.ApplicationManager;
import ru.pft.stqa.addressbook.model.GroupInfo;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }


    protected void delete(List<GroupInfo> before) {
        app.group().selectGroup(before.size() - 1);
        app.group().deleteGroup();
        assertEquals(app.group().getTextFromDeletedGroup(), "Group has been removed.\n" +
                "return to the group page");
        app.getNavigationHelper().gotoGroupPageReturn();
    }
}

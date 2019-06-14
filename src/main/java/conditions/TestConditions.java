package conditions;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;


@Listeners({TestListener.class})
public class TestConditions {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod()
    public void getUpBrowser(){
        driver = DriverManager.getDriver();
        softAssert = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        DriverManager.closeDriver();
    }
}

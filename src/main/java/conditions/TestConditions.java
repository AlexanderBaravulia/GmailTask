package conditions;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;


@Listeners({TestListener.class})
public class TestConditions {

    protected WebDriver webDriver;

    public TestConditions() {
        this.webDriver = DriverManager.get();
    }

    @BeforeClass
    public void setUp() {
        webDriver = DriverManager.get();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        DriverManager.closeDriver();
    }
}

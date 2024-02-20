import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CinemaAppTest {

    AppiumDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.tengyeekong.movieapp");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.tengyeekong.movieapp.ui.MainActivity");

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);



        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Appium driver", e);
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test(priority = 1)
    public void openApp() {
        // Implement code to open the cinema app
    }

    @Test(priority = 2)
    public void clickMovie() {
        // Implement code to click on a movie
        MobileElement movieElement = driver.findElement(By.xpath("//*[@resource-id='com.tengyeekong.movieapp:id/ivPoster']"));
        movieElement.click();

    }

    @Test(priority = 3)
    public void viewMovieDetails() {
        // Implement code to view movie details
    }


    @Test(priority = 4)
    public void bookMovie() {

        // Implement code to book the movie

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Find the book button directly as a MobileElement
        MobileElement bookButton = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.tengyeekong.movieapp:id/btnBookMovie")));

        // Click the book button
        bookButton.click();

    }

    @Test(priority = 5)
    public void viewBookingDetails() {
        // Implement code to view booking details
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@resource-id='com.tengyeekong.movieapp:id/webView']")));

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
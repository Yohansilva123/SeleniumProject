package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class BasePage {
    public static WebDriver driver = null;
    public static final int seconds = 60;  // Example: 1 hour in seconds
    private static String env;

    public static void setUpBrowser(String url, String env){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        env = env;
    }

    public static String getEnv(){
        return env;
    }

    public static void navigateToUrl(String url){
        driver.navigate().to(url);
    }

    public static void browserTearDown(){
        driver.close();
    }

    public static void closeDriver(){
        driver.quit();
    }

    public static void click(By element){
        WebDriverWait wait = new WebDriverWait(driver,intToDuration());
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.click();
    }

    public static void typeText(By element, String text){
        WebDriverWait wait = new WebDriverWait(driver,intToDuration());
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(text);
    }

    public static String getText(By element){
        WebDriverWait wait = new WebDriverWait(driver,intToDuration());
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return element1.getText();
    }

    public static boolean isElementVisible(By element){
        WebDriverWait wait = new WebDriverWait(driver,intToDuration());
        WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return element1.isDisplayed();
    }

    public static Duration intToDuration(){
        return Duration.ofSeconds(seconds);
    }

    public static Set<String> getWindowHandles() {
        Set<String> handles;
        handles = driver.getWindowHandles();
        return handles;
    }

    public static void switchWindow(String handleName){
        driver.switchTo().window(handleName);
    }
}

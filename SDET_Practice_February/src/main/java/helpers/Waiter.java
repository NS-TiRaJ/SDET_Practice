package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiter {
    public static void waitUntilVisible(final WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until((ExpectedConditions.visibilityOf(element)));
    }
    public static void waitToBeClickable(final WebDriver driver, WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(5)).until((ExpectedConditions.elementToBeClickable(element)));
    }
}

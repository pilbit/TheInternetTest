package source.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Hover {
    private WebDriver driver;
    private WebDriverWait wait;

    public Hover(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void checkViewProfile() {
        Actions action = new Actions(driver);
        List<WebElement> element = driver.findElements(cssSelector("[alt='User Avatar']"));
        action.moveToElement(element.get(0)).build().perform();
        wait.until(elementToBeClickable(linkText("View profile"))).click();
        wait.until(visibilityOf(driver.findElement(tagName("h1"))));
    }
}

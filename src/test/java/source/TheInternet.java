package source;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TheInternet {
    WebDriver driver;
    WebDriverWait wait;



    public TheInternet(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void getViewProfile() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        List<WebElement> element = driver.findElements(cssSelector("[alt='User Avatar']"));
        action.moveToElement(element.get(0)).build().perform();
        wait.until(elementToBeClickable(linkText("View profile"))).click();
        wait.until(visibilityOf(driver.findElement(tagName("h1"))));
    }

    public String getAlert() {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().accept();
        return wait.until(visibilityOf(driver.findElement(By.id("result")))).getText();

    }

    public String getNewWindow() {
        driver.get("http://the-internet.herokuapp.com/windows");
        wait.until(elementToBeClickable(driver.findElement(linkText("Click Here")))).click();
        String window = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        String newWindowTitle = switchToWindow(windows);
        driver.close();
        driver.switchTo().window(window);
        return newWindowTitle;
    }

    private String switchToWindow(Set<String> windows) {
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            driver.switchTo().window(iterator.next());
        }
        return driver.getTitle();
    }
}

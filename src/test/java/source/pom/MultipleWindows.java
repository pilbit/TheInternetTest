package source.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MultipleWindows {
    private WebDriver driver;
    private WebDriverWait wait;


    public MultipleWindows(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String MultipleWindows() {
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

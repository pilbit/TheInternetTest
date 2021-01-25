package source.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public AbTest(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String checkAbTest() {
        String header = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h3")))).getText();
        driver.navigate().back();
        return header;
    }
}

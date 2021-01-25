package source.pom;

import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.cssSelector;

public class JavaScriptAlert {
    private WebDriver driver;

    public JavaScriptAlert(WebDriver driver) {
        this.driver = driver;
    }

    public void checkJavaScriptAlert() {
        driver.findElement(cssSelector("button[onclick='jsConfirm()']")).click();
        driver.switchTo().alert().accept();
    }
}

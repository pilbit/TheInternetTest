package source.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class JavaScriptAlert {
    @FindBy(css = "button[onclick='jsConfirm()']")
    private WebElement confirm;
    private WebDriver driver;
    private WebDriverWait wait;

    public JavaScriptAlert(WebDriver driver, WebDriverWait wait) {
        initElements(driver, this);
        this.driver = driver;
    }

    public void checkJavaScriptAlert() {
        confirm.click();
        driver.switchTo().alert().accept();
    }
}

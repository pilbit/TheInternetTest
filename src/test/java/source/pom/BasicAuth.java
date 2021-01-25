package source.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasicAuth {
    @FindBy(tagName = "h3")
    private WebElement header;
    private WebDriver driver;
    private WebDriverWait wait;

    public BasicAuth(WebDriver driver, WebDriverWait wait) {
        initElements(driver, this);
        this.driver = driver;
        this.wait = wait;
    }

    public String checkBasicAuth() {
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        String headerText = wait.until(ExpectedConditions.visibilityOf(header)).getText();
        driver.navigate().back();
        return headerText;
    }
}

package source.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.TheInternet;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasicAuth extends TheInternet {
    @FindBy(tagName = "h3")
    private WebElement header;

    public BasicAuth() {
        initElements(getDriver(), this);

    }

    public String checkBasicAuth() {
        getDriver().get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        String headerText = getWait().until(ExpectedConditions.visibilityOf(header)).getText();
        getDriver().navigate().back();
        return headerText;
    }
}

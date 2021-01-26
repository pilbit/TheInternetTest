package source.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.TheInternet;

import static org.openqa.selenium.support.PageFactory.initElements;

public class JavaScriptAlert extends TheInternet {
    @FindBy(css = "button[onclick='jsConfirm()']")
    private WebElement confirm;


    public JavaScriptAlert() {
        initElements(getDriver(), this);

    }

    public void checkJavaScriptAlert() {
        confirm.click();
        getDriver().switchTo().alert().accept();
    }
}

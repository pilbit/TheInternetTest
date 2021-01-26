package source.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import source.TheInternet;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AbTestInfo extends TheInternet {
    @FindBy(tagName = "h3")
    private WebElement header;

    public AbTestInfo() {
        initElements(getDriver(), this);
    }

    public boolean checkAbTest() {
        String headerText = getWait().until(ExpectedConditions.visibilityOf(header)).getText();
        getDriver().navigate().back();
        if(headerText.equalsIgnoreCase("A/B Test Control") || headerText.equalsIgnoreCase("A/B Test Variation 1")){
            return true;
        }
        return false;
    }
}

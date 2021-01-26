package source.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import source.TheInternet;

import java.util.List;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Hover extends TheInternet {

    public void checkViewProfile() {
        Actions action = new Actions(getDriver());
        List<WebElement> element = getDriver().findElements(cssSelector("[alt='User Avatar']"));
        action.moveToElement(element.get(0)).build().perform();
        getWait().until(elementToBeClickable(linkText("View profile"))).click();
        getWait().until(visibilityOf(getDriver().findElement(tagName("h1"))));
    }
}

package source.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.TheInternet;

import java.util.Iterator;
import java.util.Set;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class MultipleWindows extends TheInternet {


    public String MultipleWindows() {
        getWait().until(elementToBeClickable(getDriver().findElement(linkText("Click Here")))).click();
        String window = getDriver().getWindowHandle();
        Set<String> windows = getDriver().getWindowHandles();
        String newWindowTitle = switchToWindow(windows);
        getDriver().close();
        getDriver().switchTo().window(window);
        return newWindowTitle;
    }

    private String switchToWindow(Set<String> windows) {
        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()) {
            getDriver().switchTo().window(iterator.next());
        }
        return getDriver().getTitle();
    }
}

package source;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import source.pom.*;

import static config.Driver.getInstance;
import static config.Driver.getInstanceWait;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class TheInternet {
    private WebDriver driver;
    private WebDriverWait wait;
    private String baseUrl;
    private static Logger log;


    public TheInternet() {
        this.driver = getInstance();
        wait = getInstanceWait();
        baseUrl = "http://the-internet.herokuapp.com";
        log = LogManager.getLogger(this.getClass().getName());
    }

    public String getHover() {
        clickMenu("Hovers");
        Hover hover = new Hover();
        hover.checkViewProfile();
        return driver.getCurrentUrl();
    }

    public boolean getInfo() {
        clickMenu("A/B Testing");
        AbTestInfo abTest = new AbTestInfo();
        return abTest.checkAbTest();
    }

    public boolean getAddRemoveElements() {
        clickMenu("Add/Remove Elements");
        AddRemoveElements addRemoveElements = new AddRemoveElements();
        return addRemoveElements.checkAddRemoveElements();
    }

    public String getBasicAuth() {
        clickMenu("Basic Auth");
        BasicAuth basicAuth = new BasicAuth();
        return basicAuth.checkBasicAuth();
    }

    public int getBrokenImages() {
        clickMenu("Broken Images");
        BrokenImages brokenImages = new BrokenImages();
        return brokenImages.checkBrokenImages();
    }

    public String getAlert() {
        clickMenu("JavaScript Alerts");
        JavaScriptAlert javaScriptAlert = new JavaScriptAlert();
        javaScriptAlert.checkJavaScriptAlert();
        return wait.until(visibilityOf(driver.findElement(id("result")))).getText();
    }

    public String getNewWindow() {
        clickMenu("Multiple Windows");
        MultipleWindows multipleWindows = new MultipleWindows();
        return multipleWindows.MultipleWindows();
    }


    private void clickMenu(String nazwaMenu) {
        driver.get(baseUrl);
        wait.until(elementToBeClickable(driver.findElement(linkText(nazwaMenu)))).click();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static Logger getLog() {
        return log;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}

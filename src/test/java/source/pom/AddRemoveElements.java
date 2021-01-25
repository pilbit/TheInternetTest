package source.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AddRemoveElements {
    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addElement;
    @FindBy(css = "button[onclick='deleteElement()']")
    private WebElement removeElement;
    private WebDriver driver;
    private WebDriverWait wait;

    public AddRemoveElements(WebDriver driver, WebDriverWait wait) {
        initElements(driver, this);
        this.wait = wait;
    }

    public boolean checkAddRemoveElements() {
        Random randomNumber = new Random();
        int buttomCounter = randomNumber.nextInt(10);
        addElements(buttomCounter);
        removeElements(buttomCounter);
        return checkElements();
    }

    private boolean checkElements() {
        try {
            removeElement.isDisplayed();
            return false;
        } catch (NoSuchElementException nsee) {
            nsee.getMessage();
            return true;
        }
    }

    private void addElements(int buttomCounter) {
        for (int i = 0; i < buttomCounter; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addElement)).click();
        }
    }

    private void removeElements(int buttomCounter) {
        for (int i = 0; i < buttomCounter; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(removeElement)).click();
        }
    }
}

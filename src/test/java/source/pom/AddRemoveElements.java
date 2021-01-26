package source.pom;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import source.TheInternet;

import java.util.Random;

import static org.openqa.selenium.support.PageFactory.initElements;

public class AddRemoveElements extends TheInternet {
    @FindBy(css = "button[onclick='addElement()']")
    private WebElement addElement;
    @FindBy(css = "button[onclick='deleteElement()']")
    private WebElement removeElement;


    public AddRemoveElements() {
        initElements(getDriver(), this);

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
            getWait().until(ExpectedConditions.elementToBeClickable(addElement)).click();
        }
    }

    private void removeElements(int buttomCounter) {
        for (int i = 0; i < buttomCounter; i++) {
            getWait().until(ExpectedConditions.elementToBeClickable(removeElement)).click();
        }
    }
}

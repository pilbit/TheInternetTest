package source.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import source.TheInternet;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BrokenImages extends TheInternet {
    @FindBy(tagName = "img")
    private List<WebElement> images;

    public BrokenImages() {
        initElements(getDriver(), this);

    }

    public int checkBrokenImages() {
        int brokenImagesCounter = 0;
        for (int i = 0; i < images.size(); i++) {
            if (images.get(i).getAttribute("src").split("/img/").length != 2) {
                brokenImagesCounter++;
            }
        }
        return brokenImagesCounter;
    }
}

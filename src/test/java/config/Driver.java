package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

public class Driver {
    private static WebDriver instance = null;

    private Driver() {
    }

    public static WebDriver getInstance() {
        if (instance == null) {
            setProperty("webdriver.chrome.driver", getProperty("user.dir")+"/src/test/java/config/chromedriver");
            instance = new ChromeDriver();
        }
        return instance;
    }
}

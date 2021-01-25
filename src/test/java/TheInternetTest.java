import com.github.javafaker.Faker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import source.TheInternet;

import java.util.Locale;

import static config.Driver.getInstance;
import static org.apache.log4j.PropertyConfigurator.configure;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static utils.ScreenShot.takeSreenShot;


public class TheInternetTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private TheInternet theInternet;
    private String expectedResult;
    private String errorMessage;
    private static Logger log;
    private Faker faker;

    @BeforeSuite
    public void setUp() {
        this.driver = getInstance();
        wait = new WebDriverWait(driver, 2);
        theInternet = new TheInternet(driver, wait);
        log = LogManager.getLogger(this.getClass().getName());
        configure(System.getProperty("user.dir")+"/src/main/resources/log4j.properties");
        faker = new Faker(new Locale("pl"));
    }

    @Test()
    public void testViewProfile() {
        theInternet.getViewProfile();
        expectedResult = "http://the-internet.herokuapp.com/users/1";
        errorMessage = "Błąd przejscia do strony po kliknięciu w viewProfile";
        assertEquals(driver.getCurrentUrl(), expectedResult, errorMessage);
    }

    @Test()
    public void testAlert() {
        expectedResult = "You clicked: Ok";
        errorMessage = "Nieprawidłowa informacja po akcji accept alert";
        assertEquals(theInternet.getAlert(), expectedResult, errorMessage);
    }

    @Test()
    public void testWindow() {
        expectedResult = "New Window";
        errorMessage = "Blad powrotu do okna glownego w metodzie - testWindow";
        assertEquals(theInternet.getNewWindow(), expectedResult, errorMessage);
    }

    @Test(dataProvider = "listaOsob")
    public void testProvider(String imie, String nazwisko) {
        log.info("Test data provider");
        assertNotEquals(imie, nazwisko,"Imie i nazwisko musi sie roznic");
    }

    @DataProvider(name = "listaOsob")
    public Object[][] providerData() {
        return new Object[][]{{faker.name().firstName(), faker.name().lastName()}, {faker.name().firstName(), faker.name().lastName()}
                , {faker.name().firstName(), faker.name().lastName()}};
    }


    @AfterMethod
    public void getScreenShot(ITestResult result) {
        if (result.getStatus() != ITestResult.SUCCESS) {
            takeSreenShot(driver, result.getMethod().getMethodName());
            log.error("Wystapil blad w \" "+result.getMethod().getMethodName()+" \"");
        }else{
            log.info("Sprawdzono \" "+result.getMethod().getMethodName()+" \"");
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

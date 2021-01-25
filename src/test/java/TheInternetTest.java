import com.github.javafaker.Faker;
import org.testng.ITestResult;
import org.testng.annotations.*;
import source.TheInternet;
import utils.ScreenShot;

import java.util.Locale;

import static java.lang.System.getProperty;
import static org.apache.log4j.PropertyConfigurator.configure;
import static org.testng.Assert.*;


public class TheInternetTest extends TheInternet {
    private String expectedResult;
    private String errorMessage;

    private Faker faker;


    @BeforeSuite
    public void setUp() {
        configure(getProperty("user.dir") + "/src/main/resources/log4j.properties");
        faker = new Faker(new Locale("pl"));
    }

    @Test()
    public void testReadInfo() {
        expectedResult = "A/B Test Variation 1";
        errorMessage = "Oczekiwany header strony - \"" + expectedResult + "\"";
        assertEquals(getInfo(), expectedResult, errorMessage);
    }

    @Test()
    public void testAddRemoveElements() {
        errorMessage = "Wystapil blad w trakcie dodawania/usuwania elementów";
        assertTrue(getAddRemoveElements(), errorMessage);
    }

    @Test()
    public void testHover() {
        expectedResult = "http://the-internet.herokuapp.com/users/1";
        errorMessage = "Błąd przejscia do strony po kliknięciu w viewProfile";
        assertEquals(getHover(), expectedResult, errorMessage);
    }

    @Test()
    public void testAlert() {
        expectedResult = "You clicked: Ok";
        errorMessage = "Nieprawidłowa informacja po akcji accept alert";
        assertEquals(getAlert(), expectedResult, errorMessage);
    }

    @Test()
    public void testWindow() {
        expectedResult = "New Window";
        errorMessage = "Blad powrotu do okna glownego w metodzie - testWindow";
        assertEquals(getNewWindow(), expectedResult, errorMessage);
    }

    @Test(dataProvider = "listaOsob")
    public void testProvider(String imie, String nazwisko) {
        errorMessage = "Imie i nazwisko musi sie roznic";
        getLog().info("Test data provider");
        assertNotEquals(imie, nazwisko, errorMessage);
    }

    @DataProvider(name = "listaOsob")
    public Object[][] providerData() {
        return new Object[][]{{faker.name().firstName(), faker.name().lastName()}, {faker.name().firstName(), faker.name().lastName()}
                , {faker.name().firstName(), faker.name().lastName()}};
    }


    @AfterMethod
    public void getScreenShot(ITestResult result) {
        ScreenShot screenShot = new ScreenShot();
        screenShot.chackResult(result);
    }

    @AfterSuite
    public void tearDown() {
        getDriver().quit();
    }
}

package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import source.TheInternet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends TheInternet {

    public void chackResult(ITestResult result) {
        if (result.getStatus() != ITestResult.SUCCESS) {
            takeSreenShot(getDriver(), result.getMethod().getMethodName());
            getLog().error("Wystapil blad w \" " + result.getMethod().getMethodName() + " \"");
        } else {
            getLog().info("Sprawdzono \" " + result.getMethod().getMethodName() + " \"");
        }
    }

    private void takeSreenShot(WebDriver driver, String name) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
        String time = formatter.format(new Date());
        String target = System.getProperty("user.dir") + "/src/test/java/files/" + name + "_" + time + ".png";
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(target));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

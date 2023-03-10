package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import page.IndexPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseSetup {

    private final String URL = "https://www.rocknation.id/";
    private WebDriver driver;
    public IndexPage indexPage;

    @BeforeClass
    public void BaseSetup() {
        //import drive chrome
        System.setProperty("webdriver.chrome.driver", "E:\\Data\\WIKU_YOGA_NDARU\\SELENIUM\\library\\chrome\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //instance driver as chrome driver;
        driver = new ChromeDriver(options);

        //setup browser to maximize
        driver.manage().window().maximize();
        //give timeout 10 scn
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate browser to website
        driver.navigate().to(URL);

        indexPage = new IndexPage(driver);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result){
        if (result.getStatus() == ITestResult.SUCCESS){
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshot/"+result.getName()+".jpg"));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

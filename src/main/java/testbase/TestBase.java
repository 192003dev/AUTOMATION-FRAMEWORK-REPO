package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import testutil.Utility;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

public class TestBase {

   // public static WebDriver driver;
    public ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    public Properties prop;

    public TestBase(){
        prop = new Properties();
        try {
            FileReader fr = new FileReader(System.getProperty("user.dir")+"/src/main/resources/config/config.properties");
            prop.load(fr);//to load the contents of properties file
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //will store the session id for a particular browser while running a test script
    public WebDriver getDriver(){
        return driver.get();
    }

    //to check which browser will be used:-
    public void initializaion(){
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")){
            //opening chrome browser:-
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\LENOVO\\Downloads\\chrome-win32\\chrome-win32\\chrome.exe");
            options.addArguments("--remote-allow-origin=*");
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/browsers/chromedriver.exe");
            driver.set(new ChromeDriver());
        }else if (browserName.equals("edge")){
            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"/src/main/resources/browsers/msedgedriver.exe");
            driver.set(new EdgeDriver());
        } else {
            System.out.println("please select correct browser!!");
        }

        getDriver().navigate().to(prop.getProperty("url"));
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        //setting page time:-
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utility.PAGE_lOAD_TIMEOUTS));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Utility.IMPLICITE_WAIT));
    }
}

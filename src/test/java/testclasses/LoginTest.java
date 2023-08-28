package testclasses;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;

public class LoginTest extends TestBase {

    LoginPage loginPage;//verify
    HomePage homePage;//validate

   LoginTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        homePage = new HomePage(getDriver());
        loginPage = new LoginPage(getDriver());
        initializaion();
    }

    @Test
    public void verifyLogin1() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        String s1 = prop.getProperty("userName");
        System.out.println(s1);
        String s2 = prop.getProperty("password");
        System.out.println(s2);

        //driver.findElement(By.id("txtUsername")).sendKeys(prop.getProperty("userName"));
        //driver.findElement(By.id("txtPassword")).sendKeys(prop.getProperty("password"));

        //loginPage.login(s1,s2);
        //loginPage.login();

        getDriver().findElement(By.id(prop.getProperty("userName1"))).sendKeys(prop.getProperty("userName"));
        getDriver().findElement(By.id(prop.getProperty("password1"))).sendKeys(prop.getProperty("password"));
        getDriver().findElement(By.id(prop.getProperty("loginButton"))).click();

        Thread.sleep(3000);
        softAssert.assertEquals(getDriver().findElement(By.xpath(prop.getProperty("homePageTitle"))).getText()
                ,"Digital Partners"
                ,"both titles should match!!");
        System.out.println(getDriver().findElement(By.xpath(prop.getProperty("homePageTitle"))).getText());
        softAssert.assertAll();
    }

    @Test
    public void verifyLogin2() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        String s1 = prop.getProperty("userName");
        System.out.println(s1);
        String s2 = prop.getProperty("password");
        System.out.println(s2);

        getDriver().findElement(By.id(prop.getProperty("userName1"))).sendKeys(prop.getProperty("userName"));
        getDriver().findElement(By.id(prop.getProperty("password1"))).sendKeys(prop.getProperty("password"));
        getDriver().findElement(By.id(prop.getProperty("loginButton"))).click();

        Thread.sleep(3000);
        softAssert.assertEquals(getDriver().findElement(By.xpath(prop.getProperty("homePageTitle"))).getText()
                ,"Digital Partners"
                ,"both titles should match!!");
        System.out.println(getDriver().findElement(By.xpath(prop.getProperty("homePageTitle"))).getText());
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}

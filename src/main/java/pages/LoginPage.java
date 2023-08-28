package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.TestBase;

public class LoginPage extends TestBase {

    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(id = "txtPassword")
    WebElement passWord;

    @FindBy(id = "login-remember")
    WebElement checkBox;

    @FindBy(id = "btnLogin")
    WebElement loginBtn;

   public LoginPage(WebDriver driver){
        //syntax to initialize all your web-elements:-
        PageFactory.initElements(driver,this);
    }

   /* public void login(){
           username.sendKeys(prop.getProperty("userName"));
           passWord.sendKeys(prop.getProperty("password"));
           loginBtn.click();
    }*/
}

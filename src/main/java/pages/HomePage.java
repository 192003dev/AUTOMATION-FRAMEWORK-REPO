package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//h3[text()='Digital Partners']")
    WebElement dashBoardTitle;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public String homePageTitle(){
        return dashBoardTitle.getText();
    }
}

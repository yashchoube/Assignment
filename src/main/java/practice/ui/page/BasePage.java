package practice.ui.page;

import core.driver.DriverManager;
import core.ui.Action;
import core.ui.Locator;
import core.utils.SyncTime;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    private WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver=driver;
    }

    public PageClassFactory getPageClassFactory() {
        return FactoryManager.getPageClassFactory();
    }

    public void click(Locator locator) {
        Action.click(DriverManager.getDriver(),locator);
    }

    public void sendKeys(Locator locator,String text){
        Action.send(DriverManager.getDriver(),locator,text);
    }
    public void clearText(Locator locator){
        Action.clearText(DriverManager.getDriver(),locator);
    };
    public void clickOnDropDown(Locator locator,String text){
        Action.clickOnDropDown(locator, DriverManager.getDriver(),text);
    }

    public String getText(Locator locator){
        return Action.getText(DriverManager.getDriver(),locator);
    }

    public List<WebElement> getWebElements(Locator locator){
        return Action.getWebElements(DriverManager.getDriver(),locator);
    }

    public List<String> getWebElementsText(Locator locator){
        return Action.getWebElementsText(DriverManager.getDriver(),locator);
    }

    public Boolean isSlected(Locator locator){
        return Action.isSlected(DriverManager.getDriver(),locator);
    }
    public void clickOnCheckBox(Locator locator){
        Action.clickOnCheckBox(DriverManager.getDriver(),locator);
    }

    public void scroll(){
        JavascriptExecutor jse = (JavascriptExecutor)DriverManager.getDriver();
        jse.executeScript("window.scrollBy(0,1000)");
    }
    public void scrollToMid(){
        JavascriptExecutor jse = (JavascriptExecutor)DriverManager.getDriver();
        jse.executeScript("window.scrollBy(0,250)");
    }

    public String getCurrentUrl(){
       return Action.getUrl(DriverManager.getDriver());
    }
    public void waitforElementTobeVisible(Locator locator){
        SyncTime.waitForvisible(DriverManager.getDriver(),locator);
    }

}


package core.ui;

import core.utils.SyncTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Action {
    public static void click (WebDriver driver, Locator locator){
        SyncTime.waitForClickable(driver,locator);
        driver.findElement(locator.getBy()).click();
    }

    public static void send(WebDriver driver, Locator locator,String text) {
        driver.findElement(locator.getBy()).sendKeys(text);
    }


    public static void clickOnDropDown(Locator locator, WebDriver driver,String text) {
        WebElement dropDown=driver.findElement(locator.getBy());
        dropDown.click();
        Select drpCountry = new Select(dropDown);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //SyncTime.waitForElementVisibility(driver,locator);
        drpCountry.selectByVisibleText(text);
    }
    public static List<WebElement> getWebElements (WebDriver driver, Locator locator) {
        return driver.findElements(locator.getBy());
    }

    public static List<String> getWebElementsText(WebDriver driver, Locator locator) {
        List<String> texts = new ArrayList<>();
        List<WebElement> webElementList = getWebElements(driver, locator);
        for (WebElement element : webElementList) {
            texts.add(element.getText());
        }
        return texts;
    }

    public static void clearText(WebDriver driver, Locator locator) {
        driver.findElement(locator.getBy()).clear();
    }

    public static Boolean isSlected(WebDriver driver, Locator locator) {
        return driver.findElement(locator.getBy()).isSelected();
    }

    public static void clickOnCheckBox(WebDriver driver, Locator locator) {
        driver.findElement(locator.getBy()).click();
    }

    public static String getText(WebDriver driver, Locator locator) {
        return driver.findElement(locator.getBy()).getText();
    }

    public static String getUrl(WebDriver driver) {
        return driver.getCurrentUrl().toString();
    }
}

package core.utils;

import core.constants.SystemConstants;
import core.ui.Locator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncTime {

    private static final int WAIT_IN_SECOND = SystemConstants.DEFAULT_EXPLICITE_WAIT;

    private SyncTime() {
    }


    public static void waitForClickable(WebDriver driver, Locator locator) {
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator.getBy())));
    }

    public static void waitForvisible(WebDriver driver, Locator locator) {
        WebDriverWait wait2 = new WebDriverWait(driver, 60);
        wait2.until(ExpectedConditions.visibilityOf(driver.findElement(locator.getBy())));
    }

//
//    public static void waitForClickable(WebDriver driver, Locator locator, int waitInSeconds) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, waitInSeconds);
//
//            wait.ignoring(NoSuchElementException.class)
//                    .until(ExpectedConditions.elementToBeClickable(driver.findElement(locator.getBy())));
//        } catch (Exception e) {
//            //logger.info("Timeout during waitForClickable");
//        }
//    }
//
//    public static void waitForElementVisibility(WebDriver driver, Locator locator) {
//        waitForElementVisibility(driver, locator, WAIT_IN_SECOND);
//    }
//
//    public static void waitForElementVisibility(WebDriver driver, Locator locator, int waitInSeconds) {
//        WebDriverWait wait = new WebDriverWait(driver, waitInSeconds);
//        wait.ignoring(NoSuchElementException.class)
//                .until(ExpectedConditions.visibilityOf(driver.findElement(locator.getBy())));
//    }


}

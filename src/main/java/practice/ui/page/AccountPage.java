package practice.ui.page;

import core.driver.DriverManager;
import core.ui.Locator;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {
    private static final Locator composeEmail = Locator.byXpath("//div[text()='Compose']");
    private static final Locator receiverEmail = Locator.byXpath("//*[@name=\"to\"]");
    private static final Locator subjectBox = Locator.byXpath("//*[@name=\"subjectbox\"]");
    private static final Locator sendEmail = Locator.byXpath("//*[text()=\"Send\"]");
    private static final Locator emailSent = Locator.byXpath("//*[text()=\"Message sent.\"]");
    public static Logger logger = Logger.getLogger(practice.ui.page.AccountPage.class);

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCompose() throws InterruptedException {

        waitforElementTobeVisible(composeEmail);
        logger.info("=================================="+ DriverManager.getDriver().getTitle());
        Assert.assertTrue(DriverManager.getDriver().getTitle().contains("automationtest975@gmail.com"));
        logger.info("User Gmail Account :");
        click(composeEmail);
    }

    public void enterDetailsToSendEmail() throws InterruptedException {
        waitforElementTobeVisible(receiverEmail);
        sendKeys(receiverEmail,"choubeys@rknec.edu");
        waitforElementTobeVisible(subjectBox);
        sendKeys(subjectBox,"Test");

    }

    public void sentEmail(){
        waitforElementTobeVisible(sendEmail);
        click(sendEmail);
        waitforElementTobeVisible(emailSent);
        logger.info("=============="+emailSent);
        logger.info("==========================="+getText(emailSent));
        Assert.assertTrue(getText(emailSent).contains("Message sent."));

    }
}

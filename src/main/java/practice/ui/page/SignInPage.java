package practice.ui.page;

import core.ui.Locator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SignInPage extends BasePage{

        private static final Locator email = Locator.byXpath("//input[@type=\"email\"]");
        private static final Locator nextButton = Locator.byXpath("//*[text()=\"Next\"]/parent::button");
        private static final Locator password = Locator.byXpath("//input[@type=\"password\"]");
        private static final Locator welcome = Locator.byXpath("//*[text()=\"Welcome\"]");
        public static Logger logger = Logger.getLogger(practice.ui.page.SignInPage.class);

        public SignInPage(WebDriver driver) {
            super(driver);
        }

        public void enterEmail()  {
            logger.info("User Details on Address Screen :");
            waitforElementTobeVisible(email);
            clearText(email);
            sendKeys(email, "automationtest975@gmail.com");
            waitforElementTobeVisible(nextButton);
            click(nextButton);
        }
        public void enterPassword(){
            waitforElementTobeVisible(welcome);
            logger.info("Welcome "+getText(welcome));
            waitforElementTobeVisible(password);
            clearText(password);
            sendKeys(password,"Automationtest@975");
            waitforElementTobeVisible(nextButton);
            click(nextButton);
        }

        public void enterCredentials(){
            enterEmail();
            enterPassword();
        }

}

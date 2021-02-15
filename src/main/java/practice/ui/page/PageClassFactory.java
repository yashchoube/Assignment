package practice.ui.page;

import org.openqa.selenium.WebDriver;

public class PageClassFactory {

    private final WebDriver driver;
    private SignInPage signInPage = null;
    private AccountPage accountPage;


    public PageClassFactory(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage getSignInPage(){
        if (this.signInPage == null) {
            this.signInPage = new SignInPage(driver);
        }
        return this.signInPage;
    }

    public AccountPage getAccountpage() {
        if (this.accountPage == null) {
            this.accountPage = new AccountPage(driver);
        }
        return this.accountPage;
    }
}


package practice.ui.stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import practice.ui.constants.AppConstants;

public class GmailAccountStepDef extends BaseStepDef {
    @Given("User on gmail")
    public void user_on_the_site_Automation_Practice() throws Exception {
        getDriver().get(AppConstants.APLICATION_URL);

    }

    @And("User SignIn in gmail")
    public void userSignInAccount()  {
        getPageClassFactory().getSignInPage().enterCredentials();
    }
    @And("User Composes email")
    public void composeEmail() throws InterruptedException {
        getPageClassFactory().getAccountpage().clickOnCompose();
    }

    @And ("User filled details for email")
    public void sendEmail() throws InterruptedException {
        getPageClassFactory().getAccountpage().enterDetailsToSendEmail();
    }

    @Then("Verify email is sent successfully")
    public void verifyEmailSent(){
        getPageClassFactory().getAccountpage().sentEmail();
    }

}

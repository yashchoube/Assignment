package practice.ui.stepdef;

import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import practice.ui.page.FactoryManager;
import practice.ui.page.PageClassFactory;

public class BaseStepDef {

    public PageClassFactory getPageClassFactory() {
        return FactoryManager.getPageClassFactory();
    }

    public WebDriver getDriver(){
        return DriverManager.getDriver();
    }
}

package practice.ui.hooks;

import core.constants.SystemConstants;
import core.driver.DriverManager;
import core.utils.Context;
import core.utils.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import practice.ui.page.FactoryManager;
import practice.ui.page.PageClassFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseHooks {

    public static Logger logger = Logger.getLogger(BaseHooks.class);

    @Before(order = 1)
    public void beforeScenario(Scenario scenario ){
        DriverManager.initializeDriver(SystemConstants.BROWSER);
    }

    @Before(order = 2)
    public void secondBeforeScenario(Scenario scenario ){
        FactoryManager.registerPageClassFactory(new PageClassFactory(DriverManager.getDriver()));
        TestContext.registerContext(new Context());
        logger.info("Running scenario: ");
        logger.info(scenario.getName());

    }

   @After
    public void afterScenario(Scenario scenario) throws IOException {
       if (scenario.isFailed()) {
           Date d = new Date();
           System.out.println(d.toString());
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
           File screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
           FileUtils.copyFile(screenshot, new File("screenshot"+sdf.format(d)+".png"));
       }
        DriverManager.quitDriver();

    }
}

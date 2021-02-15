package core.driver;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeLauncher implements DriverLauncher {
    private String browser;
    private Logger logger =  Logger.getLogger(ChromeLauncher.class);

    public ChromeLauncher (String browser){
        this.browser=browser;
    }

    @Override
    public DriverDTO launch() {
        return initializeChromeDriver();
    }

    private DriverDTO initializeChromeDriver() {
        logger.info("launching the browser");
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        return new DriverDTO(webDriver);
    }
}

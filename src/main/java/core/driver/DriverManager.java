package core.driver;

//import io.cucumber.core.logging.Logger;
//import io.cucumber.core.logging.LoggerFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

//Singleton class
public class DriverManager {
    private static DriverManager instance = null;
   // private static Logger logger = LoggerFactory.getLogger(DriverManager.class);
    private static ThreadLocal<WebDriver> webDrivers = new ThreadLocal<>();

    public DriverManager(){

    }
    public static DriverManager getInstance(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }
    public static WebDriver getDriver(){ return webDrivers.get(); }

    public static void initializeDriver(String browser){
        DriverLauncher driverLauncher = DriverLauncherFactory.getDriverLauncher(browser);
        DriverDTO driverDTO = driverLauncher.launch();
        webDrivers.set(driverDTO.getDriver());
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void quitDriver() {
        getDriver().quit();
        webDrivers.remove();
    }

}

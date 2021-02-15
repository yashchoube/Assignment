package core.driver;

public class DriverLauncherFactory {

    private DriverLauncherFactory(){

    }
    public static DriverLauncher getDriverLauncher(String browser){
        switch(browser.toLowerCase()){
            case "chrome":
            default:
                return new ChromeLauncher(browser);
        }

    }
}

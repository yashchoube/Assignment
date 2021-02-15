package core.constants;

import core.utils.PropertyReader;

public class SystemConstants {

    public static final String CHROME_DRIVER_PATH = getChromeDriverPath();;
    private static PropertyReader prop = new PropertyReader("system.properties");
    public static final String BROWSER = getBrowser();
    public static final int DEFAULT_EXPLICITE_WAIT = getDefaultExplicitWait();

    private static int getDefaultExplicitWait() {
        String defaultWait = getPropertyAsPerThePriority("default.explicit.wait.seconds", "5");
        return Integer.parseInt(defaultWait.trim());
    }

    private static String getBrowser() {
        return getPropertyAsPerThePriority("browser", "chrome");
    }
    private static String getPropertyAsPerThePriority(String property, String defaultValue) {
        if (prop != null) {
            return System.getProperty(property, prop.getProperty(property, defaultValue));
        }
        return System.getProperty(property, defaultValue);
    }
    private static String getChromeDriverPath() {
        return getPropertyAsPerThePriority("chrome.driver.path", "core/driver/chromedriver.exe");
    }
}

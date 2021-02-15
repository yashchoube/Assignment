package practice.ui.constants;

import core.utils.PropertyReader;

public class AppConstants {
    public static final String APLICATION_URL = getApplicationUrl();

    private static String getApplicationUrl() {
        return getPropertyAsPerThePriority("application.url",
                "https://mail.google.com/");
    }

    private static PropertyReader prop = new PropertyReader("system.properties");

    private static String getPropertyAsPerThePriority(String property, String defaultValue) {
        if (prop != null) {
            return System.getProperty(property, prop.getProperty(property, defaultValue));
        }
        return System.getProperty(property, defaultValue);
    }
}

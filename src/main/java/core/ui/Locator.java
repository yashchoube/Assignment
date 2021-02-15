package core.ui;

import org.openqa.selenium.By;

public abstract class Locator {

    private final By by;
    private final String locatorString;

    public Locator(By by, String locatorString) {
        this.by = by;
        this.locatorString = locatorString;
    }

    public static Locator byXpath(String locator) {
        return new XpathLocator(By.xpath(locator), locator);
    }

    public static Locator byId(String locator) {
        return new IdLocator(By.id(locator), locator);
    }

    public By getBy() {
        return this.by;
    }

    public String getLocatorString() {
        return this.locatorString;
    }

    public abstract Locator format(String... args);


    public static class XpathLocator extends Locator {

        public XpathLocator(By by, String locator) {
            super(by, locator);
        }


        @Override
        public Locator format(String... args) {
            String dynamicLocator = String.format(getLocatorString(), args);
            return new XpathLocator(By.xpath(dynamicLocator), dynamicLocator);
        }
    }

    public static class IdLocator extends Locator {

        public IdLocator(By by, String locator) {
            super(by, locator);
        }

        @Override
        public Locator format(String... args) {
            String dynamicLocator = String.format(getLocatorString(), args);
            return new IdLocator(By.id(dynamicLocator), dynamicLocator);
        }
    }

}

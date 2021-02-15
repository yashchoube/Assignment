package core.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverDTO {
    public WebDriver driver;
    public WebDriver getDriver(){
        return driver;
    }
public DriverDTO(WebDriver driver){
    this.driver=driver;
}
    public void setDriver(WebDriver driver){
        this.driver=driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DriverDTO)) return false;
        DriverDTO driver1 = (DriverDTO) o;
        return Objects.equals(driver, driver1.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver);
    }
}

package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;


public abstract class AbsCommon {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected Logger logger = LogManager.getLogger(AbsCommon.class);

    public AbsCommon(WebDriver driver) {
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        PageFactory.initElements(driver, this);
    }
}

package manePage;

import data.Fields;
import factory.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageTests {

    private WebDriver driver;


    @BeforeAll
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void initDriver() {
        this.driver = new WebDriverFactory().getDriver();
    }

    @AfterEach
    public void close() {
        if (this.driver != null) {
            this.driver.close();
            this.driver.quit();
        }
    }

     @Test
     public void OutPutTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.fillFieldEnam(Fields.NAME);
        mainPage.fillFieldEnam(Fields.EMAIL);
        mainPage.fillFieldEnam(Fields.PASSWORD);
        mainPage.fillFieldEnam(Fields.PASSWORD2);
        mainPage.passShouldBeSame();
        mainPage.fillBirthDate();
        mainPage.fillLanguageLevel();
        mainPage.registrationButtonClick();
        mainPage.outputText();
     }
}

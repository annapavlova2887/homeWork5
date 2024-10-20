package pages;

import common.AbsCommon;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public abstract class AbsBasePage extends AbsCommon {
    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private  String BASE_URL = System.getProperty("base.url");

    public void open() {
        driver.get(BASE_URL);
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public AbsBasePage fillField(WebElement element, String meaning) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(meaning);
        return this;
    }

    public AbsBasePage dropdownSelect(WebElement chooseLanguage, WebElement dropDown, String selectVal) {
        Assertions.assertFalse(chooseLanguage.isEnabled());
        Select select = new Select(dropDown);
        select.selectByValue(selectVal);
        Assertions.assertFalse(chooseLanguage.isEnabled());
        return this;
    }

    public AbsBasePage buttonClick(WebElement element) {
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        return this;
    }
}

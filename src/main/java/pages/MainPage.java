package pages;

import common.AbsCommon;
import data.Fields;
import data.LanguageLev;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbsBasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }
    private String locatorOfBirthDate = "#birthdate";
    private String locatorOfLanguageLevel = "language_level";
    private String locatorOfRegButt = "[type = 'submit']";
    private String locatorOfOutForm = "output";

    private String dateOfBirth = "08";
    private String manthOfBirth = "03";
    private String yearOfBirth = "2012";
    private String dataForBirth = dateOfBirth+manthOfBirth+yearOfBirth;


    public void fillFieldEnam(Fields field) {
        WebElement element = getElement(By.cssSelector(field.getLocator()));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        fillField(element, field.getData());
    }

    public void fillBirthDate() {
        WebElement dateOfBirth = getElement(By.cssSelector(locatorOfBirthDate));
        fillField(dateOfBirth, dataForBirth);
    }

    public void fillLanguageLevel() {
        WebElement languageLevel = getElement(By.id(locatorOfLanguageLevel));
        dropdownSelect(languageLevel, LanguageLev.BEGINNER);
    }

    public void passShouldBeSame() {
        WebElement password = getElement(By.cssSelector(Fields.PASSWORD.getLocator()));
        WebElement confirmPassword = getElement(By.cssSelector(Fields.PASSWORD2.getLocator()));
        Assertions.assertEquals(password.getText(), confirmPassword.getText());
        logger.info("Введенные пароли совпадают");
    }

    public void registrationButtonClick() {
        WebElement registrationButton = getElement(By.cssSelector(locatorOfRegButt));
        buttonClick(registrationButton);
    }

    public void outputText() {
        WebElement outputText = getElement(By.id(locatorOfOutForm));
        webDriverWait.until(ExpectedConditions.visibilityOf(outputText));
        Assertions.assertEquals("Имя пользователя: " + Fields.NAME.getData() +
                "\nЭлектронная почта: " + Fields.EMAIL.getData() +
                "\nДата рождения: " + yearOfBirth + "-" + manthOfBirth + "-" + dateOfBirth +
                "\nУровень языка: " + LanguageLev.BEGINNER.getData(), outputText.getText());
        logger.info("Текст формы соответсвует ожидаемому результату");
    }
}

package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends AbsBasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private String locatorOfName = "username";
    private String locatorOfEmail = "email";
    private String locatorOfPassword = "password";
    private String locatorOfConfirmPassword = "confirm_password";
    private String locatorOfBirthday = "birthdate";
    private String locatorOfLanguageLevel = "language_level";
    private String locatorOfChooseLanguage = "[value=\"beginner\"]";
    private String locatorOfRegButt = "[type = 'submit']";
    private String locatorOfOutForm = "output";

    private String dataForName = "Anna";
    private String dataForEmail = "anna97@mail.ru";
    private String dataForPassword = "08032012";
    private String dateOfBirth = "08";
    private String manthOfBirth = "03";
    private String yearOfBirth = "2012";
    private String dataForBirth = dateOfBirth+manthOfBirth+yearOfBirth;
    private String dateForLanguageLev = "intermediate";

    public void fillName() {
        WebElement name = getElement(By.id(locatorOfName));
        fillField(name, dataForName);
    }

    public void fillEmail() {
        WebElement email = getElement(By.id(locatorOfEmail));
        fillField(email, dataForEmail);
    }

    public void fillPassword() {
        WebElement password = getElement(By.id(locatorOfPassword));
        fillField(password, dataForPassword);
    }

    public void fillConfirmPassword() {
        WebElement confirmPassword = getElement(By.id(locatorOfConfirmPassword));
        fillField(confirmPassword, dataForPassword);
    }

    public void fillBirthDate() {
        WebElement birthDate = getElement(By.id(locatorOfBirthday));
        fillField(birthDate, dataForBirth);
    }

    public void fillLanguageLevel() {
        WebElement chooseLanguage = getElement(By.cssSelector(locatorOfChooseLanguage));
        WebElement languageLevel = getElement(By.id(locatorOfLanguageLevel));
        dropdownSelect(chooseLanguage, languageLevel, dateForLanguageLev);
    }

    public void passShouldBeSame() {
        WebElement password = getElement(By.id(locatorOfPassword));
        WebElement confirmPassword = getElement(By.id(locatorOfConfirmPassword));
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
        Assertions.assertEquals("Имя пользователя: " + dataForName +
                "\nЭлектронная почта: " + dataForEmail +
                "\nДата рождения: " + yearOfBirth + "-" + manthOfBirth + "-" + dateOfBirth +
                "\nУровень языка: " + dateForLanguageLev, outputText.getText());
        logger.info("Текст формы соответсвует ожидаемому результату");
    }
}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalDataPage extends BasePage {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameEditBox;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailEditBox;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneEditBox;

    @FindBy(xpath = "//input[@onclick='validatePersonalInfo(event)']")
    private WebElement nextButton;

    @FindBy(xpath = "//span[@id='emailErrM']")
    private WebElement emailErrorMessage;

    //private String emailError="Ошибка в поле Email";


    public PersonalDataPage(WebDriver driver) {
        super(driver);
    }

    public void inputName(String name) {

        nameEditBox.sendKeys(name);
    }

    public boolean isEmailErrorVisible() {
        return emailErrorMessage.isDisplayed();

    }

    public String getEmailErrorText() {   // актуальный результат
        return emailErrorMessage.getText();

    }


    public void inputEmail(String email) {
        emailEditBox.sendKeys(email);
    }

    public void inputPhone(String phone) {
        phoneEditBox.sendKeys(phone);
    }


    public void clickNextButton() {
        nextButton.click();
    }


    public WebElement getEmailErrorMessage() {
        return emailErrorMessage;
    }

//    public String getEmailError() {
//        return emailError;
//    }
}

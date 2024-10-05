import drivers.ChromeRegistry1;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.PersonalDataPage;
import pageObjects.TariffPlanPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalDataTestPrivateMethod {
    private WebDriver driver;

    @Test
    public void submitPersonalDataTestWithValidData() {
        driverSetup();
        PersonalDataPage personalDataPage = new PersonalDataPage(driver);
        personalDataPage.inputName("Vasia");
        personalDataPage.inputEmail("vasia.porker@gmail.com");
        personalDataPage.inputPhone("+5846187562");
        personalDataPage.clickNextButton();
        assertTrue(new TariffPlanPage(driver).isTariffPlanDisplayed());

    }

    @Test
    public void submitPersonalDataTestWithInvalidEmail() {
        driverSetup();
        PersonalDataPage personalDataPage = new PersonalDataPage(driver);
        personalDataPage.inputName("Vasia");
        personalDataPage.inputEmail("vasia.porkergmail.com");
        personalDataPage.inputPhone("+5846187562");
        personalDataPage.clickNextButton();
        assertTrue(personalDataPage.isEmailErrorVisible());
        assertEquals("Ошибка в поле Email", personalDataPage.getEmailErrorText());
        assertTrue(personalDataPage.getEmailErrorText().contains("Ошибка в поле Email"));
        // assertTrue(personalDataPage.getEmailErrorMessage().isDisplayed());
    }


    private void driverSetup() {
        this.driver = new ChromeRegistry1().registerDriver();
        driver.get("https://qa-faculty.github.io/tariff-plan/");
    }


    //assertTrue(new TariffPlanPage(driver).isTariffPlanDisplayed());  - из прошлого теста, отображение новой страницы

    // вариант 1
    // assertTrue(personalDataPage.getEmailErrorMessage().isDisplayed());


    // вариант 2
//       1. String emailError = "Ошибка в поле Email"; - задаем стрингу для сравнения в будущем
//       2. Thread.sleep(5000); - нужно поспать потому что не успевает выскочить сообщение
//       3.String actualErrorMessage = personalDataPage.getEmailErrorMessage().getText();  - вытягиваем текст из сообщения, которое выскочило
//       4. assertEquals(emailError, actualErrorMessage); сравниваем тот что кто-то когда-то написал нам в требованиях с тем что мы по факту имеем

    //getAttribute(); - вывод текста из editBox а вот .getText() - вывод теста из надписи



}

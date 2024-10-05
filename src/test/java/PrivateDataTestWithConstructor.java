import drivers.ChromeRegistry1;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.PersonalDataPage;
import pageObjects.TariffPlanPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrivateDataTestWithConstructor {
    private WebDriver driver;


    public PrivateDataTestWithConstructor() {

        this.driver = new ChromeRegistry1().registerDriver();
    }

    @Before
    public void openUrl() {
        driver.get("https://qa-faculty.github.io/tariff-plan/");
    }


    @Test
    public void submitPersonalDataTestWithValidData() {

        PersonalDataPage personalDataPage = new PersonalDataPage(driver);
        personalDataPage.inputName("Vasia");
        personalDataPage.inputEmail("vasia.porker@gmail.com");
        personalDataPage.inputPhone("+5846187562");
        personalDataPage.clickNextButton();
        assertTrue(new TariffPlanPage(driver).isTariffPlanDisplayed());

    }

    @Test
    public void submitPersonalDataTestWithInvalidEmail() {

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
}

import drivers.ChromeRegistry1;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageObjects.PersonalDataPage;
import pageObjects.TariffPlanPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonalDataTest {

    @Test
    public void SubmitPersonalDataFormWithValidData() {
        WebDriver driver = new ChromeRegistry1().registerDriver();
        driver.get("https://qa-faculty.github.io/tariff-plan/");
        PersonalDataPage personalDataPage = new PersonalDataPage(driver);
        personalDataPage.inputName("Naaameee");
        personalDataPage.inputEmail("some@gmail.com");
        personalDataPage.inputPhone("+49102938483849");
        personalDataPage.clickNextButton();
        assertTrue(new TariffPlanPage(driver).isTariffPlanDisplayed());
    }
}

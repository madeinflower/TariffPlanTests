package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TariffPlanPage extends BasePage {


    public TariffPlanPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h3[contains(text(),'Выбери план')]")
    private WebElement choosePlanTab;


    public boolean isTariffPlanDisplayed () {
//        WebElement webElement = driver.findElement(By.xpath("//h3[contains(text(),'Выбери план')]"));
//        return webElement.isDisplayed();

        return choosePlanTab.isDisplayed();
    }

    
}

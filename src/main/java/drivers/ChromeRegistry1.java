package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeRegistry1 {
    private static final String FILE_SEPARATOR = System.getProperty("file.separator");
    private static final String PATH = "C:" + FILE_SEPARATOR + "Users" + FILE_SEPARATOR + "Zar"
            + FILE_SEPARATOR + "Documents" + FILE_SEPARATOR + "Tania"
            + FILE_SEPARATOR + "QAPro" + FILE_SEPARATOR + "TariffPlanTest"
            + FILE_SEPARATOR + "src" + FILE_SEPARATOR + "main" + FILE_SEPARATOR
            + "resources" + FILE_SEPARATOR + "chromedriver.exe";



    public WebDriver registerDriver(){

        System.setProperty("webdriver.chrome.driver", PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        return new ChromeDriver(options);
    }

}

import drivers.ChromeRegistry1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeRegistry1().registerDriver();
        driver.get("https://qa-faculty.github.io/tariff-plan/");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("имяяя");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("asddsadas@gmail.com");
        driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("+490155467584");
        driver.findElement(By.xpath("//input[@onclick='validatePersonalInfo(event)']")).click();
        driver.findElement(By.xpath("//h3[contains(text(),'Выбери план')]")).isDisplayed();
    }
    }


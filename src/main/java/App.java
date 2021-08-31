import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // maximize window to prevent some issu
        driver.get("https://www.w3schools.com/html/html_iframe.asp");

       // String title = driver.switchTo().frame(0).findElement(By.cssSelector("#main > h1")).getText();
       // System.out.println(title);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(true) {
            System.out.println("klikam");
            driver.findElement(By.cssSelector("#accept-choices")).click();

        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement iframe = driver.findElement(By.cssSelector("#main > div:nth-child(7) > iframe"));
        driver.switchTo().frame(iframe).findElement(By.cssSelector("#topnav > div > div > a:nth-child(5)")).click();


    }
}

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
        driver.get("file:///C:/Users/Tom/Documents/GitHub/JavaSelenium/alerts.html");

        WebElement basicAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(2)"));
        WebElement confirmationAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(5)"));
        WebElement promptAlertButton = driver.findElement(By.cssSelector("body > button:nth-child(8)"));

        basicAlertButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert basicAlert = driver.switchTo().alert();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        basicAlert.accept();



        confirmationAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert confirmationAlert = driver.switchTo().alert();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        confirmationAlert.dismiss();

        promptAlertButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert promptAlert = driver.switchTo().alert();
        System.out.println(promptAlert.getText());
        promptAlert.sendKeys("IKuzma");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        promptAlert.accept();
        //driver.close();


        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //javascriptExecutor.executeScript("arguments[0],click()", signUpButton);


    }
}

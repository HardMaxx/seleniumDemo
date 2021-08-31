import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // maximize window to prevent some issu
        driver.get("https://www.udemy.com/course/core-java-programming-language-tutorial/");

        WebElement signUpButton = driver.findElement(By.cssSelector("#udemy > div.main-content-wrapper > div.ud-app-loader.ud-component--header-v6--header.udlite-header.ud-app-loaded > div.udlite-text-sm.header--header--3sK1h.header--flex-middle--2Xqjv > div:nth-child(8) > a > span"));
        //clicking with JavascriptExercutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", signUpButton);

        //setting up timeouts
        ((JavascriptExecutor) driver).executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 3000);");

        //changing the webpage
        ((JavascriptExecutor) driver).executeScript("window.location = 'https://wikipedia.com'");

        //scroll the webpage
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

        //driver.close();


        //JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //javascriptExecutor.executeScript("arguments[0],click()", signUpButton);


    }
}

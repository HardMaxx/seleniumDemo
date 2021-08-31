import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args)  {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // maximize window to prevent some issu
        driver.get("https://www.wikipedia.org/");

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        String searchStr = "Życie";
        searchBox.sendKeys(searchStr);

        WebElement searchButton =driver.findElement(By.cssSelector("#search-form > fieldset > button"));
        searchButton.click();

       // driver.close();
    }
}

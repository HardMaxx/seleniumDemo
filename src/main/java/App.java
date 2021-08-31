import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // maximize window to prevent some issu

        driver.get("https://www.wikipedia.org/");

        WebElement englishButton = driver.findElement(By.id("js-link-box-en"));

        englishButton.click();

        String expectedTitle ="Welcome to Wikipedia,";
        WebElement titleOfEnglishPage = driver.findElement(By.id("mp-welcome"));

        if (titleOfEnglishPage.getText().equals(expectedTitle)){
            System.out.println("Test has passed! Page is the English one");
        }
        else
        {
            System.out.println("Test has failed Click() was not successful");
        }
        driver.close();
    }
}

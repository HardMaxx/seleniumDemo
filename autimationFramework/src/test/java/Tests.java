import drivers.DriverSingleton;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tests {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;

    @BeforeClass
    public static void initializeObject(){
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(Constants.BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
    }

    @Test
    public void testingAuthentication(){
        driver.get(Constants.URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));
        assertEquals(frameworkProperties.getProperty(Constants.USERNAME),homePage.getUsername());
    }

    @Test
    public void testingAddingThingsToCart(){
        driver.get(Constants.URL);
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();
        assertEquals(Constants.CART_QUANTITY_TEST, checkoutPage.getSummaryProductsString());
    }

    @Test
    public void testingTheFullBuyingProcess(){
        driver.get(Constants.URL);
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCart();

        checkoutPage.goToCheckout();
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
        assertTrue(checkoutPage.checkFinalStatus());{
            System.out.println("Test case completed!");
        }

    }

    @AfterClass
    public static void closeObjects(){
        driver.close();
    }

}

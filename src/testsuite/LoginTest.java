package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseURL ="https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
        /**
         * Enter “standard_user” username
         * Enter “secret_sauce” password
         * Click on ‘LOGIN’ button
         * Verify the text “PRODUCTS”
         */

        // Enter “standard_user” username

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        // Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Verify the text “PRODUCTS”
        String expectedText1 = "PRODUCTS";
        String actualText1 = driver.findElement(By.xpath("//span[contains(text(),'Products')]")).getText();
        Assert.assertEquals("PRODUCTS" , expectedText1, actualText1);

                            // Or

        //verify the text 'Products'
        String expectedMessage="PRODUCTS";
        WebElement message = driver.findElement(By.xpath("//div[@class='header_secondary_container']//span[@class='title']"));
        String actualMessage = message.getText();//converting webElement into string
        Assert.assertEquals(expectedMessage, actualMessage);//verifying using the assert method
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter “standard_user” username

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        // Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        // Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Verify that six products are displayed on page
        List<WebElement> count = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int totalcount = count.size();
        System.out.println("Total Products are : " + totalcount);

        // Verify that six products are displayed on page
        int expectedProducts = 6;
        int actualProducts = driver.findElements(By.xpath("//div[@class = 'inventory_item']")).size();
        Assert.assertEquals("Products do not match", expectedProducts, actualProducts);
            }

        @After
        public void tearDown(){
        closeBrowser();

    }
}

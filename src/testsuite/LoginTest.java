package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldLoginSuccessfully() {
        // Input valid username
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        usernamefield.sendKeys("standard_user");

        // Input valid password
        WebElement passwordfield = driver.findElement(By.name("password"));
        passwordfield.sendKeys("secret_sauce");

        // Click on Login button
        WebElement loginfield = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginfield.click();

        // Verify text
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.className("title")).getText();

        // Validate actual and expected text
        Assert.assertEquals("PRODUCTS", actualText, expectedText);
    }

    @Test
    public void veriftTheSixProductsDisplayed() {
        // Input valid username
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        usernamefield.sendKeys("standard_user");

        // Input valid password
        WebElement passwordfield = driver.findElement(By.name("password"));
        passwordfield.sendKeys("secret_sauce");

        // Click on Login button
        WebElement loginfield = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginfield.click();

        // Verify the displayed products in Qty
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int actualNumOfProducts = productList.size();
        System.out.println(actualNumOfProducts);
        int expectedNoOfProducts = 6;

        Assert.assertEquals(expectedNoOfProducts, actualNumOfProducts);
    }
    @After
    public void tearDown() {
        //   closeBrowser();
    }
}

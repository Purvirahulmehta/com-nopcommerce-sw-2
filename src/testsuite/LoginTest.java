package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void teardown(){
        closeBrowser();
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //finding element for login link
        WebElement loginLink=driver.findElement(By.linkText("Log in"));
        //sending click to login link
        loginLink.click();
        //Expected Message
        String expectedMessage="Welcome, Please Sign In!";
        //find the welcome text element and get the text
        WebElement actualMessageElement=driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage=actualMessageElement.getText();

        // Validate actual and expected message
        Assert.assertEquals("Error message not displayed",expectedMessage,actualMessage);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
       // WebElement register=driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
      //  register.click();
        WebElement login=driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        login.click();
        //find the email field element
        WebElement emailField=driver.findElement(By.id("Email"));
        //sending email to email field
        emailField.sendKeys("Testing123@gmail.com");
        //find the password field element
        WebElement passwordField=driver.findElement(By.name("Password"));
        //sending the password to password field
        passwordField.sendKeys("Testing123");
        //find the login button and click on it
        WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();
        WebElement actualMessage=driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        String actualResult=actualMessage.getText();
        String expectedMessage="Log out";

        WebElement logoutButton=driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));
        logoutButton.click();
        Assert.assertEquals("Log out Successful",actualResult,expectedMessage);

    }
    @Test
    public void verifyTheErrorMessage(){
        WebElement login=driver.findElement(By.xpath("//a[contains(text(),'Log in')]"));
        login.click();
        //find the email field element
        WebElement emailField=driver.findElement(By.id("Email"));
        //sending the email to email field
        emailField.sendKeys("Testing123@gmail.com");
        //find the password field
        WebElement passwordField=driver.findElement(By.name("Password"));
         //sending the password
        passwordField.sendKeys("Test1234567");
        WebElement loginButton=driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        String expectedErrorMessage="Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage=driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']")).getText();
        //validate actual and expected message
        Assert.assertEquals("Error message not displayed",expectedErrorMessage,actualErrorMessage);

    }

}

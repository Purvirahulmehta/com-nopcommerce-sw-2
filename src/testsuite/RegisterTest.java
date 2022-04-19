package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
//opening browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    //clising browser
    @After
    public void teardown(){
        closeBrowser();
    }
    @Test
    public void userShouldNavigateToRegisterPageSuccessfully(){
        WebElement register=driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();
    }
    @Test
    public void userSholdRegisterAccountSuccessfully(){
        //finding element for registration tab
        WebElement register=driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        //sending click on it
        register.click();
        //finding element for gender/male radio button
        WebElement genderButton=driver.findElement(By.id("gender-male"));
        //sending click on it
        genderButton.click();
        //finding first name element
        WebElement firstName=driver.findElement(By.xpath("//input[@id='FirstName']"));
        //sending name to the field
        firstName.sendKeys("Pooja");
        //finding last name element
        WebElement lastName=driver.findElement(By.xpath("//input[@id='LastName']"));
        //sending last name to last name field
        lastName.sendKeys("Patel");
        //finding day of birth text box element
        WebElement dayOfBirth=driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"));
       //sending day of birth to the field
        dayOfBirth.sendKeys("10");
       //finding element for month tab
        WebElement monthOfBirth=dayOfBirth.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"));
       //monthOfBirth.click();
        //sending month to the field
        monthOfBirth.sendKeys("May");
        //finding year tab element
        WebElement yearOfBirth=driver.findElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"));
        //yearOfBirth.click();
        //sending year to the field
        yearOfBirth.sendKeys("1980");
        //finding email field element
        WebElement emailField=driver.findElement(By.xpath("//input[@id='Email']"));
        //sending email to email field
        emailField.sendKeys("Testing123@gmail.com");
        //finding password field element
        WebElement passwordField=driver.findElement(By.xpath("//input[@id='Password']"));
        //sending password to password field
        passwordField.sendKeys("Test1234567");
        //finding confirm password element
        WebElement confirmPasswordField=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        //sending password to confirm password field
        confirmPasswordField.sendKeys("Test1234567");
        //finding register field element
        WebElement registerButton=driver.findElement(By.xpath("//button[@id='register-button']"));
        //sending click to register tab
        registerButton.click();
        String expectedMessage="Your registration completed";
        WebElement actualText=driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        String actualMessage=actualText.getText();
        Assert.assertEquals("Registration Completed",expectedMessage,actualMessage);



    }
}

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    //opening the browser
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //closing the browser
    @After
    public void teardown() {
        closeBrowser();
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {
        //finding the element for computer tab
        WebElement computerlink = driver.findElement(By.linkText("Computers"));
        //sending click to the computerlink
        computerlink.click();
        //finding the element of actualmessage
        WebElement actualMessage = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualComputerMessage = actualMessage.getText();
        String expectedMessage = "Computers";
        //validate the actual and expect message
        Assert.assertEquals("User is not in a Computer Page", expectedMessage, actualComputerMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        WebElement electronicsLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        electronicsLink.click();
        WebElement actualMessage = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));
        String actualElectronicMessage = actualMessage.getText();
        String expectedMessage = "Electronics";
        //validate the actual and expect message
        Assert.assertEquals("User is not in a Electronics Page", expectedMessage, actualElectronicMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        WebElement apparelLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        apparelLink.click();
        WebElement actualMessage = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[3]/a[1]"));
        String actualApparelMessag = actualMessage.getText();
        String expectedMessage = "Apparel";
        Assert.assertEquals("User is not in a Electronics Page", expectedMessage, actualApparelMessag);
    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully() {
        WebElement digitalDownloadsLink = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        digitalDownloadsLink.click();
        WebElement actualMessage = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[4]/a[1]"));
        String actualDigitalDownloadMessage = actualMessage.getText();
        String expectedMessage = "Digital downloads";
        Assert.assertEquals("User is not in a Digital Download Page", expectedMessage, actualDigitalDownloadMessage);
    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        WebElement booksPage = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.header-menu ul.top-menu.notmobile:nth-child(1) li:nth-child(5) > a:nth-child(1)"));
        booksPage.click();
        WebElement actualMessage = driver.findElement(By.cssSelector("div.master-wrapper-page:nth-child(6) div.header-menu ul.top-menu.notmobile:nth-child(1) li:nth-child(5) > a:nth-child(1)"));
        String actualBooksMessage = actualMessage.getText();
        String expectedMessage = "Books";
        Assert.assertEquals("User is not in a Books Page", expectedMessage, actualBooksMessage);
    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        WebElement jewelryPage = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[6]"));
        jewelryPage.click();
        WebElement actualMessage = driver.findElement(By.xpath("//body[1]/div[6]/div[2]/ul[1]/li[6]"));
        String actualJewelryMessage = actualMessage.getText();
        String expectedMessage = "Jewelry";
        Assert.assertEquals("User is not in a Books Page", expectedMessage, actualJewelryMessage);
    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        WebElement giftCardsPage = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        giftCardsPage.click();
        WebElement actualMessage = driver.findElement(By.xpath("//body/div[6]/div[2]/ul[1]/li[7]/a[1]"));
        String actualGiftCardsMessage = actualMessage.getText();
        String expectedMessage = "Gift Cards";
        Assert.assertEquals("User is not in a Books Page", expectedMessage, actualGiftCardsMessage);
    }
}









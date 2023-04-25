package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    /*
    1. userShouldAddProductSuccessFullyTo
ShoppinCart()
* Mouse Hover on Men Menu
* Mouse Hover on Bottoms
* Click on Pants
     */
    @Test
    public void userShouldAddProductSuccessFullyToShoppinCart(){
        //Mouse Hover on Men Menu
        mouseHoverOnElement(By.cssSelector("a[id='ui-id-5'] span:nth-child(2)"));

        //Mouse Hover on Bottoms
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-18']//span[contains(text(),'Bottoms')]"));

        //Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']//span[contains(text(),'Pants')]"));

        //Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnMouseHover(By.id("option-label-size-143-item-175"));

        //Mouse Hover on product name 'Cronus Yoga Pant’ and click on colour Black
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnMouseHover(By.xpath("//div[@class='swatch-opt-880']//div[@id='option-label-color-93-item-49']"));

        //Mouse Hover on product name‘Cronus Yoga Pant’ and click on‘Add To Cart’ Button.
        mouseHoverOnElement(By.xpath("//a[contains(text(),'Cronus Yoga Pant')]"));
        clickOnMouseHover(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedMessage = "You added Cronus Yoga Pant to your shopping cart.";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        Assert.assertEquals("Text doesn't match",expectedMessage,actualMessage);

        //Click on ‘shopping cart’ Link into message
        clickOnMouseHover(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the text ‘Shopping Cart.’
        assertVerifyText(By.xpath("//span[@class='base']"),"Shopping Cart");

        //Verify the product name ‘Cronus Yoga Pant’
       assertVerifyText(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"),"Cronus Yoga Pant");

        //Verify the product size ‘32’
        assertVerifyText(By.xpath("//dd[contains(text(),'32')]"),"32");

        //Verify the product colour ‘Black’
        assertVerifyText(By.xpath("//dd[contains(text(),'Black')]"),"Black");
    }

    @After
    public void tearDown(){
        //close the scanner
        driver.close();
    }
}

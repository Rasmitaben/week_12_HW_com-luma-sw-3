package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class GearTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    //userShouldAddProductSuccessFullyToShoppingCart()
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){
        //Mouse Hover on Gear Menu
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-6']//span[contains(text(),'Gear')]"));

        //Click on Bags
        clickOnElement(By.xpath("//a[@id='ui-id-25']"));

        //Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//a[contains(text(),'Overnight Duffle')]"));

        //Verify the text ‘Overnight Duffle’
        assertVerifyText(By.xpath("//span[@class='base']"),"Overnight Duffle");

        //Change Qty "3"
        WebElement element = driver.findElement(By.xpath("//input[@id='qty']"));
        element.clear();
        sendTextToElement(By.xpath("//input[@id='qty']"), "3");

        //Click on ‘Add to Cart’ Button.
        clickOnElement(By.xpath("//span[contains(text(),'Add to Cart')]"));

        //Verify the text
        //‘You added Overnight Duffle to your shopping cart.’
        assertVerifyText(By.xpath("//div[@class='message-success success message']"),"You added Overnight Duffle to your shopping cart.");

        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //Verify the product name ‘Cronus Yoga Pant’
        assertVerifyText(By.xpath("//a[normalize-space()='Cronus Yoga Pant'])[2]"),"Cronus Yoga Pant");

        //Verify the Qty is ‘3’
        assertVerifyText(By.className("input-text qty"),"3");

        //Verify the product price ‘$135.00’
        assertVerifyText(By.xpath("//span[contains(text(),'$135.00')]"),"$135.00");

        //Change Qty to ‘5’
        WebElement element1 = driver.findElement(By.xpath("//input[@id='cart-102078-qty']"));
        element1.clear();
        sendTextToElement(By.xpath("//input[@id='cart-102078-qty']"), "5");

        String expectedQuantity = "5";
        String actualQuantity =element1.getAttribute("value");
        Assert.assertEquals("Doesn't match",expectedQuantity,actualQuantity);

        //Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        //Verify the product price ‘$225.00’
        assertVerifyText(By.xpath("//span[contains(text(),'$225.00')]"),"$225.00");

    }
    @After
    public void tearDown () {
        //close the scanner
        driver.close();
    }

}

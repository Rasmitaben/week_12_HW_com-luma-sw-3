package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


     // 1. verifyTheSortByProductNameFilter

    @Test
    public void verifyTheSortByProductNameFilter() {
        //Mouse Hover on Women Menu
        mouseHoverOnElement(By.cssSelector("a[id='ui-id-4'] span:nth-child(2)"));

        //Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));

        //Click on Jackets
        clickOnElement(By.cssSelector("a[id='ui-id-11'] span"));

        //Select Sort By filter “Product Name”
        dropDownOption(By.xpath("//select[@id='sorter']"), "name");

        // Verify the products name display in alphabetical order
        /*List<WebElement> nameOfProduct = driver.findElements(By.xpath("//div[@class='product details product-item-details']//strong[@class='product name product-item-name'"));
        ArrayList<String> actualProductList = new ArrayList<>();
        for (WebElement element : nameOfProduct) {
            actualProductList.add(element.getText());
            System.out.println(actualProductList);*/
        List<WebElement> listOfElements = driver.findElements(By.xpath("//div[@class='product details product-item-details']//strong[@class='product name product-item-name']"));

        ArrayList<String> actualList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            actualList.add(element.getText());
        }
        System.out.println(actualList);

        ArrayList<String> expectedList = new ArrayList<>();
        for (WebElement element : listOfElements) {
            expectedList.add(element.getText());
        }

        Collections.sort(expectedList);
        System.out.println(expectedList);
        Assert.assertEquals("Not matching", expectedList, actualList);
    }

    //2. verifyTheSortByPriceFilter

    @Test
    public void verifyTheSortByPriceFilter() {
        //Mouse Hover on Women Menu
        mouseHoverOnElement(By.cssSelector("a[id='ui-id-4'] span:nth-child(2)"));

        //Mouse Hover on Tops
        mouseHoverOnElement(By.xpath("//a[@id='ui-id-9']"));

        //Click on Jackets
        clickOnElement(By.cssSelector("a[id='ui-id-11'] span"));

        //Select Sort By filter “Price”
        dropDownOption(By.cssSelector("#sorter"), "price");

        // Verify the products price display in Low to High
        //List<WebElement> priceOfProduct = driver.findElements(By.xpath("//span[@class=''price']"));
        List<WebElement> priceOfProduct = driver.findElements(By.xpath("//div[normalize-space()='Price']"));
        ArrayList<String> actualPriceList = new ArrayList<>();
        for (WebElement element : priceOfProduct) {
            actualPriceList.add(element.getText());
            System.out.println(actualPriceList);
        }
    }
    @After
        public void tearDown () {
            //close the scanner
            driver.close();
        }

    }
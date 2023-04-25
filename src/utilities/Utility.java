package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /**
     * This  Method will MouseHover on an element
     */
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This  Method will click on MouseHover
     */
    public void clickOnMouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    /**
     * This method will click on element
     */

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    /**
     *Ths Method will get text from an element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     * his Method will select an element from dropdown
     */
    public void dropDownOption(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByValue(text);
    }
    /**
     *This Method will verify an element
     */

    public void assertVerifyText(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        String expectedText1 = expectedText;
        Assert.assertEquals("Error= Test Failed", expectedText1, actualText);
    }
    /**
     * This method will send text to element
     */

    public void sendTextToElement(By by, String number) {
        driver.findElement(by).sendKeys(number);

    }
}
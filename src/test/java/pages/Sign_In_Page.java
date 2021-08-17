package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import test.java.lib.WebDriverHelper;

import static test.java.lib.Runner.conf;
import static test.java.lib.Runner.driver;

public class Sign_In_Page {

    private WebDriverHelper webDriverHelper;

    public Sign_In_Page() {
        webDriverHelper = new WebDriverHelper();
    }

    private static final By EMAIL_ADDRESS = By.xpath(".//*[@id='email']");
    private static final By PASSWORD = By.xpath(".//*[@id='passwd']");
    private static final By SIGN_IN = By.xpath(".//*[@id='SubmitLogin']");
    private static final By ADD_NEW_ADD_BTN = By.xpath(".//*[text()='Add a new address']");
    private static final By PROCEED_TO_CHECKOUT = By.xpath("//*[text()='Proceed to checkout']");
    private static final By SHIPP_PROCEED = By.xpath("//*[@type='submit'][@Name='processCarrier']");
    private static final By AGREE_CHECKBOX = By.xpath(".//span/input[@type='checkbox']");
    private static final By PAY_BANK_WIRE = By.xpath(".//*[@title='Pay by bank wire']");
    private static final By CONFIRM_ORDER = By.xpath(".//*[text()='I confirm my order']");
    private static final By ORDER_COMPLETE = By.xpath(".//*[text()='Your order on My Store is complete.']");

    public void enterLoginDetails(){
        webDriverHelper.setText(EMAIL_ADDRESS,conf.getProperty("emailid"));
        webDriverHelper.setText(PASSWORD,conf.getProperty("password"));
        webDriverHelper.click(SIGN_IN);
        webDriverHelper.waitForElement(ADD_NEW_ADD_BTN);
    }

    public void clickProceedTillPayment(){
        webDriverHelper.click(PROCEED_TO_CHECKOUT);
//        webDriverHelper.waitForElement(AGREE_CHECKBOX);
//        webDriverHelper.click(AGREE_CHECKBOX);
        webDriverHelper.click(By.xpath(".//span[@class='checked']"));
        driver.switchTo().activeElement().sendKeys(Keys.TAB);
        webDriverHelper.hardWait(2);
        driver.switchTo().activeElement().sendKeys(Keys.SPACE);
        webDriverHelper.click(SHIPP_PROCEED);
        webDriverHelper.waitForElement(PAY_BANK_WIRE);
        webDriverHelper.click(PAY_BANK_WIRE);
    }

    public void confirmOrder(){
        webDriverHelper.waitForElement(CONFIRM_ORDER);
        webDriverHelper.click(CONFIRM_ORDER);
        webDriverHelper.waitForElement(ORDER_COMPLETE);
    }

}


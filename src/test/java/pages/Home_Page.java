package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import test.java.lib.WebDriverHelper;

import static test.java.lib.Runner.driver;

public class Home_Page {

    private WebDriverHelper webDriverHelper;

    public Home_Page() {
        webDriverHelper = new WebDriverHelper();
    }

    private static final By POPULAR_PRODUCT1 = By.xpath(".//*[@id='homefeatured']//li");
    private static final By POPULAR_PRODUCT2 = By.xpath(".//*[@id='homefeatured']//li[2]");
    private static final By ADD_TO_CART = By.xpath(".//span[text()='Add to cart']");
    private static final By ADD_TO_CART2 = By.xpath(".//*[@id='homefeatured']//li[2]//span[text()='Add to cart']");
    private static final By CONTINUE_SHOPPING = By.xpath(".//span[@title='Continue shopping']");
    private static final By PROCEED_TO_CHECKOUT = By.xpath(".//a[@title='Proceed to checkout']");
    private static final By PROCEED_TO_CHECKOUT2 = By.xpath(".//a[@title='Proceed to checkout'][contains(@href, '1')]");
    private static final By NO_OF_PRODUCTS = By.xpath(".//span[@id='summary_products_quantity']");
    private static final By CREATE_ACCOUNT = By.xpath("//h3[text()='Create an account']");

    public void selectProducts(){
        Actions action = new Actions(driver);
        action.moveToElement(webDriverHelper.findElement(POPULAR_PRODUCT1)).perform();
        webDriverHelper.click(ADD_TO_CART);
        webDriverHelper.waitForElement(CONTINUE_SHOPPING);
        webDriverHelper.click(CONTINUE_SHOPPING);
        webDriverHelper.hardWait(2);
        action.moveToElement(webDriverHelper.findElement(POPULAR_PRODUCT2)).perform();
        webDriverHelper.click(ADD_TO_CART2);
        webDriverHelper.waitForElement(PROCEED_TO_CHECKOUT);
        webDriverHelper.click(PROCEED_TO_CHECKOUT);
        webDriverHelper.waitForElement(NO_OF_PRODUCTS);
        webDriverHelper.click(PROCEED_TO_CHECKOUT2);
        webDriverHelper.waitForElement(CREATE_ACCOUNT);
    }

}


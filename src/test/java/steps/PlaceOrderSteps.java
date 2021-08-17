package test.java.steps;

import cucumber.api.java.en.When;
import test.java.lib.ExtentReport;
import test.java.lib.WebDriverHelper;
import test.java.pages.Home_Page;
import test.java.pages.Sign_In_Page;

import java.io.IOException;
import java.util.Map;

public class PlaceOrderSteps {

    private WebDriverHelper webDriverHelper;
    private ExtentReport extentReport;
    private Home_Page homePage;
    private Sign_In_Page signInPage;

    public PlaceOrderSteps(){
        webDriverHelper = new WebDriverHelper();
        extentReport = new ExtentReport();
        homePage = new Home_Page();
        signInPage = new Sign_In_Page();
    }

    @When("^I add (\\d+) Products to Cart and click on Checkout$")
    public void iAddProductsToCartAndClickOnCheckout(int arg0) throws IOException {
        homePage.selectProducts();
        extentReport.screenshot();
    }

    @When("^I login enter valid credentials to login$")
    public void iLoginEnterValidCredentialsToLogin()throws IOException {
        signInPage.enterLoginDetails();
        extentReport.screenshot();
    }

    @When("^I click on Proceed and confirm Order$")
    public void iClickOnProceedAndConfirmOrder() throws IOException {
        signInPage.clickProceedTillPayment();
        extentReport.screenshot();
        signInPage.confirmOrder();
        extentReport.screenshot();
    }
}

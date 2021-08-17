package test.java.steps;


import cucumber.api.java.en.When;
import test.java.lib.ExtentReport;
import test.java.lib.Runner;
import test.java.lib.WebDriverHelper;
import test.java.pages.Home_Page;
;import java.io.IOException;

public class NavigationSteps extends Runner {

    private ExtentReport extentReport;
    private WebDriverHelper webDriverHelper;
    private Home_Page homePage;


    public NavigationSteps(){
        webDriverHelper = new WebDriverHelper();
        homePage = new Home_Page();
        extentReport = new ExtentReport();
    }

    @When("^I open YourLogo Home Page$")
    public void iOpenYourLogoHomePage() throws IOException {
        System.out.println("STEP - I open YourLogo Home Page"+"\n");
        driver.get(conf.getProperty("UrltoUse"));
        extentReport.screenshot();
    }
}

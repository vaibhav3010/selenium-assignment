// This class contains step by step definitions corresponding to Cucumber feature file "ProductSearch.feature"

package nordea.amazon.automation.cu;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nordea.amazon.automation.pages.HomePage;
import nordea.amazon.automation.pages.ProductDetailsPage;
import nordea.amazon.automation.pages.SearchResultsPage;
import cucumber.api.java.en.And;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ProductSearchStepDefinitions {
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    ProductDetailsPage productDetailsPage;

    @Before
    public void prepare() throws Exception { 
    	driver = new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   }

	@After
    public void cleanUp() throws Exception {
        driver.quit();
    }

    @Given("^Amazon home page is open and Maximized$")
    public void prepareHomePage() {
    	homePage = new HomePage(driver).open();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();   
    }

    @When("^User searches for (.*)$")
    public void search(String item) {
    	searchResultsPage = homePage.navigationMenu()
                .searchFor(item);        
    }
    
    @And("^Sorts results by price : high to low$")
    public void sort() {
    	searchResultsPage = homePage.navigationMenu()
                .sortByPriceHighToLow();        
    }
    
    @And("^Opens the second item on the List$")
    public void openSecondItem() {
    	
    	productDetailsPage = searchResultsPage.clickSecondResultTitle();
    }
    
    @Then("^Product title of Second item contains (.*)$")
    public void assertTheSearchResult(String itemName) {
    	
        if(!productDetailsPage.getProductTitle().contains(itemName))
        {
        	Assert.fail("The word "+itemName+" doesnot exist in the Page");
        }
        
    }
}

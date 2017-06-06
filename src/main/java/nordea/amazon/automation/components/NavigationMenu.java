
// This class is used to take care of Searching and Sorting results.

package nordea.amazon.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import nordea.amazon.automation.pages.SearchResultsPage;
 
public class NavigationMenu {
   private static final By SEARCH_ITEM_SORT = By.id("sort");
   private static final By SEARCH_INPUT_BOX = By.id("twotabsearchtextbox");
   private static final By SEARCH_GO_BUTTON = By.xpath("//*[@value='Go']");
   private WebDriver driver;
 
   public NavigationMenu(WebDriver driver) {
      this.driver = driver;
   }
 
   public SearchResultsPage searchFor(String searchKey) {
      
      driver.findElement(SEARCH_INPUT_BOX)
            .sendKeys(searchKey);
      driver.findElement(SEARCH_GO_BUTTON)
            .click();
      return new SearchResultsPage(driver);
   }

  public SearchResultsPage sortByPriceHighToLow() {
	  Select dropdown = new Select(driver.findElement(SEARCH_ITEM_SORT));
      dropdown.selectByValue("price-desc-rank");
      return new SearchResultsPage(driver);
   }
 
}


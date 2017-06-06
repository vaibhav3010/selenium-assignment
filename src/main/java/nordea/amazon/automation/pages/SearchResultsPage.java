//This class finds the second item from search results and click to open product page

package nordea.amazon.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class SearchResultsPage {

	private static final By SEARCH_RESULT_SECOND_ITEM = By.xpath("//*[@id=\"result_1\"]/div/div/div/div[1]/div/div");
   private WebDriver driver;
   public SearchResultsPage(WebDriver driver) {
      this.driver = driver;
   } 
  
   public ProductDetailsPage clickSecondResultTitle() {
	   
	   driver.navigate().refresh();
	   driver.findElement(SEARCH_RESULT_SECOND_ITEM)
            .click();
      return new ProductDetailsPage(driver);
   }
}

// This class is used to give the URL of the Amazon Page.

package nordea.amazon.automation.pages;

import org.openqa.selenium.WebDriver;

import nordea.amazon.automation.components.NavigationMenu;
 
public class HomePage {
   private static final String AMAZON_HOME_PAGE_URL = "http://www.amazon.com";
   private final NavigationMenu navigationMenu;
   private WebDriver driver;
 
   public HomePage(WebDriver driver) {
      this.driver = driver;
      this.navigationMenu = new NavigationMenu(driver);
   }
 
   public HomePage open() {
      driver.get(AMAZON_HOME_PAGE_URL);
      return this;
   }
 
   public NavigationMenu navigationMenu() {
      return navigationMenu;
   }
}

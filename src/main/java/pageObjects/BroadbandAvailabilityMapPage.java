package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseClass.BasePage;

public class BroadbandAvailabilityMapPage extends BasePage {
	
	public By searchField = By.xpath("//*[@id = 'wivolo-search-input']");
	public By searchResult = By.xpath("//li[@class='ui-menu-item']");
	public By networkCapability = By.xpath("//div[@id = 'location-details-now']");
	
	public BroadbandAvailabilityMapPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterAddress(String partialAddress) {
		getElement(searchField).sendKeys(partialAddress);
	}

	public void clickSearchResult(String partialAddress) {
		getElement(searchResult);
		List<WebElement> results = driver.findElements(searchResult);
		for(WebElement result : results) {
			if(result.getText().toLowerCase().contains(partialAddress.toLowerCase())) {
				//System.out.println("found");
				result.click();
				break;
			} else {
				//System.out.println("not found");
				System.out.println(result.getText());
			}
		}
	}
}

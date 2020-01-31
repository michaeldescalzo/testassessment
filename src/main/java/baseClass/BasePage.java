package baseClass;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class BasePage {
	protected WebDriver driver;
	protected Wait<WebDriver> fluentWait;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		fluentWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);
	}
	
	public WebElement getElement(final By xpath) {
		Function<WebDriver, WebElement> function = new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(xpath);
				return element;
			}
		};
		
		try {
			return fluentWait.until(function);
		} catch (Exception e) {
			return null;
		}
	}
}

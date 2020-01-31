package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser", "url"})
	public void startTest(@Optional("chrome") String browser, @Optional("https://www.chorus.co.nz/broadband-map") String url) {
		if(browser.toLowerCase().equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_79.0.3945.36.exe");
			driver = new ChromeDriver();
		} else {
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterMethod
	public void endTest() {
		//driver.quit();
	}
}

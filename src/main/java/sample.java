import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver_79.0.3945.36.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://wwww.google.com");
		driver.close();
	}

}

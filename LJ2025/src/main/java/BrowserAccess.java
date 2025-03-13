import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class BrowserAccess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Chrome driver -> Method
		//ChromeDriver driver = new ChromeDriver();
		// WebDriver methods + class methods will be called in above
		// WebDriver -> method alone
	 	System.setProperty("webdriver.chrome.driver", "C:/Users/ronyp/OneDrive/Documents/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
	// Two ways to invoke browser one is directly by selenium manager and next is downloading chromedriver exe 
		
	  	driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
	// 	driver.close(); // closes only current window
		driver.quit(); // closes the browser completely
		
	}

}

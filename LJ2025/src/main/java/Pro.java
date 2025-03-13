import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pro {
    public static void main(String[] args) {
        // Set WebDriver path
    	System.setProperty("webdriver.chrome.driver", "C:/Users/ronyp/OneDrive/Documents/chromedriver-win64/chromedriver-win64/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
        
        // Set implicit wait (reduce to 10s) update as per your connectivity
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to LinkedIn
        driver.get("https://www.linkedin.com/");
        
        // Click sign-in button
        driver.findElement(By.cssSelector(".nav__button-secondary.btn-secondary-emphasis.btn-md")).click();
        
        // Login (Replace with secure input method)
        String username = System.getenv("LINKEDIN_USER"); // Use environment variable
        String password = System.getenv("LINKEDIN_PASS"); // Use environment variable

        driver.findElement(By.id("username")).sendKeys("@gmail.com");
        driver.findElement(By.id("password")).sendKeys("*********");
        driver.findElement(By.cssSelector("button[aria-label='Sign in']")).click();

        // Search for "Tester" jobs, change as per your job requirement
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
        searchBox.sendKeys("Tester" + Keys.ENTER);
        
        // Click on Jobs tab
        driver.findElement(By.xpath("//button[normalize-space()='Jobs']")).click();
        
        // Click on filter dropdown for date posted
        driver.findElement(By.id("searchFilter_timePostedRange")).click();
        
        // Explicit wait for "Past 24 hours" filter option
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='timePostedRange-r86400']")));
        element.click();
        
        WebElement button = driver.findElement(By.xpath("//button[@class='artdeco-button artdeco-button--2 artdeco-button--primary ember-view ml2']"));
        Actions act = new Actions(driver);
        // Corrected button locator
        
        act.moveToElement(button).click().build().perform();
        //driver.findElement(By.tagName("span.artdeco-button__text"));
        
        // Locate the list element 
        WebElement ulElement = driver.findElement(By.className("ozZCVvtCJUyqiogEVmaNpCidpQJkHwRfc")); 

        // Get all elements inside the list
        List<WebElement> liElements = ulElement.findElements(By.tagName("li"));

        // Loop through each <li> and print the text in the output
        for (WebElement li : liElements) {
            System.out.println(li.getText());
            System.out.println("----------------");
        }


        // Close browser
        driver.quit();
    }
}

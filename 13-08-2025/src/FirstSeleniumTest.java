import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTest{

	public static void main(String[] args) {

		WebDriver driver = null;

		try {

			// Launch Chrome browser

			driver = new ChromeDriver();

			// Go to Google

			driver.get("https://www.youtube.com");

			// Find the search box and type a query

			WebElement searchBox = driver.findElement(By.name("search_query"));

			searchBox.sendKeys("iphone 16 pro max");

			// Submit the search form

			searchBox.submit();

			WebElement searchButton = driver.findElement(By.cssSelector("search-icon-legacy")); 

			searchButton.click();

			// Wait a bit (basic pause, not best practice)

			//Thread.sleep(2000); // Wait 2 seconds for results to load

		} catch (Exception e) {

			// e.printStackTrace();

		}

		// Print the title of the results page

		System.out.println("Search Results Page Title: " + driver.getTitle());

		// Close the browser

		driver.quit();

	}

}

 
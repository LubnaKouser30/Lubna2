package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


import pom1.TripAdvisorHp;

public class TripTestClass {
@Test
public void TripTest() throws InterruptedException
{
	
	
	System.setProperty("webdriver.chrome.driver",
			"./softwares/chromedriver.exe");
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.tripadvisor.in");
	
	TripAdvisorHp tp=new TripAdvisorHp(driver);
	tp.clickSearch();
	tp.searchPlace("club mahindra");
	tp.selectPlace(driver);
	tp.clickReview();
	tp.clickWriteReview(driver);
	Thread.sleep(5000);
	tp.selectStars(driver);
	tp.enterReviewTitle();
}
}

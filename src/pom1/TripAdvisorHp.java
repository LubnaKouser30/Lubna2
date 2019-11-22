package pom1;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TripAdvisorHp {

	@FindBy(xpath="//span[.='Search']")
	private WebElement search;
	
	@FindBy(id="mainSearch")
	private WebElement mainSearch;
	
	@FindBy(xpath="(//div[@class='prw_rup prw_search_search_result_poi'])[1]")
	private WebElement linkClub;
	
	@FindBy(xpath="//a[@class='hotels-hotel-review-atf-info-parts-Rating__ratingsAnchor--28rqA']")
	private WebElement review;
	
	@FindBy(linkText="Write a review")
	private WebElement writeReview;
	
	@FindBy(xpath="//input[@id='ReviewTitle']")
	private WebElement reviewTitle;
	
	@FindBy(xpath="//span[@class='ui_bubble_rating fl bubble_00']")
	private WebElement selectStars;
	
	public TripAdvisorHp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickSearch() throws InterruptedException
	{
		search.click();
		Thread.sleep(2000);
	}
	
	public void searchPlace(String val) throws InterruptedException
	{
		mainSearch.sendKeys(val);
		mainSearch.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	public void selectPlace(WebDriver driver) throws InterruptedException
	{
		linkClub.click();
		Thread.sleep(3000);
		Set<String> allwindow = driver.getWindowHandles();
		for (String str : allwindow) {
			driver.switchTo().window(str);
		}
	}
	
	public void clickReview() throws InterruptedException
	{
		review.click();
		Thread.sleep(2000);
	}
	
	public void clickWriteReview(WebDriver driver) throws InterruptedException
	{
		writeReview.click();
		Thread.sleep(3000);
		Set<String> allwindow = driver.getWindowHandles();
		for (String str : allwindow) {
			driver.switchTo().window(str);
		}
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
	}
	
	public void selectStars(WebDriver driver) throws InterruptedException
	{
		Point loc = selectStars.getLocation();
		int x = loc.getX();
		int y=loc.getY();
		System.out.println(loc);
		Actions act = new Actions(driver);
		//Demo1.rating(282, "Excellent", driver,selectStars);
		selectStars.click();
		
	
		Thread.sleep(5000);
		
		//act.moveToElement(selectStars).click().perform();
		act.moveToElement(selectStars, x+30, y+30).perform();
		Thread.sleep(5000);
		act.moveToElement(selectStars, x+30, y+30).perform();
		Thread.sleep(5000);
	}
	
	public void enterReviewTitle() throws InterruptedException
	{
		Thread.sleep(3000);
		reviewTitle.sendKeys("amazing place");
	}
	
	
	
}

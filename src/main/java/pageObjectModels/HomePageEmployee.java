package pageObjectModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageEmployee {

	public WebDriver driver;

	By branding = By.xpath("//*[@src='assets/imgs/logo.svg']");

	By submitIdea = By.xpath("//*[@class='create-idea__two d-flex']");
	By trendInsightsHead = By.xpath("//*[@class='trending-insights__head']");
	By topInnovator = By.xpath("//*[@class='top-innovators faded-end-h\"]//h4[@class=\"mb-3']");
	By ideaOfMonthx = By.xpath("//div[@class='mt-4']/ite-idea-results-card[@type='winnerIdeaOfX']");
	By winnerIdeaSubTitle = By.xpath("//span[@class='subtitle']");
	By homeBar = By.xpath("//ul[@class='list-unstyled']");
	By addIdea = By.xpath("//span[text()='Add Idea']");
	// ---------TopData section---------
	By hashtags = By.xpath("//h2[text()='Hashtags']");
	By busnessUnits = By.xpath("//h2[text()='BU']");
	By tms = By.xpath("//h2[text()='Target Market Sector']");
	By skills = By.xpath("//h2[text()='Skills']");
	// By topHashttaged
	// =By.xpath("//h2[text()=\"Hashtags\"]//parent::div//ul//li[5]");
	By trendingInsightsText = By.xpath("//div[@class= 'trending-insights']");

	public HomePageEmployee(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}

	public WebElement clickAddIdea() {

		return driver.findElement(addIdea);
	}

	public WebElement brandCheck() {

		return driver.findElement(branding);
	}

	public WebElement submitIdea() {

		return driver.findElement(submitIdea);
	}

	public WebElement trendingInsightsHead() {

		return driver.findElement(trendInsightsHead);
	}

	public WebElement topInnovatortitle() {

		return driver.findElement(topInnovator);
	}

	public WebElement ideaOfTheMonthCard() {

		return driver.findElement(ideaOfMonthx);
	}

	public WebElement ideaOfTheMonthTitle() {

		return driver.findElement(winnerIdeaSubTitle);
	}

	public WebElement homeBarCheck() {

		return driver.findElement(homeBar);
	}

	public WebElement findHashtags() {

		return driver.findElement(hashtags);
	}

	public WebElement findBU() {

		return driver.findElement(busnessUnits);
	}

	public WebElement findTms() {

		return driver.findElement(tms);
	}

	public WebElement findskills() {

		return driver.findElement(skills);
	}

	public WebElement checkTrendingInsighs() {

		return driver.findElement(trendingInsightsText);
	}

	public WebElement findTopHashttaged(int i) {
		By topHashttaged = By.xpath("//h2[text()='Hashtags']//parent::div//ul//li[" + i + "]");
		return driver.findElement(topHashttaged);
	}

	public WebElement findTopBU(int i) {
		By topBU = By.xpath("//h2[text()='BU']//parent::div//ul//li[" + i + "]");
		return driver.findElement(topBU);
	}

	public WebElement findTopTMS(int i) {
		By topTMS = By.xpath("//h2[text()='Target Market Sector']//parent::div//ul//li[" + i + "]");
		return driver.findElement(topTMS);
	}

	public WebElement findtopSkills(int i) {
		By topSkills = By.xpath("//h2[text()='Skills']//parent::div//ul//li[" + i + "]");
		return driver.findElement(topSkills);
	}

	public WebElement findTrendingInsights(int i) {
		By trendingInsights = By.xpath("//div[@class= \"trending-insights\"]/div[2]/ul/li[" + i + "]");
		return driver.findElement(trendingInsights);
	}
}

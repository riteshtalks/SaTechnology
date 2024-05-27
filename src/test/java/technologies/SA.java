package technologies;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SA {
	
	public String baseUrl = "https://www.tendable.com/";
	public WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Initiating browser...");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void confirmAccessibilityOfTheTopLevelMenus() {
		
		
		System.out.println("Error: Unable to find Home menu. Not sure!");
		
		WebElement eleOurStory = driver.findElement(By.xpath("//*[@id='main-navigation-new']/ul/li[1]/a"));
		if(eleOurStory.isDisplayed()) {
			Assert.assertEquals(eleOurStory.getText(), "Our Story");
			System.out.println("Top-Level menu: " +eleOurStory.getText()+ " is displayed and verified.");
		}
		WebElement eleOurSolutions = driver.findElement(By.xpath("//*[@id='main-navigation-new']/ul/li[2]/a"));
		if(eleOurSolutions.isDisplayed()) {
			Assert.assertEquals(eleOurSolutions.getText(), "Our Solution");
			System.out.println("Top-Level menu: " +eleOurSolutions.getText()+ " is displayed and verified.");
		}
		WebElement eleWhyTendable = driver.findElement(By.xpath("//*[@id='main-navigation-new']/ul/li[3]/a"));
		if(eleWhyTendable.isDisplayed()) {
			Assert.assertEquals(eleWhyTendable.getText(), "Why Tendable?");
			System.out.println("Top-Level menu: " +eleWhyTendable.getText()+ " is displayed and verified.");
		}
		WebElement eleAboutUs = driver.findElement(By.xpath("//*[@id='main-navigation-new']/ul/li[4]/a"));
		if(eleAboutUs.isDisplayed()) {
			Assert.assertEquals(eleAboutUs.getText(), "About Us");
			System.out.println("Top-Level menu: " +eleAboutUs.getText()+ " is displayed and verified.");
		}
	}
	
	@Test
	public void verifyRequestADemoButton() {
		WebElement eleARequestADemo = driver.findElement(By.xpath("//a[contains(@class, 'button') and text() = 'Request A Demo']"));
		Assert.assertEquals(eleARequestADemo.isDisplayed(), true);
		System.out.println("The button: " +eleARequestADemo.getText()+ " is displayed and verified.");
	}
	
	@Test
	public void verifyContactUs() throws InterruptedException {
		WebElement eleContactUs= driver.findElement(By.xpath("//a[contains(@class, 'button') and text() = 'Contact Us']"));
		eleContactUs.click();
		
		WebElement eleMarketingContact= driver.findElement(By.xpath("//div[contains(text(),'Marketing')]/following-sibling::div/button"));
		eleMarketingContact.click();
		
		WebElement eleFullName= driver.findElement(By.id("form-input-fullName"));
		eleFullName.sendKeys("Full Name");
		
		WebElement eleOrgName= driver.findElement(By.id("form-input-organisationName"));
		eleOrgName.sendKeys("Organisation Name");
		
		WebElement eleMobileNu= driver.findElement(By.id("form-input-cellPhone"));
		eleMobileNu.sendKeys("9099890889");
		
		WebElement eleEmail= driver.findElement(By.id("form-input-email"));
		eleEmail.sendKeys("abc@def.ghi");
		
		WebElement eleJobRole = driver.findElement(By.id("form-input-jobRole"));
		Select objSelect = new Select(eleJobRole);
		objSelect.selectByVisibleText("Management");
		Thread.sleep(3000);	
		
		
		WebElement eleIAgree= driver.findElement(By.id("form-input-consentAgreed-0"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("form-input-consentAgreed-0")));
		eleIAgree.click();
		
		WebElement eleSubmit= driver.findElement(By.name("form_page_submit"));		
		eleSubmit.click();
		
		WebElement eleError= driver.findElement(By.xpath("//div[contains(@class, 'ff-form-errors')]/p"));
		if(eleError.isDisplayed()) {
			Assert.assertEquals(eleError.isDisplayed(), true);
			System.out.println("PASS");
			System.out.println("The error message displayes is: "+eleError.getText());
		}
	}	

	@AfterTest
	public void afterTest() {
		driver.quit();
		System.out.println("Quitting Browser!!");
	}

}

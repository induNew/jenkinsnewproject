package testActitime1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaunchBrowser {
	WebDriver driver;


	@BeforeMethod
	public void setUp()
	{
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver	=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.get("http://laptop-smc8hiai/login.do");

	}

	@Test
	public void loginToACtiTime() throws InterruptedException
	{
		
		//suraj
		driver.findElement(By.name("username")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.name("pwd")).sendKeys("manager");
		Thread.sleep(3000);
		driver.findElement(By.id("loginButton")).click();
		Thread.sleep(3000);
		
		WebElement enterTimeTrack = driver.findElement(By.xpath("//td[.='Enter Time-Track']"));
		boolean status = enterTimeTrack.isDisplayed();
		Assert.assertEquals(status, true);
	}

	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}

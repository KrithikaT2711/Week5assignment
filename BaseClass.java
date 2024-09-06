package homeassignmentweek5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	
	@Parameters({"url","uName","pwd","browser"})
	@BeforeMethod()
	public void preCondition(String url,String uName,String pwd,String browser) {
		
	
	ChromeOptions co = new ChromeOptions();
	co.addArguments("--disable-notifications");
	co.addArguments("--incognito");
	 driver = new ChromeDriver(co);

	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	driver.get(url);

	driver.findElement(By.id("username")).sendKeys(uName);
	driver.findElement(By.id("password")).sendKeys(pwd);

	driver.findElement(By.id("Login")).click();
	}
	@AfterMethod
	public void postCondition() {
		driver.close();
	}
}

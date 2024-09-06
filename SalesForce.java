package homeassignmentweek5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesForce extends BaseClass{
	@DataProvider(name="fetchData")
	public String[][] setValue(){
		String[][] data = new String[2][2];
		data[0][0] = "TestLeaf";
		data[0][1] = "Salesforce";
		
		data[1][0] = "Amazon";
		data[1][1] = "QA";
		return data;
		
	}
	@Test(dataProvider = "fetchData")
	public  void runSalesForce(String cName, String desc) throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-r4']")).click();
		Thread.sleep(3000);
		WebElement moveTo = driver.findElement(By.xpath("(//button[@class='slds-button'])[2]"));
		Actions ac = new Actions(driver);
		ac.scrollToElement(moveTo).perform();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Legal Entities");
		driver.findElement(By.xpath("//input[@class='slds-input']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//mark[text()='Legal Entities']")).click();

		/*
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button_reset'])[14]")).click();
		driver.findElement(By.xpath("//span[text()='New Legal Entity']")).click();*/
		driver.findElement(By.className("forceActionLink")).click();
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys(cName);
		driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(desc);
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		
		
	}

}

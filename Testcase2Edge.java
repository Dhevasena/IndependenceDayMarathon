package indepencedaymarathon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Testcase2Edge extends ProjectSpecific {
	@BeforeTest
	public void excelName() {
		excelName="tc2data";
	}
	@BeforeTest
	public void browserName() {
		browserName="edge";
	}

	@Test(dataProvider="data")
	public void CaseTwo(String salutation) throws InterruptedException {

		//Type  Individuals  on the Search box
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("Individuals");
		//click Individuals link
		driver.findElement(By.xpath("//p/mark[text()='Individuals']")).click();
		//Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//Select Salutation with data 
		driver.findElement(By.xpath("//a[@class='select']")).click();
		//String salutation = "Ms.";
		driver.findElement(By.xpath("//a[text()='"+salutation+"']")).click();
		//Type Last name
		driver.findElement(By.xpath("//input[contains(@class,'lastName')]")).sendKeys("Ravikumar");
		String customer=driver.findElement(By.xpath("//input[contains(@class,'lastName')]")).getText();
		//Click Save
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		Thread.sleep(3000);
		//Click on the App Launcher (dots)
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//Click on view all
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//Type Customers on the Search box
		driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Customers");
		//click Individuals link
		driver.findElement(By.xpath("//p/mark[text()='Customers']")).click();
		Thread.sleep(2000);
		//Click New
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//Type the same name provided in step 8 and confirm it appearsWebElement party = driver.findElement(By.xpath("//input[@title='Search Individuals']"));
		WebElement party = driver.findElement(By.xpath("//input[@title='Search Individuals']"));
		wait.until(ExpectedConditions.visibilityOf(party));
		party.sendKeys(customer);
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']//mark")).getText();
		if (text.equals(customer)) {
			System.out.println("The name provided appears in search suggestions as expected");
		}
	}

}

package practise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest1 {
	
	@Test(dataProvider="dataProvider_test")
	public void companyDetails(String name,String phnum,String email) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(name);
		driver.findElement(By.id("phone")).sendKeys(phnum);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.quit();
		Thread.sleep(2000);
	}
		
		@DataProvider
		public Object[][] dataProvider_test()
		{
			Object[][] objArr=new Object[1][3];
			objArr[0][0]="AAA";
			objArr[0][1]="9876534656";
			objArr[0][2]="abc@gmail.com";
			
			
			
			
			
			return objArr;
			
			
		}
		
}




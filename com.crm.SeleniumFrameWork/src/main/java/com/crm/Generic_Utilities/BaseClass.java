package com.crm.Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	
	public WebDriver driver;
	public static WebDriver sDriver;
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void BS() {
		System.out.println("DataBase Connection");
	}
	
	@BeforeTest(groups = {"SmokeTest","RegressionTest"})
	public void BT() {
		System.out.println("Execute in parallel mode");
	}
	
   // @Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
	public void BC(/*String BROWSER*/) throws Throwable 
	{
		 File_Utility flib=new File_Utility(); 
		 //String Browser = flib.getPropertyKeyValue("browser");
		 String BROWSER = flib.getPropertyKeyValue("browser");
		  
		if(BROWSER.equalsIgnoreCase("chrome"))
	      {
	     	WebDriverManager.chromedriver().setup();
	     	driver=new ChromeDriver();
	      }
	      else if(BROWSER.equalsIgnoreCase("edge"))
	     		 {
	     	 WebDriverManager.edgedriver().setup();
	     	 driver=new EdgeDriver();
	      }
	      else if(BROWSER.equalsIgnoreCase("firefox"))
	 	 {
	     WebDriverManager.firefoxdriver().setup();
	      driver=new FirefoxDriver();
	      }
	      else {
	     	 driver=new ChromeDriver();
	      } 
		sDriver=driver;
		System.out.println("Launching the Browser");
	}
	
	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
	public void BM() throws Throwable {
		File_Utility flib=new File_Utility();
		 String URL=flib.getPropertyKeyValue("url");
		 String Username=flib.getPropertyKeyValue("un");
		 String PassWord=flib.getPropertyKeyValue("pw");
		  driver.get(URL);
		 	LoginPage log=new LoginPage(driver);
		 	log.login(Username, PassWord); 
		 	
		
		System.out.println("Login to Application");
	}
	
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void AM() {
		System.out.println("Logout the Application");
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void Ac() {
		System.out.println("Close the Browser");
	}
	
	@AfterTest(groups = {"SmokeTest","RegressionTest"})
	public void AT() {
		System.out.println("Executed Sucessfully");
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void AS() {
		System.out.println("DataBase Close");
	}
	
}

package com.crm.campaign;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.Webdriver_Utility;
import com.crm.Object.Repository.CampaignCreationPage;
import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.ProductCreationPage;
import com.crm.Object.Repository.ValidationAndVerificationPage;

public class CreateCampaignWithProductTest extends BaseClass{

	@Test(groups = {"RegressionTest"})
	public void campaignProductTest() throws Throwable {
	/*driver utilities */
		 File_Utility flib=new File_Utility();
		 Java_Utility jlib=new Java_Utility();
		 Excel_Utility elib=new Excel_Utility();
	     Webdriver_Utility wlib=new  Webdriver_Utility();
	     
	     
	     /*Implicit wait*/
	 	 wlib.waitForPageToLoad(driver); 
	  /*Maximize the window*/
	 	 driver.manage().window().maximize();
	     
	 

	  /*Launch the browser*/
//	      if(BROWSER.equalsIgnoreCase("chrome"))
//	      {
//	     	WebDriverManager.chromedriver().setup();
//	     	driver=new ChromeDriver();
//	      }
//	      else if(BROWSER.equalsIgnoreCase("edge"))
//	     		 {
//	     	 WebDriverManager.edgedriver().setup();
//	     	 driver=new EdgeDriver();
//	      }
//	      else if(BROWSER.equalsIgnoreCase("firefox"))
//	 	 {
//	     WebDriverManager.firefoxdriver().setup();
//	      driver=new FirefoxDriver();
//	      }
//	      else {
//	     	 driver=new ChromeDriver();
//	      } 
	      
	 	 /*Read common data from property file*/
//	 	     String BROWSER = flib.getPropertyKeyValue("browser");
//	 	 	 String URL=flib.getPropertyKeyValue("url");
//	 	 	 String Username=flib.getPropertyKeyValue("un");
//	 	 	 String PassWord=flib.getPropertyKeyValue("pw");
//	 	 	 WebDriver driver;

	      
	 
	 /*Login to application*/
//	 	driver.get(URL);
//	 	LoginPage log=new LoginPage(driver);
//	 	log.login(Username, PassWord);
	 	
	 /*click on Products*/
	 	HomePage hp=new HomePage(driver);
	 	hp.clickProductLink();
	 	
	 	
	 /*creating new product*/
		ProductCreationPage proCreate=new ProductCreationPage(driver);
	 	proCreate.getProductCreation().click();
	 		
		
	/*Read data from excel sheet*/
		int ranNum=jlib.getRandomNum();
		String data=elib.getDataFromExcel("Sheet1",0,0)+ranNum;
		proCreate.getProductTextField().sendKeys(data);
		
	    proCreate.getSaveButton().click();
	    
		
	/*Verify the product created*/
//		ProductInfoPage proInfo=new ProductInfoPage(driver);
//		String actdata = proInfo.getSucessfullMsg().getText();
//		    if(actdata.contains(data1))
//		    {
//		    	System.out.println("pass");
//		    }
//		    else {
//		    	System.out.println("fail");
//		    }
	    
	    ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
		validate.productValidation(driver,data);
	    
		
		
	  /*Navigate to Campaign page*/
		 hp.moreLink(driver);
		 hp.campaignLinkText();
		 
		 
	 /*Create Campaign*/ 	
		 CampaignCreationPage campCreate=new CampaignCreationPage(driver);
		 campCreate.getCampaignCreation().click();
		 
		
   /*Read data*/    
		 String data1=elib.getDataFromExcel("sheet1",0,0)+ranNum;
		 campCreate.getCampaignTextField().sendKeys(data1);
		 driver.findElement(By.xpath("//img[@title='Select']")).click();
		 
		
   /*Window Switching*/
		wlib.switchToWindow(driver, "Products&action");

		driver.findElement(By.id("search_txt")).sendKeys(data1);
		driver.findElement(By.name("search")).click();

	/*Dynamic xPath*/
		driver.findElement(By.xpath("//a[text()='"+data1+"']")).click();
		
	/*Switch back Window*/
		wlib.switchToWindow(driver,"Campaigns&action");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		

	/*verify the campaign created*/
//	    CampaignInfoPage campInfo=new CampaignInfoPage(driver);
//		String actdata1 = campInfo.getSucessfullMsg().getText();
// 
//		if(actdata1.contains(data1))
//		{
//		System.out.println("pass");
//		}
//		else
//		{
//		System.out.println("fail");
//		}
		
      validate.campaignValidation(driver, data1);
//		
		
	/*logout*/
		hp.signoutLink(driver); 

		}
	}
 
	




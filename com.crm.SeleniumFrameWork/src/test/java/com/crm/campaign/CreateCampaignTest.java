package com.crm.campaign;

import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.Webdriver_Utility;
import com.crm.Object.Repository.CampaignCreationPage;
import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.ValidationAndVerificationPage;

    public class CreateCampaignTest  extends BaseClass{

    @Test(groups = {"RegressionTest"})
	public void campaignTest() throws Throwable {
		 File_Utility flib=new File_Utility();
		 Java_Utility jlib=new Java_Utility();
		 Excel_Utility elib=new Excel_Utility();
	     Webdriver_Utility wlib=new  Webdriver_Utility();
	     
	     wlib.waitForPageToLoad(driver);
	 	 driver.manage().window().maximize();
	     
	 	/*click on more*/
	 	HomePage hp=new HomePage(driver);
	 	hp.moreLink(driver);
	 	
	 	
	 	/*Navigate to campaign*/
	 	hp.campaignLinkText();
	 	
	 	
	 	/*Create Campaign*/
	 	CampaignCreationPage campCreate=new CampaignCreationPage(driver);
	 	campCreate.getCampaignCreation().click();
	 	
	 	
	    /*Read data*/
	    int ranNum=jlib.getRandomNum();
	    String data1=elib.getDataFromExcel("sheet1",0,0)+ranNum;
	    campCreate.getCampaignTextField().sendKeys(data1);
	    campCreate.getSaveButton().click();
	    
	    
	   /*Verify*/
	    ValidationAndVerificationPage validate=new ValidationAndVerificationPage(driver);
		validate.campaignValidation(driver,data1);
	    
	    /*logout*/
	    hp.signoutLink(driver);
		
	    }
}


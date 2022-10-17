package com.crm.organisation;

import org.testng.annotations.Test;

import com.crm.Generic_Utilities.BaseClass;
import com.crm.Generic_Utilities.Excel_Utility;
import com.crm.Generic_Utilities.File_Utility;
import com.crm.Generic_Utilities.Java_Utility;
import com.crm.Generic_Utilities.Webdriver_Utility;
import com.crm.Object.Repository.HomePage;
import com.crm.Object.Repository.OrganizationCreationPage;
import com.crm.Object.Repository.OrganizationInfo;

public class CreateOrganisationTest extends BaseClass{
	@Test(groups = {"RegressionTest"})
	public void organisationTest() throws Throwable {
		
	 /*Create Objects*/	
	 File_Utility flib=new File_Utility();
	 Java_Utility jlib=new Java_Utility();
	 Excel_Utility elib=new Excel_Utility();
     Webdriver_Utility wlib=new  Webdriver_Utility();
     
     wlib.waitForPageToLoad(driver);
	 driver.manage().window().maximize();
	 
	 /*Launch the browser*/
     /*Read common data*/
     /*Login to application*/


	 /*Click on Organization*/
	 HomePage hp=new HomePage(driver);
	 hp.clickOrganisationsLink();
	 
	 	 
    /*Create Organization*/   
     OrganizationCreationPage org=new OrganizationCreationPage(driver);
      org.createNewOrganization();
	 
	 /*Read Test Data*/		
	 int ranNum=jlib.getRandomNum();
	 String data=elib.getDataFromExcel("sheet1",0,0)+ranNum;
//	 org.organisationName(data);
//	 org.getSaveButton();
	 	
	  /* infoVerify*/
	  OrganizationInfo orgInfo=new OrganizationInfo(driver);
	  String actdata = orgInfo.getSucessfullMsg().getText();

	    if(actdata.contains(data))
	    {
	    	System.out.println("pass");
	    }
	    else {
	    	System.out.println("fail");
	    }
	    
	    /*Logout*/
	    hp.signoutLink(driver);
	    

	}
//	@Test
//	
//	public void modifyOrg() {
//		System.out.println("modified");
	} 



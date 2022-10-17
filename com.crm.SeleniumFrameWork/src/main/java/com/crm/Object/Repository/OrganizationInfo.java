package com.crm.Object.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	public  OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//span[text()='[ ACC91 ] sdfa -  Organization Information']")
	private WebElement sucessfullMsg;
	
	public WebElement getSucessfullMsg() {
		return sucessfullMsg;
	}

}
 
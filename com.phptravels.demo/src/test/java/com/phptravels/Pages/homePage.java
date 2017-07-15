package com.phptravels.Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.phptravels.UtilityLibrary.BasePage;

public class homePage extends BasePage{
	
	final static Logger mylogger = Logger.getLogger(homePage.class);
	
	public  homePage goto_HomePage(){
		driver.navigate().to("http://www.phptravels.net/");
		// driver.get("http://www.phptravels.net/");
		

		String title = driver.getTitle();
		mylogger.info("current title is " +title);
		Assert.assertEquals(title, "PHPTRAVELS | Travel Technology Partner");
		
		return this;
	}
	
	public homePage goto_differentPages(String types){
	WebElement whole= driver.findElement(By.cssSelector(".nav.navbar-nav.navbar-left.go-right"));
	List<WebElement> allservecies = whole.findElements(By.tagName("li"));
	
	for(WebElement temp : allservecies){
		String all =temp.getText();
		System.out.println(all);
	if(all.contains(types)){
			temp.click();
			break;
		}
		
			
		
	}
		
		
		
		
		return this;
	}

	
	
	
}

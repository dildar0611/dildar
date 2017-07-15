package com.phptravels.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.phptravels.UtilityLibrary.BasePage;

public class HotelPage extends BasePage {

	public HotelPage waitUntilPageLoad() {

		WebElement element = myLib.fluentWait(By.id("s2id_autogen1"));
		verigyPageTitle();
		Assert.assertNotNull(element);

		return this;
	}

	public HotelPage search_Hotel_Actions() throws InterruptedException {

		// element not visisble exceptions, element not clickable exceptions,
		// time out exceptions.

		WebElement inputelem = driver.findElement(By.id("s2id_autogen1"));
		Actions actions = new Actions(driver);
		actions.moveToElement(inputelem);
		actions.click();
		actions.sendKeys("Chicago");
		actions.build().perform();
		Thread.sleep(3000);
		WebElement parentelem = driver.findElement(By.className("select2-results"));
		WebElement childlist = parentelem.findElement(By.tagName("li"));
		WebElement subelem = childlist.findElement(By.cssSelector(".select2-result-sub"));
		List<WebElement> sublist = subelem.findElements(By.tagName("li"));
		sublist.get(0).click();

		Thread.sleep(5000);

		WebElement checkintime = driver.findElement(By.cssSelector(".form.input-lg.dpd1"));
		checkintime.clear();
		checkintime.sendKeys("09/21/2017");
		Thread.sleep(5000);
		
		WebElement checkouttime = driver.findElement(By.cssSelector(".form.input-lg.dpd2"));
		checkouttime.clear();
		checkouttime.sendKeys("09/25/2017");
		
		Thread.sleep(5000);
		WebElement selectElem = driver.findElement(By.className("icon_set_1_icon-42"));
		selectElem.click();
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.id("adults")));
		select.selectByValue("4");
		Thread.sleep(5000);
		
		
		Select select1 = new Select(driver.findElement(By.id("child")));
		select1.selectByVisibleText("2");
		Thread.sleep(5000);
		
		WebElement searchButton = driver.findElement(By.cssSelector(".btn-warning.btn.btn-lg.btn-block"));
		searchButton.click();
		
		Thread.sleep(2000);
		
		return this;
	}
	
	public HotelPage subSearching_actions (){
		
		WebElement paretnelem = driver.findElement(By.cssSelector(".rating"));
		List<WebElement> groupElem = paretnelem.findElements(By.tagName("div"));
		for(WebElement temp : groupElem){
			if(temp.getAttribute("class").contains("go-right")){
				WebElement inputelem = driver.findElement(By.tagName("input"));
				if(inputelem.getAttribute("id").contains("4")){
					WebElement elem =temp.findElement(By.tagName("div"));
					elem.click();
					break;
					
				}
				
				
				
			}
		}
		
		
		
	
		
		WebElement start_radio_button = driver.findElement(By.className("iCheck-helper"));
		start_radio_button.click();
		
		return this;
	}

	private void verigyPageTitle() {

		String currenttitle = driver.getTitle();
		System.out.println("here is current title " + currenttitle);
		Assert.assertEquals(currenttitle, "Hotels");
	}

}

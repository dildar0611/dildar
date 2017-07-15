package com.phptravels.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.phptravels.UtilityLibrary.BasePage;

public class FlightPage extends BasePage {

	public void pageloadtimeout() {

		WebElement iframeelement = driver.findElement(By.id("tpcwl_iframe"));
		driver.switchTo().frame((iframeelement));

		WebElement element = myLib.fluentWait(By.cssSelector("#flights-origin-prepop-whitelabel_en"));
		verigyPageTitle();
		Assert.assertNotNull(element);
	}

	public FlightPage search_activity() throws Exception {

		WebElement original_Destination = driver.findElement(By.id("flights-origin-prepop-whitelabel_en"));
		original_Destination.click();
		original_Destination.sendKeys("DCA");

		/*
		 * Actions action = new Actions(driver); WebElement started_table =
		 * driver.findElement(By.className("mewtwo-autocomplete"));
		 * action.moveToElement(started_table).build().perform();
		 * Thread.sleep(3000); driver.findElement(By.
		 * linkText("Washington Dulles International Airport")).click();
		 */
		/*
		 * WebElement table =
		 * driver.findElement(By.className("mewtwo-autocomplete-list"));
		 * action.moveToElement(table).build().perform();
		 * driver.findElement(By.linkText("O'Hare International Airport"));
		 */

		WebElement arrived_destination = driver.findElement(By.id("flights-destination-prepop-whitelabel_en"));
		arrived_destination.click();
		arrived_destination.sendKeys("CHI");
		Thread.sleep(10000);

		return this;

	}

	private void verigyPageTitle() {

		String currenttitle = driver.getTitle();
		System.out.println("here is current title " + currenttitle);
		Assert.assertEquals(currenttitle, "Flights");
	}
}

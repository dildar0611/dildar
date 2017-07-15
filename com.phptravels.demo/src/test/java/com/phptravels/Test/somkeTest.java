package com.phptravels.Test;

import org.testng.annotations.Test;

import com.phptravels.Pages.FlightPage;
import com.phptravels.Pages.HotelPage;
import com.phptravels.Pages.homePage;
import com.phptravels.UtilityLibrary.BasePage;


public class somkeTest extends BasePage {

	homePage hp = new homePage();
	FlightPage fp = new FlightPage();
	HotelPage myhp= new HotelPage();
	
	
	@Test (enabled = false)
	public void flight_smoketesting() throws Exception {

		hp.goto_HomePage();
		Thread.sleep(5000);
		hp.goto_differentPages("Flights");
		Thread.sleep(5000);
		fp.pageloadtimeout();
		Thread.sleep(5000);
		fp.search_activity();
		Thread.sleep(5000);

	}
	
	@Test(enabled= true)
	public void hotel_smokeTesting() throws Exception{
		hp.goto_HomePage();
		Thread.sleep(5000);
		hp.goto_differentPages("Hotels");
		myhp.search_Hotel_Actions();
		myhp.subSearching_actions();
		Thread.sleep(5000);
		
		
	}

}

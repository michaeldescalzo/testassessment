package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseTest;
import pageObjects.BroadbandAvailabilityMapPage;
import testData.TestData;

public class BroadbandMapTestCases extends BaseTest {

	@Test(dataProvider = "broadbandMapAddress", dataProviderClass=TestData.class)
	public void TC001_CheckServiceAvailability(String address, String expectedNetworkCapability) {
		/* 
		 * User story: As an Internet User, I want to know which Chorus services are available to me, 
		 * So that I can decide on the service I want to order.
		 * 
		 * Test case description:
		 * Check Chorus service availability using Address search
		 */

		BroadbandAvailabilityMapPage mapPage = new BroadbandAvailabilityMapPage(driver);
		mapPage.enterAddress(address);
		mapPage.clickSearchResult(address);
		String networkCapability = mapPage.getElement(mapPage.networkCapability).getText();
		
		Assert.assertEquals(networkCapability, expectedNetworkCapability);
	}
}

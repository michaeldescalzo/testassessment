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
		 * Check Chorus service availability using Address search
		 */

		BroadbandAvailabilityMapPage mapPage = new BroadbandAvailabilityMapPage(driver);
		mapPage.enterAddress(address);
		mapPage.clickSearchResult(address);
		String networkCapability = mapPage.getElement(mapPage.networkCapability).getText();
		
		Assert.assertEquals(networkCapability, expectedNetworkCapability);
	}
}

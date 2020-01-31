package testData;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name = "broadbandMapAddress")
	public Object[][] broadbandMapAddress() {
		/*
		 * Test Data for TC001_CheckServiceAvailability Check Chorus service using Address search
		 */
		return new Object[][] {
			{"1 Arthur Street, Ellerslie", "Network capability now\nUFB fibre up to 1 Gbps\nBroadband > 20 Mbps (with the right modem and plan)\nBroadband > 10 Mbps"},
			{"4 Old Balfour Road", "Network capability now\nBroadband > 5 Mbps"},
			{"1 Wilmot Pass Road", "Outside planned coverage area"}
		};
	}
}

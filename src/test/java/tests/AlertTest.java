
package tests;

import config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertPage;

public class AlertTest extends BaseTest {

	@Test
	public void testAlerts() {

	    driver.get(ConfigReader.getBaseUrl() + "/alerts");

	    AlertPage alertPage = new AlertPage(driver);

	    alertPage.triggerAlert();
	    alertPage.triggerConfirmDismiss();
	    alertPage.triggerPrompt("Hello");

	    Assert.assertTrue(driver.getCurrentUrl().contains("alerts"));
	}
}
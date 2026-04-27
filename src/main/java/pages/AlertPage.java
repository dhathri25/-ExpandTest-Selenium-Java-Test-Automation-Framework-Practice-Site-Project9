
package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

	private By jsAlertBtn = By.xpath("//button[contains(text(),'Alert')]");
	private By jsConfirmBtn = By.xpath("//button[contains(text(),'Confirm')]");
	private By jsPromptBtn = By.xpath("//button[contains(text(),'Prompt')]");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void triggerAlert() {
        click(jsAlertBtn);
        driver.switchTo().alert().accept();
    }

    public void triggerConfirmDismiss() {
        click(jsConfirmBtn);
        driver.switchTo().alert().dismiss();
    }

    public void triggerPrompt(String text) {
        click(jsPromptBtn);
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
    }
}
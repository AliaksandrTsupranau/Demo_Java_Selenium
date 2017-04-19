package framework.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxInboxPage extends PageBase{

	public MailBoxInboxPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='mail-NestedList-Item-Info-Extras']")
	private WebElement inboxCounter;

	public int getInboxEmailsCount() {
		return Integer.parseInt(inboxCounter.getText().trim().substring(2).trim());
		
	}
	
	
	
}

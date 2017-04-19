package framework.core.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailBoxPage extends PageBase{

	public MailBoxPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='mail-User-Name']")
	private WebElement accountMenu;
	
	
	public boolean isLoggedIn(){
		return isPresent(accountMenu);
	}
	

}

package framework.core.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.common.data.URLS;

public abstract class PageBase {

	protected WebDriver driver;
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='#inbox']/span")
	private WebElement inboxEmailsButton;
	
	
	public PageBase openPage(URLS url){
		driver.get(url.getURL());
		return this;
	}
	
    public By userDDButton = By.xpath("//span[@class='uname']");
	
    public boolean isPresent(WebElement element){
		return element.isDisplayed();
	}
	
	public String getURL(){
		return driver.getCurrentUrl();
	}
	
	public MailBoxInboxPage goToInboxFolder(){
		inboxEmailsButton.click();
		return new MailBoxInboxPage(driver);
	}
}

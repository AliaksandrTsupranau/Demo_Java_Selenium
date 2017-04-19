package framework.core.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends PageBase{

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='i-holder']/input[@tabindex='1']")
	private WebElement loginField;
	
	@FindBy(xpath="//div[@class='i-holder']/input[@tabindex='2']")
	private WebElement passwordField;

	@FindBy(xpath="//div[@class='b-hold']/input[@tabindex='4']")
	private WebElement loginButton;
	
	@FindBy(xpath="//a[@class='enter']")
	private WebElement openLoginFormButton;
	
	@FindBy(xpath="//li[@class='auth-navigation__li'][2]/a")
	private WebElement emailButton;
	
	@FindBy(xpath="//span[@class='uname']")
	private WebElement userButton;
	
	public MainPage fillLoginForm(String login, String password){
		loginField.sendKeys(login);
		passwordField.sendKeys(password);
		loginButton.click();
		return this;
	}

	public MainPage openLoginForm(){
		openLoginFormButton.click();
		return this;
	}
	
	public MailBoxPage openEmailPage(){
		userButton.click();
		emailButton.click();
		String tab1 = driver.getWindowHandle();
		List<String> tab2= new ArrayList<String>(driver.getWindowHandles());
		tab2.remove(tab1);
		driver.switchTo().window(tab2.get(0));
		
//		driver.close();
//		driver.switchTo().window(tab1);
		
		return new MailBoxPage(driver);
	}
	
	
	
	
}

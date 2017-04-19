package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import framework.core.drivers.Drivers;
import framework.core.drivers.Drivers.SUPPORTED_BROWSERS;
import framework.core.pages.MailBoxInboxPage;
import framework.core.pages.MailBoxPage;
import framework.core.pages.MainPage;

public abstract class TestBase {

	protected WebDriver driver;
	private MainPage mainPage;
	private MailBoxPage mailBoxPage;
	private MailBoxInboxPage mailBoxInboxPage;
	
	@BeforeClass(alwaysRun=true)
	public void initDriver(){
		driver = Drivers.getDriver(SUPPORTED_BROWSERS.CHROME);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown(){
		Drivers.tearDown();
	}
	
	protected MainPage getMainPage(){
		if(mainPage==null){
			mainPage = new MainPage(driver);
		}
		return mainPage;
	}
	
	protected MailBoxPage getMailBoxPage(){
		if(mailBoxPage==null){
			mailBoxPage = new MailBoxPage(driver);
		}
		return mailBoxPage;
	}
	
	protected MailBoxInboxPage getInboxFolder(){
		if(mailBoxInboxPage==null){
			mailBoxInboxPage = new MailBoxInboxPage(driver);
		}
		return mailBoxInboxPage;
	}
}

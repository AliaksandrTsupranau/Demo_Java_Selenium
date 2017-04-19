package framework.core.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {


	//will help to implement GRID
	public enum SUPPORTED_BROWSERS{
		FIREFOX(),
		CHROME();
		
		private SUPPORTED_BROWSERS() {
		}
	}
	
	private static WebDriver driver;
	private Drivers(){}
	
	public static WebDriver getDriver(SUPPORTED_BROWSERS browser){
		if(driver==null){
			switch (browser) {
			case CHROME:
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
				driver = new ChromeDriver();
				break;

			case FIREFOX:
				driver = new FirefoxDriver();
			default:
				driver = new FirefoxDriver();
				break;
			}
		}
		return driver;
	}

	
	public static void tearDown(){
		if(driver!=null){
			driver.quit();
		}
	}
	
	
}

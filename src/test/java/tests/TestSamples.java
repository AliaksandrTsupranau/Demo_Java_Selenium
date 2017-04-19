package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import framework.common.businessObjects.User;
import framework.common.data.Data;
import framework.common.data.URLS;

public class TestSamples extends TestBase{

	@Test(priority = 0)
	public void openMainPage(){
		getMainPage().openPage(URLS.MAIN_PAGE);
	}
	
	@Test(dependsOnMethods="openMainPage", dataProvider="user", dataProviderClass=Data.class)
	public void fillLoginForm(User user){
		getMainPage()
			.openLoginForm()
			.fillLoginForm(user.getLogin(), user.getPassword())
			.openEmailPage();

		
		Assert.assertTrue(getMailBoxPage().isLoggedIn());
	}
	
	
	@Test(dependsOnMethods="fillLoginForm")
	public void getInboxEmails(){
		getInboxFolder()
			.goToInboxFolder();
			
		//get EmailsCount (from the task)
			System.out.println(getInboxFolder().getInboxEmailsCount());
			Assert.assertTrue(getInboxFolder().getInboxEmailsCount()>0);
	}
}

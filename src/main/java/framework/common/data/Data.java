package framework.common.data;

import org.testng.annotations.DataProvider;

import framework.common.businessObjects.User;

public class Data {

	@DataProvider(name="user")
	public Object[][] getUser(){
		return new Object[][]{
//			{new User().setLogin("invalid").setPassword("invalid")},
			{new User().setLogin("mail.for.test").setPassword("testtest")}
		};
	}
	
	
}

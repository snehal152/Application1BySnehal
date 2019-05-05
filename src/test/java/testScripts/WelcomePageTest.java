package testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.WelcomePage;

public class WelcomePageTest extends TestBase{

	@BeforeSuite
	public void initialiseTest() throws IOException
	{
		WelcomePage welcomePage =start();
	}
	
	@Test
	public void verifyBtnVisibilityOnWelcomePage() throws IOException
	{
		//WelcomePage welcomePage =start();
		WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softAssert=new SoftAssert();

		boolean gmobuttonVisibleFlag = welcomePage.isGMOOnlineButtonVisible();
		softAssert.assertTrue(gmobuttonVisibleFlag);
		
		boolean gmobuttonBrowseFlag = welcomePage.isBrowseTestPageButtonVisible(); 
		softAssert.assertTrue(gmobuttonBrowseFlag);
		
		boolean aboutSiteFlag = welcomePage.isAboutSiteButtonVisible();
		softAssert.assertTrue(aboutSiteFlag);
		
		softAssert.assertAll();
		
	}
	
	@Test
	public void verifyBtnClicableOnWelcomePage() throws IOException
	{
	//	WelcomePage welcomePage =start();
		WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softAssert=new SoftAssert();

		boolean gmobuttonClickFlag = welcomePage.isGMOOnlineButtonClickable();
		softAssert.assertTrue(gmobuttonClickFlag);
		
		boolean gmobuttonBrowseFlag = welcomePage.isAboutSiteButtonClickable(); 
		softAssert.assertTrue(gmobuttonBrowseFlag);
		
		boolean aboutSiteFlag = welcomePage.isBrowseTestPageButtonClickable();
		softAssert.assertTrue(aboutSiteFlag);
		
		softAssert.assertAll();
		
	}
	
	@Test
	public void verifyOnlineCatlogPage() throws IOException
	{
	//	WelcomePage welcomePage =start();
		WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softAssert=new SoftAssert();

		boolean gmobuttonClickFlag = welcomePage.isGMOOnlineButtonClickable();
		softAssert.assertTrue(gmobuttonClickFlag);
		
		boolean gmobuttonBrowseFlag = welcomePage.isAboutSiteButtonClickable(); 
		softAssert.assertTrue(gmobuttonBrowseFlag);
		
		boolean aboutSiteFlag = welcomePage.isBrowseTestPageButtonClickable();
		softAssert.assertTrue(aboutSiteFlag);
		
		softAssert.assertAll();
		
	}
	
	
	@AfterSuite
	public void stopTest() throws IOException
	{
		stop();
	}
}

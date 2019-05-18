package testScripts;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.WelcomePage;

public class WelcomePageTest extends TestBase{

	@BeforeTest
	public void initialiseTest() throws IOException
	{
		WelcomePage welcomePage =start();
	}
	
	@Parameters(value="browser")
	@Test
	public void verifyWordDisplayOnWelcomePage() throws IOException
	{
		WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(welcomePage.getTitleOfWelcomePage(), "Welcome to Green Mountain Outpost");
		softAssert.assertEquals(welcomePage.getURLOfWelcomePage(), "https://demo.borland.com/gmopost/");
		softAssert.assertTrue(welcomePage.isGMOOnlineWordVisible());
		softAssert.assertAll();
	}
	
	@Test
	public void verifyBtnVisibilityOnWelcomePage() throws IOException
	{
		//System.out.println(browserName);
		WelcomePage welcomePage =start();
		//WelcomePage welcomePage=WelcomePage.getInstance();
		SoftAssert softAssert=new SoftAssert();

		boolean gmobuttonVisibleFlag = welcomePage.isGMOOnlineButtonVisible();
		softAssert.assertTrue(gmobuttonVisibleFlag);
		
		boolean gmobuttonBrowseFlag = welcomePage.isBrowseTestPageButtonVisible(); 
		softAssert.assertTrue(gmobuttonBrowseFlag);
		
		boolean aboutSiteFlag = welcomePage.isAboutSiteButtonVisible();
		softAssert.assertTrue(aboutSiteFlag);
		
		welcomePage.takeLogoImage();
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
	
	
	@AfterTest
	public void stopTest() throws IOException
	{
		stop();
	}
}

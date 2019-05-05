package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.OnLineCatalogPage;
import pages.WelcomePage;
import pojo.OnlineCatelogPOJO;

public class OnLineCatalogPageTest extends TestBase {

	@Test
	public void verifyBtnVisibilityOnLineCatelogPage() throws IOException
	{
		WelcomePage welcomePage =start();
		//WelcomePage welcomePage=WelcomePage.getInstance();
		welcomePage.clickGMOOnlineButton();
		OnLineCatalogPage onLineCatalogPage=OnLineCatalogPage.getInstance();
		
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(onLineCatalogPage.isResetFormBtnVisible());
		softAssert.assertTrue(onLineCatalogPage.isSubmitBtnVisible());
		softAssert.assertAll();
		
	}
	@Test
	public void verifyReset() throws IOException
	{
		WelcomePage welcomePage =start();
		//WelcomePage welcomePage=WelcomePage.getInstance();
		welcomePage.clickGMOOnlineButton();
		OnLineCatalogPage onLineCatalogPage=OnLineCatalogPage.getInstance();
		
		OnlineCatelogPOJO onlineCatelogPOJO=new OnlineCatelogPOJO();
		onlineCatelogPOJO.setDemoTent("5");
		onlineCatelogPOJO.setFrameBackPack("4");
		onLineCatalogPage.setQuantity(onlineCatelogPOJO);
	}
	
}


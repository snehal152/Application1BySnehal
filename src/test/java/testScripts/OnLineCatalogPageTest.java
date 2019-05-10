package testScripts;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.OnLineCatalogPage;
import pages.OnLineCatalogPage.ITEM;
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
	public void verifySetQuantity() throws IOException
	{
		WelcomePage welcomePage =start();
		//WelcomePage welcomePage=WelcomePage.getInstance();
		welcomePage.clickGMOOnlineButton();
		OnLineCatalogPage onLineCatalogPage=OnLineCatalogPage.getInstance();
		
		OnlineCatelogPOJO onlineCatelogPOJO=new OnlineCatelogPOJO();
		onlineCatelogPOJO.setDemoTent("5");
		onlineCatelogPOJO.setFrameBackPack("4");
		onlineCatelogPOJO.setSunGlasses("22");
		onlineCatelogPOJO.setPaddedSocks("6");
		onlineCatelogPOJO.setHikingBoot("8");
		onlineCatelogPOJO.setBackCountryShorts("44");
		onLineCatalogPage.setQuantity(onlineCatelogPOJO);
		
		Assert.assertEquals(onLineCatalogPage.getQuantity(ITEM.TENTS), onlineCatelogPOJO.getDemoTent());
		Assert.assertEquals(onLineCatalogPage.getQuantity(ITEM.BACKPACKS), onlineCatelogPOJO.getFrameBackPack());
		Assert.assertEquals(onLineCatalogPage.getQuantity(ITEM.SUNGLASS), onlineCatelogPOJO.getSunGlasses());
		Assert.assertEquals(onLineCatalogPage.getQuantity(ITEM.SOCKS), onlineCatelogPOJO.getPaddedSocks());
		Assert.assertEquals(onLineCatalogPage.getQuantity(ITEM.BOOTS), onlineCatelogPOJO.getHikingBoot());
		Assert.assertEquals(onLineCatalogPage.getQuantity(ITEM.SHORTS), onlineCatelogPOJO.getBackCountryShorts());
		
		
		
		//onLineCatalogPage.clickResetFormBtn();	
		
	}
	
	@Test(dependsOnMethods="verifySetQuantity")
	public void verifyResetQuantity() throws IOException
	{
		OnLineCatalogPage onLineCatalogPage=OnLineCatalogPage.getInstance();
			
		onLineCatalogPage.clickResetFormBtn();
		Assert.assertEquals(onLineCatalogPage.getQuantity(ITEM.TENTS), "0");
		
		SoftAssert softAssert= new SoftAssert();
		
		softAssert.assertEquals(onLineCatalogPage.getQuantity(ITEM.TENTS),"0");
		softAssert.assertEquals(onLineCatalogPage.getQuantity(ITEM.BACKPACKS), "4");
		softAssert.assertEquals(onLineCatalogPage.getQuantity(ITEM.SUNGLASS), "0");
		softAssert.assertEquals(onLineCatalogPage.getQuantity(ITEM.SOCKS), "1");
		softAssert.assertEquals(onLineCatalogPage.getQuantity(ITEM.BOOTS), "0");
		softAssert.assertEquals(onLineCatalogPage.getQuantity(ITEM.SHORTS),"0");
		softAssert.assertAll();
		
	}
	
	@Test
	public void verifyPlaceOrderWithoutItem() throws IOException
	{
		WelcomePage welcomePage =start();
		//WelcomePage welcomePage=WelcomePage.getInstance();
		welcomePage.clickGMOOnlineButton();
		OnLineCatalogPage onLineCatalogPage=OnLineCatalogPage.getInstance();
		onLineCatalogPage.clickSubmitBtn();
		Assert.assertTrue(onLineCatalogPage.verifyPlaceAnOrderAlertPresent());
		Assert.assertEquals(onLineCatalogPage.getTextPlaceAnOrderAlert(), "Please Order Something First");
		
	}
	
	@Test(dependsOnMethods="verifySetQuantity")
	public void verifyPlaceOrderWithItem() throws IOException
	{
	
		OnLineCatalogPage onLineCatalogPage=OnLineCatalogPage.getInstance();
		onLineCatalogPage.clickSubmitBtn();
		Assert.assertFalse(onLineCatalogPage.verifyPlaceAnOrderAlertPresent());

		
	}
	
	@Test(dependsOnMethods="verifyBtnVisibilityOnLineCatelogPage")
	public void verifyItemNumberOrder() throws IOException
	{
		OnLineCatalogPage onlineCatalogPage = OnLineCatalogPage.getInstance();
		ArrayList<Integer> indexList= onlineCatalogPage.getItemIds();
		
		Assert.assertTrue(indexList.isEmpty(),"Wrong item ids " + indexList);

		
	}
	
	@Test(dependsOnMethods="verifyBtnVisibilityOnLineCatelogPage")
	public void verifyProductLink() throws IOException
	{
		OnLineCatalogPage onlineCatalogPage = OnLineCatalogPage.getInstance();
		Assert.assertTrue(onlineCatalogPage.verifyLink(ITEM.TENTS));
		Assert.assertTrue(onlineCatalogPage.verifyLink(ITEM.BACKPACKS));

		
	}
	
	@Test(dependsOnMethods="verifyBtnVisibilityOnLineCatelogPage")
	public void verifyRedirectLinksOnLineCatelogPage() throws IOException
	{
		OnLineCatalogPage onlineCatalogPage = OnLineCatalogPage.getInstance();
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals(onlineCatalogPage.clickLink(ITEM.TENTS),"https://demo.borland.com/gmopost/products.htm#tents");

		softAssert.assertEquals(onlineCatalogPage.backToCatalogPage(),"https://demo.borland.com/gmopost/online-catalog.htm");
		softAssert.assertEquals(onlineCatalogPage.clickLink(ITEM.BACKPACKS),"https://demo.borland.com/gmopost/products.htm#backpacks");

		softAssert.assertAll();
		
	}
	
	@Test(dependsOnMethods="verifyBtnVisibilityOnLineCatelogPage")
	public void verifyProductPriceOnLineCatelogPage() throws IOException
	{
		OnLineCatalogPage onlineCatalogPage = OnLineCatalogPage.getInstance();
		SoftAssert softAssert= new SoftAssert();
		System.out.println(onlineCatalogPage.getProductPrice(ITEM.TENTS));
		System.out.println(onlineCatalogPage.getProductPrice(ITEM.BACKPACKS));
		
	}
	
}


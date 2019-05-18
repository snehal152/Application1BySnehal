package pages;

import java.io.IOException;

import base.PredefinedActions;
import contant.ConstantPath;
import util.PropertyFileOperation;

public class WelcomePage extends PredefinedActions {
	private static WelcomePage welcomePage;
	PropertyFileOperation propOperation;
	private WelcomePage() throws IOException
	{
		 propOperation = new PropertyFileOperation(ConstantPath.WELCOMEPAGEPATH);
	}
	public static WelcomePage getInstance() throws IOException
	{
		if(welcomePage == null)
			welcomePage = new WelcomePage();
		return welcomePage;
	}
	
	//***************WelcomePage Comman methods**********************
	private boolean visibilityOnWelcomePage(String locator)
	{
		return visiblilityOfElement(locator);
	}
	//*************************************
	/**
	 * 
	 * @return page Title of welcomepage
	 */
	public String getTitleOfWelcomePage()
	{
		return getPageTitle();
	}

	public boolean isGMOOnlineWordVisible()
	{
		return visiblilityOfElement(propOperation.getValue("gmoOnlineWord"));
	}
	public boolean isGMOOnlineButtonVisible() // 
	{
		return visiblilityOfElement(propOperation.getValue("gmoOnlineBtn"));
		//return visibilityOnWelcomePage("");
	}
	
	public boolean isAboutSiteButtonVisible() // 
	{
		return visibilityOnWelcomePage(propOperation.getValue("aboutGmoSiteBtn"));
	}
	
	public boolean isBrowseTestPageButtonVisible() // 
	{
		return visibilityOnWelcomePage(propOperation.getValue("browserTestPageBtn"));
	}
	
	public boolean isGMOOnlineButtonClickable() // 
	{
		return isElementClickable(propOperation.getValue("gmoOnlineBtn"));
		//return visibilityOnWelcomePage("");
	}
	
	public boolean isAboutSiteButtonClickable() // 
	{
		return isElementClickable(propOperation.getValue("aboutGmoSiteBtn"));
	}
	
	public boolean isBrowseTestPageButtonClickable() // 
	{
		return isElementClickable(propOperation.getValue("browserTestPageBtn"));
	}
	
	public OnLineCatalogPage clickGMOOnlineButton() throws IOException // 
	{
		click(propOperation.getValue("gmoOnlineBtn"));
		return OnLineCatalogPage.getInstance();
	}
	
	public void clickAboutSiteButton() // 
	{
		 click(propOperation.getValue("aboutGmoSiteBtn"));
	}
	
	public void clickBrowseTestPageButton() // 
	{
		 click(propOperation.getValue("browserTestPageBtn"));
	}
	public String getURLOfWelcomePage() {
		// TODO Auto-generated method stub
		return getPageURL();
	}
	
	public void takeLogoImage() throws IOException
	{
		takeElementScreenShot(propOperation.getValue("LogoImg"),"\\LogoImage");
		
	}
}
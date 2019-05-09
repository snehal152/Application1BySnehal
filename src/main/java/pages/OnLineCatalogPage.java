package pages;

import java.io.IOException;
import java.util.ArrayList;

import base.PredefinedActions;
import contant.ConstantPath;
import pages.OnLineCatalogPage.ITEM;
import pojo.OnlineCatelogPOJO;
import testScripts.TestBase;
import util.PropertyFileOperation;

public class OnLineCatalogPage extends PredefinedActions {


	private static OnLineCatalogPage onLineCatalogPage;
	private PropertyFileOperation propOperation;
	public enum ITEM{
		TENTS, BACKPACKS,BOOTS, SUNGLASS,SOCKS,SHORTS,
	}
	
	
	private OnLineCatalogPage() throws IOException
	{
		 propOperation = new PropertyFileOperation(ConstantPath.ONLINECATALOGPAGEPATH);
	}
	public static OnLineCatalogPage getInstance() throws IOException
	{
		if(onLineCatalogPage == null)
			onLineCatalogPage = new OnLineCatalogPage();
		return onLineCatalogPage;
	}
	
	public boolean isResetFormBtnVisible()
	{
		return visiblilityOfElement(propOperation.getValue("resetFormBtn"));
	}
	
	public boolean isSubmitBtnVisible()
	{
		return visiblilityOfElement(propOperation.getValue("placeAnOrderBtn"));
	}

	public boolean isResetFormBtnClickable()
	{
		return isElementClickable(propOperation.getValue("resetFormBtn"));
	}
	
	public boolean isSubmitBtnClickable()
	{
		return isElementClickable(propOperation.getValue("paceAnOrderBtn"));
	}
	
	public void clickResetFormBtn()
	{
		 click(propOperation.getValue("resetFormBtn"));
	}
	
	public void clickSubmitBtn()
	{
		 click(propOperation.getValue("placeAnOrderBtn"));
	}
	
	public OnLineCatalogPage orderQuantityDemoTent(int quantity)
	{
		setText(propOperation.getValue("QTY_TENTS"),String.valueOf(quantity),true);
		return this;
	}
	
	
	public OnLineCatalogPage orderQuantityFrameBackPack(int quantity)
	{
		setText(propOperation.getValue("QTY_BACKPACKS"),String.valueOf(quantity),true);
		return this;
	}
	
	
	public void setQuantity(OnlineCatelogPOJO onlineCatelogPOJO) {
		// TODO Auto-generated method stub
		if(onlineCatelogPOJO.getDemoTent()!=null&&!onlineCatelogPOJO.getDemoTent().equals(""))
			setText(propOperation.getValue("QYT_TENTS"), onlineCatelogPOJO.getDemoTent(), true);
		
		if(onlineCatelogPOJO.getFrameBackPack()!=null&&!onlineCatelogPOJO.getFrameBackPack().equals(""))
			setText(propOperation.getValue("QTY_BACKPACKS"), onlineCatelogPOJO.getFrameBackPack(), true);
		
		if(onlineCatelogPOJO.getSunGlasses()!=null&&!onlineCatelogPOJO.getSunGlasses().equals(""))
			setText(propOperation.getValue("QTY_GLASSES"), onlineCatelogPOJO.getSunGlasses(), true);
		
		if(onlineCatelogPOJO.getPaddedSocks()!=null&&!onlineCatelogPOJO.getPaddedSocks().equals(""))
			setText(propOperation.getValue("QTY_SOCKS"), onlineCatelogPOJO.getPaddedSocks(), true);
		
		if(onlineCatelogPOJO.getHikingBoot()!=null&&!onlineCatelogPOJO.getHikingBoot().equals(""))
			setText(propOperation.getValue("QTY_BOOTS"), onlineCatelogPOJO.getHikingBoot(), true);
		
		if(onlineCatelogPOJO.getBackCountryShorts()!=null&&!onlineCatelogPOJO.getBackCountryShorts().equals(""))
			setText(propOperation.getValue("QTY_SHORTS"), onlineCatelogPOJO.getBackCountryShorts(), true);
		
		
	}
	
	public OnlineCatelogPOJO getQuantity()
	{
		OnlineCatelogPOJO onlineCatelogPOJO=new OnlineCatelogPOJO();
		onlineCatelogPOJO.setDemoTent(getText(propOperation.getValue("QYT_TENTS")));
		onlineCatelogPOJO.setFrameBackPack(getText(propOperation.getValue("QTY_BACKPACKS")));;
		
		
		return onlineCatelogPOJO;
	}



	public String getQuantity(ITEM item)
	{
		
		if(item==ITEM.TENTS)
			return getAttributeValue(propOperation.getValue("QYT_TENTS"), "value");
		if(item==ITEM.BACKPACKS)
			return getAttributeValue(propOperation.getValue("QTY_BACKPACKS"), "value");
		if(item==ITEM.SUNGLASS)
			return getAttributeValue(propOperation.getValue("QTY_GLASSES"), "value");
		if(item==ITEM.SOCKS)
			return getAttributeValue(propOperation.getValue("QTY_SOCKS"), "value");
		if(item==ITEM.BOOTS)
			return getAttributeValue(propOperation.getValue("QTY_BOOTS"), "value");
		if(item==ITEM.SHORTS)
			return getAttributeValue(propOperation.getValue("QTY_SHORTS"), "value");
			
		
		return null;
		
	}
	
	public boolean verifyPlaceAnOrderAlertPresent()
	{
		return verifyAlertPresent();
	}
	
	public String getTextPlaceAnOrderAlert()
	{
		return handleAccept();
	}

	
	public ArrayList<Integer> getItemIds()
	{
		ArrayList<Integer> indexNumber = new ArrayList<Integer>();
		int totalRow = getTotalRowCount(propOperation.getValue("itemTable")); // 8
		int index = Integer.parseInt(getText(propOperation.getValue("itemNumber").replace("%x%", "2")))+1; // initial value 
		
		for(int i=3;i<totalRow;i++) // 8 [2-7]
		{
			int currentIndex = Integer.parseInt(getText(propOperation.getValue("itemNumber").replace("%x%", String.valueOf(i))));
			if(currentIndex == (index+1))
			{
				indexNumber.add(currentIndex);
			}
			index++;
		}
		return indexNumber;
	}
	public boolean verifyLink(ITEM item) {
		// TODO Auto-generated method stub
		if(item==ITEM.TENTS)
			return isElementClickable(propOperation.getValue("TENTS_Link"));
		if(item==ITEM.BACKPACKS)
			return isElementClickable(propOperation.getValue("BACKPACKS_Link"));
		if(item==ITEM.SUNGLASS)
			return isElementClickable(propOperation.getValue("SUNGLASS_Link"));
		if(item==ITEM.SOCKS)
			return isElementClickable(propOperation.getValue("SOCKS_Link"));
		if(item==ITEM.BOOTS)
			return isElementClickable(propOperation.getValue("BOOTS_Link"));
		if(item==ITEM.SHORTS)
			return isElementClickable(propOperation.getValue("SHORTS_Link"));
				
		return false;	
		
	}
	
	public String clickLink(ITEM item) {
		// TODO Auto-generated method stub
		if(item==ITEM.TENTS)
			 click(propOperation.getValue("TENTS_Link"));
		if(item==ITEM.BACKPACKS)
			 click(propOperation.getValue("BACKPACKS_Link"));
		if(item==ITEM.SUNGLASS)
			 click(propOperation.getValue("SUNGLASS_Link"));
		if(item==ITEM.SOCKS)
			 click(propOperation.getValue("SOCKS_Link"));
		if(item==ITEM.BOOTS)
			 click(propOperation.getValue("BOOTS_Link"));
		if(item==ITEM.SHORTS)
			 click(propOperation.getValue("SHORTS_Link"));
				
		return getPageURL();	
		
	}
	public String backToCatalogPage() {
		// TODO Auto-generated method stub
		return navigateToBack();
	}
	
	
}

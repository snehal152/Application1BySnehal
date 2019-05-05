package pages;

import java.io.IOException;

import base.PredefinedActions;
import contant.ConstantPath;
import pojo.OnlineCatelogPOJO;
import testScripts.TestBase;
import util.PropertyFileOperation;

public class OnLineCatalogPage extends PredefinedActions {


	private static OnLineCatalogPage onLineCatalogPage;
	PropertyFileOperation propOperation;
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
		return visiblilityOfElement(propOperation.getValue("paceAnOrderBtn"));
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
		 click(propOperation.getValue("paceAnOrderBtn"));
	}
	
	public void orderQuantityDemoTent(int quantity)
	{
		setText(propOperation.getValue(""), String.valueOf(quantity), true);
	}
	public void setQuantity(OnlineCatelogPOJO onlineCatelogPOJO) {
		// TODO Auto-generated method stub
		if(onlineCatelogPOJO.getDemoTent()!=null&&!onlineCatelogPOJO.getDemoTent().equals(""))
			setText(propOperation.getValue("QYT_TENTS"), onlineCatelogPOJO.getDemoTent(), true);
		
		if(onlineCatelogPOJO.getFrameBackPack()!=null&&!onlineCatelogPOJO.getFrameBackPack().equals(""))
			setText(propOperation.getValue("QTY_BACKPACKS"), onlineCatelogPOJO.getDemoTent(), true);
		
		if(onlineCatelogPOJO.getSunGlasses()!=null&&!onlineCatelogPOJO.getSunGlasses().equals(""))
			setText(propOperation.getValue("QYT_TENTS"), onlineCatelogPOJO.getDemoTent(), true);
		
		if(onlineCatelogPOJO.getHikingBoot()!=null&&!onlineCatelogPOJO.getHikingBoot().equals(""))
			setText(propOperation.getValue("QYT_TENTS"), onlineCatelogPOJO.getDemoTent(), true);
		
		if(onlineCatelogPOJO.getPaddedSocks()!=null&&!onlineCatelogPOJO.getPaddedSocks().equals(""))
			setText(propOperation.getValue("QYT_TENTS"), onlineCatelogPOJO.getDemoTent(), true);
		
		if(onlineCatelogPOJO.getBackCountryShorts()!=null&&!onlineCatelogPOJO.getBackCountryShorts().equals(""))
			setText(propOperation.getValue("QYT_TENTS"), onlineCatelogPOJO.getDemoTent(), true);
		
		
	}

}

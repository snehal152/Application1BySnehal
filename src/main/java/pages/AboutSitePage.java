package pages;

import java.io.IOException;

import base.PredefinedActions;
import contant.ConstantPath;
import util.PropertyFileOperation;

public class AboutSitePage extends PredefinedActions {

	private static AboutSitePage aboutSitePage;
	PropertyFileOperation propOperation;
	
	private AboutSitePage() throws IOException
	{
		propOperation = new PropertyFileOperation(ConstantPath.WELCOMEPAGEPATH);
	}
	
	public static AboutSitePage getInstance() throws IOException
	{
		if(aboutSitePage==null)
		{
			aboutSitePage=new AboutSitePage();
		}
		return aboutSitePage;
	}
}

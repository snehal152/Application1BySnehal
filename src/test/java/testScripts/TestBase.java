package testScripts;

import java.io.IOException;

import base.PredefinedActions;
import pages.WelcomePage;

public class TestBase {

	 WelcomePage start() throws IOException
	{
		PredefinedActions.initialization("https://demo.borland.com/gmopost/");
		return  WelcomePage.getInstance();
	}
	void stop()
	{
		PredefinedActions.closeBrower();
	}
}

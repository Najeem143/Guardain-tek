package tek.bdd.guardians.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import 
tek.bdd.guardians.utilities.CommonUtility;

public class BaseUIText extends CommonUtility {
	
	/*
     * @Before
     * is a Cucumber hook and we can write the code implementation in this method and the purpose of this method 
     * is to execute this block of code before each Scenario and Scenario Outline
     * 
     * For now we will just call the method setupBrowser()
     * 
     * @After
     * is a Cucumber hook and we can write the code implementation in this method and the purpose of this method
     * is to execute this block of code after each Scenario and Scenario Outline
     * 
     * For now we will check and see if scenario or scenario outline fails, so that it takes a screenshot of failed
     * test step for that test case and add it to our test report and then close the browser
     * 
     * Or if scenario and scenario outlines passes, so that it just closes the browser
     */
	
	@Before
	public void setupTest() {
		super.setupBrowser();
	}
	
	@After
	public void closeTests (Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenShot = takeScreenShotAsBytes();
			scenario.attach(screenShot,"image/png", scenario.getName() + "Scenario Failed");
			
		}
		super.quitBrowser();
		
	}
	
	
	

}

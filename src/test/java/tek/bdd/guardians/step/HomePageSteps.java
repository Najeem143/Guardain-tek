package tek.bdd.guardians.step;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import tek.bdd.guardians.pages.POMFactory;
import tek.bdd.guardians.utilities.CommonUtility;

public class HomePageSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();
	@Given("User is on retail website homepage")
	public void userIsOnRetailWebsiteHomepage() {
		Assert.assertTrue(pomFactory.homePage().tekSchoolLogo.isDisplayed());
		logger.info("TEKSCHOOL logo is displayed");
		
	    	}

}

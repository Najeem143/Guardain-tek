package tek.bdd.guardians.config;

import org.openqa.selenium.WebDriver;

public interface Browser {
	
	// we create this method and implement this method in each of the browser classes.
	
	WebDriver openBrowser(String url);

}

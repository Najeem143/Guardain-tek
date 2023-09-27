package tek.bdd.guardians.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.guardians.base.BaseSetup;

public class HomePage extends BaseSetup{
	//Will create one construct and by using the initElement method from PageFactory class we will 
	// initialize our page object in this class.

	
	public HomePage () {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//a[@class='top-nav__logo active']")

    public WebElement tekschoolLogo;
		
	}
	


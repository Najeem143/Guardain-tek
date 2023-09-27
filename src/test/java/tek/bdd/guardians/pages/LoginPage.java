

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import tek.bdd.guardians.base.BaseSetup;

 

public class LoginPage extends BaseSetup{


    public LoginPage() {

        PageFactory.initElements(getDriver(), this);

    }

 

    @FindBy(linkText = "Sign in")

    public WebElement signInLink;


    @FindBy(id = "email")

    public WebElement emailField;


    @FindBy(id = "password")

    public WebElement passwordField;


    @FindBy(xpath = "//button[text()='Login']")

    public WebElement loginBttn;


    @FindBy(id = "logoutBtn")

    public WebElement logoutBttn;


    @FindBy(id = "newAccountBtn")

    public WebElement newAccountBttn;


    @FindBy(id = "nameInput")

    public WebElement nameInputField;


    @FindBy(id = "emailInput")

    public WebElement emailInputField;


    @FindBy(id = "passwordInput")

    public WebElement passwordInputField;


    @FindBy(id = "confirmPasswordInput")

    public WebElement confirmPassInputField;


    @FindBy(id = "signupBtn")

    public WebElement signupBttn;


    @FindBy(xpath = "//h1[text()='Your Profile']")

    public WebElement yourProfileText;




}
package tek.bdd.guardians.pages;

import tek.bdd.guardians.base.BaseSetup;

public class POMFactory extends BaseSetup{

    private HomePage homePage;
    private LoginPage loginPage;

    public POMFactory() {
        this.homePage = new HomePage();
        this.loginPage = new LoginPage();
    }

    public HomePage homePage() {
        return this.homePage;
    }

    public LoginPage loginPage() {
        return this.loginPage;
    }

 

    
}
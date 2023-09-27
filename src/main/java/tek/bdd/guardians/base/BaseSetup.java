package tek.bdd.guardians.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import tek.bdd.guardians.config.Browser;
import tek.bdd.guardians.config.ChromeBrowser;
import tek.bdd.guardians.config.ChromeHeadless;
import tek.bdd.guardians.config.EdgeBrowser;
import tek.bdd.guardians.config.FireFoxBrowser;
import tek.bdd.guardians.utilities.ReadYamlFiles;

public class BaseSetup {
	private static WebDriver webDriver;
	private final ReadYamlFiles enviormentVariables;
	public static Logger logger;

	public BaseSetup() {
		// we need the path to env_config file and store it in a String variable
		String filePath = System.getProperty("user.dir" + "/src/main/resources/env_config.yml");

		// we need the path to the log4j.porperties fine and store it in String Variable
		String log4jPath = System.getProperty("user.dir" + "/src/main/resources/log4j.properties");

		try {
			enviormentVariables = ReadYamlFiles.getInstance(filePath);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("Failed for load eviroment context. Check possible file path");
			throw new RuntimeException("Failed to load evn_config file: " + e.getMessage());

		}

		// initilize our Logger

		logger = logger.getLogger("file_Name");
		PropertyConfigurator.configure(log4jPath);

	}

	// this method will return an instance of webDriver.
	// it is same as in Selenium we used the reference to WebDriver instance
	// (driver)
	public WebDriver getDriver() {
		return webDriver;
	}
	// to get the enviroment configuration from the env_config file and setup
	// browser

	public void setupBrowser() {
		HashMap uiProperties = enviormentVariables.getYamlProperty("ui");

		String url = uiProperties.get("url").toString().toLowerCase();
		Browser browser;

		switch (uiProperties.get("brwoser").toString().toLowerCase()) {

		case "chrome":
			if ((boolean) uiProperties.get("headless")) {
				browser = new ChromeHeadless();

			} else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;

		case "firefox":
			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;

		case "Edge":
			browser = new EdgeBrowser();
			break;
		default:
			throw new RuntimeException("Browser name in config did not match any of the cases");

		}

		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	// close the browsers

	public void quitBrowser() {

		if (webDriver != null)
			webDriver.quit();
	}

}

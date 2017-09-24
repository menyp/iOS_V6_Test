package Native;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.xml.sax.SAXException;

import com.applitools.eyes.Eyes;

//MobileElement e2; //test will wait for this diring 20 seconds
enum EnvironmentMode {
	Prod, Staging, Development, Demo
}
	
//MobileElement e2; //test will wait for this diring 20 seconds

  public class SanityIos {
	  
	@WithTimeout(time = 30, unit = TimeUnit.SECONDS)
	@iOSFindBy (id = "relevant id need to be added here")

	
	String currentDateFolder;
	String webElementXmlLang;
	String webElementXmlPath;
	String StartServerPath;
	String StopServerPath;
	String appIdentifier;
	

	IOSDriver<MobileElement> driver;
	IosMethods genMeth = new IosMethods();
	Eyes eyes = new Eyes();
	Boolean useEye;
	boolean  skipfailure = true;
	IosElements iosData;
	EnvironmentMode EnvMode;
	AppiumDriverLocalService service;


	
	
	@BeforeSuite(alwaysRun = true)
	public void setupBeforeSuite(ITestContext context) throws ParserConfigurationException, SAXException, IOException, InterruptedException, jdk.internal.org.xml.sax.SAXException {
		
        // This is your api key, make sure you use it in all your tests.
		//Set the tests configuration
		webElementXmlPath = genMeth.getValueFromPropFile("webElementXmlPath");
		webElementXmlLang = genMeth.getValueFromPropFile("webElementXmlLang");
		
		//Set the tests configuration
		EnvMode = genMeth.UserSetEnvironmentMode(EnvMode);
		useEye = genMeth.UseEye();
		
		
		iosData = genMeth.setElements(webElementXmlPath, webElementXmlLang);
		//service = genMeth.startAppiumService();

		driver = genMeth.setCapabilitiesIos(genMeth);
		//genMeth.eyesCheckWindow("Test", useEye, genMeth, skipfailure);

		genMeth.cleanLoginIos(genMeth, EnvMode);
	}

	@BeforeMethod (alwaysRun = true)
	public void checkHomeScreen() throws InterruptedException, IOException, ParserConfigurationException, SAXException, jdk.internal.org.xml.sax.SAXException{


		// Check if the client still logged in & in StartUp screen before each test
		if (driver == null) {
			try {
//				driver.removeApp(genMeth.getValueFromPropFile("appPackage"));
				//driver.quit();
				driver = genMeth.setCapabilitiesIos(genMeth);
				genMeth.cleanLoginIos(genMeth, EnvMode);
				
			} catch (Exception e) {
				// swallow if fails
				
			}
			
		}

		else {
			
			boolean StartUpScreenDisplay = genMeth.checkIsElementVisible( By.id("Applications"));

			if (StartUpScreenDisplay != true) {

				try {
					/*
					genMeth.clickId(genMeth, iosData.BTNsettingsIconXpth);
					driver.findElementById(iosData.BTNlogoutName).click();
					//genMeth.clickId(genMeth, iosData.BTNlogoutName);			
					driver.removeApp(appIdentifier);
					driver.quit();
					*/
					
					//reset app -->  reinstall the app (login screen will be displayed)
					driver.resetApp();
					//driver.resetApp();   

					
				} catch (Exception e) {
					driver.quit();
					// swallow if fails
				}
				
				/*
				try {
					driver.removeApp(appIdentifier);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
					driver.quit();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

*/
				
				//driver = genMeth.setCapabilitiesIos(genMeth);
				//iosData = genMeth.setElements(webElementXmlPath, webElementXmlLang);
				genMeth.releaseAllow(genMeth);
				genMeth.cleanLoginIos(genMeth, EnvMode);

			}

		}

	}
		
	
	@Test(enabled = true, testName = "Bad Credentials", retryAnalyzer = Retry.class, description = "Bad Credentials",
			groups = { "Sanity IOS" })

	public void logins_BadCredentials() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {

		//Sign out from the Application screen
		genMeth.signOutFromStartup(genMeth);
		
		//Attempt to login with Empty Credentials
		genMeth.clickId(genMeth, iosData.BTNloginID);
		genMeth.eyesCheckWindow("(iOS_V6) Logins_BadCredentials- Empty credentials", useEye, genMeth, skipfailure);
		genMeth.releaseOK(genMeth);
		
		// Attempt to login with Empty Password
		genMeth.sendId(genMeth, "Username", iosData.userQA);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		genMeth.eyesCheckWindow("(iOS_V6) Logins_BadCredentials- Empty Password", useEye, genMeth, skipfailure);
		genMeth.releaseOK(genMeth);
		genMeth.clickId(genMeth, iosData.userQA);
		genMeth.clickId(genMeth, iosData.BTNclearText);
		
		
		// Attempt to login with Empty Username
		genMeth.sendId(genMeth, "Password", iosData.passwordQA);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		genMeth.eyesCheckWindow("(iOS_V6) Logins_BadCredentials- Empty Username", useEye, genMeth, skipfailure);
		genMeth.releaseOK(genMeth);
		
		//Login with incorrect Credentials
		genMeth.sendId(genMeth, "Username", iosData.badPassword);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		genMeth.eyesCheckWindow("(iOS_V6) Logins_BadCredentials- - Incorrecr User or password", useEye, genMeth,skipfailure);
		genMeth.releaseOK(genMeth);
		
		//Clear Fields
		genMeth.clickId(genMeth, iosData.badPassword);
		genMeth.clickId(genMeth, iosData.BTNclearText);
		genMeth.clickId(genMeth, "•••");
		genMeth.clickId(genMeth, iosData.BTNclearText);
		
		//Login with user without app permissions
		genMeth.sendId(genMeth, "Username", iosData.UserNoAppsPermissions);
		genMeth.sendId(genMeth, "Password", iosData.passwordQA);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6) Logins_BadCredentials- - No Apps Permissions", useEye, genMeth,skipfailure);
		genMeth.signOutFromStartup(genMeth);

		//Login with inactive user
		genMeth.sendId(genMeth, "Username", iosData.UserinActive);
		genMeth.sendId(genMeth, "Password", iosData.passwordQA);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6) Logins_BadCredentials- - InActive user", useEye, genMeth,skipfailure);
		genMeth.releaseOK(genMeth);
		
		//Login with 1Password
		genMeth.clickId(genMeth, "login 1password icon dark");
		genMeth.clickId(genMeth, "1Password");
		genMeth.sendId(genMeth, "Master Password", "Trustno1");
		genMeth.clickId(genMeth, "Go");
		genMeth.clickId(genMeth, "Show all Logins");
		genMeth.clickId(genMeth, "Appium@v6.com");
		genMeth.clickId(genMeth, iosData.BTNloginID);

		
		//Login to the sample app
		genMeth.signOutFromStartup(genMeth);
		genMeth.clickId(genMeth, "Sample Account");
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6) Logins_BadCredentials- - Sample App", useEye, genMeth,skipfailure);
		genMeth.signOutFromStartup(genMeth);

		
		// Login with correct credentials (go back to Application screen)
		genMeth.sendId(genMeth, "Username", iosData.userQA);
		genMeth.sendId(genMeth, "Password", iosData.passwordQA);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		genMeth.eyesCheckWindow("(iOS_V6) Applications screen", useEye, genMeth, skipfailure);
		
		
	}

		
	@Test(enabled = true, testName = "environmentsScreen", retryAnalyzer = Retry.class, description = "environmentsScreen",
			groups = { "Sanity IOS" })

	public void environmentsScreen() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {
		

		//Sign out from the Application screen
		String DevAuthorizationURL = "http://SGDS-dev.cloudapp.net/auth/oauth2/token";
		String DevDistributionURL = "https://SGDS-dev.cloudapp.net/PublisherAPIV2/api/V2";
		String DevClient_ID = "099153c2625149bc8ecb3e85e03f0022";
		String DevClient_Secret = "IxrAjDoa2FqElO7IhrSrUJELhUckePEPVpaePlS_Xaw";
		
		genMeth.signOutFromStartup(genMeth);
		
		//Open the ENV screen
		genMeth.clickId(genMeth, iosData.IconLoginSettings);
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- Default ENV chosen", useEye, genMeth, skipfailure);
		
		//Choose Demo ENV
		genMeth.clickId(genMeth, "Demo");
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- Demo ENV chosen", useEye, genMeth, skipfailure);

		//Add new ENV
		genMeth.clickId(genMeth, "Add environment");
		
		//Open QR
		genMeth.clickId(genMeth, "Fill From Barcode");
		genMeth.releaseOK(genMeth);
		Thread.sleep(2000);
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- QR Open", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.IconCancelENV);
		
		//Open Type
		genMeth.clickId(genMeth, "Type");
		genMeth.clickId(genMeth, "TAG");
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- Type = TAG", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, "SkyGiraffe");
		genMeth.clickId(genMeth, iosData.IconBack);
		
		//ENV Label
		genMeth.sendId(genMeth, "Environment Label", "Customized ENV - Dev");
		
		//Publisher
		genMeth.sendId(genMeth, "https://www.example.com", DevDistributionURL);
		genMeth.closeKeyborad();

		//Authentication
		genMeth.sendId(genMeth, "https://www.example.com", DevAuthorizationURL);
		genMeth.closeKeyborad();

		//Client id
		genMeth.sendId(genMeth, "Required", DevClient_ID);
		genMeth.closeKeyborad();

		// Client secret
		genMeth.sendId(genMeth, "Required", DevClient_Secret);
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- All ENV set", useEye, genMeth, skipfailure);

		genMeth.clickId(genMeth, iosData.BTNadd);
		
		//Need to press it till bug # will be fixed
		genMeth.clickId(genMeth, "Customized ENV - Dev");
		
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- Customized ENV was chosen", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.IconCancelENV);
		
		// Login with correct credentials (go back to Application screen)
		genMeth.sendId(genMeth, "Username", iosData.userQA);
		genMeth.sendId(genMeth, "Password", iosData.passwordQA);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6) Applications screen", useEye, genMeth, skipfailure);
		
		
		
		//Reopen customize ENV
		genMeth.signOutFromStartup(genMeth);
		genMeth.clickId(genMeth, iosData.IconLoginSettings);
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- Customized ENV was chosen", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, "Development");

		/*

		//Edit Customize ENV by swipe
		Thread.sleep(2000);
		//TouchAction ta = new TouchAction(driver);
		driver.swipe(320, 370, 150, 370, 2000);
		genMeth.clickId(genMeth, "Edit  ");
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- Edit Customized ENV", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.IconCancelENV);
		
		//Delete Customize ENV by swipe
		Thread.sleep(2000);
		driver.swipe(300, 370, 100, 370, 2000);
		genMeth.clickId(genMeth, iosData.BTNdelete);
		genMeth.eyesCheckWindow("(iOS_V6) environmentsScreen- Customized ENV was deleted", useEye, genMeth, skipfailure);
*/
		
		//Go Back to the Application Screen
		genMeth.clickId(genMeth, iosData.IconCancelENV);
		genMeth.sendId(genMeth, "Username", iosData.userQA);
		genMeth.sendId(genMeth, "Password", iosData.passwordQA);
		genMeth.clickId(genMeth, iosData.BTNloginID);
		genMeth.eyesCheckWindow("(iOS_V6) Applications screen", useEye, genMeth, skipfailure);
		

	}
	
	@Test(enabled = true, testName = "environmentsScreen", retryAnalyzer = Retry.class, description = "environmentsScreen",
			groups = { "Sanity IOS" })

	public void EmployeeDirectory_Person() throws ParserConfigurationException, SAXException,
			IOException, InterruptedException {
		

		//Open the SQL Golden V6 App
		genMeth.clickId(genMeth, "SQL Golden V6");
		
		//Open the ED report
		genMeth.clickId(genMeth, "ED");
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - main screen", useEye, genMeth, skipfailure);
		
		//Search a non existing user
		genMeth.clickId(genMeth, "nav icon search");
		genMeth.sendId(genMeth, "Search", "non existing user");
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Non Existing user", useEye, genMeth, skipfailure);

		//Close & open the search field
		genMeth.clickId(genMeth, "nav icon search");
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Close search field", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, "nav icon search");
		
		//Clear search filed
		genMeth.clickId(genMeth, iosData.BTNclearText);
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Clear search field", useEye, genMeth, skipfailure);
		
		//Search an employee
		genMeth.sendId(genMeth, "Search", "steve");
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Search steve", useEye, genMeth, skipfailure);

		
		//Open the employee (go to profile tab)
		genMeth.clickId(genMeth, "Steve Jonson");
		Thread.sleep(4000); 		
		
		//Check the advanced columns
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Steve advanced columns upper side", useEye, genMeth, skipfailure);
		
		// Open Phone
		genMeth.clickId(genMeth, "Phone");
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Phone", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNCancel);
		
		// Open Email
		genMeth.clickId(genMeth, "Email");
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Email", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNCancel);
		genMeth.clickId(genMeth, iosData.BTNdeleteDraft);
		genMeth.clickId(genMeth, "Email");
		genMeth.clickId(genMeth, iosData.BTNsend);
		
		//Address
		genMeth.clickId(genMeth, "Address");
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Address", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNCancel);
		
		//Mini Map
		
		genMeth.swipeDownIphone6(1, 1000);
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Steve advanced columns down side", useEye, genMeth, skipfailure);
		
		//Landline
		genMeth.clickId(genMeth, "Landline");
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Landline", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNCancel);
		
		//Navigate to manager
		genMeth.clickId(genMeth, "Manager Name");
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6)- EmployeeDirectory_Person - Navigate to manager", useEye, genMeth, skipfailure);
		
		//Go back to the ED main screen
		genMeth.clickId(genMeth, "Profile");
		genMeth.clickId(genMeth, "ED");
		//Waiting for element id's from Limor
		genMeth.clickXpth(genMeth, "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");
		Thread.sleep(2000);
		genMeth.clickXpth(genMeth, "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");

	}
	
	@Test(enabled = true, testName = "Grid_AdvancedColumns", retryAnalyzer = Retry.class, description = "Grid_AdvancedColumns",
			groups = { "Sanity IOS" })

	public void Grid_AdvancedColumns()
			throws ParserConfigurationException, SAXException, IOException, InterruptedException {

		// Open the SQL Golden V6 App
		genMeth.clickId(genMeth, "SQL Golden V6");

		// Open Grid tab
		genMeth.clickId(genMeth, "Grid");
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - main screen", useEye, genMeth, skipfailure);

		genMeth.swipeDownIphone6(4, 1000);
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - Scroll Down", useEye, genMeth, skipfailure);

		genMeth.swipeUpIphone6(4, 1000);
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - Scroll Up", useEye, genMeth, skipfailure);

		// Address
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[5]/XCUIElementTypeOther[1]/XCUIElementTypeImage[1]");
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - Address maps", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNCancel);

		// Mobile Phone
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[6]/XCUIElementTypeOther[1]/XCUIElementTypeImage[1]");
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - Mobile Phone", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNCancel);

		// Email
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[7]/XCUIElementTypeOther[1]/XCUIElementTypeImage[1]");
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - Email", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNsend);

		// Landline
		Thread.sleep(1000);
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[8]/XCUIElementTypeOther[1]/XCUIElementTypeImage[1]");
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - Landline", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNCancel);

		// URL
		genMeth.swipeRightIphone6(1, 1000);
		genMeth.clickId(genMeth, "www.milliondollarhomepage.com");
		Thread.sleep(5000);
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - URL Page is open", useEye, genMeth, skipfailure);
		genMeth.clickId(genMeth, iosData.BTNdone);

		genMeth.swipeRightIphone6(1, 1000);
		genMeth.eyesCheckWindow("(iOS_V6)- Grid_AdvancedColumns - Swipe right (Icon,Precentage,Currency)", useEye,
				genMeth, skipfailure);

		// Go back to the ED main screen
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");

	}

	public void List_Regular_AdvancedColumns()
			throws ParserConfigurationException, SAXException, IOException, InterruptedException {

		// Open the SQL Golden V6 App
		genMeth.clickId(genMeth, "SQL Golden V6");

		// Go back to the ED main screen
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");
		genMeth.clickXpth(genMeth,
				"//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");

	}
	
	
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
		
		if (driver != null){
		try {
			//driver.resetApp();   -->  reinstall the app (login screen will be displayed)
			
			//Logout from the app
			genMeth.signOutFromStartup(genMeth);	
			
			//Not sure why it doesn't uninstall the app (deprecated?)
			driver.removeApp(appIdentifier);
			driver.quit();
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//service.stop();
			driver.quit();

			e.printStackTrace();
		}
		}
		else{
			driver.quit();
			//service.stop();
			
		}

		SendResults sr = new SendResults("elicherni444@gmail.com",
				"meny@skygiraffe.com", "TestNG results", "Test Results");
		//sr.sendTestNGResult();
		sr.sendRegularEmail();
		/*
		TestListenerAdapter tla = new TestListenerAdapter();
		TestNG testng2 = new TestNG();
		testng2.setTestClasses(new Class[] { SendReport.class });
		testng2.setGroups("send mail");
		testng2.addListener(tla);
		testng2.run();
*/
	}
	
	
	
  }
  
  
  






package settings;

import testcases.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.android.Activity;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by: Al Imran on 21/09/2018.
 * Email: imranreee@gmail.com
 **/

public class RunCases extends AndroidSettings {
    /******************************
     Run the cases from here
     ******************************/

    /*@Test(retryAnalyzer = RetryAnalyzer.class, priority = 1)
    public void am005FirstOnBoardingPageTest() throws Exception {
        new AM005FirstOnBoardingPage(driver).am005FirstOnBoardingPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 2)
    public void am006SecondOnBoardingPageTest() throws Exception {
        new AM006SecondOnBoardingPage(driver).am006SecondOnBoardingPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 3)
    public void am007ThirdOnBoardingPageTest() throws Exception {
        new AM007ThirdOnBoardingPage(driver).am007ThirdOnBoardingPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 4)
    public void am008OnBoardingSkipBtnTest() throws Exception {
        new AM008OnBoardingSkipBtn(driver).am008OnBoardingSkipBtn();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 5)
    public void am009SignInAndUpPageTest() throws Exception {
        new AM009SignInAndUpPage(driver).am009SignInAndUpPage();
    }

    */

    /*@Test(retryAnalyzer = RetryAnalyzer.class, priority = 6)
    public void am013ContinueWithFacebookTest() throws Exception {
        new AM013ContinueWithFacebook(driver).am013ContinueWithFacebook();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 7)
    public void am015ContinueWithGoogleTest() throws Exception {
        new AM015ContinueWithGoogle(driver).am015ContinueWithGoogle();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 8)
    public void am019ContinueWithTwitterTest() throws Exception {
        new AM019ContinueWithTwitter(driver).am019ContinueWithTwitter();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 9)
    public void am020SignUpTest() throws Exception {
        new AM020SignUp(driver).am020SignUp();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 10)
    public void am021SignInTest() throws Exception {
        new AM021SignIn(driver).am021SignIn();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 11)
    public void am022InvalidSignInTest() throws Exception {
        new AM022InvalidSignIn(driver).am022InvalidSignIn();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 12)
    public void am023SkipBtnSignInPageTest() throws Exception {
        new AM023SkipBtnSignInPage(driver).am023SkipBtnSignInPage();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 13)
    public void am024ForgotPasswordTest() throws Exception {
        new AM024ForgotPassword(driver).am024ForgotPassword();
    }


    */


    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 14)
    public void am026BottomNavigationButtonsTest() throws Exception {
        new AM026BottomNavigationButtons(driver).am026BottomNavigationButtons();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 15)
    public void am027BottomProfileButtonTest() throws Exception {
        new AM027BottomProfileButton(driver).am027BottomProfileButton();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 16)
    public void am028BottomMoreButtonTest() throws Exception {
        new AM028BottomMoreButton(driver).am028BottomMoreButton();
    }

    @Test(retryAnalyzer = RetryAnalyzer.class, priority = 16)
    public void am029BottomButtonFlipTest() throws Exception {
        new AM029BottomButtonFlip(driver).am029BottomButtonFlip();
    }

























    /******************************
     Run the cases End
     ******************************/

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh-mm-ssaa");
    Date date = new Date();
    String currentDate = dateFormat.format(date);

    DateFormat dateFormatNew = new SimpleDateFormat("dd-MMM-yyyy");
    Date dateNew = new Date();
    String currentDateNew = dateFormatNew.format(dateNew);

    public static String readExcelPath = System.getProperty("user.dir") + "\\src\\test\\java\\utils\\manualtestcase\\TCOfAskMesh.xlsx";
    public static String writeExcelPath = System.getProperty("user.dir") + "\\src\\test\\java\\utils\\excelreport\\Result.xlsx";
    public static String appPath = System.getProperty("user.dir") + "\\src\\test\\java\\utils\\apk\\"+Credentials.apkFileName;
    public static int rowNum = 0;
    public static boolean bool = true ;

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidForAppium();
    }

    @BeforeTest
    public void config() throws Exception {
        File file = new File(System.getProperty("user.dir") + "\\src\\test\\java\\utils\\extentreport\\" + currentDateNew);
        if (!file.exists()) {
            file.mkdir();
        } else {

        }

        htmlReporter = new ExtentHtmlReporter(file + "\\AutomationTestResult"+ Credentials.appName + "_" + Credentials.appVersion + "_" + currentDate + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("Machine", Credentials.machine);
        extent.setSystemInfo("Platform Name", "Android");
        extent.setSystemInfo("Application Name", Credentials.appName);
        extent.setSystemInfo("Application Version", Credentials.appVersion);
        extent.setSystemInfo("User Name", Credentials.userName);

        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Automation Test Results");
        htmlReporter.config().setReportName("Automation Test Results of " + Credentials.appName + "_" + Credentials.appVersion+" Android App");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @AfterMethod
    public void getResult(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE && bool == true) {
            String screenShotPath = GetScreenshot.capture(driver, result.getName() + "_" + currentDate);
            ExcelWrite.writeData(writeExcelPath, 0, rowNum, 8, "Failed");

            //For restarting the app if any case is failed
            Activity activity = new Activity(Credentials.appPackage, Credentials.appActivity);
            driver.startActivity(activity);

            //Automatic issue create on the JIRA, row and column number depend on the excel file
            /*Jira jr = new Jira();
            jr.issueTitle = ExcelRead.readData(RunCases.readExcelPath, 0, RunCases.rowNum, 2);
            jr.issueDescription = ExcelRead.readData(RunCases.readExcelPath, 0, RunCases.rowNum, 5);
            jr.screenshotPath = screenShotPath;
            jr.setUp();
            jr.logInJira();
            jr.tearDown();*/

        } else if (result.getStatus() == ITestResult.SUCCESS && bool == true) {
            ExcelWrite.writeData(writeExcelPath, 0, rowNum, 8, "Passed");
        } else if (result.getStatus() == ITestResult.SKIP && bool == true) {
            ExcelWrite.writeData(writeExcelPath, 0, rowNum, 8, "Skipped");
        }else {
            ExcelWrite.writeData(writeExcelPath, 0, rowNum, 8, "NA for AT");
            ExcelWrite.writeData(writeExcelPath, 0, rowNum, 9, "Not applicable for Automation testing");
            bool = true;
        }
    }

    @AfterTest
    public void tearDown() {
        extent.flush();
    }

    @AfterClass
    public void endTest() {
        driver.quit();
    }

}

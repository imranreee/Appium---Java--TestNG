package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.fail;

/**
 * Created by: Al Imran on 21/09/2018.
 * Email: imranreee@gmail.com
 **/

public class Jira {

    //Change below credentials as per the needs
    String projectNameText = "Music Mesh Sync (MMS)";
    String JIRA_ID = "imran_qa";
    String JIRA_PW = "Im730729";
    String projectUrl = "MMS/";
    String issueTypeText = "Bug";

    //----------------------------------------------------

    String issueTitle;
    String issueDescription;
    String screenshotPath;

    private WebDriver driver;
    private String baseUrl;

    By idField = By.xpath("//*[@id=\"login-form-username\"]");
    By pwField = By.xpath("//*[@id=\"login-form-password\"]");
    By loginBtn = By.xpath("//*[@id=\"login-form-submit\"]");
    By browseBtn = By.xpath("//*[@id=\"create-issue-dialog\"]/div[2]/div[1]/div/form/div[1]/div[2]/fieldset/div/div/span/button");
    By createBtn = By.id("create_link");
    By issueTypeField = By.id("issuetype-field");
    By projectName = By.id("project-field");
    By summaryField = By.id("summary");
    By descriptionField = By.id("description");

    private final StringBuffer verificationErrors = new StringBuffer();

    @BeforeTest
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "E:\\DRIVER\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        baseUrl = "https://projects.leftofthedot.com:8443/projects/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void logInJira() throws Exception {

        driver.get(baseUrl + projectUrl);

        driver.findElement(idField).click();
        Thread.sleep(1000);
        driver.findElement(idField).sendKeys(JIRA_ID);

        driver.findElement(pwField).click();
        Thread.sleep(1000);
        driver.findElement(pwField).sendKeys(JIRA_PW);

        Thread.sleep(1000);
        driver.findElement(loginBtn).click();

        waitForClickabilityOf(createBtn);
        driver.findElement(createBtn).click();
        System.out.println("Clicked on the create button");

        waitForClickabilityOf(projectName);
        driver.findElement(projectName).click();
        driver.findElement(projectName).clear();
        driver.findElement(projectName).sendKeys(projectNameText);
        waitForClickabilityOf(descriptionField);

        driver.findElement(descriptionField).click();
        waitForClickabilityOf(issueTypeField);

        driver.findElement(issueTypeField).click();
        driver.findElement(issueTypeField).clear();
        driver.findElement(issueTypeField).sendKeys(issueTypeText);

        waitForClickabilityOf(descriptionField);
        driver.findElement(descriptionField).click();

        waitForClickabilityOf(summaryField);
        driver.findElement(summaryField).click();
        driver.findElement(summaryField).sendKeys(issueTitle);

        waitForClickabilityOf(descriptionField);
        driver.findElement(descriptionField).click();
        driver.findElement(descriptionField).sendKeys(issueDescription);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement Element = driver.findElement(browseBtn);
        js.executeScript("arguments[0].scrollIntoView();", Element);

        waitForClickabilityOf(browseBtn);
        driver.findElement(browseBtn).click();

        StringSelection ss = new StringSelection(screenshotPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot;
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }


    @AfterTest
    public void tearDown() throws Exception {
        //driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }


    protected void waitForClickabilityOf(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}

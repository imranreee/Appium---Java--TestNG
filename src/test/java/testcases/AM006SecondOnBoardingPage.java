package testcases;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.support.PageFactory;
import settings.*;

import java.util.Map;

import static settings.Credentials.*;

public class AM006SecondOnBoardingPage extends BaseClass {

    @AndroidFindBy(id = "mi_image")
    WebElement onBoardingPageImg;

    @AndroidFindBy(id = "mi_button_back")
    WebElement skipBtn;

    @AndroidFindBy(id = "mi_button_next")
    WebElement nextBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share your knowledge by answering the question']")
    WebElement secondPageDescription;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Take public opinion by creating the photo poll']")
    WebElement thirdPageDescription;


    public AM006SecondOnBoardingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public AM006SecondOnBoardingPage am006SecondOnBoardingPage() throws Exception {
        RunCases.rowNum = 12;
        for (int i = 1; i < 10; i++){
            String value = ExcelRead.readData(RunCases.readExcelPath, 0, RunCases.rowNum, i);
            ExcelWrite.writeData(RunCases.writeExcelPath, 0, RunCases.rowNum, i, value);
        }

        Activity activity = new Activity(appPackage, appActivity);
        ((AndroidDriver)driver).startActivity(activity);

        waitForVisibilityOfWe(onBoardingPageImg);
        System.out.println("Application on the OnBoarding page and page image found");


        nextBtn.click();
        waitForVisibilityOfWe(secondPageDescription);
        System.out.println("On the second page");

        waitForVisibilityOfWe(skipBtn);
        System.out.println("Skip button found");

        waitForVisibilityOfWe(onBoardingPageImg);
        System.out.println("Page image found");

        nextBtn.click();
        waitForVisibilityOfWe(thirdPageDescription);
        System.out.println("Next button worked, app on the third onBoarding page");

        return new AM006SecondOnBoardingPage(driver);
    }
}

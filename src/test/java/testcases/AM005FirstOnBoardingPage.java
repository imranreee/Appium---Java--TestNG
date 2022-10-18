package testcases;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import settings.BaseClass;
import settings.ExcelRead;
import settings.ExcelWrite;
import settings.RunCases;

public class AM005FirstOnBoardingPage extends BaseClass {

    @AndroidFindBy(id = "mi_image")
    WebElement onBoardingPageImg;

    @AndroidFindBy(id = "mi_description")
    WebElement pageDescription;

    @AndroidFindBy(id = "mi_button_back")
    WebElement skipBtn;

    @AndroidFindBy(id = "mi_button_next")
    WebElement nextBtn;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Share your knowledge by answering the question']")
    WebElement secondPageDescription;


    public AM005FirstOnBoardingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public AM005FirstOnBoardingPage am005FirstOnBoardingPage() throws Exception {
        RunCases.rowNum = 11;
        for (int i = 1; i < 10; i++){
            String value = ExcelRead.readData(RunCases.readExcelPath, 0, RunCases.rowNum, i);
            ExcelWrite.writeData(RunCases.writeExcelPath, 0, RunCases.rowNum, i, value);
        }

        waitForVisibilityOfWe(onBoardingPageImg);
        System.out.println("Application on the OnBoarding page and page image found");

        waitForVisibilityOfWe(pageDescription);
        System.out.println("Page description found");

        nextBtn.click();
        waitForVisibilityOfWe(secondPageDescription);
        System.out.println("On the second page, next button worked as expected");

        return new AM005FirstOnBoardingPage(driver);
    }
}

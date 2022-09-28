package com.otelz.pages;

import com.otelz.utility.TestUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    TestUtility testUtility;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(id = "com.otelz.mobil:id/tvSearchHome")
    MobileElement searchBar;

    @FindBy(id = "com.otelz.mobil:id/search_src_text")
    MobileElement searchInputField;

    @FindBy(id = "com.otelz.mobil.search:id/constraintSearch")
    MobileElement targetResult;

    @FindBy(id = "com.otelz.mobil:id/layoutCheckInDate")
    MobileElement dateMenu;

    @AndroidFindBy(id = "com.otelz.mobil:id/month_view")
    MobileElement dateTable;

//    @FindAll(
//            @FindBy(id ="com.otelz.mobil:id/tv_day_number")
//    )
//    List<WebElement>  days;

    String dayNumberFinder = "com.otelz.mobil:id/tv_day_number";

    @FindBy(id = "com.otelz.mobil:id/relativeBtnChooseDate")
    MobileElement confirmDateButton;

    @FindBy(id = "com.otelz.mobil:id/llSearchHome")
    MobileElement searchButton;


    public void searchHotel() {
        searchBar.click();
        searchInputField.sendKeys("Ankara");
        targetResult.click();
        TestUtility.sleep(2);
    }

    public void selectDate(int checkInDate, int checkOutDate) {
        dateMenu.click();
        List<MobileElement> days = dateTable.findElements(By.id(dayNumberFinder));
        for (WebElement day : days) {
            String n = day.getText();
            if (n.equals(String.valueOf(checkInDate))) {
                day.click();
            }
        }

        days = dateTable.findElements(By.id(dayNumberFinder));
        for (WebElement day : days) {
            String n = day.getText();
            if (n.equals(String.valueOf(checkOutDate))) {
                day.click();
            }
        }
        confirmDateButton.click();
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

}

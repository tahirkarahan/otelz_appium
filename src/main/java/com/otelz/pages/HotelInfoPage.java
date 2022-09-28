package com.otelz.pages;

import com.otelz.utility.TestUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HotelInfoPage {

    WebDriver driver;
    TestUtility testUtility;

    public HotelInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(id = "com.otelz.mobil:id/tvFacilityDetailName")
    MobileElement name2;

    @FindBy(id = "com.otelz.mobil:id/tv_best_price_total_price_value")
    MobileElement price2;

    @FindBy(id = "com.otelz.mobil:id/btnChooseRoom")
    MobileElement optionsButton;

    @FindBy(id = "com.otelz.mobil:id/tvPersonCount")
    MobileElement chooseRoomButton;

    @FindBy(id = "com.otelz.mobil:id/btnMakeReservation")
    MobileElement bookingButton;


    public String getTargetHotelName() {
        return name2.getText().trim();
    }

    public String getTargetHotelPrice() {
        TestUtility.scrollUp(500, 1000, 500, 300, driver);
        return price2.getText().replace("TRY", "TL").trim();
    }

    public void bookingRoom() {
        optionsButton.click();
        chooseRoomButton.click();
        bookingButton.click();
    }
}

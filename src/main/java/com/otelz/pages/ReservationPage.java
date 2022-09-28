package com.otelz.pages;

import com.otelz.utility.TestUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ReservationPage {
    WebDriver driver;
    TestUtility testUtility;

    public ReservationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(id = "com.otelz.mobil.reservationSteps:id/tvNewCoupon")
    MobileElement newCouponButton;

    @FindBy(id = "com.otelz.mobil.reservationSteps:id/etCouponCode")
    MobileElement couponField;

    @FindBy(id = "com.otelz.mobil.reservationSteps:id/button4")
    MobileElement useButton;

    @FindBy(id = "android:id/message")
    MobileElement message;

    public void useCoupon(String coupon) {
        newCouponButton.click();
        couponField.sendKeys(coupon);
        useButton.click();
    }

    public boolean verifyReservationFinish() {
        if (message.isDisplayed()) {
            System.out.println(message.getText());
            return true;
        } else {
            System.out.println("reservation is failed");
            return false;
        }

    }
}

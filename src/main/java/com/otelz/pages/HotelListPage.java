package com.otelz.pages;

import com.otelz.utility.TestUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;

public class HotelListPage {

    WebDriver driver;
    TestUtility testUtility;

    public HotelListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(id = "com.otelz.mobil:id/textView21")
    MobileElement name1;

    @FindBy(id = "com.otelz.mobil:id/tvFinalPrice")
    MobileElement price1;

    public String getHotelName() {
        return name1.getText().trim();
    }

    public String getHotelPrice() {
        return price1.getText().trim();
    }

    public void selectFirstHotel() {
        name1.click();
        new HotelInfoPage(driver);
    }

}

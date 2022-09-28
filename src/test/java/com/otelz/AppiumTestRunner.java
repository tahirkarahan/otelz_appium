package com.otelz;

import com.otelz.pages.*;
import com.otelz.utility.TestBase;
import com.otelz.utility.TestUtility;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AppiumTestRunner extends TestBase {
    HomePage homePage;
    HotelListPage hotelListPage;
    HotelInfoPage hotelInfoPage;
    CustomerInfoPage customerInfoPage;
    ReservationPage reservationPage;
    private final String COUPON_CODE = "PSD483";

    @BeforeTest
    public void setUp() {
        initilization();
        TestUtility.implicitWait(driver, 20);
        WebElement element1 = driver.findElementById("com.otelz.mobil:id/textView9");
        element1.isDisplayed();
        TestUtility.swipeScreen(element1, driver);
        driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();
        WebElement element2 = driver.findElementById("com.otelz.mobil:id/constraintOnBoardItem");
        TestUtility.swipeScreen(element2, driver);
        driver.findElementById("com.otelz.mobil:id/materialButtonContinue").click();

    }

    @Test
    public void testOtelzMobileApp() {
        homePage = new HomePage(driver);
        homePage.searchHotel();
        homePage.selectDate(29, 30);
        homePage.clickOnSearchButton();

        hotelListPage = new HotelListPage(driver);
        String hotelName = hotelListPage.getHotelName();
        String hotelPrice = hotelListPage.getHotelPrice();
        hotelListPage.selectFirstHotel();

        hotelInfoPage = new HotelInfoPage(driver);
        Assert.assertEquals(hotelName, hotelInfoPage.getTargetHotelName());
        Assert.assertEquals(hotelPrice, hotelInfoPage.getTargetHotelPrice());

        hotelInfoPage.bookingRoom();
        TestUtility.sleep(3);

        customerInfoPage = new CustomerInfoPage(driver);
        customerInfoPage.inputCustomerInfo(TestUtility.generateFakeFirstName(), TestUtility.generateFakeLastName(),
                TestUtility.randomEmailAddress(), TestUtility.generateFakeNumber());

        reservationPage = new ReservationPage(driver);
        reservationPage.useCoupon(COUPON_CODE);
        Assert.assertTrue(reservationPage.verifyReservationFinish());

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}

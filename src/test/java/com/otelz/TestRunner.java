package com.otelz;

import com.otelz.utility.TestBase;
import com.otelz.utility.TestUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRunner extends TestBase {

    @Test
    public void testOtelzAndroidApp() {

        initilization();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        TestUtility.sleep(6);
        WebElement element1 = driver.findElementById("com.otelz.mobil:id/textView9");

        element1.isDisplayed();
        TestUtility.swipeScreen(element1, driver);

        driver.findElementById("com.android.permissioncontroller:id/permission_allow_foreground_only_button").click();

        WebElement element2 = driver.findElementById("com.otelz.mobil:id/constraintOnBoardItem");
        TestUtility.swipeScreen(element2, driver);

        driver.findElementById("com.otelz.mobil:id/materialButtonContinue").click();


        //HomePage
        driver.findElementById("com.otelz.mobil:id/tvSearchHome").click();

        driver.findElementById("com.otelz.mobil:id/search_src_text").sendKeys("ANKARA");

        driver.findElementById("com.otelz.mobil.search:id/constraintSearch").click();

        driver.findElementById("com.otelz.mobil:id/layoutCheckInDate").click();


        WebElement dateTable = driver.findElementById("com.otelz.mobil:id/month_view");
        List<WebElement> days = dateTable.findElements(By.id("com.otelz.mobil:id/tv_day_number"));
        for (WebElement day : days) {
            String n = day.getText();
            if (n.equals("29")) {
                day.click();
            }
        }

        dateTable = driver.findElementById("com.otelz.mobil:id/month_view");
        days = dateTable.findElements(By.id("com.otelz.mobil:id/tv_day_number"));
        for (WebElement day : days) {
            String n = day.getText();
            if (n.equals("30")) {
                day.click();
            }
        }

        driver.findElementById("com.otelz.mobil:id/relativeBtnChooseDate").click(); //submit button

        driver.findElementById("com.otelz.mobil:id/llSearchHome").click();

        //HotelsPage
        WebElement hotelNameElement1 = driver.findElementById("com.otelz.mobil:id/textView21");
        String hotelName1 = hotelNameElement1.getText().trim();
        WebElement hotelPriceElement1 = driver.findElementById("com.otelz.mobil:id/tvFinalPrice");
        String hotelPrice1 = hotelPriceElement1.getText().trim();
        hotelNameElement1.click();

        //TargetHotelPage
        WebElement hotelNameElement2 = driver.findElementById("com.otelz.mobil:id/tvFacilityDetailName");
        String hotelName2 = hotelNameElement2.getText().trim();
        TestUtility.scrollUp(500, 1000, 500, 300, driver);
        WebElement hotelPriceElement2 = driver.findElementById("com.otelz.mobil:id/tv_best_price_total_price_value");
        String hotelPrice2 = hotelPriceElement2.getText().replace("TRY", "TL");
        if (hotelName1.equals(hotelName2) && hotelPrice1.equals(hotelPrice2)) {
            System.out.println("Validate hotel name and hotel price successfully");
            Assert.assertTrue(true);
        } else {
            System.out.println("Validate hotel name and hotel price failed");
            Assert.fail();
        }
        //Assert.assertEquals(hotelName1, hotelName2);
        //Assert.assertEquals(hotelPrice1, hotelPrice2);

        driver.findElementById("com.otelz.mobil:id/btnChooseRoom").click(); //click on other room options button
        driver.findElementById("com.otelz.mobil:id/tvPersonCount").click(); //click on choose room button
        driver.findElementById("com.otelz.mobil:id/btnMakeReservation").click(); //click on book now button

        //Customer info page
        driver.findElementById("com.otelz.mobil:id/tvPersonalInfoName").sendKeys("Serdar");//name field
        driver.findElementById("com.otelz.mobil:id/tvPersonalInfoSurname").sendKeys("Ahmet");//surname field
        driver.findElementById("com.otelz.mobil:id/tvPersonalInfoMail").sendKeys("serdar@gmail.com");//email field
        driver.findElementById("com.otelz.mobil:id/etPersonalInfoPhoneCode").click();//code field
        driver.findElementById("com.otelz.mobil:id/relativeCountryCodeItem").click();//code selected
        driver.findElementById("com.otelz.mobil:id/tvPersonalInfoPhone").sendKeys("5462351234");//phone number field
        driver.findElementById("com.otelz.mobil:id/tvPersonalInfoCountry").click();//country field
        driver.findElementById("com.otelz.mobil:id/relativeCountryItem").click();//country selected
        TestUtility.scrollUp(500, 1000, 500, 300, driver);
        driver.findElementById("com.otelz.mobil:id/checkBoxIllumination").click();//second check box
        driver.findElementById("com.otelz.mobil:id/checkBoxPermission").click();//Third check box
        driver.findElementById("com.otelz.mobil:id/btnPersonalInfoNext2").click();//next step button

        // last page
        driver.findElementById("com.otelz.mobil.reservationSteps:id/tvNewCoupon").click();//new(coupon) button
        driver.findElementById("com.otelz.mobil.reservationSteps:id/etCouponCode").sendKeys("PSD483");//coupon field
        driver.findElementById("com.otelz.mobil.reservationSteps:id/button4").click();//use button

        //verify
        WebElement message = driver.findElementById("android:id/message");
        if (message.isDisplayed()) {
            System.out.println("Validate coupon message successfully");
            Assert.assertTrue(true);
        } else {
            System.out.println("Validate coupon message failed");
            Assert.fail();
        }

    }

}

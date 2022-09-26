package com.otelz.utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    public static AndroidDriver<WebElement> driver;

    public void initilization() {
        // Desired Capabilities, system platform
        DesiredCapabilities dcap = new DesiredCapabilities();
        dcap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        dcap.setCapability(MobileCapabilityType.DEVICE_NAME, "MyPhone");

        dcap.setCapability(MobileCapabilityType.APP, "D:\\For_Appium\\Otelz\\Otelz.apk");

        //Android Driver initialization
        try {
            driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dcap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}

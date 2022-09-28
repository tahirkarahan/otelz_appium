package com.otelz.pages;

import com.otelz.utility.TestUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CustomerInfoPage {
    WebDriver driver;
    TestUtility testUtility;

    public CustomerInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
        testUtility = new TestUtility(driver);
    }

    @FindBy(id = "com.otelz.mobil:id/tvPersonalInfoName")
    MobileElement nameField;

    @FindBy(id = "com.otelz.mobil:id/tvPersonalInfoSurname")
    MobileElement surnameField;

    @FindBy(id = "com.otelz.mobil:id/tvPersonalInfoMail")
    MobileElement emailField;

    @FindBy(id = "com.otelz.mobil:id/etPersonalInfoPhoneCode")
    MobileElement codeDropdown;

    @FindBy(id = "com.otelz.mobil:id/relativeCountryCodeItem")
    MobileElement targetCode;

    @FindBy(id = "com.otelz.mobil:id/tvPersonalInfoPhone")
    MobileElement phoneNumberField;

    @FindBy(id = "com.otelz.mobil:id/tvPersonalInfoCountry")
    MobileElement regionDropdown;

    @FindBy(id = "com.otelz.mobil:id/relativeCountryItem")
    MobileElement targetRegion;

    @FindBy(id = "com.otelz.mobil:id/checkBoxIllumination")
    MobileElement secondCheckBox;

    @FindBy(id = "com.otelz.mobil:id/checkBoxPermission")
    MobileElement thirdCheckBox;

    @FindBy(id = "com.otelz.mobil:id/btnPersonalInfoNext2")
    MobileElement nextStepButton;

    public void inputCustomerInfo(String name, String surname, String email, String phoneNumber) {
        nameField.sendKeys(name);
        surnameField.sendKeys(surname);
        emailField.sendKeys(email);
        codeDropdown.click();
        targetCode.click();
        phoneNumberField.sendKeys(phoneNumber);
        regionDropdown.click();
        targetRegion.click();
        TestUtility.sleep(2);
        TestUtility.scrollUp(500, 1000, 500, 300, driver);
        secondCheckBox.click();
        thirdCheckBox.click();
        nextStepButton.click();
    }
}


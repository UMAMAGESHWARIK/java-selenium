package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmployeeFormPage {
    WebDriver driver;

    public EmployeeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators (matching HTML exactly)
    By empIdField = By.id("empId");
    By empNameField = By.id("empName");
    By dobField = By.id("dob");
    By addressField = By.id("address");
    By mobileField = By.id("mobile");
    By emailField = By.id("email");
    By submitButton = By.cssSelector("input[type='submit']");
    By resultText = By.id("result");

    public void enterEmpId(String empId) {
        driver.findElement(empIdField).clear();
        driver.findElement(empIdField).sendKeys(empId);
    }

    public void enterEmpName(String empName) {
        driver.findElement(empNameField).clear();
        driver.findElement(empNameField).sendKeys(empName);
    }

    public void enterDob(String dob) {
        driver.findElement(dobField).sendKeys(dob); // Must be yyyy-MM-dd
    }

    public void enterAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterMobile(String mobile) {
        driver.findElement(mobileField).clear();
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    public void clickSubmit() {
        driver.findElement(submitButton).click();
    }

    public String getResultText() {
        WebElement result = driver.findElement(resultText);
        return result.isDisplayed() ? result.getText() : null;
    }
}

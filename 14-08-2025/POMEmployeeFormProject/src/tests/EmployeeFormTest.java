package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EmployeeFormPage;

public class EmployeeFormTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://127.0.0.1:5500/index.html");
            driver.manage().window().maximize();

            EmployeeFormPage formPage = new EmployeeFormPage(driver);

            formPage.enterEmpId("101");
            formPage.enterEmpName("Savi");
            formPage.enterDob("2002-10-19"); // yyyy-MM-dd format
            formPage.enterAddress("123 ABC Street");
            formPage.enterMobile("7777777777");
            formPage.enterEmail("savi@example.com");

            formPage.clickSubmit();

            Thread.sleep(1000);
            String result = formPage.getResultText();

            if (result != null && !result.trim().isEmpty()) {
                System.out.println("Success: " + result);
            } else {
                System.out.println("Submission failed or no output shown.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

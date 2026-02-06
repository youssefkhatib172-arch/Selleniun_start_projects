package Selleniun_start_projects.Selleniun_start_projects;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalculatorTests {

    static WebDriver browser;

    @Before
    public void setup() {
        System.setProperty(
                "webdriver.gecko.driver",
                "C:\\Users\\USER\\Downloads\\geckodriver-v0.36.0-win32\\geckodriver.exe"
        );

        browser = new FirefoxDriver();
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String url = "https://testpages.eviltester.com/apps/button-calculator/";
        browser.get(url);
    }

    // ================================
    // חיבור – חיובית
    // ================================
    @Test
    public void Add_1_Plus_2_Equals_3() {

        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button02")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        String expected = "3";
        assertEquals(expected, result);
    }

    // ================================
    // חיבור – שלילית (דיוק עשרוני)
    // ================================
    @Test
    public void Add_1_Plus_MissingSecondOperand_ShouldNotCalculate() {

        browser.findElement(By.id("button01")).click();
        browser.findElement(By.id("buttonplus")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");

        // הציפייה: להישאר 1
        String expected = "1";
        assertEquals(expected, result);
    }

    
    // ================================
    // חיסור – חיובית
    // ================================
    @Test
    public void Sub_9_Minus_4_Equals_5() {

        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button04")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        String expected = "5";
        assertEquals(expected, result);
    }

    // ================================
    // חיסור – שלילית (שרשרת חיסור)
    // ================================
    @Test
    public void Sub_9_Minus_MissingSecondOperand_ShouldNotCalculate() {

        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonminus")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");

        // הציפייה: לא לבצע חישוב ולהישאר 9
        String expected = "9";
        assertEquals(expected, result);
    }



    // ================================
    // כפל – חיובית
    // ================================
    @Test
    public void Mul_3_Times_4_Equals_12() {

        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button04")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        String expected = "12";
        assertEquals(expected, result);
    }

    // ================================
    // כפל – שלילית (חסר אופרן שני → בפועל יוצא 81)
    // ================================
    @Test
    public void Mul_9_Times_MissingSecondOperand_ShouldNotCalculate() {

        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonmultiply")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");

        // מצופה לוגית: לא לחשב ולהשאיר 9
        // בפועל באתר: 81 → ולכן הבדיקה תיכשל ותחשוף באג
        String expected = "9";
        assertEquals(expected, result);
    }
}

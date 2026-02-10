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
    // חיבור – חיובית (1 + 2 = 3)
    // ================================
    @Test
    public void add_1_plus_2_equals_3() {

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
    // חיבור – חיובית (9 + 9 = 18)
    // ================================
    @Test
    public void add_9_plus_9_equals_18() {

        browser.findElement(By.id("button09")).click();
        browser.findElement(By.id("buttonplus")).click();
        browser.findElement(By.id("button09")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        String expected = "18";
        assertEquals(expected, result);
    }

    // ================================
    // חיסור – חיובית (9 − 4 = 5)
    // ================================
    @Test
    public void sub_9_minus_4_equals_5() {

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
    // חיסור – חיובית (3 − 7 = -4)
    // ================================
    @Test
    public void sub_3_minus_7_equals_minus4() {

        browser.findElement(By.id("button03")).click();
        browser.findElement(By.id("buttonminus")).click();
        browser.findElement(By.id("button07")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        String expected = "-4";
        assertEquals(expected, result);
    }

    // ================================
    // כפל – חיובית (3 × 4 = 12)
    // ================================
    @Test
    public void mul_3_times_4_equals_12() {

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
    // כפל – חיובית (0 × 8 = 0)
    // ================================
    @Test
    public void mul_0_times_8_equals_0() {

        browser.findElement(By.id("button00")).click();
        browser.findElement(By.id("buttonmultiply")).click();
        browser.findElement(By.id("button08")).click();

        try { Thread.sleep(1000); }
        catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        browser.findElement(By.id("buttonequals")).click();

        String result = browser.findElement(By.id("calculated-display")).getAttribute("value");
        String expected = "0";
        assertEquals(expected, result);
    }
}

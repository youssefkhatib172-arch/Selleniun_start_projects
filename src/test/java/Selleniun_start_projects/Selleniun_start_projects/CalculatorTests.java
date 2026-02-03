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

        // זמן המתנה לאיתור אלמנטים (אפשר להשאיר כמו שהוא)
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String url = "https://testpages.eviltester.com/apps/button-calculator/";
        browser.get(url);
    }

    // ================================
    // בדיקות חיבור (+) - לפחות 2
    // ================================

    @Test
    public void Add_1_Plus_2_Equals_3() {
        // לחיצה על 1
        browser.findElement(By.id("button01")).click();
        // לחיצה על +
        browser.findElement(By.id("buttonplus")).click();
        // לחיצה על 2
        browser.findElement(By.id("button02")).click();
        // לחיצה על =
        browser.findElement(By.id("buttonequals")).click();
        // קריאת תוצאת המחשבון מהשדה
        String result =
                browser.findElement(By.id("calculated-display"))
                        .getAttribute("value");
        // הערך הצפוי
        String expected = "3";
        assertEquals(expected, result);
    }

    @Test
    public void Add_9_Plus_9_Equals_18() {
        // לחיצה על 9
        browser.findElement(By.id("button09")).click();
        // לחיצה על +
        browser.findElement(By.id("buttonplus")).click();
        // לחיצה על 9
        browser.findElement(By.id("button09")).click();
        // לחיצה על =
        browser.findElement(By.id("buttonequals")).click();
        // קריאת תוצאת המחשבון מהשדה
        String result =
                browser.findElement(By.id("calculated-display"))
                        .getAttribute("value");
        // הערך הצפוי
        String expected = "18";
        assertEquals(expected, result);
    }

    // ================================
    // בדיקות חיסור (-) - לפחות 2
    // ================================

    @Test
    public void Sub_9_Minus_4_Equals_5() {
        // לחיצה על 9
        browser.findElement(By.id("button09")).click();
        // לחיצה על -
        browser.findElement(By.id("buttonminus")).click();
        // לחיצה על 4
        browser.findElement(By.id("button04")).click();
        // לחיצה על =
        browser.findElement(By.id("buttonequals")).click();
        // קריאת תוצאת המחשבון מהשדה
        String result =
                browser.findElement(By.id("calculated-display"))
                        .getAttribute("value");
        // הערך הצפוי
        String expected = "5";
        assertEquals(expected, result);
    }

    @Test
    public void Sub_3_Minus_7_Equals_Minus4() {
        // לחיצה על 3
        browser.findElement(By.id("button03")).click();
        // לחיצה על -
        browser.findElement(By.id("buttonminus")).click();
        // לחיצה על 7
        browser.findElement(By.id("button07")).click();
        // לחיצה על =
        browser.findElement(By.id("buttonequals")).click();
        // קריאת תוצאת המחשבון מהשדה
        String result =
                browser.findElement(By.id("calculated-display"))
                        .getAttribute("value");
        // הערך הצפוי
        String expected = "-4";
        assertEquals(expected, result);
    }
    // ================================
    // בדיקות כפל (×) - לפחות 2
    // ================================

    @Test
    public void Mul_3_Times_4_Equals_12() {
        // לחיצה על 3
        browser.findElement(By.id("button03")).click();
        // לחיצה על ×
        // באתר הזה id של כפל הוא buttonmultiply
        browser.findElement(By.id("buttonmultiply")).click();
        // לחיצה על 4
        browser.findElement(By.id("button04")).click();
        // לחיצה על =
        browser.findElement(By.id("buttonequals")).click();
        // קריאת תוצאת המחשבון מהשדה
        String result =
                browser.findElement(By.id("calculated-display"))
                        .getAttribute("value");
        // הערך הצפוי
        String expected = "12";
        assertEquals(expected, result);
    }

    @Test
    public void Mul_0_Times_8_Equals_0() {
        // לחיצה על 0
        browser.findElement(By.id("button00")).click();
        // לחיצה על ×
        browser.findElement(By.id("buttonmultiply")).click();
        // לחיצה על 8
        browser.findElement(By.id("button08")).click();
        // לחיצה על =
        browser.findElement(By.id("buttonequals")).click();
        // קריאת תוצאת המחשבון מהשדה
        String result =
                browser.findElement(By.id("calculated-display"))
                        .getAttribute("value");
        // הערך הצפוי
        String expected = "0";
        assertEquals(expected, result);
    }
}

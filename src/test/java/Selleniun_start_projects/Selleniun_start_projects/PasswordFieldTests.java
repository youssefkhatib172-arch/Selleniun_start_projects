package Selleniun_start_projects.Selleniun_start_projects;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class PasswordFieldTests {
    static WebDriver browser;
    @Before
    public void setup() {
        System.setProperty(
                "webdriver.gecko.driver",
                "C:\\Users\\USER\\Downloads\\geckodriver-v0.36.0-win32\\geckodriver.exe"
        );
        browser = new FirefoxDriver();
        // זמן המתנה לאיתור אלמנטים
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // ================================
        // כניסה לדף בדיקת הסיסמה
        // ================================
        String url =
                "https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html";
        browser.get(url);
    }
    
    // ================================
    // EP1: בדיוק 7 תווים חוקיים -> Valid
    // ================================
    @Test
    public void EP_Valid_Exactly7Chars() {
        // ניקוי השדה
        browser.findElement(By.name("characters")).clear();
        // הקלדת סיסמה תקינה (7 תווים, חוקיים)
        browser.findElement(By.name("characters"))
                .sendKeys("Abc12*9");
        browser.findElement(By.name("validate")).click();
        // קריאת תוצאת הבדיקה
        String result =
                browser.findElement(By.name("validation_message"))
                        .getAttribute("value");
        // הערך הצפוי
        String expected = "Valid Value";
        assertEquals(expected, result);
    }
    
    // ================================
    // EP2: פחות מ־7 תווים -> Invalid
    // ================================
    @Test
    public void EP_Invalid_ShorterThan7() {
        browser.findElement(By.name("characters")).clear();
        // סיסמה קצרה מדי
        browser.findElement(By.name("characters"))
                .sendKeys("abc12");
        browser.findElement(By.name("validate")).click();
        String result =
                browser.findElement(By.name("validation_message"))
                        .getAttribute("value");
        String expected = "Invalid Value";
        assertEquals(expected, result);
    }
    
    // ================================
    // EP3: יותר מ־7 תווים -> Invalid
    // ================================
    @Test
    public void EP_Invalid_LongerThan7() {
        browser.findElement(By.name("characters")).clear();
        // סיסמה ארוכה מדי
        browser.findElement(By.name("characters"))
                .sendKeys("abc123456");
        browser.findElement(By.name("validate")).click();
        String result =
                browser.findElement(By.name("validation_message"))
                        .getAttribute("value");
        String expected = "Invalid Value";
        assertEquals(expected, result);
    }

    // ================================
    // EP4: תו לא חוקי -> Invalid
    // ================================
    @Test
    public void EP_Invalid_IllegalCharacter() {

        browser.findElement(By.name("characters")).clear();
        // 7 תווים אבל עם תו לא חוקי (@)
        browser.findElement(By.name("characters"))
                .sendKeys("abc12@#");
        browser.findElement(By.name("validate")).click();
        String result =
                browser.findElement(By.name("validation_message"))
                        .getAttribute("value");
        String expected = "Invalid Value";
        assertEquals(expected, result);
    }
}

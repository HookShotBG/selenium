import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class First {


    @Test
    public void openGoogle(){
    }

    public String baseUrl= "http://www.google.com/";
    public WebDriver driver = new FirefoxDriver();

    @Test
    public void verifyHomePageTitle() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/daniellutziger/IdeaProjects/selenium/geckodriver.exe");
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        String eTitle = "First Selenium Test";
        // Enter something to search for
        element.sendKeys(eTitle);

        eTitle += " - Google-Suche";

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        assertTrue(wait.until(ExpectedConditions.titleContains(eTitle)));

        // Check the title of the page
        assertEquals(eTitle, driver.getTitle());

        //quit firefox
        driver.quit();
    }
}

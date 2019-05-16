import org.junit.jupiter.api.*;
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

    public WebDriver driver = new FirefoxDriver();

    @BeforeEach
    public void init(){

    }

    @AfterEach
    public void remove(){
        //quit firefox

    }

    @Test
    public void verifyHomePageTitle() throws Exception {
        System.setProperty("webdriver.gecko.driver", "/Users/daniellutziger/IdeaProjects/selenium/geckodriver.exe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://www.google.com/");

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

    }

    @Test
    public void netflix(){
        System.setProperty("webdriver.gecko.driver", "/Users/daniellutziger/IdeaProjects/selenium/geckodriver.exe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.netflix.com ");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement we = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/a[2]"));
        we.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_userLoginId")));

        WebElement login = driver.findElement(By.id("id_userLoginId"));
        WebElement password = driver.findElement(By.id("id_password"));
        WebElement submit = driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div/div[1]/form/button"));
        WebElement rememberme = driver.findElement(By.className("login-remember-me-label-text"));

        String mail = "your email";
        String pw = "your password";
        login.sendKeys(mail);
        password.sendKeys(pw);
        rememberme.click();
        submit.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div/ul/li[4]")));

        WebElement profile = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div/ul/li[4]"));
        profile.click();

        WebElement mylist = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[1]/div/div/ul/li[6]/a"));
        mylist.click();

        WebElement movie = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/div/div/div/div[4]"));
        movie.click();

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/span/span/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[4]/a/span")).click();

        }
}/**

//*[@id="appMountPoint"]/div/div/div/div/div[1]/div/div/div/div[1]/div/div/input
//*[@id="appMountPoint"]/div/div/div/div/div[1]/div/div/div/div[1]/div/button


<div class="searchInput">
<span class="icon-search"></span><
        input type="text" placeholder="Titles, people, genres" data-search-input="true" dir="ltr" data-uia="search-box-input" maxlength="80" value="" style="opacity: 1; transition-duration: 300ms;"><span class="icon-close empty"></span></div>
 **/
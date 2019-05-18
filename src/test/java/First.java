import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class First {

    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeAll
    public void init(){
        //driver.manage().
        FirefoxOptions foptions = new FirefoxOptions();
        foptions.addArguments("--disable-notifications");

        driver = new FirefoxDriver(foptions);
        System.setProperty("webdriver.gecko.driver", "/Users/daniellutziger/IdeaProjects/selenium/geckodriver.exe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;


    }

    @AfterAll
    public void remove(){
        //quit firefox
        //driver.quit();
    }

    @Test
    public void facebook(){
        driver.get("https://www.facebook.com");
        String mail = "smueller98tindee@gmail.com";
        String pw = "daniel88?D";
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement usern = driver.findElement(By.id("email"));
        usern.sendKeys(mail);
        WebElement pwf = driver.findElement(By.id("pass"));
        pwf.sendKeys(pw);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"u_0_2\"]")));
        WebElement login = driver.findElement(By.xpath("//*[@id=\"u_0_2\"]"));
        login.click();

        js.executeScript("console.log('Welcome to Damn');");
        driver.manage().window().maximize();

        WebElement screeny = driver.findElement(By.className("_3ixn"));
        screeny.click();

        List<WebElement> names = driver.findElements(By.className("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[6]/div/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/div/ul/li/div/div[2]/div[1]/div[2]/div[1]/strong/a"));
        System.out.println(names);
        //html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[6]/div/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/div/ul/li/div/div[2]/div[1]/div[2]/div[1]/strong/a
        //html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div[2]/div/div[6]/div/div/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div/div/div[1]/div/ul/li[2]/div/div[2]/div[1]/div[2]/div[1]/strong/a
        //*[@id="js_28h"]
        //*[@id="js_28h"]
        //*[@id="js_2dn"]
        /*
        List<WebElement> friends = driver.findElements(By.className("FriendRequestAdd"));

        int f = 0;
        for(WebElement friend : friends){
            friend.click();
            System.out.println(f++ + " : " + friend.getTagName());
        }

        WebElement posty = driver.findElement(By.name("xhpc_message"));

        posty.click();
        driver.findElement(By.className("_1p1v")).click();

*/

        driver.findElement(By.className("_1p1v")).sendKeys("asdf");
        //posty.sendKeys("I like d-k");


        WebElement PostBtn = driver.findElement(By.cssSelector("button[data-testid='react-composer-post-button']"));
        PostBtn.click();


        //WebElement element = driver.findElement(By.name("q"));
        //element.sendKeys("ffff");
        //element.submit();
/*        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/a")));
        WebElement posty = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div[2]/div/a"));
        posty.click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[2]/div[2]/div[1]/div/div[2]/div[2]/div/div[2]/div/div[1]/ol/li/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/div/div/div")).click();

        WebElement share = driver.findElement(By.xpath("//*[@id=\"js_6b\"]/div[2]/div[3]/div[2]/div/div/button/span"));
 */   }



    @Test
    public void verifyHomePageTitle() {

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

        String mail = "ffff";
        String pw = "fff";
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


        movie = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div/div/div[14]/div/div/div/div/div/div[5]"));
        movie.click();

        //driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div/div/div[1]/div/span/span/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[4]/a/span")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div[2]/div/div[2]/div/div/div[14]/div/span/span/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[5]/a/span/span[2]")).click();


    }
}
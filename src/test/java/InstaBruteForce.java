import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class InstaBruteForce {

    private WebDriver driver;
    private JavascriptExecutor js;

    @BeforeAll
    public void init(){

        driver = new FirefoxDriver();
        System.setProperty("webdriver.gecko.driver", "/Users/daniellutziger/IdeaProjects/selenium/geckodriver.exe");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        js = (JavascriptExecutor) driver;


    }

    @Test
    public void spamIGPhisher(){
        for(int i = 97; i<=122; i++) {
            for(int j = 100; j<=122; j++) {
               for(int k = 105; k<=122; k++) {
                    for(int l = 99; l<=122; l++) {
                        for(int m = 99; m<=122; m++) {
                            for(int n = 108; n<=122; n++) {
                                for(int o = 117; o<=122; o++) {
                                    for(int p = 97; p<=122; p++) {
                                        for(int q = 116; q<=122; q++) {
                                            driver.get("https://kontoeinstellung.com");
                                            driver.manage().window().maximize();
                                            WebDriverWait wait = new WebDriverWait(driver, 10);

                                            WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div/form/input[1]"));
                                            WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/form/input[2]"));
                                            WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/form/b/input"));

                                            String input = Character.toString((char)i) + Character.toString((char)j) + Character.toString((char)k) + Character.toString((char)l) + Character.toString((char)m)  + Character.toString((char)n)  + Character.toString((char)o)  + Character.toString((char)p) + Character.toString((char)q);
                                            System.out.println(input);
                                            username.sendKeys(input);
                                            password.sendKeys(input);
                                            submit.click();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    @Test
    public void spamPhisherFromFile(){
        for(int i = 0; i<100;i++) {
        driver.get("https://kontoeinstellung.com");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div/form/input[1]"));
        WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/form/input[2]"));
        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/form/b/input"));

            String input = "";
            String pwd = "";
            try (Stream<String> lines = Files.lines(Paths.get("usernames.txt"))) {
                input = lines.skip(new Random().nextInt(400000)).findFirst().get();
            } catch (Exception e) {
                System.out.println(e);
            }
            try (Stream<String> lines = Files.lines(Paths.get("8-more-passwords.txt"))) {
                pwd = lines.skip(new Random().nextInt(86000)).findFirst().get();
            } catch (Exception e) {
                System.out.println(e);
            }

            System.out.println(input);
            System.out.println(pwd);
            username.sendKeys(input);
            password.sendKeys(pwd);
            submit.click();
        }
    }

    @AfterAll
    public void remove(){
        //quit firefox
       // driver.quit();
    }


}
